abstract class Product {
    int id;
    double unitPrice;
    double discountRate;
    int stockQuantity;
    String productName;
    Brand brand;

    public Product(int id, double unitPrice, double discountRate, int stockQuantity, String productName, Brand brand) {
        this.id = id;
        this.unitPrice = unitPrice;
        this.discountRate = discountRate;
        this.stockQuantity = stockQuantity;
        this.productName = productName;
        this.brand = brand;
    }

    abstract void displayDetails();
}