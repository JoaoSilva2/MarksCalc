package Command;

import Backend.ServerResponse;

import Exceptions.UserAlreadyExistsException;
import Exceptions.WrongCredentialsException;

public abstract class Command {
    public enum type{
        REGISTER,
        LOGIN;
    }
    private String _name;
    
    Command(String name){
        _name = name;
    }
    public abstract ServerResponse execute() throws WrongCredentialsException, UserAlreadyExistsException;
    public String getName(){
        return _name;
    }
}
