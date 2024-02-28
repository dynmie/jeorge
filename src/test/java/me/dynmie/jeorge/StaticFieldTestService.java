package me.dynmie.jeorge;

/**
 * @author dynmie
 */
public class StaticFieldTestService {

    @Inject
    private static Animal injectedFieldAnimal;

    public static Animal getInjectedFieldAnimal() {
        return injectedFieldAnimal;
    }

}
