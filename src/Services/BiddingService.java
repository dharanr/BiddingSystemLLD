package Services;

import Model.Logins.User;
import Exception.LesserBidException;
import Model.Product;

public class BiddingService {
    public boolean placeBid(User user, Product product, int bidValue){
        synchronized(this){
            if(bidValue < product.getMarketPrice()){
                throw new LesserBidException();
            }
            
            product.setMarketPrice(bidValue);
            product.setBidder(user);
            return true;
        }
    }
}
