package ru.sbt.mipt.oop;

import java.io.IOException;

public interface SmartHomeReader {
  SmartHome loadHome(String path) throws IOException;

}
