package ru.sbt.mipt.oop.homereader;

import ru.sbt.mipt.oop.SmartHome;

import java.io.IOException;

public interface SmartHomeReader {
  SmartHome loadHome(String path) throws IOException;

}
