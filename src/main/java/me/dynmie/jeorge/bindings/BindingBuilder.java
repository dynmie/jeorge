package me.dynmie.jeorge.bindings;

/**
 * @author dynmie
 */
public interface BindingBuilder<T> {

    void to(Class<? extends T> clazz);

    Class<T> getKey();

    Class<? extends T> getValue();

}
