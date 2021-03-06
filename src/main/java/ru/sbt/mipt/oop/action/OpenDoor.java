package ru.sbt.mipt.oop.action;

import ru.sbt.mipt.oop.object.Door;
import ru.sbt.mipt.oop.object.Room;

public class OpenDoor implements Action {
  String door_id;
  String room_name;

  public OpenDoor(String object_id) {
    door_id = object_id;
    room_name = "none";
  }

  public String GetRoom() {return room_name;}

  public void InspectRoom (Room room) {
    if (door_id.equals("all")) {
      room_name = room.getName();
    } else {
      for (Door door : room.getDoors()) {
        if (door.getId().equals(door_id)) {
          room_name = room.getName();
        }
      }
    }
  }

  public void run(Object object) {
    if(object instanceof Door) {
      String object_id = ((Door) object).getId();
      if (door_id.equals(object_id) || door_id.equals("all")) {
        ((Door) object).setOpen(true);
        System.out.println("Door " + object_id + " in room " + room_name + " was opened.");

      }
    } else if (object instanceof Room && room_name.equals("none"))  {
      InspectRoom((Room) object);
    }
  }

}
