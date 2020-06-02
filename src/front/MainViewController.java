package front;

import back.Employee;
import back.FileReader;
import back.FileWriter;

public class MainViewController {
    private JTableSortingExample jTableSortingExample;
    private GeneralButtonsPanel generalButtonsPanel;
    private MenuBar menuBar;
    FileWriter fileWriter;
    FileReader fileReader;

    public MainViewController(JTableSortingExample jTableSortingExample, GeneralButtonsPanel generalButtonsPanel, MenuBar menuBar) {
        this.jTableSortingExample = jTableSortingExample;
        this.generalButtonsPanel = generalButtonsPanel;
        this.menuBar = menuBar;
        this.generalButtonsPanel.setController(this);
        this.menuBar.setController(this);
    }

    public void addEmployee(Employee employee){
        jTableSortingExample.addEmployee(employee);
    }
    public void removeEmployee(){
        jTableSortingExample
                .removeEmployee(jTableSortingExample.getTable().getSelectedRow());
    }


    public void saveDataToFile(String path){
        fileWriter = new FileWriter(path);
        fileWriter.writeUsersToFile(jTableSortingExample.getListEmployees());
        fileWriter.close();
    }

    public void readDataFromFile(String path){
        fileReader = new FileReader(path);
        jTableSortingExample.setListEmployees(fileReader.readUsersFromFile());
    }


}
