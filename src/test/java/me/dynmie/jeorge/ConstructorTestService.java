package me.dynmie.jeorge;

/**
 * @author dynmie
 */
public class ConstructorTestService {

    @Inject
    private Animal injectedFieldAnimal;

    private final Animal animal;

    @Inject
    public ConstructorTestService(Animal animal) {
        this.animal = animal;
    }

    public Animal getAnimal() {
        return animal;
    }

    public Animal getInjectedFieldAnimal() {
        return injectedFieldAnimal;
    }

}
