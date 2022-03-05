package Services;
import java.util.*;

public class SchedulerService extends TimerTask {
    InventoryService inventoryService;
    Long productId; 
    boolean isBidding;

    SchedulerService(InventoryService inventoryService, Long productId, boolean isBidding){
        this.inventoryService = inventoryService;
        this.productId = productId;
        this.isBidding = isBidding;
    }

    @Override
    public void run() {
        if(this.isBidding){
            this.inventoryService.moveProductToBidding(productId);
        }else{
            this.inventoryService.expireProductBidding(productId);
        }
    }
}