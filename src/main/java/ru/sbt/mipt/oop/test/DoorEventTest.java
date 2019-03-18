package ru.sbt.mipt.oop.test;

import java.io.IOException;
import org.junit.Assert;
import org.junit.Test;
import ru.sbt.mipt.oop.Door;
import ru.sbt.mipt.oop.handler.DoorEventHandler;
import ru.sbt.mipt.oop.FileSmartHomeReader;
import ru.sbt.mipt.oop.Room;
import ru.sbt.mipt.oop.SensorEvent;
import ru.sbt.mipt.oop.SmartHome;

import static ru.sbt.mipt.oop.SensorEventType.DOOR_CLOSED;
import static ru.sbt.mipt.oop.SensorEventType.DOOR_OPEN;


public class DoorEventTest {

  @Test
  public void openKitchenDoor() throws IOException {
    FileSmartHomeReader reader = new FileSmartHomeReader();
    SmartHome smarthome = reader.loadHome("smart-home-1.js");
    SensorEvent test_event = new SensorEvent(DOOR_OPEN, "1");
    DoorEventHandler handler = new DoorEventHandler();
    handler.handleEvent(smarthome, test_event);
    for(Room room: smarthome.getRooms()) {
      String cur_room = room.getName();
      if(cur_room.equals("kitchen")) {
        for(Door door: room.getDoors()) {
          String cur_door_id = door.getId();
          if(cur_door_id.equals("1")) {
            Assert.assertTrue(door.isOpen());
          }
        }
      }
    }
  }

  @Test
  public void closeBedroomDoor() throws IOException {
    FileSmartHomeReader reader = new FileSmartHomeReader();
    SmartHome smarthome = reader.loadHome("smart-home-1.js");
    SensorEvent test_event = new SensorEvent(DOOR_CLOSED, "3");
    DoorEventHandler handler = new DoorEventHandler();
    handler.handleEvent(smarthome, test_event);
    for(Room room: smarthome.getRooms()) {
      String cur_room = room.getName();
      if(cur_room.equals("bedroom")) {
        for(Door door: room.getDoors()) {
          String cur_door_id = door.getId();
          if(cur_door_id.equals("3")) {
            Assert.assertFalse(door.isOpen());
          }
        }
      }
    }
  }

}
