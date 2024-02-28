package me.dynmie.jeorge.exception;

/**
 * @author dynmie
 */
public class BindFailedException extends RuntimeException {
    public BindFailedException() {
        super();
    }

    public BindFailedException(String message) {
        super(message);
    }

    public BindFailedException(String message, Throwable cause) {
        super(message, cause);
    }

    public BindFailedException(Throwable cause) {
        super(cause);
    }

    protected BindFailedException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
