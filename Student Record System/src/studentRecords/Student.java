package studentRecords;

import java.io.Serializable;

public class Student implements Serializable {

    private String number;
    private String firstname;
    private String surname;
    private String address;
    private String course;

    public Student() {
    }

    public Student(String number, String firstname, String surname, String address, String course) {
        this.number = number;
        this.firstname = firstname;
        this.surname = surname;
        this.address = address;
        this.course = course;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    @Override
    public String toString() {
        return number + ": " + firstname + " " + surname + ", " + course;
    }
}
