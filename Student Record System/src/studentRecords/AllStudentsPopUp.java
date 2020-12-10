package studentRecords;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class AllStudentsPopUp extends Stage {

    public AllStudentsPopUp(MainMenu parent){

        ListView<Student> stuList;

        this.initModality(Modality.APPLICATION_MODAL);

        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));

        stuList = new ListView<>();
        stuList.setPrefSize(280, 220);
        parent.updateStudentList(stuList);

        grid.add(stuList,0,0);

        Scene dialogScene = new Scene(grid, 375,200);
        this.setScene(dialogScene);
    }
}
