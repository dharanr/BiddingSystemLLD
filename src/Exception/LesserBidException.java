package Exception;

public class LesserBidException extends RuntimeException{   
    public LesserBidException() {
        super("\n-- The entered bid amount is lesser than the Market price");
    }
}
