package Exceptions;

public class UserAlreadyExistsException extends Exception {
    private String _message = "Username already exists";

    public UserAlreadyExistsException() {}

    public UserAlreadyExistsException(String message){
        _message = message;
    }

    public void printMessage(){
        System.out.println(_message);
    }
}
