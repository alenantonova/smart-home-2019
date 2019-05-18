package ru.sbt.mipt.oop;

import com.coolcompany.smarthome.events.SensorEventsManager;
import ru.sbt.mipt.oop.adapter.HandlerAdapter;
import ru.sbt.mipt.oop.handler.AlarmEventHandler;
import ru.sbt.mipt.oop.handler.DoorEventHandler;
import ru.sbt.mipt.oop.handler.HallDoorEventHandler;
import ru.sbt.mipt.oop.handler.LightEventHandler;
import ru.sbt.mipt.oop.homereader.FileSmartHomeReader;

import java.io.IOException;

public class ApplicationWithAdapter {
    public static void main(String[] args) throws IOException {
        FileSmartHomeReader reader = new FileSmartHomeReader();
        SmartHome smartHome = reader.loadHome("smart-home-1.js");
        SensorEventsManager sensorEventsManager = new SensorEventsManager();
        sensorEventsManager.registerEventHandler(event -> {
            System.out.println("Event type [" + event.getEventType() + "] from object with id=" + event.getObjectId() + "]");
        });
        sensorEventsManager.registerEventHandler(new HandlerAdapter(new LightEventHandler(), smartHome));
        sensorEventsManager.registerEventHandler(new HandlerAdapter(new DoorEventHandler(), smartHome));
        sensorEventsManager.registerEventHandler(new HandlerAdapter(new HallDoorEventHandler(), smartHome));
        sensorEventsManager.registerEventHandler(new HandlerAdapter(new AlarmEventHandler(), smartHome));
        sensorEventsManager.start();
    }
}
