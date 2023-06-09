import java.sql.Array;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;

public class ProductBuilder extends Manager implements ProductAction {
    @Override
    public void create(ArrayList arrayOfCommands) throws SQLException, ClassNotFoundException {

        if (arrayOfCommands.get(2).equals("help"))
            out("Create product using the following template\ncode, name, unit, type, price, stock\ncode - text, min - 2 - 6, mandatory\nname - text, min 3 - 30 char, mandatory\nunitcode - text, kg/l/piece/combo, mandatory\ntype - text, between enumerated values, mandatory\nprice - number, mandatory\nstock - number, default 0");

        else if (arrayOfCommands.size() == 7) {

            // Creating Product Object
            Product product = new Product();
            product.setCode(arrayOfCommands.get(2).toString());
            product.setName(arrayOfCommands.get(3).toString());
            product.setUnitCode(arrayOfCommands.get(4).toString());
            product.setType(arrayOfCommands.get(5).toString());
            product.setCostPrice(Float.parseFloat(arrayOfCommands.get(6).toString()));

            // Storing Product in Database
            ConnectionDB connectionDB = new ConnectionDB();
            String sql = "INSERT INTO products (code, name, unit_code, type, price, stock) VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement preparedStatement = connectionDB.getConnection().prepareStatement(sql);
            preparedStatement.setString(1, product.getCode());
            preparedStatement.setString(2, product.getName());
            preparedStatement.setString(3, product.getUnitCode());
            preparedStatement.setString(4, product.getType());
            preparedStatement.setFloat(5, product.getCostPrice());
            preparedStatement.setInt(6, 0);
            preparedStatement.executeUpdate();
            out("Product entry added.");
        }

        else
            out("Invalid command, please try again.");
    }

    @Override
    public void edit(ArrayList arrayOfCommands) throws SQLException, ClassNotFoundException {

        if (arrayOfCommands.get(2).equals("help")) {
            out("Edit product using following template. Copy the product data from the list, edit the attribute values.\nid: <id - 6>, name: <name-edited>, unitcode: <unitcode>,  type: <type>, price: <price>");
            out("You can also restrict the product data by editable attributes. Id attribute is mandatory for all the edit operation.\nid: <id - 6>, name: <name-edited>, unitcode: <unitcode-edited>");
            out("You can not give empty or null values to the mandatory attributes.\nid: <id - 6>, name: , unitcode: null");
        }

        else if (splitCommandsByComma.length == 5 && arrayOfCommands.size() == 8) {
            ArrayList productArrayEdited = new ArrayList<>();
            productArrayEdited.add(arrayOfCommands.get(2).toString());
            productArrayEdited.add(Float.parseFloat(arrayOfCommands.get(3).toString()));
            boolean flag = true;
            for (int index = 4; index < 8; index++) {
                String[] splitCommandByColon = arrayOfCommands.get(index).toString().replaceAll("\\s+", "").split(":");
                if ((splitCommandByColon[0].equals("name") && splitCommandByColon[1].length() > 2 && splitCommandByColon[1].length() < 30) || (splitCommandByColon[0].equals("unitcode") && splitCommandByColon[1].length() < 5) || (splitCommandByColon[0].equals("type"))) {
                    productArrayEdited.add(splitCommandByColon[0]);
                    productArrayEdited.add(splitCommandByColon[1]);
                }
                else if (splitCommandByColon[0].equals("price")) {
                    productArrayEdited.add(splitCommandByColon[0]);
                    productArrayEdited.add(Integer.parseInt(splitCommandByColon[1]));
                }
                else { flag = false; break; }
            }
            if (flag == true) {
                int size = productArrayEdited.size();
                ConnectionDB connectionDB = new ConnectionDB();
                // Edit product in Database
                editDatabase(productArrayEdited, size);
                if (productArrayEdited.size() == 4) {
                    String sql = "UPDATE products SET ? = ?";
                    PreparedStatement preparedStatement = connectionDB.getConnection().prepareStatement(sql);

                }

            }
            else out("Invalid syntax, please try again.");
        }

        else out("Invalid command, please try again.");
    }

    void editDatabase(ArrayList productArrayEdited, int size) {

    }
}
