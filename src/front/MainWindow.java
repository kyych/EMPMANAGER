package front;

import javax.swing.*;
import java.awt.*;

public class MainWindow extends JFrame {
    public MainWindow() throws HeadlessException {
        super("EmployeeManager");

        this.add(new JTableSortingExample(), BorderLayout.SOUTH);
        this.add(new GeneralButtonsPanel(), BorderLayout.NORTH);

        pack();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }
}
