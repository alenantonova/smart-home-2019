package ru.sbt.mipt.oop.test;

import static ru.sbt.mipt.oop.SensorEventType.LIGHT_OFF;
import static ru.sbt.mipt.oop.SensorEventType.LIGHT_ON;

import java.io.IOException;
import org.junit.Assert;
import org.junit.Test;
import ru.sbt.mipt.oop.FileSmartHomeReader;
import ru.sbt.mipt.oop.Light;
import ru.sbt.mipt.oop.handler.LightEventHandler;
import ru.sbt.mipt.oop.Room;
import ru.sbt.mipt.oop.SensorEvent;
import ru.sbt.mipt.oop.SmartHome;

public class LightEventTest {
  @Test
  public void turnOnBedroomLight() throws IOException {
    FileSmartHomeReader reader = new FileSmartHomeReader();
    SmartHome smarthome = reader.loadHome("smart-home-1.js");
    SensorEvent test_event = new SensorEvent(LIGHT_ON, "4");
    LightEventHandler handler = new LightEventHandler();
    handler.handleEvent(smarthome, test_event);
    for(Room room: smarthome.getRooms()) {
      String cur_room = room.getName();
      if(cur_room.equals("bedroom")) {
        for(Light light: room.getLights()) {
          String cur_light_id = light.getId();
          if(cur_light_id.equals("4")) {
            Assert.assertTrue(light.isOn());
          }
        }
      }
    }
  }

  @Test
  public void turnOffBathroomLight() throws IOException {
    FileSmartHomeReader reader = new FileSmartHomeReader();
    SmartHome smarthome = reader.loadHome("smart-home-1.js");
    SensorEvent test_event = new SensorEvent(LIGHT_OFF, "3");
    LightEventHandler handler = new LightEventHandler();
    handler.handleEvent(smarthome, test_event);
    for(Room room: smarthome.getRooms()) {
      String cur_room = room.getName();
      if(cur_room.equals("bathroom")) {
        for(Light light: room.getLights()) {
          String cur_light_id = light.getId();
          if(cur_light_id.equals("3")) {
            Assert.assertFalse(light.isOn());
          }
        }
      }
    }
  }
}
