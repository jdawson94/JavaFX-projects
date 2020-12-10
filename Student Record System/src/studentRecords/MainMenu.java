package studentRecords;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.scene.control.*;

public class MainMenu extends Application {

    private StudentsList listOfStudents;
    private CourseList listOfCourses;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        listOfStudents = new StudentsList();
        listOfCourses = new CourseList();

        Label studentLbl = new Label("Student");
        Label courseLbl = new Label("Courses");
        Label deleteLbl = new Label("Delete");

        Button addStudentButton = new Button("Add student");
        addStudentButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                AddStudentPopUp popup = new AddStudentPopUp(MainMenu.this);
                popup.initOwner(primaryStage);
                popup.show();
            }
        });

        Button findStudentButton = new Button("Find student");
        findStudentButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                FindStudentPopUp popup = new FindStudentPopUp(MainMenu.this);
                popup.initOwner(primaryStage);
                popup.show();
            }
        });

        Button viewAllStudentsButton = new Button("View all");
        viewAllStudentsButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                AllStudentsPopUp popup = new AllStudentsPopUp(MainMenu.this);
                popup.initOwner(primaryStage);
                popup.show();
            }
        });

        Button addCoursesButton = new Button("Add course");
        addCoursesButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                AddCoursePopUp popup = new AddCoursePopUp(MainMenu.this);
                popup.initOwner(primaryStage);
                popup.show();
            }
        });

        Button findCourseButton = new Button("Find course");
        findCourseButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                FindCoursePopUp popup = new FindCoursePopUp(MainMenu.this);
                popup.initOwner(primaryStage);
                popup.show();
            }
        });

        Button viewAllCoursesButton = new Button("View all");
        viewAllCoursesButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                AllCoursesPopUp popup = new AllCoursesPopUp(MainMenu.this);
                popup.initOwner(primaryStage);
                popup.show();
            }
        });

        Button changeCourseButton = new Button("Change course");
        changeCourseButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                ChangeCoursePopUp popup = new ChangeCoursePopUp(MainMenu.this);
                popup.initOwner(primaryStage);
                popup.show();
            }
        });

        Button deleteStudentButton = new Button("Delete student");
        deleteStudentButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                DeleteStudentPopUp popup = new DeleteStudentPopUp(MainMenu.this);
                popup.initOwner(primaryStage);
                popup.show();
            }
        });

        Button deleteCourseButton = new Button("Delete course");
        deleteCourseButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                DeleteCoursePopUp popup = new DeleteCoursePopUp(MainMenu.this);
                popup.initOwner(primaryStage);
                popup.show();
            }
        });

        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));
        grid.add(studentLbl,0,1);
        grid.add(addStudentButton, 1, 1);
        grid.add(findStudentButton, 2, 1);
        grid.add(viewAllStudentsButton,3,1);
        grid.add(changeCourseButton,4,1);
        grid.add(courseLbl,0,2);
        grid.add(addCoursesButton,1,2);
        grid.add(findCourseButton,2,2);
        grid.add(viewAllCoursesButton,3,2);
        grid.add(deleteLbl,0,3);
        grid.add(deleteStudentButton,1,3);
        grid.add(deleteCourseButton,2,3);


        Scene scene = new Scene(grid, 550, 200);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Student Records");
        primaryStage.show();

    }

    void setAddStudent(String number, String firstname, String surname, String address, String course) {
        listOfStudents.addStudent(number, firstname, surname, address, course);
    }

    void setFindStudent(String findNumber, String findSurname, Label resultsLbl) {
        Student stu;
        if (!findNumber.equals("")) {
            stu = listOfStudents.findStudentByNumber(findNumber);
        }
        else{
            stu = listOfStudents.findStudentByName(findSurname);
        }
        resultsLbl.setText(stu.toString());
    }

    void updateStudentList(ListView<Student> lv){
        lv.setItems(listOfStudents);
    }

    void setAddCourse(String number, String name){
        listOfCourses.addCourse(number,name);
    }

    void setFindCourse(String findNumber, String findName, Label resultsLbl) {
        Course c;
        if (!findNumber.equals("")) {
            c = listOfCourses.findCourseByNumber(findNumber);
        }
        else{
            c = listOfCourses.findCourseByName(findName);
        }
        resultsLbl.setText(c.toString());
    }

    void updateCourseList(ListView<Course> c){
        c.setItems(listOfCourses);
    }

    void updateStudentCourse(Student s, Course c){
        s.setCourse(c.getName());
    }

    void setRemoveStudent(Student toDelete){
        listOfStudents.removeStudent(toDelete.getSurname());
    }

    void setRemoveCourse(Course toDelete){
        listOfCourses.removeCourse(toDelete.getName());
    }

}