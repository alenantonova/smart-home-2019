package ru.sbt.mipt.oop.command;

import ru.sbt.mipt.oop.SmartHome;
import ru.sbt.mipt.oop.object.Alarm;

import java.util.Scanner;

public class ActivateAlarmCommand implements Command {
    private Alarm alarm;
    private String code;

    public ActivateAlarmCommand(Alarm alarm, String code) {
        this.alarm = alarm;
        this.code = code;
    }


    public boolean execute() {
        if(alarm.CheckCode(code)) {
            alarm.activate();
            return true;
        }
        return false;
    }
}
