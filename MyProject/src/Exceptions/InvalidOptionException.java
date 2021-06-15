package Exceptions;

public class InvalidOptionException extends Exception{
    private String _message = "Invalid option";

    public InvalidOptionException() {}

    public InvalidOptionException(String message){
        _message = message;
    }

    public void printMessage(){
        System.out.println(_message);
    }
    
}
