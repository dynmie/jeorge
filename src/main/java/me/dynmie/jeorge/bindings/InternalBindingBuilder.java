package me.dynmie.jeorge.bindings;

/**
 * @author dynmie
 */
public class InternalBindingBuilder<T> implements BindingBuilder<T> {

    private final Class<T> key;
    private Class<? extends T> value;

    public InternalBindingBuilder(Class<T> key) {
        this.key = key;
    }

    @Override
    public void to(Class<? extends T> clazz) {
        value = clazz;
    }

    @Override
    public Class<T> getKey() {
        return key;
    }

    @Override
    public Class<? extends T> getValue() {
        return value;
    }

}
