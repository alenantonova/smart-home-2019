package ru.sbt.mipt.oop.adapter;

import com.coolcompany.smarthome.events.CCSensorEvent;
import ru.sbt.mipt.oop.SmartHome;
import ru.sbt.mipt.oop.adapter.EventAdapter;
import ru.sbt.mipt.oop.handler.EventHandler;


public class HandlerAdapter implements com.coolcompany.smarthome.events.EventHandler {
    EventHandler handler;
    SmartHome smartHome;

    public HandlerAdapter(EventHandler init_handler, SmartHome init_home) {
        this.handler = init_handler;
        this.smartHome = init_home;
    }

    public void handleEvent(CCSensorEvent event) {
        handler.handleEvent(smartHome, new EventAdapter(event));
    }

}
