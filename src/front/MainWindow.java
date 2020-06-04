package front;

import javax.swing.*;
import java.awt.*;

public class MainWindow extends JFrame {
    public MainWindow() throws HeadlessException {
        super("EmployeeManager");

        MenuBar menuBar = new MenuBar();
        JTableSortingExample jTableSortingExample = new JTableSortingExample();
        GeneralButtonsPanel generalButtonsPanel = new GeneralButtonsPanel();
        FilterPanel filterPanel = new FilterPanel();

        MainViewController mainViewController = new MainViewController(jTableSortingExample,
                generalButtonsPanel, menuBar, filterPanel);
        filterPanel.setUI();


        this.setJMenuBar(menuBar);
        this.add(jTableSortingExample, BorderLayout.CENTER);
        this.add(generalButtonsPanel, BorderLayout.NORTH);
        this.add(filterPanel, BorderLayout.SOUTH);


        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }
}
