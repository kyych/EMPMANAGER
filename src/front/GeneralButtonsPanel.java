package front;

import back.Employee;
import back.Position;

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
            JTextField surname = new JTextField();
            //JTextField job = new JTextField();
            JComboBox<Position> positionJComboBox = new JComboBox<Position>(Position.values());
            JTextField experience = new JTextField();
            JTextField salary = new JTextField();

            Object[] employeeDataInput = {
                    "Name: ", name,
                    "Surname: ", surname,
                    "Job: ", positionJComboBox,
                    "EXP (MONTHS): ", experience,
                    "Salary: ", salary
            };

            JOptionPane.showConfirmDialog(this.getRootPane().getContentPane(), employeeDataInput, "Add user",
                    JOptionPane.PLAIN_MESSAGE);

            try{
                int exp = Integer.parseInt(experience.getText());
                double sal  = Double.parseDouble(salary.getText());
                mainViewController.addEmployee(new Employee(name.getText(), surname.getText(), (Position) positionJComboBox.getSelectedItem(), exp, sal));
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
