package ru.sbt.mipt.oop.action;

public interface Action<T> {

  String get_location();
  void set_location(String location_name);


  boolean run(T object);
  void print_result();
}
