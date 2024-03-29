package me.dynmie.jeorge.provider;

/**
 * @author dynmie
 */
public class InstanceProvider<T> implements Provider<T> {

    private final T instance;

    public InstanceProvider(T instance) {
        this.instance = instance;
    }

    @Override
    public T getInstance() {
        return instance;
    }

}
