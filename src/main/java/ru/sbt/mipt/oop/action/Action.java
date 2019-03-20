package ru.sbt.mipt.oop.action;

public interface Action<T> {

  String get_location();
  String get_area();
  void run(T object, String room_name);
}
