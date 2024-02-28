package me.dynmie.jeorge;

import me.dynmie.jeorge.exception.BindFailedException;
import me.dynmie.jeorge.provider.InstanceProvider;
import me.dynmie.jeorge.provider.Provider;
import me.dynmie.jeorge.provider.TypeInstanceProvider;

import java.util.HashMap;
import java.util.Map;

/**
 * @author dynmie
 */
public abstract class Binder {

    private final Map<Class<?>, Provider<?>> providers = new HashMap<>();

    public abstract void configure();

    public <T> void bind(Class<T> from, Class<? extends T> to) {
        providers.put(from, new TypeInstanceProvider<>(to));
    }

    public void bind(Class<?> from, Object to) {
        if (!from.isInstance(to)) {
            throw new BindFailedException("instance not of type " + from.getName());
        }
        providers.put(from, new InstanceProvider<>(to));
    }

    public Map<Class<?>, Provider<?>> getBindings() {
        providers.clear();
        configure();
        return providers;
    }

}
