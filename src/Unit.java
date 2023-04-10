import java.util.ArrayList;
import java.util.Arrays;

public class Unit extends Manager {
    String id;
    String name;
    String code;
    String description;
    boolean isDividable;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean getIsDividable() {
        return isDividable;
    }

    public void setIsDividable(boolean isDividable) {
        this.isDividable = isDividable;
    }

}

