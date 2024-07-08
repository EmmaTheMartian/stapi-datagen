package emmathemartian.datagen;

public class DataGenException extends RuntimeException {
    public DataGenException() {
        super();
    }

    public DataGenException(String message) {
        super(message);
    }

    public DataGenException(String message, Throwable cause) {
        super(message, cause);
    }

    public DataGenException(Throwable cause) {
        super(cause);
    }
}
