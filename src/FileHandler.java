import java.io.*;
import java.util.ArrayList;

public class FileHandler {

    public static String folderDirectory = System.getProperty("user.dir") + "\\userData.txt";

    public static void writeFile(ArrayList<User> userList){
        try{
            FileWriter writeToFile = new FileWriter(folderDirectory, true);
            PrintWriter printToFile = new PrintWriter(writeToFile);
            for(User x : userList){
                printToFile.println(x.toString());
            }
            printToFile.close();
            writeToFile.close();
        }catch(Exception e){
            System.out.println("Error: " + e);
        }
    }

    public static ArrayList<User> readFile(){
        ArrayList<User> userList = new ArrayList<>();
        String lineFromFile;
        try{
            BufferedReader read = new BufferedReader(new FileReader(folderDirectory));
            while((lineFromFile = read.readLine()) != null){
                String[] userDetails = lineFromFile.split(",");
                User newUser = new User(userDetails[0], userDetails[1], userDetails[2]);
                userList.add(newUser);
            }
            read.close();
        }catch(Exception e){
            System.out.println("Error: " + e);
        }
        return userList;
    }


}
