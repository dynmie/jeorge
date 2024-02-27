package me.dynmie.jeorge;

import org.junit.jupiter.api.Test;

/**
 * @author dynmie
 */
public class InjectionTest {

    @Test
    public void constructorInjectionTest() {
        Injector injector = Jeorge.createInjector(new TestModule());

        FieldTestService field = injector.createInstance(FieldTestService.class);
        field.getAnimal().speak();
    }

    @Test
    public void fieldInjectionByClassTest() {
        Injector injector = Jeorge.createInjector(new TestModule());

        FieldTestService field = injector.createInstance(FieldTestService.class);
        field.getAnimal().speak();
    }

    @Test
    public void fieldInjectionByInstanceTest() {
        Injector injector = Jeorge.createInjector(new TestModule());

        FieldTestService field = injector.inject(new FieldTestService());
        field.getAnimal().speak();
    }

}
