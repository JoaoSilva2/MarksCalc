package Frontend;
import Scanner.SingletonScanner;
import Backend.Server;
import Backend.ServerResponse;
import Command.Command;
import Command.RegisterCommand;
import Command.LoginCommand;

import Exceptions.UserAlreadyExistsException;
import Exceptions.WrongCredentialsException;

public class AuthState implements MenuState {
    @Override
    public void next(Frontend menu){
        //TODO
    }

    @Override
    public void prev(Frontend menu){
        //TODO
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
            if(command_no.equals("1")){
                Command command = new LoginCommand();
                //Change status to enum
                ServerResponse response = command.execute();
                if(response.getStatus().equals(Server.Status.ACK.name())){

                    System.out.println("Logged in");
                    menu.setState(new MainMenuState(response.getSessionName()));
                } else if(response.getStatus().equals(Server.Status.NOK.name())){
                    System.out.println("Error in login");
                }
    
            } else if(command_no.equals("2")){
                Command command = new RegisterCommand();
                //Change to aux object or enum
                ServerResponse response = command.execute();
                if(response.getStatus().equals(Server.Status.ACK.name())){
                    System.out.println("Registered");

                } else if(response.getStatus().equals(Server.Status.NOK.name())){
                    System.out.println("Error in REGISTER");
                }
    
            } else if(command_no.equals("3")){
                menu.setActive(false);
            } else {
                System.out.println("Invalid option");
                return;
            }
        } catch(UserAlreadyExistsException uaee){
            uaee.printMessage();
        } catch(WrongCredentialsException wce){
            wce.printMessage();
        }

    }
}
