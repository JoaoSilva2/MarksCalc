package Exceptions;

public class WrongCredentialsException extends Exception{
    
    private String _message = "Wrong username or password";;

    public WrongCredentialsException() {}

    public WrongCredentialsException(String message){
        _message = message;
    }

    public void printMessage(){
        System.out.println(_message);
    }
}
