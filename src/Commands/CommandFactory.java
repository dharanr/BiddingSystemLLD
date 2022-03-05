package Commands;

import Controller.BiddingController;
import Controller.InventoryController;
import Exception.WrongCommandException;

public class CommandFactory {
    public static Command getCommander(String input, InventoryController inventoryController, BiddingController biddingController){
        if(input == null) return null;
        String[] params = input.split(" ");

        switch(params[0]){
            case "home" : return new HomeCommand(params, inventoryController); 
            case "bid"  : return new BidCommand(params, inventoryController, biddingController);
            case "exit" : System.exit(0); break;
            default     : throw new WrongCommandException();
        }
        return null;
    }
}
