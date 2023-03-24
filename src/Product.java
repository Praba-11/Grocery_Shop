public class Product {
    int id;
    String code;
    String name;
    String unitCode;
    String type;
    float availableQuantity;
    float price;
    float costPrice;

    public Product(int id, String code, String name, String unitCode, String type, float availableQuantity, float price, float costPrice) {
        this.id = id;
        this.code = code;
        this.name = name;
        this.unitCode = unitCode;
        this.type = type;
        this.availableQuantity = availableQuantity;
        this.price = price;
        this.costPrice = costPrice;
    }
}
