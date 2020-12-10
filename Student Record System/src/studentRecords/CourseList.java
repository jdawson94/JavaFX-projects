package studentRecords;

import com.sun.javafx.collections.ObservableListWrapper;
import javafx.collections.FXCollections;

public class CourseList extends ObservableListWrapper<Course> {

    public CourseList(){
        super(FXCollections.observableArrayList());
    }

    public void addCourse(String number, String name){
        super.add(new Course(number,name));
    }

    public Course findCourseByName(String name){
        Course temp;
        int indexLocation = -1;
        for (int i = 0; i < super.size(); i++) {
            temp = super.get(i);
            if (temp.getName().equals(name)){
                indexLocation = i;
                break;
            }
        }
        if (indexLocation == -1) {
            return null;
        } else { return super.get(indexLocation);
        }
    }

    public Course findCourseByNumber(String number){
        Course temp;
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

    public void removeCourse(String course){
        Course deleteCourse = this.findCourseByName(course);
        super.remove(deleteCourse);
    }
}
