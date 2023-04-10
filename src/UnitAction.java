import java.sql.SQLException;
import java.util.ArrayList;

public interface UnitAction {
    void create(ArrayList arrayOfCommands) throws SQLException, ClassNotFoundException;
    void edit(ArrayList arrayOfCommands);
}
