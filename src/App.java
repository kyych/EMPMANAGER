import front.JTableSortingExample;
import front.MainWindow;

import javax.swing.*;

public class App {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
//                new JTableSortingExample().setVisible(true);
                new MainWindow().setVisible(true);
            }
        });
    }
}
