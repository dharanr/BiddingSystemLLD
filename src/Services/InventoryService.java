package Services;

import Model.Category;
import Model.Logins.Vendor;
import Utils.BTime;
import Model.Product;
import Model.TimeSlot;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Timer;


public class InventoryService {
    //DB
    private HashMap<Category, LinkedList<Long>> biddingList = new HashMap<>();
    private HashMap<Long, Product> products = new HashMap<>();

    public boolean isRegisteredProduct(Long productId){
        return products.containsKey(productId);
    }

    public Product getProduct(Long productId){
        return products.get(productId);
    }

    public HashMap<Category, LinkedList<Long>> getBiddingList(){
        return biddingList;
    }

    public Product createProduct(String name, Vendor vendor, int basePrice, TimeSlot timeSlot, Category category){
        Product product = new Product(name, vendor, basePrice, timeSlot, category);
        products.put(product.getId(), product);

        if(BTime.isBiddingExpired(timeSlot)){
            return product;
        }
        else if(BTime.isBiddingProduct(timeSlot)){
            LinkedList<Long> list = biddingList.getOrDefault(product.getCategory(), new LinkedList<>());
            list.add(product.getId());
            biddingList.put(product.getCategory(), list);
            this.scheduleBidding(product, false);
        }
        else{
            //Schedule for bidding
            this.scheduleBidding(product, true);
        }
        return product;
    }

    public void moveProductToBidding(Long productId){
        Product product = products.get(productId);

        //Stored
        LinkedList<Long> list = biddingList.getOrDefault(product.getCategory(), new LinkedList<>());
        list.add(product.getId());
        biddingList.put(product.getCategory(), list);

        //Schedule for expiry
        System.out.println("\nNew product to bidding ->" + product.getName() + "(" +product.getId()+")\n");
        this.scheduleBidding(product, false);
    }

    public void expireProductBidding(Long productId){
        //Remove from biddingList
        Product product = products.get(productId);
        LinkedList<Long> list =  biddingList.get(product.getCategory());
        list.remove(productId);
        biddingList.put(product.getCategory(), list);
        
        //Winner
        System.out.println("\nNotification ----------------------------" + java.time.LocalTime.now().toString().substring(0,8));
        if(product.getBidder()==null)
            System.out.println("Product "+ product.getName()+" is Unsold");
        else
            System.out.println(product.getName() + " sold to - " + product.getBidder().getName() + " for "+ product.getMarketPrice());
        System.out.println("-------------------------------------------------\n");
    }

    private void scheduleBidding(Product product, boolean isBidding){
        Date scheduleTime = isBidding ? product.getTimeSlot().getFromTime() 
                                      : product.getTimeSlot().getToTime();
        new Timer().schedule(
            new SchedulerService(this, product.getId(), isBidding),
            scheduleTime
        );
    }
}