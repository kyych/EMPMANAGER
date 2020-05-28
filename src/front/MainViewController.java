package front;

import back.Employee;
import back.FileWriter;

public class MainViewController {
    private JTableSortingExample jTableSortingExample;
    private GeneralButtonsPanel generalButtonsPanel;
    private MenuBar menuBar;
    FileWriter fileWriter;

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

    public void saveDataToFile(String path){
        fileWriter = new FileWriter(path);
        fileWriter.writeUsersToFile(jTableSortingExample.getListEmployees());
    }


}
