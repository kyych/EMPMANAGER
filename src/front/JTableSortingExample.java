package front;

import back.Employee;
import back.EmployeeTableModel;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class JTableSortingExample extends JPanel {
    private JTable table;
    private List<Employee> listEmployees;

    public List<Employee> getListEmployees() {
        return listEmployees;
    }

    public JTable getTable() {
        return table;
    }

    public void setListEmployees(List<Employee> listEmployees) {
        this.listEmployees.addAll(listEmployees);
        ((EmployeeTableModel)table.getModel()).updateIndexes();
        ((AbstractTableModel)table.getModel()).fireTableDataChanged();
    }

    public JTableSortingExample() {
        listEmployees = createListEmployees();
        TableModel tableModel = new EmployeeTableModel(listEmployees);
        table = new JTable(tableModel);

        /* TODO: CAN CAUSE TROUBLE WHILE ADDING NEW EMPLOYEES
        *   check after adding "add" functionality
        */

        table.setPreferredScrollableViewportSize(table.getPreferredScrollableViewportSize());

        // insert code for sorting here...
        table.setAutoCreateRowSorter(true);

        this.setLayout(new BorderLayout());
        add(new JScrollPane(table), BorderLayout.CENTER);
    }

    public List<Employee> createListEmployees() {
        List<Employee> listEmployees = new ArrayList<>();

        // code to add dummy data here...
//        listEmployees.add(new Employee("Ada","Ginekolog",33));
//        listEmployees.add(new Employee("Grażyna", "Szczęsna",11));

        return listEmployees;
    }

    public void addEmployee(Employee employee){
        listEmployees.add(employee);
        ((EmployeeTableModel)table.getModel()).updateIndexes();
        ((AbstractTableModel)table.getModel()).fireTableDataChanged();

    }

    public void removeEmployee(int selectedRow) {
        listEmployees.remove(selectedRow);
        ((EmployeeTableModel)table.getModel()).updateIndexes();
        ((AbstractTableModel)table.getModel()).fireTableDataChanged();

    }
}
