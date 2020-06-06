package back;

import java.io.Serializable;

public class Employee implements Serializable {
    private int ID;
    private String name, surname;
    private String job;
    private int experience; // MONTHS

    public Employee(String name, String job, int experience) {
        this.name = name;
        this.job = job;
        this.experience = experience;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }
}
