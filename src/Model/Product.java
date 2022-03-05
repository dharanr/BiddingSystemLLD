package Model;
import Model.Logins.User;
import Model.Logins.Vendor;
import Services.IdentifierService;

public class Product {
    long id;
    String name;
    Vendor vendor;
    int basePrice;
    int marketPrice;
    TimeSlot timeSlot;
    Category category;
    User bidder;

    public Product(String name, Vendor vendor, int basePrice, TimeSlot timeSlot, Category category) {
        this.id = IdentifierService.getInstance().generate();
        this.name = name;
        this.vendor = vendor;
        this.basePrice = basePrice;
        this.marketPrice = basePrice;
        this.timeSlot = timeSlot;
        this.category = category;
        this.bidder = null;
    }
    
    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Vendor getVendor() {
        return this.vendor;
    }

    public void setVendor(Vendor vendor) {
        this.vendor = vendor;
    }

    public int getBasePrice() {
        return this.basePrice;
    }

    public void setBasePrice(int basePrice) {
        this.basePrice = basePrice;
    }

    public TimeSlot getTimeSlot() {
        return this.timeSlot;
    }

    public void setTimeSlot(TimeSlot timeSlot) {
        this.timeSlot = timeSlot;
    }

    public Category getCategory() {
        return this.category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public User getBidder() {
        return this.bidder;
    }

    public void setBidder(User bidder) {
        this.bidder = bidder;
    }

    public int getMarketPrice(){
        return this.marketPrice;
    }

    public void setMarketPrice(int bidValue) {
        this.marketPrice = bidValue;
    }
}