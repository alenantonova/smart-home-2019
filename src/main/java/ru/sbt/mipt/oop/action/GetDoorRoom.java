package ru.sbt.mipt.oop.action;

import ru.sbt.mipt.oop.Door;

public class GetDoorRoom implements Action<Door> {
  String target_id;
  String location;

  public GetDoorRoom(String id) {
    target_id = id;
    location = "none";
  }

  public void set_location(String location_name) {
    location = location_name;
  }

  public String get_location() {
    return location;
  }

  public void print_result() {
  }

  public boolean run(Door door) {
    return target_id.equals(door.getId());
  }

}
