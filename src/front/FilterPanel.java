package front;

import back.EmployeeTableModel;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.TableRowSorter;
import java.awt.*;

public class FilterPanel extends JPanel {
    private final PlaceholderTextField searchForAllTextField = new PlaceholderTextField("");
    private final PlaceholderTextField searchBySalary = new PlaceholderTextField("");

    private MainViewController controller;
    private TableRowSorter<EmployeeTableModel> tableRowSorter;

    public FilterPanel() {
        this.setLayout(new BorderLayout());
    }

    public void setUI(){
        Dimension screenDim = Toolkit.getDefaultToolkit().getScreenSize();
        tableRowSorter = new TableRowSorter<>(controller.getEmployeeTable().getTableModel());

        controller.getEmployeeTable().getTable().setRowSorter(tableRowSorter);

        searchForAllTextField.setPreferredSize(new Dimension(screenDim.width/5, screenDim.height/60));
        searchForAllTextField.setPlaceholder("Search");
        searchBySalary.setPreferredSize(new Dimension(screenDim.width/5, screenDim.height/60));
        searchBySalary.setPlaceholder("Search by salary");
        this.add(searchForAllTextField, BorderLayout.WEST);
        this.add(searchBySalary, BorderLayout.EAST);

        searchForAllTextField.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                String text = searchForAllTextField.getText();

                if (text.trim().length() == 0) {
                    tableRowSorter.setRowFilter(null);
                } else {
                    tableRowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + text));
                }
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                String text = searchForAllTextField.getText();

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
        searchBySalary.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                String text = searchBySalary.getText();

                if (text.trim().length() == 0) {
                    tableRowSorter.setRowFilter(null);
                } else {
                    tableRowSorter.setRowFilter(RowFilter.regexFilter("(?i)"+text, 5)); // 5 is salary column
                }
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                String text = searchBySalary.getText();

                if (text.trim().length() == 0) {
                    tableRowSorter.setRowFilter(null);
                } else {
                    tableRowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + text,5));    //second parameter stands for column to sort
                }
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                throw new UnsupportedOperationException("Not supported yet.");

            }
        });
    }

    public void setController(MainViewController mainViewController) {
        this.controller = mainViewController;
    }
}
