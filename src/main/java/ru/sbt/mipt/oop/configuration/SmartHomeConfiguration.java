package ru.sbt.mipt.oop.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.sbt.mipt.oop.EventHandlerDecorator;
import ru.sbt.mipt.oop.SmartHome;
import ru.sbt.mipt.oop.handler.*;
import ru.sbt.mipt.oop.homereader.FileSmartHomeReader;
import ru.sbt.mipt.oop.miner.RandomEventsMiner;
import ru.sbt.mipt.oop.object.Alarm;
import ru.sbt.mipt.oop.object.SmartHomeRemoteControl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;

@Configuration
public class SmartHomeConfiguration {
    private FileSmartHomeReader reader;
    private SmartHome smartHome;
    private HandlersList typeRecognizer;
    private RandomEventsMiner miner;
    private SmartHomeRemoteControl remoteControl;
    private Alarm alarm;

    public SmartHomeConfiguration() {
        reader = new FileSmartHomeReader();
        try {
            smartHome = reader.loadHome("smart-home-1.js");
        } catch (IOException e) {
            e.printStackTrace();
        }
        miner = new RandomEventsMiner();
        typeRecognizer = new HandlersList(createEventHandler());
        remoteControl = new SmartHomeRemoteControl("0");
        alarm = new Alarm();
    }

    @Bean
    SmartHome getHome() {
        return smartHome;
    }

    @Bean
    RandomEventsMiner getMiner() {
        return miner;
    }

    @Bean
    HandlersList getTypeRecognizer() {
        return typeRecognizer;
    }

    @Bean
    SmartHomeRemoteControl getRemoteControl() { return remoteControl; }

    @Bean
    Alarm getAlarm() {return alarm; }

    public static class HandlersList {
        private Collection<EventHandler>  handlers;

        public HandlersList (Collection<EventHandler> handlers) {
            this.handlers = handlers;
        }

        public Collection<EventHandler> getHandlersList() {
            return handlers;
        }
    }

    private static Collection<EventHandler> createEventHandler() {
        Collection<EventHandler> eventHandlers = new ArrayList<>();
        eventHandlers.add(new EventHandlerDecorator(new LightEventHandler()));
        eventHandlers.add(new EventHandlerDecorator(new DoorEventHandler()));
        eventHandlers.add(new EventHandlerDecorator(new HallDoorEventHandler()));
        eventHandlers.add(new AlarmEventHandler());
        return eventHandlers;
    }
}


