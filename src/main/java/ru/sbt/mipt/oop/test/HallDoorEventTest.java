package ru.sbt.mipt.oop.test;

import static ru.sbt.mipt.oop.SensorEventType.DOOR_CLOSED;

import java.io.IOException;
import org.junit.Assert;
import org.junit.Test;
import ru.sbt.mipt.oop.object.Door;
import ru.sbt.mipt.oop.homereader.FileSmartHomeReader;
import ru.sbt.mipt.oop.handler.HallDoorEventHandler;
import ru.sbt.mipt.oop.object.Light;
import ru.sbt.mipt.oop.object.Room;
import ru.sbt.mipt.oop.event.SensorEvent;
import ru.sbt.mipt.oop.SmartHome;


public class HallDoorEventTest {

  @Test
  public void closeHallDoor() throws IOException {
    FileSmartHomeReader reader = new FileSmartHomeReader();
    SmartHome smarthome = reader.loadHome("smart-home-1.js");
    SensorEvent test_event = new SensorEvent(DOOR_CLOSED, "4");
    HallDoorEventHandler handler = new HallDoorEventHandler();
    handler.handleEvent(smarthome, test_event);
    for(Room room: smarthome.getRooms()) {
      if (room.getName().equals("hall")) {
        for(Door door: room.getDoors()) {
          if (door.getId().equals("4")) {
            Assert.assertFalse(door.isOpen());
          }
        }
      }
      for(Light light: room.getLights()) {
        Assert.assertFalse(light.isOn());
      }
    }
  }

}
