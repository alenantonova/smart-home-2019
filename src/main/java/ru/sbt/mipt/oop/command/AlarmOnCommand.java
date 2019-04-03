package ru.sbt.mipt.oop.command;

import ru.sbt.mipt.oop.SmartHome;

public class AlarmOnCommand extends Command{
    public AlarmOnCommand(SmartHome smarthome) {
        super(smarthome);
    }

    @Override
    public boolean execute() {
        smarthome.getAlarm().alarm();
        return true;
    }
}
