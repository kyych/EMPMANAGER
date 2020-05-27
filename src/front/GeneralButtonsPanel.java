package front;

import back.Employee;
import com.sun.tools.javac.Main;

import javax.swing.*;
import java.awt.*;

public class GeneralButtonsPanel extends JPanel {
    JButton addButton =     new JButton("Add");
    JButton deleteButton =  new JButton("Delete");
    JButton editButton =    new JButton("Edit");

    private MainViewController mainViewController;


    public GeneralButtonsPanel() {
        this.setLayout(new FlowLayout(FlowLayout.LEFT));

        this.add(addButton);

        addButton.addActionListener(e -> {
            JTextField name = new JTextField();
            JTextField job = new JTextField();
            JTextField age = new JTextField();

            Object[] employeeDataInput = {
                    "Name: ", name,
                    "Job: ", job,
                    "Age: ", age
            };

            JOptionPane.showConfirmDialog(this.getRootPane().getContentPane(), employeeDataInput, "Add user",
                    JOptionPane.PLAIN_MESSAGE);

            mainViewController.addEmployee(new Employee(name.getText(), job.getText(), Integer.valueOf(age.getText())));


//            System.out.println("DEBUG: " + name.getText()); //TODO: based on this data create employee

        });

        this.add(deleteButton);
        this.add(editButton);
    }

    public void setController(MainViewController controller){
        mainViewController = controller;
    }
}
