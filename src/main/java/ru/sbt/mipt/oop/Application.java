package ru.sbt.mipt.oop;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import ru.sbt.mipt.oop.configuration.SmartHomeConfiguration;
import ru.sbt.mipt.oop.event.SensorEvent;
import ru.sbt.mipt.oop.handler.*;
import ru.sbt.mipt.oop.configuration.SmartHomeConfiguration.HandlersList;
import ru.sbt.mipt.oop.miner.RandomEventsMiner;

public class Application {

    public static void main(String... args) {
        // считываем состояние дома из файла
        AbstractApplicationContext homeContext = new AnnotationConfigApplicationContext(SmartHomeConfiguration.class);
        SmartHome smartHome = homeContext.getBean(SmartHome.class);
        // начинаем цикл обработки событий
        RandomEventsMiner miner = homeContext.getBean(RandomEventsMiner.class);
        HandlersList typeRecognizer = homeContext.getBean(HandlersList.class);
        SensorEvent event = miner.getNextSensorEvent();
        while (event != null) {
            System.out.println("Got event: " + event);
            for(EventHandler handler: typeRecognizer.getHandlersList()) {
                handler.handleEvent(smartHome, event);
            }
            event =miner.getNextSensorEvent();
        }
    }
}
