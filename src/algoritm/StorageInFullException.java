package algoritm;

public class StorageInFullException extends RuntimeException{
    public StorageInFullException() {
    }

    public StorageInFullException(String message) {
        super(message);
    }

    public StorageInFullException(String message, Throwable cause) {
        super(message, cause);
    }

    public StorageInFullException(Throwable cause) {
        super(cause);
    }

    public StorageInFullException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
