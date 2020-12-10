package studentRecords;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class ChangeCoursePopUp extends Stage {

    Student selectedStudent;

    public ChangeCoursePopUp(MainMenu parent){

        ListView<Student> stuList;
        ListView<Course> cList;

        this.initModality(Modality.APPLICATION_MODAL);

        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));

        stuList = new ListView<>();
        stuList.setPrefSize(280, 220);
        parent.updateStudentList(stuList);

        cList = new ListView<>();
        parent.updateCourseList(cList);
        cList.setDisable(true);

        Button btnC = new Button("Change course");
        btnC.setDisable(true);
        btnC.setVisible(false);

        Button btnS = new Button("Select student");
        btnS.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                selectedStudent = stuList.getSelectionModel().getSelectedItem();
                btnS.setDisable(true);
                btnC.setDisable(false);
                btnC.setVisible(true);
                stuList.setDisable(true);
                cList.setDisable(false);
            }
        });

        btnC.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                Course selectedCourse = cList.getSelectionModel().getSelectedItem();
                parent.updateStudentCourse(selectedStudent,selectedCourse);
                parent.updateStudentList(stuList);
                ChangeCoursePopUp.this.close();
            }
        });

        grid.add(stuList,0,0);
        grid.add(cList,1,0);
        grid.add(btnS,0,1);
        grid.add(btnC,1,1);

        Scene dialogScene = new Scene(grid, 375,200);
        this.setScene(dialogScene);


    }
}
