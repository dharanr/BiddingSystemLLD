package Model.Logins;
import java.util.LinkedList;
import java.util.List;
import Model.Product;

public class Vendor {
    long id;
    String name;
    List<Product> products;

    public Vendor(long id, String name){
        this.id = id;
        this.name = name;
        this.products = new LinkedList<>();
    }

    public boolean addProduct(Product product){
        return this.products.add(product);
    }
}