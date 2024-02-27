package me.dynmie.jeorge.internal;

/**
 * @author dynmie
 */
public class CannotBindException extends RuntimeException {
    public CannotBindException() {
        super();
    }

    public CannotBindException(String message) {
        super(message);
    }

    public CannotBindException(String message, Throwable cause) {
        super(message, cause);
    }

    public CannotBindException(Throwable cause) {
        super(cause);
    }

    protected CannotBindException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
