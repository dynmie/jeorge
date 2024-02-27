package me.dynmie.jeorge;

/**
 * @author dynmie
 */
public class FieldTestService {
    @Inject
    private Animal animal;

    public Animal getAnimal() {
        return animal;
    }
}
