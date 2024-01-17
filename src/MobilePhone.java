class CellPhone extends Product {
    String memory;
    double screenSize;
    int batteryPower;
    int ram;
    String color;

    public CellPhone(int id, double unitPrice, double discountRate, int stockQuantity, String productName,
                     Brand brand, String memory, double screenSize, int batteryPower, int ram, String color) {
        super(id, unitPrice, discountRate, stockQuantity, productName, brand);
        this.memory = memory;
        this.screenSize = screenSize;
        this.batteryPower = batteryPower;
        this.ram = ram;
        this.color = color;
    }

    @Override
    void displayDetails() {
        System.out.format("ID: %d, Product: %s, Brand: %s, Price: %.2f, Stock: %d, Discount: %.2f%n",
                id, productName, brand.name, unitPrice, stockQuantity, discountRate);
        System.out.format("Memory: %s, Screen Size: %.1f inch, Battery Power: %d, RAM: %d MB, Color: %s%n",
                memory, screenSize, batteryPower, ram, color);
    }
}