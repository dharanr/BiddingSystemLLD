package Services;

import Model.Logins.User;
import Model.Product;
import java.util.HashMap;

public class UserService {
    //DB
    private HashMap<Long, User> users = new HashMap<>();

    public User getUser(Long vendorId){
        return users.get(vendorId);
    }
    
    public User registerUser(String name){
        Long id = IdentifierService.getInstance().generate();
        User user = new User(id, name);
        users.put(id, user);

        System.out.println("User" + "  Id : " + id + "  " + name);
        return user;
    }

    public boolean validateUser(Long id){
        return users.containsKey(id);
    }

    public boolean PlaceOrder(long userId, Product product){
        User user = users.get(userId);
        if(user != null){
            return user.placeOrder(product);
        }
        return false;
    }
}
