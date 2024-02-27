package me.dynmie.jeorge;

import me.dynmie.jeorge.internal.InternalInjectorBuilder;

import java.util.Arrays;

/**
 * @author dynmie
 */
public interface Jeorge {

    static Injector createInjector(Module... modules) {
        return createInjector(Arrays.asList(modules));
    }

    static Injector createInjector(Iterable<? extends Module> modules) {
        return new InternalInjectorBuilder().modules(modules).build();
    }

}
