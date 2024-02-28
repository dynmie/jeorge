package me.dynmie.jeorge;

import me.dynmie.jeorge.internal.InternalInjectorBuilder;

import java.util.Arrays;

/**
 * @author dynmie
 */
public interface Jeorge {

    static Injector createInjector(Binder... binders) {
        return createInjector(Arrays.asList(binders));
    }

    static Injector createInjector(Iterable<? extends Binder> binders) {
        return new InternalInjectorBuilder().binders(binders).build();
    }

}
