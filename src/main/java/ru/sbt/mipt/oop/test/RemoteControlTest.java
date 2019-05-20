package ru.sbt.mipt.oop.test;

import org.junit.Assert;
import org.junit.Test;
import ru.sbt.mipt.oop.SmartHome;
import ru.sbt.mipt.oop.object.SmartHomeRemoteControl;
import ru.sbt.mipt.oop.command.ActivateAlarmCommand;
import ru.sbt.mipt.oop.command.AlarmOnCommand;
import ru.sbt.mipt.oop.command.CloseHallDoorCommand;
import ru.sbt.mipt.oop.command.Command;
import ru.sbt.mipt.oop.homereader.FileSmartHomeReader;
import ru.sbt.mipt.oop.object.Alarm;
import ru.sbt.mipt.oop.object.Door;
import ru.sbt.mipt.oop.object.Light;
import ru.sbt.mipt.oop.object.Room;
import ru.sbt.mipt.oop.object.alarmstates.ActiveState;
import ru.sbt.mipt.oop.object.alarmstates.AlarmState;

import java.io.IOException;

public class RemoteControlTest {
    @Test
    public void SucCloseHallDoorTest() throws IOException {
        FileSmartHomeReader reader = new FileSmartHomeReader();
        SmartHome smarthome = reader.loadHome("smart-home-1.js");
        SmartHomeRemoteControl controller = new SmartHomeRemoteControl("1234");
        Command testCommand = new CloseHallDoorCommand(smarthome);
        controller.setCommandToButton("A", testCommand);
        controller.onButtonPressed("A", "1234");
        for (Room room: smarthome.getRooms()) {
            if (room.getName().equals("hall")) {
                for (Door door: room.getDoors()) {
                    Assert.assertFalse(door.isOpen());
                }
            }
            for (Light light: room.getLights()) {
                Assert.assertFalse(light.isOn());
            }
        }
    }

    @Test
    public void noSuchCommandTest() throws IOException {
        FileSmartHomeReader reader = new FileSmartHomeReader();
        SmartHome smarthome = reader.loadHome("smart-home-1.js");
        SmartHomeRemoteControl controller = new SmartHomeRemoteControl("1234");
        Command testCommand = new ActivateAlarmCommand(smarthome.getAlarm(), "0000");
        controller.setCommandToButton("B", testCommand);
        controller.onButtonPressed("1", "1234");
        Assert.assertFalse(smarthome.getAlarm().getState() instanceof ActiveState);
    }

    @Test
    public void SuccTurnOnAlarmTest() throws IOException {
        FileSmartHomeReader reader = new FileSmartHomeReader();
        SmartHome smarthome = reader.loadHome("smart-home-1.js");
        SmartHomeRemoteControl controller = new SmartHomeRemoteControl("1234");
        Alarm testAlarm = new Alarm("1121");
        smarthome.set_alarm(testAlarm);
        Command testCommand = new AlarmOnCommand(smarthome.getAlarm());
        controller.setCommandToButton("B", testCommand);
        controller.onButtonPressed("B", "1234");
        Assert.assertTrue(smarthome.getAlarm().getState() instanceof AlarmState);
    }


}
