package utils;

public class NotLoggedException extends Exception {

    public NotLoggedException() {
        super();
    }

    public NotLoggedException(String message) {
        super(message);
    }

    public NotLoggedException(String message, Throwable cause) {
        super(message, cause);
    }

    public NotLoggedException(Throwable cause) {
        super(cause);
    }

    public NotLoggedException(String message, Throwable cause,
                              boolean enableSuppression,
                              boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
