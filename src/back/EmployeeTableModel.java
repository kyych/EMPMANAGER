package back;

import javax.swing.table.AbstractTableModel;
import java.util.List;


public class EmployeeTableModel extends AbstractTableModel {
    private static final int COLUMN_NO      = 0;
    private static final int COLUMN_NAME    = 1;
    private static final int COLUMN_SURNAME = 2;
    private static final int COLUMN_JOB     = 3;
    private static final int COLUMN_EXP     = 4;


    private final String[] columnNames = {"EmployeeID", "Name", "Surname", "Job", "EXPERIENCE"};
    private final List<Employee> listEmployees;

    public EmployeeTableModel(List<Employee> listEmployees) {
        this.listEmployees = listEmployees;
        updateIndexes();
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return columnIndex != 0;    // ID shouldnt be editable
    }

    public void updateIndexes(){
        int indexCount = 1;
        for (Employee employee : listEmployees) {
            employee.setID(indexCount++);
        }
    }


    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public int getRowCount() {
        return listEmployees.size();
    }

    @Override
    public String getColumnName(int columnIndex) {
        return columnNames[columnIndex];
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        if (listEmployees.isEmpty()) {
            return Object.class;
        }
        return getValueAt(0, columnIndex).getClass();
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Employee employee = listEmployees.get(rowIndex);
        Object returnValue;

        switch (columnIndex) {
            case COLUMN_NO:
                returnValue = employee.getID();
                break;
            case COLUMN_NAME:
                returnValue = employee.getName();
                break;
            case COLUMN_JOB:
                returnValue = employee.getJob();
                break;
            case COLUMN_EXP:
                returnValue = employee.getExperience();
                break;
            case COLUMN_SURNAME:
                returnValue = employee.getSurname();
                break;
            default:
                throw new IllegalArgumentException("Invalid column index");
        }

        return returnValue;
    }

    @Override
    public void setValueAt(Object value, int rowIndex, int columnIndex) {
//        Employee employee = listEmployees.get(rowIndex);
//        if (columnIndex == COLUMN_NO) {
//            employee.setIndex((int) value);
//        }

        Employee row = listEmployees.get(rowIndex);
        if(COLUMN_NO == columnIndex){
            row.setID((Integer) value);
        } else if(COLUMN_NAME == columnIndex){
            row.setName((String) value);
        } else if(COLUMN_JOB==columnIndex){
            row.setJob((Position) value);
        } else if(COLUMN_EXP == columnIndex){
            row.setExperience((Integer)value);
        } else if(COLUMN_SURNAME == columnIndex){
            row.setSurname((String)value);
        } else{
            throw new IllegalArgumentException("Wrong index number");
        }

    }

}