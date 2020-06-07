package front;

import back.EmployeeTableModel;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.TableRowSorter;
import java.awt.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

public class FilterPanel extends JPanel {
//    private JTextField searchForAllTextField = new JTextField("Search for all");
//    private JTextField searchBySalary = new JTextField("Search by salary");
    private PlaceholderTextField searchForAllTextField = new PlaceholderTextField("");
    private PlaceholderTextField searchBySalary = new PlaceholderTextField("");

    private Dimension screenDim;
    private MainViewController controller;
    private TableRowSorter<EmployeeTableModel> tableRowSorter; //= new TableRowSorter<>(controller.getjTableSortingExample().getTableModel());

    public FilterPanel() {
        this.setLayout(new BorderLayout());
    }

    public void setUI(){
        screenDim = Toolkit.getDefaultToolkit().getScreenSize();
        tableRowSorter = new TableRowSorter<>(controller.getjTableSortingExample().getTableModel());

        controller.getjTableSortingExample().getTable().setRowSorter(tableRowSorter);
//        this.add(new JLabel("Specify a word to match:"),
//                BorderLayout.WEST);

//        searchForAllTextField.setPreferredSize(new Dimension(350,100));
//        searchBySalary.setPreferredSize(new Dimension(350,100));
        searchForAllTextField.setPreferredSize(new Dimension(screenDim.width/5, screenDim.height/60));  //TODO: try not to hardcode those values based on proportions
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
                    tableRowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + text,3));    //second parameter stands for column to sort :D
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
