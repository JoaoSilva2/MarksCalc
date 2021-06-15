package Exceptions;

public class ErrorWritingToFileException extends Exception{
    private String _message = "Error writing to file";

    public ErrorWritingToFileException() {}

    public ErrorWritingToFileException(String message){
        _message = message;
    }

    public void printMessage(){
        System.out.println(_message);
    }
}
