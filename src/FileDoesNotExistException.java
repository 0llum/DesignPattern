public class FileDoesNotExistException extends Exception {
    String message;
    public FileDoesNotExistException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
