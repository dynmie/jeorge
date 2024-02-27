package me.dynmie.jeorge;

/**
 * @author dynmie
 */
public class TestInstanceBinder extends Binder {
    @Override
    public void configure() {
        bind(Animal.class, new Cat());
    }
}
