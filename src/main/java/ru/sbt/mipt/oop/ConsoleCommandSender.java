package ru.sbt.mipt.oop;

public class ConsoleCommandSender implements CommandSender{
  public void sendCommand(SensorCommand command) {
    System.out.println("Pretent we're sending command " + command);
  }
}
