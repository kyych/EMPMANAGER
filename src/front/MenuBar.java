package front;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

public class MenuBar extends JMenuBar {
    private final JFileChooser fileChooser;

    private MainViewController mainViewController;


    public MenuBar() {
        fileChooser = new JFileChooser();
        JMenuItem openFile = new JMenuItem("Open File");
        JMenuItem addDataFromFile = new JMenuItem("Add Data");
        JMenuItem saveFile = new JMenuItem("Save");
        JMenuItem close = new JMenuItem("Close");


        addDataFromFile.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, ActionEvent.CTRL_MASK));
        addDataFromFile.addActionListener(e -> {
            int code = fileChooser.showOpenDialog(this.getRootPane().getContentPane());
            if (code == JFileChooser.APPROVE_OPTION) {
                String path = fileChooser.getSelectedFile().getPath();
                mainViewController.readDataFromFile(path);
            } else {
                JOptionPane.showMessageDialog(this.getRootPane().getContentPane(), "U have to choose data file!");
            }
        });

        openFile.addActionListener(e -> {
            int code = fileChooser.showOpenDialog(this.getRootPane().getContentPane());
            if (code == JFileChooser.APPROVE_OPTION) {
                String path = fileChooser.getSelectedFile().getPath();
                mainViewController.replaceDataFromFile(path);
            } else {
                JOptionPane.showMessageDialog(this.getRootPane().getContentPane(), "U have to choose data file!");
            }
        });

        saveFile.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, ActionEvent.CTRL_MASK));
        saveFile.addActionListener(e -> {
            int code = fileChooser.showOpenDialog(this.getRootPane().getContentPane());
            if (code == JFileChooser.APPROVE_OPTION) {
                String path = fileChooser.getSelectedFile().getPath();
                mainViewController.saveDataToFile(path);
            } else {
                JOptionPane.showMessageDialog(this.getRootPane().getContentPane(), "U have to choose data file!");
            }
        });


        JMenu menu = new JMenu("File");


        menu.add(openFile);
        menu.addSeparator();
        menu.add(addDataFromFile);
        menu.addSeparator();
        menu.add(saveFile);
        menu.addSeparator();
        menu.add(close);

        this.add(menu);
    }


    public void setController(MainViewController mainViewController) {
        this.mainViewController = mainViewController;
    }
}