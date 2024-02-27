package me.dynmie.jeorge;

import me.dynmie.jeorge.internal.CannotBindException;

import java.util.HashMap;
import java.util.Map;

/**
 * @author dynmie
 */
public abstract class Binder {

    private final Map<Class<?>, Object> binds = new HashMap<>();

    public abstract void configure();

    public <T> void bind(Class<T> from, Class<? extends T> to) {
        binds.put(from, to);
    }

    public void bind(Class<?> from, Object to) {
        if (!from.isInstance(to)) {
            throw new CannotBindException("instance not of type " + from.getName());
        }
        binds.put(from, to);
    }

    public Map<Class<?>, Object> getBindings() {
        binds.clear();
        configure();
        return binds;
    }

}
