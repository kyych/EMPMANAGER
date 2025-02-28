package back;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.List;

public class FileWriter {
    private FileOutputStream fout;
    private ObjectOutputStream oos;

    public FileWriter(String path) {
        try {
            fout = new FileOutputStream(path);
            oos = new ObjectOutputStream(fout);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void writeUsersToFile(List<Employee> userList){
        try {
            oos.writeObject(userList);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void close(){
        try {
            fout.close();
            oos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
