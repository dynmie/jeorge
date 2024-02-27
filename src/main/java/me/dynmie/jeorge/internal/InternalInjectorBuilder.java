package me.dynmie.jeorge.internal;

import me.dynmie.jeorge.Module;
import me.dynmie.jeorge.bindings.BindingBuilder;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * @author dynmie
 */
public class InternalInjectorBuilder {

    private Iterable<? extends Module> modules = new ArrayList<>();

    public InternalInjectorBuilder modules(Iterable<? extends Module> modules) {
        this.modules = modules;
        return this;
    }

    public InternalInjector build() {
        Map<Class<?>, Class<?>> binds = new HashMap<>();
        for (Module module : modules) {
            for (BindingBuilder<?> binding : module.getBindings()) {
                binds.put(binding.getKey(), binding.getValue());
            }
        }

        return new InternalInjector(binds, new HashMap<>());
    }

}
