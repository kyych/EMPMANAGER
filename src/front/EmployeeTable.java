package front;

import back.Employee;
import back.EmployeeTableModel;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableModel;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeTable extends JPanel {
    private final JTable table;
    private final List<Employee> listEmployees;
    private final TableModel tableModel;

    public EmployeeTableModel getTableModel() {
        return (EmployeeTableModel)tableModel;
    }

    public List<Employee> getListEmployees() {
        return listEmployees;
    }

    public JTable getTable() {
        return table;
    }


    public void addListEmployees(List<Employee> listEmployees) {
        this.listEmployees.addAll(listEmployees);
        ((EmployeeTableModel)table.getModel()).updateIndexes();
        ((AbstractTableModel)table.getModel()).fireTableDataChanged();
    }

    public void setListEmployees(List<Employee> listEmployees) {
        this.listEmployees.clear();
        addListEmployees(listEmployees);
    }

    public EmployeeTable() {
        listEmployees = createListEmployees();
        tableModel = new EmployeeTableModel(listEmployees);
        table = new JTable(tableModel);

        table.setPreferredScrollableViewportSize(table.getPreferredScrollableViewportSize());

        //  code for sorting can be added here
        //  using default sorting provided by swing JTable
        table.setAutoCreateRowSorter(true);

        this.setLayout(new BorderLayout());
        add(new JScrollPane(table), BorderLayout.CENTER);
    }

    public List<Employee> createListEmployees() {
        List<Employee> listEmployee= new ArrayList<>();
        // hardcode employees here for testing purposes
//        listEmployees.add(new Employee("Grażyna", "Szczęsna",11));

        return new ArrayList<>();
    }

    public void addEmployee(Employee employee){
        listEmployees.add(employee);
        ((EmployeeTableModel)table.getModel()).updateIndexes();
        ((AbstractTableModel)table.getModel()).fireTableDataChanged();

    }

    public void removeEmployee(int selectedRow) {
        try {
            listEmployees.remove(selectedRow);
            ((EmployeeTableModel) table.getModel()).updateIndexes();
            ((AbstractTableModel) table.getModel()).fireTableDataChanged();
        } catch (IndexOutOfBoundsException ex){
            System.out.println("No element to delete");
        }

    }
}
