package Backend;

public class ServerResponse {

    private String _status;
    private String _session_name;

    public String getStatus(){
        return _status;
    }

    public void setStatus(String status){
        _status = status;
    }

    public String getSessionName(){
        return _session_name;
    }

    public void setSessionName(String session_name){
        _session_name = session_name;
    }
}
