package me.dynmie.jeorge;

import me.dynmie.jeorge.bindings.BindingBuilder;
import me.dynmie.jeorge.bindings.InternalBindingBuilder;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author dynmie
 */
public abstract class Module {

    private final List<BindingBuilder<?>> bindingBuilders = new ArrayList<>();

    public abstract void configure();

    public <T> BindingBuilder<T> bind(Class<T> clazz) {
        BindingBuilder<T> builder = new InternalBindingBuilder<>(clazz);
        bindingBuilders.add(builder);
        return builder;
    }

    public List<BindingBuilder<?>> getBindings() {
        bindingBuilders.clear();
        configure();
        return Collections.unmodifiableList(bindingBuilders);
    }

}
