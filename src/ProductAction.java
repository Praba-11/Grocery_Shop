import java.sql.SQLException;
import java.util.ArrayList;

public interface ProductAction {
    void createProduct(ArrayList arrayOfCommands) throws SQLException, ClassNotFoundException;
    void editProduct(ArrayList arrayOfCommands) throws SQLException, ClassNotFoundException;

}
