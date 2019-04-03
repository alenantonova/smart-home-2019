package ru.sbt.mipt.oop.homereader;

import com.google.gson.Gson;
import ru.sbt.mipt.oop.SmartHome;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileSmartHomeReader implements SmartHomeReader {
  public SmartHome loadHome(String path) throws IOException {
    Gson gson = new Gson();
    String json = new String(Files.readAllBytes(Paths.get(path)));
     return gson.fromJson(json, SmartHome.class);
  }

}
