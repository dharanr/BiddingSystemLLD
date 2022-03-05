package Commands;

import Controller.BiddingController;
import Controller.InventoryController;
import Exception.InvalidDataException;

public class BidCommand extends Command{

    public BidCommand(String[] params, InventoryController inventoryController, BiddingController biddingController) {
        super(params, inventoryController, biddingController);
    }

    @Override
    public boolean validate() {
        try{
            return inventoryController.isRegisteredUser(Long.valueOf(params[1])) &&
                   inventoryController.isRegisteredProduct(Long.valueOf(params[2]));
        }
        catch(Exception ex){
            throw new InvalidDataException();
        }
    }

    @Override
    public void execute() {
        biddingController.bid(Long.valueOf(params[1]), Long.valueOf(params[2]), Integer.valueOf(params[3]));
    }
}
