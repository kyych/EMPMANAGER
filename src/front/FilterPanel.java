package front;

import back.EmployeeTableModel;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.TableRowSorter;
import java.awt.*;

public class FilterPanel extends JPanel {
    private JTextField searchForAllTextField = new JTextField();
    private JTextField searchBySalary = new JTextField();
    private MainViewController controller;
    private TableRowSorter<EmployeeTableModel> tableRowSorter; //= new TableRowSorter<>(controller.getjTableSortingExample().getTableModel());

    public FilterPanel() {
        this.setLayout(new BorderLayout());
    }

    public void setUI(){
        tableRowSorter = new TableRowSorter<>(controller.getjTableSortingExample().getTableModel());

        controller.getjTableSortingExample().getTable().setRowSorter(tableRowSorter);
//        this.add(new JLabel("Specify a word to match:"),
//                BorderLayout.WEST);
        searchForAllTextField.setPreferredSize(new Dimension(350,100));
        searchBySalary.setPreferredSize(new Dimension(350,100));
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
                    tableRowSorter.setRowFilter(RowFilter.regexFilter("(?i)"+text, 3)); // TODO: AFTER MODEL BEING UPDATED, CHANGE COLUMN NUMBER (3) TO SALARY COLUMN
                                                                                                        // 3 is age column, to change
                }
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                String text = searchBySalary.getText();

                if (text.trim().length() == 0) {
                    tableRowSorter.setRowFilter(null);
                } else {
                    tableRowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + text,3));
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
