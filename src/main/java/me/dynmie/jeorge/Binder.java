package me.dynmie.jeorge;

import java.util.HashMap;
import java.util.Map;

/**
 * @author dynmie
 */
public abstract class Binder {

    private final Map<Class<?>, Object> binds = new HashMap<>();

    public abstract void configure();

    public void bind(Class<?> from, Class<?> to) {
        binds.put(from, to);
    }

    public void bind(Class<?> from, Object to) {
        binds.put(from, to);
    }

    public Map<Class<?>, Object> getBindings() {
        binds.clear();
        configure();
        return binds;
    }

}
