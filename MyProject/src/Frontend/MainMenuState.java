package Frontend;
import Scanner.SingletonScanner;

public class MainMenuState implements MenuState {

    private String _session_name;

    MainMenuState(String session_name){
        super();
        _session_name = session_name;
    }

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

    
        System.out.println("1 - Add cadeira");
        System.out.println("2 - Log Out");

        SingletonScanner scanner = SingletonScanner.getScanner();

        String command_no = scanner.readInput();


        if(command_no.equals("1")){
            
            
        } else if(command_no.equals("2")){
            menu.setState(new AuthState());
        } else {
            System.out.println("Invalid option");
            return;
        }
        
    }
}

