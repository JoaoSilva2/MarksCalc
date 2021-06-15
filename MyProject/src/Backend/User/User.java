package Backend.User;

import java.util.ArrayList;
import java.util.List;

public class User {

    private String _name;
    private List<Cadeira> _cadeiras = new ArrayList<Cadeira>();

    public User(String name, String password){
        _name = name;
    }

    public List<Cadeira> getCadeiras(){
        return _cadeiras;
    }

    public void addCadeira(Cadeira cadeira){
        _cadeiras.add(cadeira);
    }

    public String getName(){
        return _name;
    }
}
