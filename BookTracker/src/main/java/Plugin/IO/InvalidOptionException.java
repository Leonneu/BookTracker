package Plugin.IO;

public class InvalidOptionException extends Exception {
    public InvalidOptionException(String errorMessage){
        super(errorMessage);
    }
}
