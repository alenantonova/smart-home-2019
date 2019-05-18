package ru.sbt.mipt.oop;

import rc.RemoteControl;
import ru.sbt.mipt.oop.command.Command;

import java.util.HashMap;
import java.util.Scanner;


public class SmartHomeRemoteControl implements RemoteControl {
    HashMap<String, Command> commands;
    String rcId;

    public SmartHomeRemoteControl(String initRcId) {
        commands = new HashMap<>();
        this.rcId = initRcId;
    }

    public void setCommandToButton(String button, Command command) {
        if (commands.containsKey(button)) {
            System.out.println("This button has already had command, change it? (y/n)");
            Scanner in = new Scanner(System.in);
            if (in.nextLine().equals("y")) {
                commands.remove(button);
                commands.put(button, command);
            }
            return;
        }

        commands.put(button, command);
    }

    public void onButtonPressed(String buttonCode, String rcId) {
        if(commands.containsKey(buttonCode)) {
            commands.get(buttonCode).execute();
        } else {
            System.out.println("No command on this button");
        }
    }

}
