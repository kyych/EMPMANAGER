package front;

import back.Employee;
import back.FileReader;
import back.FileWriter;

public class MainViewController {
    private final EmployeeTable employeeTable;
    private final MenuBar menuBar;
    FileWriter fileWriter;
    FileReader fileReader;

    public MainViewController(EmployeeTable employeeTable, GeneralButtonsPanel generalButtonsPanel, MenuBar menuBar, FilterPanel filterPanel) {
        this.employeeTable = employeeTable;
        this.menuBar = menuBar;
        generalButtonsPanel.setController(this);
        filterPanel.setController(this);
        this.menuBar.setController(this);
    }

    public void addEmployee(Employee employee){
        employeeTable.addEmployee(employee);
    }
    public void removeEmployee(){
        employeeTable
                .removeEmployee(employeeTable.getTable().getSelectedRow());
    }


    public void saveDataToFile(String path){
        fileWriter = new FileWriter(path);
        fileWriter.writeUsersToFile(employeeTable.getListEmployees());
        fileWriter.close();
    }

    public void readDataFromFile(String path){
        fileReader = new FileReader(path);
        fileReader.connectMenuView(this.menuBar);
        employeeTable.addListEmployees(fileReader.readUsersFromFile());
    }

    public void replaceDataFromFile(String path){
        fileReader = new FileReader(path);
        employeeTable.setListEmployees(fileReader.readUsersFromFile());
    }

    public EmployeeTable getEmployeeTable() {
        return employeeTable;
    }
}
