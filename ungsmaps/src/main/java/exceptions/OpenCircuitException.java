package exceptions;

public class OpenCircuitException extends RuntimeException {

    public OpenCircuitException(String message) {
        super(message);
    }

}