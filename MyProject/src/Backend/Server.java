package Backend;

import java.io.File;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

import Backend.User.User;

import java.io.BufferedReader;

import Exceptions.WrongCredentialsException;
import Exceptions.UserAlreadyExistsException;


public class Server {

    public enum Status{
        ACK,
        NOK;
    }

    private String usersDirPath = "Backend/usrDir/";
    private static Server server = new Server();

    private HashMap<String, User> _users = new HashMap<String, User>();

    public Server() {}

    /**
     * Returns server instance.
     * Singleton pattern used as sockets are not being used and there is
     * only one server instance. 
     * @return
     */
    public static Server getInstance(){
        return server;
    }

    /**
     * Creates the directory where the users files will be kept if it
     * does not already exists
     */
    public void createUsersDir(){
        File usrDir = new File(usersDirPath);
        if(!usrDir.exists()){
            usrDir.mkdirs();
        }
    }

    /**
     * Registers a new user in the system. If the user already exists throws
     * exception
     * 
     * @param username
     * @param password
     */
    public ServerResponse registerUser(String username, String password) throws UserAlreadyExistsException{

        ServerResponse response = new ServerResponse();

        try{

            File usrDir = new File(usersDirPath + username);
            if(usrDir.exists()){
                throw new UserAlreadyExistsException();
            }

            usrDir.mkdirs();
            File usrFile = new File(usersDirPath + username + "/" + username + ".txt");
            usrFile.createNewFile();
            FileWriter myWriter = new FileWriter(usrFile);
            myWriter.write(username);
            myWriter.write(",");
            myWriter.write(password);
            myWriter.close();

            response.setStatus(Status.ACK.name());

            User new_user = new User(username, password);
            _users.put(username, new_user);

            return response;

        } catch(IOException ioe){
            response.setStatus(Status.NOK.name());
            return response;
        }
    }


    /**
     * User login.
     * If user does not exists or credentials are wrong throws an
     * exception
     * @param username
     * @param password
     * @throws WrongCredentialsException
     */
    public ServerResponse userLogin(String username, String password) throws WrongCredentialsException{

        ServerResponse response;

        if(_users.containsKey(username)){
            response = buildLoginResponse(username, Status.ACK.name());
            return response;
        }

        try{
            File userFile = new File(usersDirPath + username + "/" + username + ".txt");
            if(!userFile.exists()){
                throw new WrongCredentialsException("User not found");
            }

            BufferedReader br = new BufferedReader(new FileReader(userFile));
            String line = br.readLine();
            br.close();

            if(line == null){
                System.out.println("Error in file");
                response = buildLoginResponse(username, Status.NOK.name());
                return response;
            }

            String[] data = line.split(",");

            if(!username.equals(data[0]) || !password.equals(data[1])){
                throw new WrongCredentialsException();
            }

            response = buildLoginResponse(username, Status.ACK.name());
            return response;

        } catch(IOException ioe){
            ioe.printStackTrace();
            response = buildLoginResponse(username, Status.NOK.name());
            return response;
        }

    }

    public ServerResponse buildLoginResponse(String username, String status){
        ServerResponse response = new ServerResponse();
        response.setStatus(status);
        response.setSessionName(username);
        return response;
    }

    /**
     * Encrypts string and returns it
     * @param target
     * @return encrypted string
     */
    public String encrypt(String target){
        String result = "";
        for(int i = 0; i < target.length(); i++){
            result = result + (target.charAt(i) + 1);
        }

        return result;
    }


}
