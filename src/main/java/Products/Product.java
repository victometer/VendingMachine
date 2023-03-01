package Products;

import Interfaces.IBuyable;

public abstract class Product implements IBuyable {
    private double price;
    private String brand;

    public Product(double price, String brand){
        this.price = price;
        this.brand = brand;
    }

    public double getPrice() {
        return price;
    }

    public String getBrand() {
        return brand;
    }
}
