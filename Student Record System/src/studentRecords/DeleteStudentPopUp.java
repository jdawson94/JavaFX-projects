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

public class DeleteStudentPopUp extends Stage {

    public DeleteStudentPopUp(MainMenu parent){

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

        Button btn = new Button("Delete");
        btn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                int selectedIndex = stuList.getSelectionModel().getSelectedIndex();
                Student toDelete = stuList.getItems().get(selectedIndex);
                parent.setRemoveStudent(toDelete);
                DeleteStudentPopUp.this.close();
            }
        });

        grid.add(stuList,0,0);
        grid.add(btn,0,1);

        Scene dialogScene = new Scene(grid, 375,200);
        this.setScene(dialogScene);
    }


}
