package me.dynmie.jeorge;

/**
 * @author dynmie
 */
public class TestBinder extends Binder {
    @Override
    public void configure() {
        bind(Animal.class, Cat.class);
    }
}
