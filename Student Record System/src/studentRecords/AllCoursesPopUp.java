package studentRecords;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

import javafx.scene.control.ListView;

public class AllCoursesPopUp extends Stage {

    public AllCoursesPopUp(MainMenu parent){

        ListView<Course> cList;

        this.initModality(Modality.APPLICATION_MODAL);

        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));

        cList = new ListView<>();
        cList.setPrefSize(280, 220);
        parent.updateCourseList(cList);

        grid.add(cList,0,0);

        Scene dialogScene = new Scene(grid, 375,200);
        this.setScene(dialogScene);
    }

}
