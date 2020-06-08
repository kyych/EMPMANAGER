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

// --Commented out by Inspection START (07.06.2020, 23:03):
//    public String getSurname() {
//        return surname;
//    }
// --Commented out by Inspection STOP (07.06.2020, 23:03)

// --Commented out by Inspection START (07.06.2020, 23:02):
//    public void setSurname(String surname) {
//        this.surname = surname;
//    }
// --Commented out by Inspection STOP (07.06.2020, 23:02)

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
