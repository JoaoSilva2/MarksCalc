package Command;

import Backend.Server;
import Backend.ServerResponse;
import Scanner.SingletonScanner;

import Exceptions.UserAlreadyExistsException;

public class RegisterCommand implements Command {
    
    private Server server = Server.getInstance();

    @Override
    public ServerResponse execute() throws UserAlreadyExistsException{
        SingletonScanner scanner = SingletonScanner.getScanner();
        System.out.print("Username: ");
        String username = scanner.readInput();
        System.out.print("Password: ");
        String password = scanner.readInput();

        ServerResponse response = server.registerUser(username, password);
        return response;
    }
}
