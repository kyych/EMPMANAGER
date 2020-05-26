package front;

import back.Employee;
import back.EmployeeTableModel;

import javax.swing.*;
import javax.swing.table.TableModel;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class JTableSortingExample extends JPanel {
    private JTable table;

    public JTableSortingExample() {


        List<Employee> listEmployees = createListEmployees();
        TableModel tableModel = new EmployeeTableModel(listEmployees);
        table = new JTable(tableModel);

        /* TODO: CAN CAUSE TROUBLE WHILE ADDING NEW EMPLOYEES
        *   check after adding "add" functionality
        */

        table.setPreferredScrollableViewportSize(table.getPreferredSize());

        // insert code for sorting here...
        table.setAutoCreateRowSorter(true);

        this.setLayout(new BorderLayout());
        add(new JScrollPane(table), BorderLayout.CENTER);
    }

    public List<Employee> createListEmployees() {
        List<Employee> listEmployees = new ArrayList<>();

        // code to add dummy data here...
        listEmployees.add(new Employee("Ada","Ginekolog",33));
        listEmployees.add(new Employee("Grażyna", "Szczęsna",11));

        return listEmployees;
    }
}
