package Command;

import Backend.ServerResponse;

import Exceptions.UserAlreadyExistsException;
import Exceptions.WrongCredentialsException;

public interface Command {
    
    ServerResponse execute() throws WrongCredentialsException, UserAlreadyExistsException;
}
