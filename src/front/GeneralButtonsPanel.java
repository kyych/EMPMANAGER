package front;

import javax.swing.*;
import java.awt.*;

public class GeneralButtonsPanel extends JPanel {
    JButton addButton =     new JButton("Add");
    JButton deleteButton =  new JButton("Delete");
    JButton editButton =    new JButton("Edit");

    public GeneralButtonsPanel() {
        this.setLayout(new FlowLayout(FlowLayout.LEFT));

        this.add(addButton);
        this.add(deleteButton);
        this.add(editButton);
    }
}
