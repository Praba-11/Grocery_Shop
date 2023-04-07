import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static String command;
    public static String[] splitCommandsByComma;
    public static void main(String[] args) {
        while (true) {
            System.out.print("> ");
            Scanner scanner = new Scanner(System.in);
            command = scanner.nextLine();
            command = command.trim();
            splitCommandsByComma = command.split(",");
            ArrayList arrayOfCommands = new ArrayList<>();
            for (int index = 0; index < splitCommandsByComma.length; index++) {
                String trimmedCommand = splitCommandsByComma[index].trim();
                String[] splitCommandBySpaces = splitCommandsByComma[0].split("\\s+");
                if (index == 0) {
                    for (String cmd : splitCommandBySpaces)
                        arrayOfCommands.add(cmd);
                } else
                    arrayOfCommands.add(trimmedCommand);
            }

            // All commands for unit
            if (command.lastIndexOf(",") != command.length() - 1) {
                if (arrayOfCommands.get(0).equals("unit")) {
                    Unit unit = new Unit();
                    unit.execute(arrayOfCommands);
                }
            } else out("Invalid command, please try again.");
        }
    }
    public static void out(String output) {
        System.out.println(">> " + output);
    }
}