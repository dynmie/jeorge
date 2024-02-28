package me.dynmie.jeorge.provider;

/**
 * @author dynmie
 */
public class TypeInstanceProvider<T> implements Provider<T> {

    private final Class<T> type;
    private T instance;

    public TypeInstanceProvider(Class<T> type) {
        this.type = type;
    }

    @Override
    public T getInstance() {
        if (instance == null) {
            try {
                instance = type.newInstance();
            } catch (InstantiationException | IllegalAccessException e) {
                throw new RuntimeException(e);
            }
        }
        return instance;
    }

}
