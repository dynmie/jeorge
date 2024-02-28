package me.dynmie.jeorge;

/**
 * @author dynmie
 */
public interface Injector {

    void injectMembers(Object instance);

    void injectStaticMembers(Class<?> clazz);

    <T> T getDependency(Class<T> clazz);

    <T> T createInstance(Class<T> clazz);

}
