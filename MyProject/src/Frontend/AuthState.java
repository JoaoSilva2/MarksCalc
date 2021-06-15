package Frontend;
import Scanner.SingletonScanner;
import Backend.Server;
import Backend.ServerResponse;
import Command.Command;
import Command.RegisterCommand;
import Command.LoginCommand;

import Exceptions.UserAlreadyExistsException;
import Exceptions.WrongCredentialsException;
import Exceptions.InvalidOptionException;

public class AuthState implements MenuState {
    @Override
    public void next(Frontend menu){
    }

    @Override
    public void prev(Frontend menu){
    }

    public Command DetermineCommand(String command_num) throws InvalidOptionException{
        switch(command_num){
            case "1":
                return new LoginCommand();
            case "2":
                return new RegisterCommand();
            case "3":
                return null;
            default:
                throw new InvalidOptionException();
        }
    }

    public void analyseResponse(ServerResponse response,Command command, Frontend menu){
        String status = response.getStatus();

        if(status.equals(Server.Status.NOK.name())){
            System.out.println("Error");

        } else if(response.getStatus().equals(Server.Status.ACK.name())){
            if(command.getName().equals(Command.type.LOGIN.name())){
                System.out.println("Logged in");
                menu.setState(new MainMenuState(response.getSessionName()));
            }
            else if(command.getName().equals(Command.type.REGISTER.name())){
                System.out.println("Registered");
            }
        }
    }

    //Change so it returns a command instead?
    @Override
    public void render(Frontend menu){
        System.out.println("1 - Login");
        System.out.println("2 - Register");
        System.out.println("3 - Exit");

        SingletonScanner scanner = SingletonScanner.getScanner();
        String command_no = scanner.readInput();
        try{
            Command command = DetermineCommand(command_no);
            if(command == null){
                menu.setActive(false);
            }
            ServerResponse response = command.execute();
            analyseResponse(response, command, menu);
        }catch(UserAlreadyExistsException uaee){
            uaee.printMessage();
        }catch(WrongCredentialsException wce){
            wce.printMessage();
        }catch(InvalidOptionException ioe){
            ioe.printMessage();
        }
    }
}
