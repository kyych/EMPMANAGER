package front;

import back.Employee;

import javax.swing.*;
import java.awt.*;

public class GeneralButtonsPanel extends JPanel {
    final JButton addButton =     new JButton("Add");
    final JButton deleteButton =  new JButton("Delete");

    private MainViewController mainViewController;

    public GeneralButtonsPanel() {
        this.setLayout(new FlowLayout(FlowLayout.LEFT));

        this.add(addButton);

        addButton.addActionListener(e -> {
            JTextField name = new JTextField();
            JTextField job = new JTextField();
            JTextField experience = new JTextField();

            Object[] employeeDataInput = {
                    "Name: ", name,
                    "Job: ", job,
                    "EXP (MONTHS): ", experience
            };

            JOptionPane.showConfirmDialog(this.getRootPane().getContentPane(), employeeDataInput, "Add user",
                    JOptionPane.PLAIN_MESSAGE);

            try{
                int exp = Integer.parseInt(experience.getText());
                mainViewController.addEmployee(new Employee(name.getText(), job.getText(), exp));
            } catch (NumberFormatException ex){
                JOptionPane.showMessageDialog(this.getRootPane().getContentPane(), "Please enter the experience in Integers");
            } catch (Exception ex){
                JOptionPane.showMessageDialog(this.getRootPane().getContentPane(), "Error happened, please contact the dev.");
            }
        });


        deleteButton.addActionListener(e -> {
            mainViewController.removeEmployee();
        });

        this.add(deleteButton);
    }

    public void setController(MainViewController controller){
        mainViewController = controller;
    }
}
