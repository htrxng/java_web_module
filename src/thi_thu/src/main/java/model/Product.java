package model;

public class Product {
    private int productId;
    private String productName;
    private double price;
    private int quantity;
    private int colorId;
    private int categoryId;

    public Product() {
    }

    public Product(int productId, String productName, double price, int quantity, int colorId, int categoryId) {
        this.productId = productId;
        this.productName = productName;
        this.price = price;
        this.quantity = quantity;
        this.colorId = colorId;
        this.categoryId = categoryId;
    }

    public Product(String productName, Double price, int quantity, int colorId, int categoryId) {
        this.productName = productName;
        this.price = price;
        this.quantity = quantity;
        this.colorId = colorId;
        this.categoryId = categoryId;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getColorId() {
        return colorId;
    }

    public void setColorId(int colorId) {
        this.colorId = colorId;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }
}
