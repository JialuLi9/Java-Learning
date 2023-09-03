//Class representing an electronic store
//Has an array of products that represent the items the store can sell

import java.io.*;
import java.util.*;

public class ElectronicStore implements Serializable{

    private int curProducts;
    private String name;
    private ArrayList<Product> stock; //Array to hold all products
    private double revenue;
    private ArrayList<Customer> customers;

    public ElectronicStore(String initName) {
        revenue = 0.0;
        name = initName;
        stock = new ArrayList<>();
        curProducts = 0;
        customers = new ArrayList<>();
    }

    public ElectronicStore(int curProducts, String name, ArrayList<Product> stock, double revenue, ArrayList<Customer> customers) {
        this.curProducts = curProducts;
        this.name = name;
        this.stock = stock;
        this.revenue = revenue;
        this.customers = customers;
    }

    public String getName() {
        return name;
    }

    //Adds a product and returns true if there is space in the array
    //Returns false otherwise
    public boolean addProduct(Product newProduct) {

        for (Product p : stock) {
            if (p.toString().equals(newProduct.toString())) {
                return false;
            }
        }
        stock.add(newProduct);
        curProducts++;
        return true;
    }

    public boolean registerCustomer(Customer customer) {
        for (Customer c : customers) {
            if (c.getName().equals(customer.getName())) {
                return false;
            }
        }
        customers.add(customer);
        return true;
    }

    public List<Customer> getCustomers() {
        ArrayList<Customer> uniqueCustomer = new ArrayList<>(customers);
        return uniqueCustomer;
    }

    public List<Product> searchProducts(String x) {
        List<Product> matchProducts = new ArrayList<>();
        for (Product p : stock) {
            if (p.toString().toLowerCase().contains(x.toLowerCase())) {
                matchProducts.add(p);
            }
        }
        return matchProducts;
    }

    public List<Product> searchProducts(String x, double minPrice, double maxPrice) {
        List<Product> matchProducts = new ArrayList<>();
        List<Product> temp = new ArrayList<>();
        for (Product p : stock) {
            if (p.toString().toLowerCase().contains(x.toLowerCase())) {
                temp.add(p);
            }

        }
        if (minPrice < 0 && maxPrice < 0) {
            return temp;
        }
        if (maxPrice < 0) {
            for (Product p : temp) {
                if (p.getPrice() > minPrice)
                    matchProducts.add(p);
            }
            return matchProducts;
        }

        for (Product p : temp) {
            if (p.getPrice() >= minPrice && p.getPrice() <= maxPrice)
                matchProducts.add(p);
        }
        return matchProducts;

    }

    public boolean addStock(Product p, int amount) {
        for (Product product : stock) {
            if (product.equals(p)) {
                int curStock = product.getStockQuantity();
                curStock += amount;
                product.setStockQuantity(curStock);
                return true;
            }
        }
        return false;
    }

    public boolean sellProduct(Product p, Customer c, int amount) {
        if (stock.contains(p) && customers.contains(c) && (p.getStockQuantity() >= amount)) {
            double totalPrice = p.sellUnits(amount);
            revenue += totalPrice;
            if(!c.getProducts().contains(p)){
                c.addProducts(p);
                c.addAmount(amount);
            }else {
                int index = c.getProducts().indexOf(p);
                int tempAmount = c.getAmount().get(index) + amount;
                c.getAmount().set(index, tempAmount) ;
            }

            c.setTotalSpend(totalPrice);
            return true;
        }
        return false;
    }

    public List<Customer> getTopXCustomers(int x) {

        if (x <= 0) {
            return new ArrayList<>();
        }
        if (x > customers.size()) {
            x = customers.size();
        }
        Collections.sort(customers, new Comparator<Customer>() {

            public int compare(Customer o1, Customer o2) {
                return Double.compare(o2.getTotalSpend(), o1.getTotalSpend());
            }
        });
        return customers.subList(0, x);

    }

    public boolean saveToFile(String filename) {
        try {
            FileOutputStream file = new FileOutputStream(filename);
            ObjectOutputStream out = new ObjectOutputStream(file);
            out.writeObject(this);
            file.close();
            out.close();
            return true;

        } catch (IOException e) {
            return false;
        }
    }

    public static ElectronicStore loadFromFile(String filename) {

        try {
            FileInputStream file = new FileInputStream(filename);
            ObjectInputStream in = new ObjectInputStream(file);
            ElectronicStore e = (ElectronicStore) in.readObject();
            file.close();
            in.close();
            return e;

        } catch (IOException e) {

        } catch (ClassNotFoundException e) {

        }
        return null;
    }

    public List<Product> getStock() {
        return this.stock;
    }


}