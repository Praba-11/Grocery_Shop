import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Connection connection = new ConnectionDB().getConnection();
        while (true) {
            System.out.print("> ");
            Scanner scanner = new Scanner(System.in);
            String command = scanner.nextLine();
            String[] splitCommandsByComma = command.split(",");
            ArrayList arrayOfCommands = new ArrayList<>();
            for (int index = 0; index < splitCommandsByComma.length; index++) {
                String trimmedCommand = splitCommandsByComma[index].trim();
                String[] splitCommandBySpaces = splitCommandsByComma[0].split("\\s+");
                if (index == 0) {
                    for (String cmd : splitCommandBySpaces)
                        arrayOfCommands.add(cmd);
                }
                else
                    arrayOfCommands.add(trimmedCommand);
            }
            System.out.println(arrayOfCommands);

        }
    }
    public static void out(String output) {
        System.out.println(">> " + output);
    }
}