package Commands;
import java.util.HashMap;
import java.util.LinkedList;
import Controller.InventoryController;
import Model.Category;
import Model.Product;

public class HomeCommand extends Command{
    String tabSpace = "   ";

    public HomeCommand(String[] params, InventoryController inventoryController) {
        super(params, inventoryController, null);
    }

    @Override
    public boolean validate() {
        return params[0].equals("home");
    }

    @Override
    public void execute() {
        System.out.println("\n<-- Products that are bidding right now -->");
        boolean isBiddingAvailable = false;
        HashMap<Category, LinkedList<Long>> biddingList = inventoryController.getBiddingProducts();

        //For Each category
        for(int i=0; i<Category.values().length; i++){
            Category category = Category.values()[i];
            if(!biddingList.containsKey(category)) continue;
            
            //List all the current bidding products
            LinkedList<Long> list = biddingList.get(category);
            isBiddingAvailable = isBiddingAvailable || list.size() > 0;
            if(list.size() > 0){
                System.out.println("\n" + category.name() + "\n");
            }

            for(int j=0; j<list.size(); j++){
                Product product = inventoryController.getProduct(list.get(j));
                String UIContent =  tabSpace + "Product Name : " + product.getName() + "\n" +
                                    tabSpace + "ID : " + product.getId() + "\n" +
                                    tabSpace + "Base Price : " + product.getBasePrice() + "\n" +
                                    tabSpace + "Market Price -> " + product.getMarketPrice() +"\n";
                System.out.println(UIContent);
            }
        }

        if(!isBiddingAvailable) 
            System.out.println("No products available for bidding right now");
    }
}
