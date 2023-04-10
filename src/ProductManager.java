import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;

public class ProductManager {
    public static void out(String output) {
        System.out.println(">> " + output);
    }
    ProductAction productAction = new ProductMethods();
    public void execute(ArrayList arrayOfCommands) throws SQLException, ClassNotFoundException {
        String action = arrayOfCommands.get(1).toString();
        if (action.equals("create"))
            productAction.createProduct(arrayOfCommands);
        else if (action.equals("edit"))
            productAction.editProduct(arrayOfCommands);
        else if (action.equals("delete")) {}
            // delete
        else if (action.equals("list")) {}
            // list
        else out("Invalid command, please try again.");
    }
}
