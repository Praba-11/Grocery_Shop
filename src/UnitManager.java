import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class UnitManager extends Manager{
    UnitAction unitAction = new UnitBuilder();

    public void execute(ArrayList arrayOfCommands) throws SQLException, ClassNotFoundException {

        String action = arrayOfCommands.get(1).toString();

        if (action.equals("create")) {
            if (validate(arrayOfCommands))
                out("Product already exists.");
            else
                unitAction.create(arrayOfCommands);
        }

        else if (action.equals("edit")) {}
            // edit

        else if (action.equals("delete")) {}
            // delete

        else if (action.equals("list")) {}
            // list

        else out("Invalid command, please try again.");
    }

    public boolean validate(ArrayList arrayOfCommands) throws SQLException, ClassNotFoundException {
        boolean count = false;

        ConnectionDB connectionDB = new ConnectionDB();
        String unitCode = arrayOfCommands.get(2).toString();

        Statement statement = connectionDB.getConnection().createStatement();
        String query = "SELECT COUNT(*) FROM unit WHERE code = '" + unitCode + "'";
        ResultSet resultSet = statement.executeQuery(query);

        if (resultSet.next())
            count = resultSet.getBoolean(1);
        return count;
    }
}
