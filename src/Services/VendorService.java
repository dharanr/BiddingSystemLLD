package Services;

import Model.Logins.Vendor;
import Model.Product;
import java.util.HashMap;


public class VendorService {
    //DB
    private HashMap<Long, Vendor> vendors = new HashMap<>();

    public Vendor getVendor(Long vendorId){
        return vendors.get(vendorId);
    }
    
    public Vendor registerVendor(String name){
        Long id = IdentifierService.getInstance().generate();
        Vendor vendor = new Vendor(id, name);
        vendors.put(id, vendor);

        System.out.println("Vendor" + "  Id : " + id + "  " + name);
        return vendor;
    }

    public boolean validateVendor(Long id){
        return vendors.containsKey(id);
    }

    public boolean addProduct(long vendorId, Product product){
        Vendor vendor = vendors.get(vendorId);
        if(vendor != null){
            return vendor.addProduct(product);
        }
        return false;
    }
}
