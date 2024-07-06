package pro.sky.exception;

public class EllementNotFoundException extends RuntimeException{
    public EllementNotFoundException() {
    }

    public EllementNotFoundException(String message) {
        super(message);
    }

    public EllementNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public EllementNotFoundException(Throwable cause) {
        super(cause);
    }

    public EllementNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
