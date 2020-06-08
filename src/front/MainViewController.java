package front;

import back.Employee;
import back.FileReader;
import back.FileWriter;

public class MainViewController {
    private final EmployeeTable employeeTable;
    private final GeneralButtonsPanel generalButtonsPanel;
    private final MenuBar menuBar;
    private final FilterPanel filterPanel;
    FileWriter fileWriter;
    FileReader fileReader;

    public MainViewController(EmployeeTable employeeTable, GeneralButtonsPanel generalButtonsPanel, MenuBar menuBar, FilterPanel filterPanel) {
        this.employeeTable = employeeTable;
        this.generalButtonsPanel = generalButtonsPanel;
        this.menuBar = menuBar;
        this.filterPanel = filterPanel;
        this.generalButtonsPanel.setController(this);
        this.filterPanel.setController(this);
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
