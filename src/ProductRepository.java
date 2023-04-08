import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

public class ProductRepository extends Main {
    public void createProduct(ArrayList arrayOfCommands) throws SQLException, ClassNotFoundException {
        if (arrayOfCommands.get(2).equals("help"))
            out("Create product using the following template\ncode, name, unit, type, price, stock\ncode - text, min - 2 - 6, mandatory\nname - text, min 3 - 30 char, mandatory\nunitcode - text, kg/l/piece/combo, mandatory\ntype - text, between enumerated values, mandatory\nprice - number, mandatory\nstock - number, default 0");
        else if (arrayOfCommands.size() == 7) {
            Product product = new Product();
            product.setCode(arrayOfCommands.get(2).toString());
            product.setName(arrayOfCommands.get(3).toString());
            product.setUnitCode(arrayOfCommands.get(4).toString());
            product.setType(arrayOfCommands.get(5).toString());
            product.setCostPrice(Float.parseFloat(arrayOfCommands.get(6).toString()));
            // store created product in database
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
            out("product inserted");
        }
        else out("Invalid command, please try again.");
    }
}
