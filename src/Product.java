import org.checkerframework.checker.units.qual.C;

import java.util.ArrayList;

public class Product extends Main {
    int id;
    String code;
    String name;
    String unitCode;
    String type;
    float availableQuantity;
    float price;
    float costPrice;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUnitCode() {
        return unitCode;
    }

    public void setUnitCode(String unitCode) {
        this.unitCode = unitCode;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public float getAvailableQuantity() {
        return availableQuantity;
    }

    public void setAvailableQuantity(float availableQuantity) {
        this.availableQuantity = availableQuantity;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public float getCostPrice() {
        return costPrice;
    }

    public void setCostPrice(float costPrice) {
        this.costPrice = costPrice;
    }

    public void execute(ArrayList arrayOfCommands) {
        String action = arrayOfCommands.get(1).toString();
        Control control = new Control();
        if (action.equals("create"))
            control.productCreate(arrayOfCommands);
        else if (action.equals("edit"))
            control.productEdit(arrayOfCommands);
        else if (action.equals("delete"))
            control.productDelete(arrayOfCommands);
        else if (action.equals("list"))
            control.productList(arrayOfCommands);
        else out("Invalid command, please try again.");
    }
}
