package ru.sbt.mipt.oop;

import ru.sbt.mipt.oop.action.Action;

public interface Actionable<T> {
  void execute(Action<T> action);

}
