package intenger;

public class itemNotFoundException extends RuntimeException {
    public itemNotFoundException() {
    }

    public itemNotFoundException(String message) {
        super(message);
    }

    public itemNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public itemNotFoundException(Throwable cause) {
        super(cause);
    }

    public itemNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
