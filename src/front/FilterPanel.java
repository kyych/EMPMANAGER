package front;

import back.EmployeeTableModel;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.TableRowSorter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FilterPanel extends JPanel {
    private final PlaceholderTextField searchForAllTextField = new PlaceholderTextField("");
    private final PlaceholderTextField searchBySalary = new PlaceholderTextField("");


    private final JButton statusButton = new JButton("<");  //  default <, on add click will change this value to >, value of salaryButtonLess will change
    private boolean salaryButtonLess = true;

    private EmployeeTableModel employeeTableModel;


    private MainViewController controller;
    private TableRowSorter<EmployeeTableModel> tableRowSorter;

    public FilterPanel() {
        this.setLayout(new BorderLayout());
    }


    RowFilter<EmployeeTableModel, Integer> GreaterThan = new RowFilter<EmployeeTableModel, Integer>() {
        public boolean include(Entry<? extends EmployeeTableModel, ? extends Integer> entry) {
            employeeTableModel = entry.getModel();

            //0 is the first column
//                if ((int) table.getValueAt(entry.getIdentifier(), 0) > Integer.parseInt(filterText.getText())) {
//                    return true;
//                }

            // TODO: works for greaterThan, now implement same thing for lower... :)
            if ((double) controller.getEmployeeTable().getTable().getValueAt(entry.getIdentifier(), 5) > Double.parseDouble(searchBySalary.getText())) {
                return true;
            }
            return false;
        }
    };

    public void setUI(){
        Dimension screenDim = Toolkit.getDefaultToolkit().getScreenSize();
        tableRowSorter = new TableRowSorter<>(controller.getEmployeeTable().getTableModel());
        employeeTableModel = controller.getEmployeeTable().getTableModel();



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
                    //tableRowSorter.setRowFilter(RowFilter.regexFilter("(?i)"+text, 5)); // 5 is salary column
                    tableRowSorter.setRowFilter(GreaterThan);
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

        statusButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(salaryButtonLess) {statusButton.setText(">");
                    salaryButtonLess=false;
                } else {statusButton.setText("<");
                    salaryButtonLess=true;}
            }
        });

    }

    public void setController(MainViewController mainViewController) {
        this.controller = mainViewController;
    }
}
