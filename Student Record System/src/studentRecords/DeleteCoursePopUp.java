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

public class DeleteCoursePopUp extends Stage {

    public DeleteCoursePopUp(MainMenu parent) {

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

        Button btn = new Button("Delete");
        btn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                int selectedIndex = cList.getSelectionModel().getSelectedIndex();
                Course toDelete = cList.getItems().get(selectedIndex);
                parent.setRemoveCourse(toDelete);
                DeleteCoursePopUp.this.close();
            }
        });

        grid.add(cList, 0, 0);
        grid.add(btn, 0, 1);

        Scene dialogScene = new Scene(grid, 375, 200);
        this.setScene(dialogScene);
    }
}
