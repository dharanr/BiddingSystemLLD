package Controller;

import Model.Product;
import Model.Logins.User;
import Services.BiddingService;

public class BiddingController {
    BiddingService biddingService = new BiddingService(); //stateless
    private InventoryController inventoryController;

    public BiddingController(InventoryController inventoryController) {
        this.inventoryController = inventoryController;
    }

    public void bid(Long userId, Long productId, int value){
        Product product = inventoryController.getProduct(productId);
        User user = inventoryController.getUser(userId);
        biddingService.placeBid(user, product, value);
    }
}
