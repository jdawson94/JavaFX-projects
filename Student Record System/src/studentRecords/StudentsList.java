package studentRecords;

import com.sun.javafx.collections.ObservableListWrapper;
import javafx.collections.FXCollections;


public class StudentsList extends ObservableListWrapper<Student> {

    public StudentsList(){
        super(FXCollections.observableArrayList());
    }

    public void addStudent(String number, String firstname, String surname, String address, String course){
        super.add(new Student(number,firstname,surname,address,course));
    }

    public Student findStudentByName(String name){
        Student temp;
        int indexLocation = -1;
        for (int i = 0; i < super.size(); i++) {
            temp = super.get(i);
            if (temp.getSurname().equals(name)){
                indexLocation = i;
                break;
            }
        }
        if (indexLocation == -1) {
            return null;
        } else { return super.get(indexLocation);
        }
    }

    public Student findStudentByNumber(String number){
        Student temp;
        int indexLocation = -1;
        for (int i = 0; i < super.size(); i++) {
            temp = super.get(i);
            if (temp.getNumber().equals(number)){
                indexLocation = i;
                break;
            }
        }
        if (indexLocation == -1) {
            return null;
        } else {
            return super.get(indexLocation);
        }
    }

    public void removeStudent(String student){
        Student deleteStudent = this.findStudentByName(student);
        super.remove(deleteStudent);
    }

}
