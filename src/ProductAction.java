import java.sql.SQLException;
import java.util.ArrayList;

public interface ProductAction {
    void create(ArrayList arrayOfCommands) throws SQLException, ClassNotFoundException;
    void edit(ArrayList arrayOfCommands) throws SQLException, ClassNotFoundException;

}
