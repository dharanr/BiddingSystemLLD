package Commands;
import Controller.BiddingController;
import Controller.InventoryController;

public abstract class Command {
    String[] params;
    InventoryController inventoryController;
    BiddingController biddingController;

    public Command(String[] params, InventoryController inventoryController,  BiddingController biddingController) {
        this.params = params;
        this.inventoryController = inventoryController;
        this.biddingController = biddingController;
    }

    abstract public boolean validate();
    abstract public void execute();
}
