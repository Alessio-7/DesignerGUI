package designer;

/**
 * Eccezione per un valore errato nela <code>designer.ListaOggettiMenu</code>
 */
public class WrongValueException extends Exception {
    private static final long serialVersionUID = -9048508152870964929L;

    /**
     * Costruttore dell'eccezione
     *
     * @param errorMessage messaggio dell'eccezione
     */
    public WrongValueException(String errorMessage) {
        super(errorMessage);
    }
}