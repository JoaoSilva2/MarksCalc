package Command;

import Backend.Server;
import Scanner.SingletonScanner;

import Backend.ServerResponse;

import Exceptions.WrongCredentialsException;

public class LoginCommand extends Command{

    private Server server = Server.getInstance();

    public LoginCommand(){
        super(Command.type.LOGIN.name());
    }

    @Override
    public ServerResponse execute() throws WrongCredentialsException{
        SingletonScanner scanner = SingletonScanner.getScanner();
        System.out.print("Username: ");
        String username = scanner.readInput();
        System.out.print("Password: ");
        String password = scanner.readInput();


        ServerResponse response = server.userLogin(username, password);
        return response;
    }
}
