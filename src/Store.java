import java.util.*;

public class Store {
    private static ArrayList<Brand> brands = new ArrayList<>();
    private static ArrayList<Product> products = new ArrayList<>();
    private static int productIdCounter = 1;

    public static void main(String[] args) {
        initializeBrands(); // Markaları oluştur

        Scanner scanner = new Scanner(System.in);

        while (true) {
            printMenu();
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    addProduct(scanner);
                    break;
                case 2:
                    deleteProduct(scanner);
                    break;
                case 3:
                    listProducts(scanner);
                    break;
                case 4:
                    filterProducts(scanner);
                    break;
                case 5:
                    System.out.println("Çıkılıyor...");
                    System.exit(0);
                default:
                    System.out.println("Geçersiz seçenek. Tekrar deneyin.");
            }
        }
    }

    private static void initializeBrands() {
        brands.add(new Brand(1, "Samsung"));
        brands.add(new Brand(2, "Lenovo"));
        brands.add(new Brand(3, "Apple"));
        brands.add(new Brand(4, "Huawei"));
        brands.add(new Brand(5, "Casper"));
        brands.add(new Brand(6, "Asus"));
        brands.add(new Brand(7, "HP"));
        brands.add(new Brand(8, "Xiaomi"));
        brands.add(new Brand(9, "Monster"));

        Collections.sort(brands, Comparator.comparing(brand -> brand.name)); // Alfabe sırasına göre sırala
    }

    private static void printMenu() {
        System.out.println("***** PatikaStore *****");
        System.out.println("1. Ürün Ekle");
        System.out.println("2. Ürün Sil");
        System.out.println("3. Ürünleri Listele");
        System.out.println("4. Ürünleri Filtrele");
        System.out.println("5. Çıkış");
        System.out.print("Seçenek: ");
    }

    private static void addProduct(Scanner scanner) {
        System.out.println("Ürün grubunu seçin (1: Cep Telefonu, 2: Notebook): ");
        int productType = scanner.nextInt();

        System.out.print("Ürün adı: ");
        String productName = scanner.next();

        System.out.print("Marka seçin: ");
        displayBrands();
        int brandId = scanner.nextInt();
        Brand selectedBrand = getBrandById(brandId);

        System.out.print("Birim fiyatı: ");
        double unitPrice = scanner.nextDouble();

        System.out.print("İndirim oranı: ");
        double discountRate = scanner.nextDouble();

        System.out.print("Stok miktarı: ");
        int stockQuantity = scanner.nextInt();

        if (productType == 1) {
            System.out.print("Hafıza bilgisi seçin (128 GB, 64 GB): ");
            String memory = scanner.next();

            System.out.print("Ekran boyutu (örn. 6,1): ");
            double screenSize = scanner.nextDouble();

            System.out.print("Pil gücü: ");
            int batteryPower = scanner.nextInt();

            System.out.print("RAM: ");
            int ram = scanner.nextInt();

            System.out.print("Renk: ");
            String color = scanner.next();

            CellPhone newCellPhone = new CellPhone(productIdCounter++, unitPrice, discountRate, stockQuantity,
                    productName, selectedBrand, memory, screenSize, batteryPower, ram, color);

            products.add(newCellPhone);
        } else if (productType == 2) {
            System.out.print("RAM: ");
            int ram = scanner.nextInt();

            System.out.print("Depolama (örn. 512 SSD): ");
            String storage = scanner.next();

            System.out.print("Ekran boyutu (örn. 14): ");
            double screenSize = scanner.nextDouble();

            Notebook newNotebook = new Notebook(productIdCounter++, unitPrice, discountRate, stockQuantity,
                    productName, selectedBrand, ram, storage, screenSize);

            products.add(newNotebook);
        } else {
            System.out.println("Geçersiz ürün tipi.");
        }

        System.out.println("Ürün başarıyla eklendi!");
    }

    private static void deleteProduct(Scanner scanner) {
        System.out.print("Silmek istediğiniz ürünün ID'sini girin: ");
        int productId = scanner.nextInt();

        Product productToDelete = getProductById(productId);

        if (productToDelete != null) {
            products.remove(productToDelete);
            System.out.println("Ürün başarıyla silindi!");
        } else {
            System.out.println("Belirtilen ID'ye sahip ürün bulunamadı.");
        }
    }

    private static void listProducts(Scanner scanner) {
        System.out.println("Ürün grubunu seçin (1: Cep Telefonu, 2: Notebook): ");
        int productType = scanner.nextInt();

        if (productType == 1) {
            System.out.println("***** Cep Telefonları *****");
            for (Product product : products) {
                if (product instanceof CellPhone) {
                    product.displayDetails();
                    System.out.println("----------------------------");
                }
            }
        } else if (productType == 2) {
            System.out.println("***** Notebooklar *****");
            for (Product product : products) {
                if (product instanceof Notebook) {
                    product.displayDetails();
                    System.out.println("----------------------------");
                }
            }
        } else {
            System.out.println("Geçersiz ürün tipi.");
        }
    }

    private static void filterProducts(Scanner scanner) {
        System.out.print("Filtrelemek istediğiniz markanın ID'sini girin: ");
        int brandId = scanner.nextInt();
        Brand selectedBrand = getBrandById(brandId);

        if (selectedBrand != null) {
            System.out.println("***** Filtrelenmiş Ürünler *****");
            for (Product product : products) {
                if (product.brand.id == selectedBrand.id) {
                    product.displayDetails();
                    System.out.println("----------------------------");
                }
            }
        } else {
            System.out.println("Belirtilen ID'ye sahip marka bulunamadı.");
        }
    }

    private static void displayBrands() {
        System.out.println("***** Markalar *****");
        for (Brand brand : brands) {
            System.out.println(brand.id + ". " + brand.name);
        }
    }

    private static Brand getBrandById(int brandId) {
        for (Brand brand : brands) {
            if (brand.id == brandId) {
                return brand;
            }
        }
        return null;
    }

    private static Product getProductById(int productId) {
        for (Product product : products) {
            if (product.id == productId) {
                return product;
            }
        }
        return null;
    }
}