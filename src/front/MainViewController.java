package front;

import back.Employee;

public class MainViewController {
    private JTableSortingExample jTableSortingExample;
    private GeneralButtonsPanel generalButtonsPanel;

    public MainViewController(JTableSortingExample jTableSortingExample, GeneralButtonsPanel generalButtonsPanel) {
        this.jTableSortingExample = jTableSortingExample;
        this.generalButtonsPanel = generalButtonsPanel;
        this.generalButtonsPanel.setController(this);
    }

    public void addEmployee(Employee employee){
        jTableSortingExample.addEmployee(employee);
    }



}
