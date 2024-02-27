package me.dynmie.jeorge;

/**
 * @author dynmie
 */
public class ConstructorTestService {

    private final Animal animal;

    @Inject
    public ConstructorTestService(Animal animal) {
        this.animal = animal;
    }

    public Animal getAnimal() {
        return animal;
    }
}
