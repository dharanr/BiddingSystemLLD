package Model.Logins;
import Model.Product;
import java.util.LinkedList;
import java.util.List;

public class User {
    Long id;
    String name;
    List<Product> orders;

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Product> getOrders() {
        return this.orders;
    }

    public void setOrders(List<Product> orders) {
        this.orders = orders;
    }

    public User(long id, String name){
        this.id = id;
        this.name = name;
        this.orders = new LinkedList<>();
    }

    public boolean placeOrder(Product product){
        return this.orders.add(product);
    }
}
