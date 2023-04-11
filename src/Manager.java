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

            ArrayList arrayOfCommands = new ArrayList<>();
            command(arrayOfCommands);

            UnitManager unitManager = new UnitManager();
            ProductManager productManager = new ProductManager();

            if (command.lastIndexOf(",") != command.length() - 1) {
                String choice = arrayOfCommands.get(0).toString();
                switch (choice) {
                    case "unit": unitManager.execute(arrayOfCommands); break;
                    case "product": productManager.execute(arrayOfCommands); break;
                    default: out("Invalid command, please try again."); break;
                }
            } else out("Invalid command, please try again.");
        }
    }

    public static void out(String output) {
        System.out.println(">> " + output);
    }

    public static void command(ArrayList arrayOfCommands) {
        System.out.print("> ");
        Scanner scanner = new Scanner(System.in);
        command = scanner.nextLine();
        command = command.trim();
        splitCommandsByComma = command.split(",");
        for (int index = 0; index < splitCommandsByComma.length; index++) {
            String trimmedCommand = splitCommandsByComma[index].trim();
            String[] splitCommandBySpaces = splitCommandsByComma[0].split("\\s+");
            int flag = 0;
            if (index == 0) {
                for (String cmd : splitCommandBySpaces) {
                    if (flag == 2) {
                        String[] str = cmd.split(":");
                        for (String string : str) arrayOfCommands.add(string);
                    }
                    else arrayOfCommands.add(cmd);
                    flag++;
                }
            } else arrayOfCommands.add(trimmedCommand);
        }
    }
}