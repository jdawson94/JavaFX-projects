package studentRecords;

import java.io.Serializable;

public class Course implements Serializable {

    private String number;
    private String name;

    public Course() {
    }

    public Course(String number, String name) {
        this.number = number;
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return number + ": " + name;
    }
}
