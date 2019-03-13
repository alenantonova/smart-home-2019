package ru.sbt.mipt.oop;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import ru.sbt.mipt.oop.handler.*;

public class Application {

    public static void main(String... args) throws IOException {
        // считываем состояние дома из файла
        FileSmartHomeReader reader = new FileSmartHomeReader();
        SmartHome smartHome = reader.loadHome("smart-home-1.js");
        // начинаем цикл обработки событий
        RandomEventsMiner miner = new RandomEventsMiner();
        Collection<EventHandler> typeRecognizer = createEventHandler();
        SensorEvent event = miner.getNextSensorEvent();
        while (event != null) {
            System.out.println("Got event: " + event);
            for(EventHandler handler: typeRecognizer) {
                handler.handleEvent(smartHome, event);
            }
            event =miner.getNextSensorEvent();
        }
    }


    private static Collection<EventHandler> createEventHandler() {
        Collection<EventHandler> eventTypes = new ArrayList<>();
        eventTypes.add(new LightEventHandler());
        eventTypes.add(new DoorEventHandler());
        return eventTypes;
    }
}
