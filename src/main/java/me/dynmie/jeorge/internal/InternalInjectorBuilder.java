package me.dynmie.jeorge.internal;

import me.dynmie.jeorge.Binder;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * @author dynmie
 */
public class InternalInjectorBuilder {

    private Iterable<? extends Binder> modules = new ArrayList<>();

    public InternalInjectorBuilder modules(Iterable<? extends Binder> modules) {
        this.modules = modules;
        return this;
    }

    public InternalInjector build() {
        Map<Class<?>, Class<?>> binds = new HashMap<>();
        Map<Class<?>, Object> dependencies = new HashMap<>();
        for (Binder binder : modules) {
            for (Map.Entry<Class<?>, Object> entry : binder.getBindings().entrySet()) {
                Object value = entry.getValue();
                if (value instanceof Class<?>) {
                    binds.put(entry.getKey(), (Class<?>) value);
                    continue;
                }
                dependencies.put(entry.getKey(), entry.getValue());
            }
        }

        return new InternalInjector(binds, dependencies);
    }

}
