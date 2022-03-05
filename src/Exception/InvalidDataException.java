package Exception;

public class InvalidDataException extends RuntimeException{
    public InvalidDataException() {
        super("\n-- Data entered belonged to a different data type");
    }
}
