package Controller;

import java.util.HashMap;
import java.util.LinkedList;

import Model.Category;
import Model.Product;
import Model.TimeSlot;
import Model.Logins.User;
import Model.Logins.Vendor;
import Services.InventoryService;
import Services.UserService;
import Services.VendorService;

public class InventoryController {
    private VendorService vendorService;
    private UserService userService;
    private InventoryService inventoryService;

    public InventoryController() {
        this.vendorService = new VendorService();
        this.userService = new UserService();
        this.inventoryService = new InventoryService();
    }

    //Registration
    public Product registerProduct(String name, Vendor vendor, int basePrice, TimeSlot timeSlot, Category category){
        return inventoryService.createProduct(name, vendor, basePrice, timeSlot, category);
    }

    public Vendor registerVendor(String name){
        return vendorService.registerVendor(name);
    }

    public User registerUser(String name){
        return userService.registerUser(name);
    }

    //Validation
    public boolean isRegisteredUser(Long userId){
        return userService.validateUser(userId);
    }

    public boolean isRegisteredProduct(Long productId){
        return inventoryService.isRegisteredProduct(productId);
    }

    //Get Requests
    public Product getProduct(Long productId){
        return inventoryService.getProduct(productId);
    }

    public HashMap<Category, LinkedList<Long>> getBiddingProducts(){
        return this.inventoryService.getBiddingList();
    }

    public User getUser(Long userId){
        return this.userService.getUser(userId);
    }
}
