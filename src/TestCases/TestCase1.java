package TestCases;

import Controller.InventoryController;
import Model.Category;
import Model.Product;
import Model.Logins.Vendor;
import Utils.BTime;

public class TestCase1 implements TestInterface {
    InventoryController store;

    public TestCase1(InventoryController inventoryController){
        this.store = inventoryController;
    }

    @Override
    public void loadPortal() {
        //Vendors
        System.out.println("Vendors:");
        Vendor v1 = store.registerVendor("dharan");
        Vendor v2 = store.registerVendor("Rajan");

        //usershom
        System.out.println("\nUsers:");
        store.registerUser("userA");
        store.registerUser("userB");

        //Product Registration
        Product p1 = store.registerProduct("Charger 3.0", v1, 100, BTime.set(46,54), Category.APPLIANCES);
        v1.addProduct(p1);
        Product p2 = store.registerProduct("Television", v1, 100, BTime.set(10, 17), Category.ELECTRONICS);
        v2.addProduct(p2);
    }
    
}
