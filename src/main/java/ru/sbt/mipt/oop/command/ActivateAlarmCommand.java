package ru.sbt.mipt.oop.command;

import ru.sbt.mipt.oop.SmartHome;

import java.util.Scanner;

public class ActivateAlarmCommand extends Command {
    public ActivateAlarmCommand(SmartHome smarthome) {
        super(smarthome);
    }

    @Override
    public boolean execute() {
        System.out.println("Please enter activation code:");
        Scanner in = new Scanner(System.in);
        String code = in.nextLine();
        if(smarthome.getAlarm().CheckCode(code)) {
            smarthome.getAlarm().activate();
            return true;
        }
        return false;
    }
}
