package Frontend;

public class Frontend {

    private MenuState _state = new AuthState();
    private boolean _active = true;

    public void start(){

        while(_active){
            //TODO catch specific program terminating exception
            try{
                _state.render(this);
            } catch(Exception e){
                break;
            }
        }
    }

    public void setState(MenuState state){
        _state = state;
    }

    public void setActive(boolean active){
        _active = active;
    }
}
