package studentRecords;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class FindStudentPopUp extends Stage {

    public FindStudentPopUp(MainMenu parent){

        this.initModality(Modality.APPLICATION_MODAL);

        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));

        Label numberLbl = new Label("Student Number: ");
        Label surnameLbl = new Label("Surname:");
        Label resultsLbl = new Label();

        TextField numberTF = new TextField();
        TextField surnameTF = new TextField();

        Button btn = new Button("Find");
        btn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                String number = numberTF.getText();
                String surname = surnameTF.getText();
                parent.setFindStudent(number,surname,resultsLbl);
            }
        });

        grid.add(numberLbl,0,0);
        grid.add(numberTF,1,0);
        grid.add(surnameLbl,0,1);
        grid.add(surnameTF,1,1);
        grid.add(resultsLbl,0,2);
        grid.add(btn,0,3);

        Scene dialogScene = new Scene(grid, 375,200);
        this.setScene(dialogScene);
    }
}
