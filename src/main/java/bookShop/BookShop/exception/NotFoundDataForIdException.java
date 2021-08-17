package bookShop.BookShop.exception;

public class NotFoundDataForIdException extends RuntimeException {
    public NotFoundDataForIdException(String message) {
        super(message);
    }
}
