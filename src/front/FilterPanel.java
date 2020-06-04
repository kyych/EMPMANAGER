package front;

import back.EmployeeTableModel;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.TableRowSorter;
import java.awt.*;

public class FilterPanel extends JPanel {
    private JTextField textField = new JTextField();
    private MainViewController controller;
    private TableRowSorter<EmployeeTableModel> tableRowSorter; //= new TableRowSorter<>(controller.getjTableSortingExample().getTableModel());


    public FilterPanel() {
        this.setLayout(new BorderLayout());
    }

    public void setUI(){
        tableRowSorter = new TableRowSorter<>(controller.getjTableSortingExample().getTableModel());
        controller.getjTableSortingExample().getTable().setRowSorter(tableRowSorter);
        this.add(new JLabel("Specify a word to match:"),
                BorderLayout.WEST);
        this.add(textField, BorderLayout.CENTER);

        textField.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                String text = textField.getText();

                if (text.trim().length() == 0) {
                    tableRowSorter.setRowFilter(null);
                } else {
                    tableRowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + text));
                }
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                String text = textField.getText();

                if (text.trim().length() == 0) {
                    tableRowSorter.setRowFilter(null);
                } else {
                    tableRowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + text));
                }
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        });
    }

    public void setController(MainViewController mainViewController) {
        this.controller = mainViewController;
    }
}
