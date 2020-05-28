package front;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

class MenuBar extends JMenuBar {
    private JMenuItem openFile, saveFile, close;
    private JMenu menu;
    private JFileChooser fileChooser;

    private MainViewController mainViewController;


    public MenuBar() {
        fileChooser = new JFileChooser();
        openFile = new JMenuItem("Open");
        saveFile = new JMenuItem("Save");
        close = new JMenuItem("Close");


        openFile.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, ActionEvent.CTRL_MASK));
        openFile.addActionListener(e -> {
            int code = fileChooser.showOpenDialog(this.getRootPane().getContentPane());
            if (code == JFileChooser.APPROVE_OPTION) {
                String path = fileChooser.getSelectedFile().getPath(); //this variable should be transfered to method
                mainViewController.readDataFromFile(path);  //TODO: NOT WORKING
            } else {    // it should cover also diffrent extensions of files
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
        menu.add(saveFile);
        menu.addSeparator();
        menu.add(close);

        this.add(menu);
    }


    public void setController(MainViewController mainViewController) {
        this.mainViewController = mainViewController;
    }
}