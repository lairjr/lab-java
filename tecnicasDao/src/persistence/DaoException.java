package persistence;

/**
 * Created by ljunior on 4/14/16.
 */
public class DaoException extends Exception {
    private String message;
    private Exception innerException;

    public DaoException(Exception exception, String message) {
        this.innerException = exception;
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public Exception getInnerException() {
        return innerException;
    }
}
