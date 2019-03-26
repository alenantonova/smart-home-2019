package ru.sbt.mipt.oop.adapter;

import com.coolcompany.smarthome.events.CCSensorEvent;
import ru.sbt.mipt.oop.SensorEventType;
import ru.sbt.mipt.oop.event.SensorEvent;

import static ru.sbt.mipt.oop.SensorEventType.*;

public class EventAdapter extends SensorEvent {

    CCSensorEvent ccEvent;

    public EventAdapter(CCSensorEvent event) { this.ccEvent = event; }

    @Override
    public SensorEventType getType() {
        switch (ccEvent.getEventType()) {
            case "LightIsOn":
                return LIGHT_ON;
            case "LightIsOff":
                return LIGHT_OFF;
            case "DoorIsOpen":
                return DOOR_OPEN;
            case "DoorIsClosed":
                return DOOR_CLOSED;
            case "DoorIsLocked":
                return DOOR_LOCKED;
            case "DoorIsUnlocked":
                return DOOR_UNLOCKED;
            default:
                return DOOR_CLOSED;
        }
    }

    @Override
    public String getObjectId() {
        return ccEvent.getObjectId();
    }
}
