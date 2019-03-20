package ru.sbt.mipt.oop;

import java.util.ArrayList;
import java.util.Collection;
import ru.sbt.mipt.oop.action.Action;
import ru.sbt.mipt.oop.alarm.Alarm;

public class SmartHome implements Actionable {
    Collection<Room> rooms;
    Alarm alarm;

    public SmartHome() {
        rooms = new ArrayList<>();
        alarm = new Alarm();
    }

    public SmartHome(Collection<Room> rooms) {
        this.rooms = rooms;
        alarm = new Alarm();
    }

    public SmartHome(Collection<Room> rooms, String alarm_code) {
        this.rooms = rooms;
        this.alarm = new Alarm(alarm_code);
    }

    public void set_alarm(Alarm alarm) {this.alarm = alarm;}

    public void addRoom(Room room) {
        rooms.add(room);
    }

    public Collection<Room> getRooms() {
        return rooms;
    }

    public Alarm getAlarm() {return alarm;}

    public void execute(Action action) {
        for(Room room : rooms) {
            room.execute(action);
        }
    }
}
