package shipping.exceptions;

public class InvalidWeightException extends Exception{
    public InvalidWeightException(String errorMessage) {
        super(errorMessage);
    }
}
