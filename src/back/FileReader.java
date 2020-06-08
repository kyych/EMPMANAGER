package back;


import java.io.*;
import java.util.ArrayList;
import java.util.List;

import front.MenuBar;

import javax.swing.*;

public class FileReader {
    private ObjectInputStream ois;
    private MenuBar menuBar;


    public void connectMenuView(MenuBar menuBar) {
        this.menuBar = menuBar;
    }

    public FileReader(String path){
        try {
            FileInputStream finput = new FileInputStream(path);
            ois = new ObjectInputStream(finput);
        } catch (FileNotFoundException e) {
            JOptionPane.showMessageDialog(menuBar.getRootPane().getContentPane(), "File not found");
        } catch (IOException e) {
            JOptionPane.showMessageDialog(menuBar.getRootPane().getContentPane(), "Cant open that file");
        }
    }

    public List<Employee> readUsersFromFile(){
        List<Employee> employeeList=new ArrayList<>();
        try {
            //noinspection unchecked
            employeeList = (List<Employee>) ois.readObject();
        } catch (IOException e) {
            //e.printStackTrace();
            JOptionPane.showMessageDialog(menuBar.getRootPane().getContentPane(), "Cant open that file");

        } catch (ClassNotFoundException e) {
            JOptionPane.showMessageDialog(menuBar.getRootPane().getContentPane(), "Please check if the file has been saved using the same version of the application");
        }
        if(employeeList==null) {System.out.println("NULL");
//            JOptionPane.showMessageDialog(menuBar.getRootPane().getContentPane(), "Empty list of employees");
        }
        return employeeList;
    }
}
