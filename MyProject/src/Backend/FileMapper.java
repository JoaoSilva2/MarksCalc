package Backend;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import Backend.User.User;
import Exceptions.ErrorWritingToFileException;
import Exceptions.UserAlreadyExistsException;

public class FileMapper {
    
    public void putUser(String username, String password) throws UserAlreadyExistsException, ErrorWritingToFileException{
        String path = "Backend/usrDir/" + username;
        String file_name = path + "/" + username + ".txt";

        try{

            File usrDir = new File(path);
            if(usrDir.exists()){
                throw new UserAlreadyExistsException();
            }

            usrDir.mkdirs();
            File usrFile = new File(file_name);
            usrFile.createNewFile();
            FileWriter myWriter = new FileWriter(usrFile);
            myWriter.write(username);
            myWriter.write(",");
            myWriter.write(password);
            myWriter.close();

        } catch(IOException ioe){
            throw new ErrorWritingToFileException();
        }
    }

    public User getUser(String username) throws IOException{
        String path = "Backend/usrDir/" + username + ".txt";

        try{
            File userFile = new File(path);

            BufferedReader br = new BufferedReader(new FileReader(userFile));
            String line = br.readLine();
            br.close();

            String[] data = line.split(",");

            User user = new User(data[0], data[1]);
            return user;

        }catch(FileNotFoundException fnfe){
            return null;
        }
    }
}
