package Products;

public abstract class Product {
    private int price;
    private String brand;
    private int code;

    public Product(int price, String brand, int code){
        this.price = price;
        this.brand = brand;
        this.code = code;
    }

    public int getPrice() {
        return price;
    }

    public String getBrand() {
        return brand;
    }

    public int getCode() {
        return code;
    }
}
