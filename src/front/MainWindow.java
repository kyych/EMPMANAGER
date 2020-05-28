package front;

import javax.swing.*;
import java.awt.*;

public class MainWindow extends JFrame {
    public MainWindow() throws HeadlessException {
        super("EmployeeManager");

        MenuBar menuBar = new MenuBar();
        JTableSortingExample jTableSortingExample = new JTableSortingExample();
        GeneralButtonsPanel generalButtonsPanel = new GeneralButtonsPanel();

        MainViewController mainViewController = new MainViewController(jTableSortingExample, generalButtonsPanel, menuBar);


        this.setJMenuBar(menuBar);
        this.add(jTableSortingExample, BorderLayout.CENTER);
        this.add(generalButtonsPanel, BorderLayout.NORTH);


        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }
}
