import java.util.ArrayList;
import java.util.Arrays;

public class Unit extends Main {

    public void execute(ArrayList arrayOfCommands) {
        int size = arrayOfCommands.size();
        int length = splitCommandsByComma.length;
        switch (length) {
            case 1:
                if (size == 3 && arrayOfCommands.get(2).equals("help")) {
                    if (arrayOfCommands.get(1).toString().equals("create")) {
                        out("Create unit with the following template: unit create name, code, description, isDividable\nname - TEXT, MANDATORY WITH 3 - 30 CHARACTERS\ncode - TEXT, MANDATORY WITH 4 CHARACTERS MAXIMUM\ndescription\nisDividable - BOOLEAN, MANDATORY");
                    }
                    else if (arrayOfCommands.get(1).toString().equals("list")) {
                        out("List unit with the following options.");
                        out("unit list -- WILL LIST ALL THE UNITS");
                    } else if (arrayOfCommands.get(1).toString().equals("edit")) {
                        out("Edit unit with the following template. \nid: <id - 6>, name: <name-edited>, code: <code>, description: <description>, isDividable: <isDividable>");
                        out("You can also restrict the user data by editable attributes. ID attribute is mandatory for all edit operations.\nid: <id - 6>, name: <name>, code: <code>");
                        out("You cannot give empty or null values to the mandatory attributes.");
                    } else if (arrayOfCommands.get(1).toString().equals("delete")) {
                        out("Delete unit using the following template.\ncode - TEXT, MINIMUM 3 - 30 CHARACTERS, MANDATORY, EXISTING");
                    } else {
                        out("Invalid command, please try again.");
                        break;
                    }
                } else if (size == 3 && arrayOfCommands.get(1).equals("delete")) {
                    String unitCodeToDelete = arrayOfCommands.get(2).toString();
                    // Delete unit operation
                    out("unit delete. Check!!");
                } else out("Invalid command, please try again.");
                break;

            case 4:
                if (size == 6 && arrayOfCommands.get(1).equals("create")) {
                    String unitName = arrayOfCommands.get(2).toString();
                    String unitCode = arrayOfCommands.get(3).toString();
                    String unitDescription = arrayOfCommands.get(4).toString();
                    boolean isDividable = Boolean.valueOf(arrayOfCommands.get(5).toString());
                    // Create unit operation
                    out("unit create. Check!!");
                }
                else out("Invalid command, please try again.");
                break;

            case 5:
                if (size == 8 && arrayOfCommands.get(1).equals("edit")) {
                    StringBuilder[] unitArrayEdited = new StringBuilder[4];
                    boolean flag = true;
                    int i = 0;
                    for (int index = 4; index < 8; index++) {
                        unitArrayEdited[i] = new StringBuilder();
                        String[] splitCommandByColon = arrayOfCommands.get(index).toString().replaceAll("\\s+", "").split(":");
                        if ((splitCommandByColon[0].equals("name") && splitCommandByColon[1].length() > 2 && splitCommandByColon[1].length() < 30) || (splitCommandByColon[0].equals("code") && splitCommandByColon[1].length() < 5) || (splitCommandByColon[0].equals("description")) || (splitCommandByColon[0].equals("isdividable"))) {
                            unitArrayEdited[i].append(splitCommandByColon[1]);
                            i = i + 1;
                        }
                        else {
                            flag = false;
                            break;
                        }
                    }
                    if (flag == true)
                        // Edit unit operation
                        System.out.println(Arrays.toString(unitArrayEdited));
                    else
                        System.out.println("Invalid syntax.");
                }
                else out("Invalid command, please try again.");
                break;

            default:
                out("Invalid command, please try again.");
                break;

        }
    }
}

