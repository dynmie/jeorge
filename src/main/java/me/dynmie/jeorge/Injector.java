package me.dynmie.jeorge;

/**
 * @author dynmie
 */
public interface Injector {

    <T> T inject(T instance);

    <T> T getInstance(Class<T> clazz);

    <T> T createInstance(Class<T> clazz);

}
