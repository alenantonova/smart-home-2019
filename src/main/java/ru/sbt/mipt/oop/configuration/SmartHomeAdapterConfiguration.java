package ru.sbt.mipt.oop.configuration;

import com.coolcompany.smarthome.events.SensorEventsManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.sbt.mipt.oop.SmartHome;
import ru.sbt.mipt.oop.adapter.HandlerAdapter;
import ru.sbt.mipt.oop.handler.*;
import ru.sbt.mipt.oop.homereader.FileSmartHomeReader;


import java.io.IOException;


@Configuration
public class SmartHomeAdapterConfiguration {

    private SmartHome smartHome;
    private SmartHomeConfiguration.HandlersList typeRecognizer;
    private SensorEventsManager manager;

    public SmartHomeAdapterConfiguration() {
        FileSmartHomeReader reader = new FileSmartHomeReader();
        try {
            smartHome = reader.loadHome("smart-home-1.js");
        } catch (IOException e) {
            e.printStackTrace();
        }
        manager = new SensorEventsManager();
        manager.registerEventHandler(event -> {
            System.out.println("[ Event type [" + event.getEventType() + "] from object with id=" + event.getObjectId() + " ]");
        });
        manager.registerEventHandler(new HandlerAdapter(new LightEventHandler(), smartHome));
        manager.registerEventHandler(new HandlerAdapter(new DoorEventHandler(), smartHome));
        manager.registerEventHandler(new HandlerAdapter(new HallDoorEventHandler(), smartHome));
        manager.registerEventHandler(new HandlerAdapter(new AlarmEventHandler(), smartHome));
    }

    @Bean
    SmartHome getHome() {
        return smartHome;
    }

    @Bean
    SensorEventsManager getManager() {
        return manager;
    }
}
