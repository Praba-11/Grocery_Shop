import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;

public class ProductManager extends Manager {
    ProductAction productAction = new ProductBuilder();
    public void execute(ArrayList arrayOfCommands) throws SQLException, ClassNotFoundException {

        String action = arrayOfCommands.get(1).toString();

        if (action.equals("create")) {
            if (validate(arrayOfCommands))
                out("Product already exists.");
            else
                productAction.create(arrayOfCommands);
        }

        else if (action.equals("edit")) {
            productAction.edit(arrayOfCommands);
        }

        else if (action.equals("delete")) {
            // delete
        }


        else if (action.equals("list")) {
            // list
        }

        else out("Invalid command, please try again.");
    }
    boolean validate(ArrayList arrayOfCommands) throws SQLException, ClassNotFoundException {

        boolean count = false;

        ConnectionDB connectionDB = new ConnectionDB();
        String productCode = arrayOfCommands.get(2).toString();

        Statement statement = connectionDB.getConnection().createStatement();
        String query = "SELECT COUNT(*) FROM products WHERE code = '" + productCode + "'";
        ResultSet resultSet = statement.executeQuery(query);

        if (resultSet.next())
            count = resultSet.getBoolean(1);
        return count;

    }
}
