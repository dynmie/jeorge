package me.dynmie.jeorge.internal;

/**
 * @author dynmie
 */
public class BindNotFoundException extends InjectionFailedException {
    public BindNotFoundException() {
        super();
    }

    public BindNotFoundException(String message) {
        super(message);
    }

    public BindNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public BindNotFoundException(Throwable cause) {
        super(cause);
    }

    protected BindNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
