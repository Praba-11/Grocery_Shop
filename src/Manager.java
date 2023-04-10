import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Manager {
    public static String command;
    public static String[] splitCommandsByComma;
    public static void main(String[] args) throws SQLException, ClassNotFoundException {

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
            UnitManager unitManager = new UnitManager();
            ProductManager productManager = new ProductManager();
            if (command.lastIndexOf(",") != command.length() - 1) {
                if (arrayOfCommands.get(0).equals("unit")) {
                    unitManager.execute(arrayOfCommands);
                }
                else if (arrayOfCommands.get(0).equals("product")) {
                    productManager.execute(arrayOfCommands);
                }
                else out("Invalid command, please try again.");
            } else out("Invalid command, please try again.");
        }
    }
    public static void out(String output) {
        System.out.println(">> " + output);
    }
}