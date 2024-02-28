package me.dynmie.jeorge.exception;

/**
 * @author dynmie
 */
public class InjectionFailedException extends RuntimeException {
    public InjectionFailedException() {
        super();
    }

    public InjectionFailedException(String message) {
        super(message);
    }

    public InjectionFailedException(String message, Throwable cause) {
        super(message, cause);
    }

    public InjectionFailedException(Throwable cause) {
        super(cause);
    }

    protected InjectionFailedException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
