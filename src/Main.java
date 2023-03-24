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
            String cmd[] = command.split("[, ]");
            System.out.println(Arrays.toString(cmd));
            if (cmd[0].equals("end"))
                break;
            if (cmd[0].equals("unit") && cmd[1].equals("create")) {
                if (cmd.length == 3 && cmd[2].equals("help"))
                    exec("Create Unit using following template.\nName, Code, Description, isDividable\nname - text, mandatory with 3 to 30 chars\ncode - text, maximum 4 char, mandatory\ndescription - text\nisdividable - boolean, mandatory");
                else if (cmd.length == 5) {
                    String name = cmd[3];
                    String code = cmd[4];
                    String desc = cmd[5];
                    boolean isDividable = Boolean.parseBoolean(cmd[6]);
                }
            }
        }
    }
    public static void exec(String output) {
        System.out.println(">> " + output);
    }
}