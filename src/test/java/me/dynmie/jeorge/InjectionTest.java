package me.dynmie.jeorge;

import org.junit.jupiter.api.Test;

/**
 * @author dynmie
 */
public class InjectionTest {

    @Test
    public void constructorInjectionTest() {
        Injector injector = Jeorge.createInjector(new TestBinder());

        FieldTestService field = injector.createInstance(FieldTestService.class);
        field.getAnimal().speak();
    }

    @Test
    public void fieldInjectionByClassTest() {
        Injector injector = Jeorge.createInjector(new TestBinder());

        FieldTestService field = injector.createInstance(FieldTestService.class);
        field.getAnimal().speak();
    }

    @Test
    public void fieldInjectionByInstanceTest() {
        Injector injector = Jeorge.createInjector(new TestBinder());

        FieldTestService field = injector.inject(new FieldTestService());
        field.getAnimal().speak();
    }

    @Test
    public void fieldInjectionByInstanceWithInstanceBinderTest() {
        Injector injector = Jeorge.createInjector(new TestInstanceBinder());

        FieldTestService field = injector.inject(new FieldTestService());
        field.getAnimal().speak();
    }

}
