package front;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

class MenuBar extends JMenuBar {
    private JMenuItem addDataFromFile, saveFile, close, openFile;
    private JMenu menu;
    private JFileChooser fileChooser;

    private MainViewController mainViewController;


    public MenuBar() {
        fileChooser = new JFileChooser();
        openFile = new JMenuItem("Open File");
        addDataFromFile = new JMenuItem("Add Data");
        saveFile = new JMenuItem("Save");
        close = new JMenuItem("Close");


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
                String path = fileChooser.getSelectedFile().getPath(); //this variable should be transfered to method
                mainViewController.saveDataToFile(path);
            } else {    // it should cover also diffrent extensions of files
                JOptionPane.showMessageDialog(this.getRootPane().getContentPane(), "U have to choose data file!");
            }
        });


        menu = new JMenu("File");


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