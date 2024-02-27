package me.dynmie.jeorge.internal;

import me.dynmie.jeorge.Inject;
import me.dynmie.jeorge.Injector;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

/**
 * @author dynmie
 */
public class InternalInjector implements Injector {

    private final Map<Class<?>, Class<?>> binds;
    private final Map<Class<?>, Object> dependencies;

    public InternalInjector(Map<Class<?>, Class<?>> binds, Map<Class<?>, Object> dependencies) {
        this.binds = binds;
        this.dependencies = dependencies;
    }

    @Override
    public <T> T inject(T instance) {
        for (Field field : instance.getClass().getDeclaredFields()) {
            if (!field.isAnnotationPresent(Inject.class)) {
                continue;
            }

            boolean accessible = field.isAccessible();
            try {
                field.setAccessible(true);
                field.set(instance, getInstance(field.getType()));
                field.setAccessible(accessible);
            } catch (IllegalAccessException | IllegalArgumentException e) {
                throw new InjectionFailedException(e);
            }
        }

        return instance;
    }

    @Override
    public <T> T getInstance(Class<T> clazz) {
        Object dep = dependencies.get(clazz);
        if (dep != null) {
            return clazz.cast(dep);
        }

        Class<?> bind = binds.get(clazz);
        if (bind == null) {
            throw new BindNotFoundException("bind for " + clazz.getName() + " was not found");
        }

        T instance;
        try {
            instance = clazz.cast(bind.newInstance());
        } catch (InstantiationException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
        dependencies.put(clazz, instance);

        return instance;
    }

    @Override
    public <T> T createInstance(Class<T> clazz) {
        Constructor<?> constructor = null;
        for (Constructor<?> c : clazz.getConstructors()) {
            if (!c.isAnnotationPresent(Inject.class)) continue;

            constructor = c;
        }

        if (constructor == null) {
            T t;
            try {
                t = clazz.newInstance();
            } catch (InstantiationException | IllegalAccessException e) {
                throw new InjectionFailedException("instantiation failed for " + clazz.getName(), e);
            }
            return inject(t);
        }

        Object[] params = new Object[constructor.getParameterTypes().length];
        for (int i = 0; i < constructor.getParameterTypes().length; i++) {
            Class<?> parameterType = constructor.getParameterTypes()[i];
            params[i] = getInstance(parameterType);
        }

        try {
            return clazz.cast(constructor.newInstance(params));
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException e) {
            throw new InjectionFailedException(e);
        }
    }

}
