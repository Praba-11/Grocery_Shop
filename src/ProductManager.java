import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;

public class ProductManager extends Main {

    public void editProduct(ArrayList arrayOfCommands) {
        System.out.println(Arrays.toString(splitCommandsByComma));
        System.out.println(arrayOfCommands);
        if (arrayOfCommands.get(2).equals("help")) {
            out("Edit product using following template. Copy the product data from the list, edit the attribute values.\nid: <id - 6>, name: <name-edited>, unitcode: <unitcode>,  type: <type>, price: <price>");
            out("You can also restrict the product data by editable attributes. Id attribute is mandatory for all the edit operation.\nid: <id - 6>, name: <name-edited>, unitcode: <unitcode-edited>");
            out("You can not give empty or null values to the mandatory attributes.\nid: <id - 6>, name: , unitcode: null");
        }
        else if (splitCommandsByComma.length == 5 && arrayOfCommands.size() == 8) {
            StringBuilder[] productArrayEdited = new StringBuilder[4];
            boolean flag = true;
            int i = 0;
            for (int index = 4; index < 8; index++) {
                productArrayEdited[i] = new StringBuilder();
                String[] splitCommandByColon = arrayOfCommands.get(index).toString().replaceAll("\\s+", "").split(":");
                System.out.println(Arrays.toString(splitCommandByColon));
                if ((splitCommandByColon[0].equals("name") && splitCommandByColon[1].length() > 2 && splitCommandByColon[1].length() < 30) || (splitCommandByColon[0].equals("unitcode") && splitCommandByColon[1].length() < 5) || (splitCommandByColon[0].equals("type")) || (splitCommandByColon[0].equals("price"))) {
                    productArrayEdited[i].append(splitCommandByColon[1]);
                    i = i + 1;
                } else { flag = false; break; }
            }
            if (flag == true)
                // Edit product operation

                System.out.println(Arrays.toString(productArrayEdited));
            else out("Invalid syntax.");
        } else out("Invalid command, please try again.");
    }
    public void deleteProduct(ArrayList arrayOfCommands) {
        String deleteProductWithId = arrayOfCommands.get(2).toString();
        // delete product using id

    }
    public void listProduct(ArrayList arrayOfCommands) {

    }
}
