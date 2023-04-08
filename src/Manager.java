import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Arrays;

public class Manager extends Main {
    public void productCreate(ArrayList arrayOfCommands) {
        if (arrayOfCommands.get(2).equals("help"))
            out("Create product using the following template\ncode, name, unit, type, price, stock\ncode - text, min - 2 - 6, mandatory\nname - text, min 3 - 30 char, mandatory\nunitcode - text, kg/l/piece/combo, mandatory\ntype - text, between enumerated values, mandatory\nprice - number, mandatory\nstock - number, default 0");
        else if (arrayOfCommands.size() == 7) {
            Product product = new Product();
            product.setCode(arrayOfCommands.get(2).toString());
            product.setName(arrayOfCommands.get(3).toString());
            product.setUnitCode(arrayOfCommands.get(4).toString());
            product.setType(arrayOfCommands.get(5).toString());
            product.setCostPrice(Integer.parseInt(arrayOfCommands.get(6).toString()));
            // store created product in database

        }
        else out("Invalid command, please try again.");
    }

    public void productEdit(ArrayList arrayOfCommands) {
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
                } else { flag = false; break;}
            }
            if (flag == true)
                // Edit product operation
                System.out.println(Arrays.toString(productArrayEdited));
            else out("Invalid syntax.");
        }
        else out("Invalid command, please try again.");
    }
    public void productDelete(ArrayList arrayOfCommands) {
        String deleteProductWithId = arrayOfCommands.get(2).toString();
        // delete product using id

    }
    public void productList(ArrayList arrayOfCommands) {

    }
}
