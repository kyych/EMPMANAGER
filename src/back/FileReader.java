package back;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.List;

public class FileReader {
    private String path;
    private FileInputStream finput;
    private ObjectInputStream ois;

    public FileReader(String path){
        this.path = path;
        try {
            finput = new FileInputStream(path);
            ois = new ObjectInputStream(finput);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<Employee> readUsersFromFile(){      //TODO: CHECK THAT
        List<Employee> employeeList=null;   //that might be still null
        try {
            employeeList = (List<Employee>) ois.readObject();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        if(employeeList==null) System.out.println("NULL");
        return employeeList;
    }
}
