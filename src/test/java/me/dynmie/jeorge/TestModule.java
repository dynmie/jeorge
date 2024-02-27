package me.dynmie.jeorge;

/**
 * @author dynmie
 */
public class TestModule extends Module {
    @Override
    public void configure() {
        bind(Animal.class).to(Cat.class);
    }
}
