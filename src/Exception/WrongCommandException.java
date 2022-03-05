package Exception;

public class WrongCommandException extends RuntimeException{
    public WrongCommandException(){
        super("\n-- Please do check with admin");
    }
}
