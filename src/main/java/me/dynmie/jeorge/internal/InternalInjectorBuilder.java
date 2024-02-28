package me.dynmie.jeorge.internal;

import me.dynmie.jeorge.Binder;
import me.dynmie.jeorge.provider.Provider;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * @author dynmie
 */
public class InternalInjectorBuilder {

    private Iterable<? extends Binder> binders = new ArrayList<>();

    public InternalInjectorBuilder binders(Iterable<? extends Binder> binders) {
        this.binders = binders;
        return this;
    }

    public InternalInjector build() {
        Map<Class<?>, Provider<?>> providers = new HashMap<>();
        for (Binder binder : binders) {
            providers.putAll(binder.getBindings());
        }

        return new InternalInjector(providers);
    }

}
