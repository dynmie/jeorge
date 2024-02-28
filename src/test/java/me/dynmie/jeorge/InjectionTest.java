package me.dynmie.jeorge;

import org.junit.jupiter.api.Test;

/**
 * @author dynmie
 */
public class InjectionTest {

    @Test
    public void constructorInjectionTest() {
        Injector injector = Jeorge.createInjector(new TestBinder());

        ConstructorTestService service = injector.createInstance(ConstructorTestService.class);
        service.getAnimal().speak();

        service.getInjectedFieldAnimal().speak();
    }

    @Test
    public void fieldInjectionByClassTest() {
        Injector injector = Jeorge.createInjector(new TestBinder());

        FieldTestService service = injector.createInstance(FieldTestService.class);
        service.getAnimal().speak();
    }

    @Test
    public void fieldInjectionByInstanceTest() {
        Injector injector = Jeorge.createInjector(new TestBinder());

        FieldTestService service = injector.inject(new FieldTestService());
        service.getAnimal().speak();
    }

    @Test
    public void fieldInjectionByInstanceWithInstanceBinderTest() {
        Injector injector = Jeorge.createInjector(new TestInstanceBinder());

        FieldTestService service = injector.inject(new FieldTestService());
        service.getAnimal().speak();
    }

}
