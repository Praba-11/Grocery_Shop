import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

public class UnitBuilder extends Manager implements UnitAction {
    @Override
    public void create(ArrayList arrayOfCommands) throws SQLException, ClassNotFoundException {

        if (arrayOfCommands.get(2).equals("help"))
            out("Create unit with the following template: unit create name, code, description, isDividable\nname - TEXT, MANDATORY WITH 3 - 30 CHARACTERS\ncode - TEXT, MANDATORY WITH 4 CHARACTERS MAXIMUM\ndescription\nisDividable - BOOLEAN, MANDATORY");

        else if (arrayOfCommands.size() == 7) {

            // Creating Unit Object
            Unit unit = new Unit();
            unit.setId(arrayOfCommands.get(2).toString());
            unit.setName(arrayOfCommands.get(3).toString());
            unit.setCode(arrayOfCommands.get(4).toString());
            unit.setDescription(arrayOfCommands.get(5).toString());
            unit.setIsDividable(Boolean.valueOf(arrayOfCommands.get(6).toString()));

            // Storing Unit in Database
            ConnectionDB connectionDB = new ConnectionDB();
            String sql = "INSERT INTO unit (id, name, code, description, isDividable) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement preparedStatement = connectionDB.getConnection().prepareStatement(sql);
            preparedStatement.setString(1, unit.getCode());
            preparedStatement.setString(2, unit.getName());
            preparedStatement.setString(3, unit.getCode());
            preparedStatement.setString(4, unit.getDescription());
            preparedStatement.setBoolean(5, unit.getIsDividable());
            preparedStatement.executeUpdate();
            out("Unit entry added.");
        }

        else
            out("Invalid command, please try again.");
    }
}