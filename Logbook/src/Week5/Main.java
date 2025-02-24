package Week5;

import java.util.ArrayList;
import java.util.Objects;

class Product {
    public int ID;
    public String Name;
    public int Quantity;

    public Product(int ID, String name, int quantity) {
        SetID(ID);
        SetName(name);
        SetQuantity(quantity);
    }

    public void SetID(int ID) {
        this.ID = ID;
    }

    public void SetName(String name) {
        this.Name = name;
    }

    public void SetQuantity(int Quantity) {
        this.Quantity = Quantity;
    }

    public int GetID() {
        return ID;
    }

    public String GetName() {
        return Name;
    }

    public int GetQuantity() {
        return Quantity;
    }
}

class StockList {
    ArrayList<Product> Products = new ArrayList<>();

    public void AddToInventory(Product product) {
        Products.add(product);
    }

    public void PrintInventory() {
        for (Product product : Products) {
            System.out.println("Product ID: " + product.GetID());
            System.out.println("Product Name: " + product.GetName());
            System.out.println("Product Quantity: " + product.GetQuantity());
        }
    }

    public Product SearchInventoryBasedOnID(int ID) {
        for (Product product : Products) {
            if (product.ID == ID) {
                System.out.println("Found Product with an ID of " + ID);
                return product;
            }
        }

        return null;
    }

    public Product SearchInventoryBasedOnName(String Name) {
        for (Product product : Products) {
            if (Objects.equals(product.Name, Name)) {
                System.out.println("Found Product with Name of " + Name);
                return product;
            }
        }

        return null;
    }
}

class StockDemo {
    StockList stocks = new StockList();

    public StockDemo() {
        Run();
    }

    public void Run() {
        CreateTestProducts();
        PrintResults();

        stocks.SearchInventoryBasedOnID(1);
        stocks.SearchInventoryBasedOnName("Xbox Series X");
    }

    public void CreateTestProducts() {
        stocks.AddToInventory(new Product(1, "Xbox Series X", 100));
        stocks.AddToInventory(new Product(2, "MacBook Pro", 10));
        stocks.AddToInventory(new Product(3, "MacBook Air", 81));
        stocks.AddToInventory(new Product(4, "iPhone 16", 76));
        stocks.AddToInventory(new Product(5, "iPhone 16e", 12));
    }

    public void PrintResults() {
        stocks.PrintInventory();
    }
}

public class Main {
    public static void main(String[] args) {
        StockDemo NewDemo = new StockDemo();
    }
}
