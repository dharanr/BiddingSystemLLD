
import java.util.Scanner;
import Commands.Command;
import Commands.CommandFactory;
import Controller.BiddingController;
import Controller.InventoryController;
import TestCases.TestCase1;
import TestCases.TestInterface;

public class App {
    public static void main(String[] args) throws Exception {
        //Controllers
        InventoryController inventoryController = new InventoryController();
        BiddingController biddingController = new BiddingController(inventoryController);

        Scanner sc = new Scanner(System.in);
        System.out.println("\n----Welcome to bidding!!----\n");

        //TestCase
        TestInterface testCase = new TestCase1(inventoryController);
        testCase.loadPortal();

        //Controls
        do{
            System.out.println("\nPlease enter the command:");
            String input = sc.nextLine();
            try{
                Command command = CommandFactory.getCommander(input, inventoryController, biddingController);
                if(command.validate()){
                    command.execute();
                }
            }
            catch(Exception ex){
                System.out.println();
                System.out.println(":: " + ex);
            }
        }
        while(true);
    }
}
