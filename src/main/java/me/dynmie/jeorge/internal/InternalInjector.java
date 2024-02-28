package me.dynmie.jeorge.internal;

import me.dynmie.jeorge.Inject;
import me.dynmie.jeorge.Injector;
import me.dynmie.jeorge.exception.BindNotFoundException;
import me.dynmie.jeorge.exception.InjectionFailedException;
import me.dynmie.jeorge.provider.Provider;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Modifier;
import java.util.Map;

/**
 * @author dynmie
 */
public class InternalInjector implements Injector {

    private final Map<Class<?>, Provider<?>> providers;

    public InternalInjector(Map<Class<?>, Provider<?>> providers) {
        this.providers = providers;
    }

    @Override
    public void injectMembers(Object instance) {
        for (Field field : instance.getClass().getDeclaredFields()) {
            if (!field.isAnnotationPresent(Inject.class)) {
                continue;
            }

            boolean accessible = field.isAccessible();
            try {
                field.setAccessible(true);
                field.set(instance, getDependency(field.getType()));
                field.setAccessible(accessible);
            } catch (IllegalAccessException | IllegalArgumentException e) {
                throw new InjectionFailedException(e);
            }
        }
    }

    @Override
    public void injectStaticMembers(Class<?> clazz) {
        for (Field field : clazz.getDeclaredFields()) {
            if (!Modifier.isStatic(field.getModifiers())) {
                continue;
            }
            if (!field.isAnnotationPresent(Inject.class)) {
                continue;
            }

            boolean accessible = field.isAccessible();
            try {
                field.setAccessible(true);
                field.set(null, getDependency(field.getType()));
                field.setAccessible(accessible);
            } catch (IllegalAccessException | IllegalArgumentException e) {
                throw new InjectionFailedException(e);
            }
        }
    }

    @Override
    public <T> T getDependency(Class<T> clazz) {
        if (clazz == Injector.class) {
            return clazz.cast(this);
        }

        Provider<?> provider = providers.get(clazz);
        if (provider == null) {
            throw new BindNotFoundException("bind for " + clazz.getName() + " was not found");
        }

        return clazz.cast(provider.getInstance());
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
            injectMembers(t);
            return t;
        }

        Object[] params = new Object[constructor.getParameterTypes().length];
        for (int i = 0; i < constructor.getParameterTypes().length; i++) {
            Class<?> parameterType = constructor.getParameterTypes()[i];
            params[i] = getDependency(parameterType);
        }

        T t;
        try {
            t = clazz.cast(constructor.newInstance(params));
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException e) {
            throw new InjectionFailedException(e);
        }

        injectMembers(t);
        return t;
    }

}
