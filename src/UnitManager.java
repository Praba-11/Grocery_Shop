import java.sql.SQLException;
import java.util.ArrayList;

public class UnitManager extends Manager{
    UnitAction unitAction = new UnitBuilder();

    public void execute(ArrayList arrayOfCommands) throws SQLException, ClassNotFoundException {
        String action = arrayOfCommands.get(1).toString();
        if (action.equals("create"))
            unitAction.create(arrayOfCommands);
        else if (action.equals("edit")) {}
            // edit
        else if (action.equals("delete")) {}
        // delete
        else if (action.equals("list")) {}
        // list
        else out("Invalid command, please try again.");
    }
}
