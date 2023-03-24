import java.sql.Connection;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        Connection connection = new ConnectionDB().getConnection();
        while (true) {
            System.out.print("> ");
            Scanner scanner = new Scanner(System.in);
            String command = scanner.nextLine();
            String cmd[] = command.split(" ");
            System.out.println(Arrays.toString(cmd));
            if (cmd[0].equals("end"))
                break;
            if (cmd[0].equals("unit") && cmd[1].equals("create") && cmd[2].equals("help"))
                exec("Create Unit using following template.\nName, Code, Description, isDividable\nname - text, mandatory with 3 to 30 chars\ncode - text, maximum 4 char, mandatory\ndescription - text\nisdividable - boolean, mandatory");


        }
    }
    public static void exec(String output) {
        System.out.println(">> " + output);
    }
}