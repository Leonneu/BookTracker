package Model;

public class BookNotFoundException extends Exception{
    public BookNotFoundException(String errorMessage){
        super(errorMessage);
    }
}
