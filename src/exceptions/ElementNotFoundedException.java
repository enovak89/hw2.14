package exceptions;

public class ElementNotFoundedException extends RuntimeException{
    public ElementNotFoundedException(String message) {
        super(message);
    }
}
