import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;

public class ProductManager extends Manager {
    ProductAction productAction = new ProductBuilder();
    public void execute(ArrayList arrayOfCommands) throws SQLException, ClassNotFoundException {
        String action = arrayOfCommands.get(1).toString();
        if (action.equals("create"))

            productAction.create(arrayOfCommands);
        else if (action.equals("edit"))
            productAction.edit(arrayOfCommands);
        else if (action.equals("delete")) {}
            // delete
        else if (action.equals("list")) {}
            // list
        else out("Invalid command, please try again.");
    }
}
