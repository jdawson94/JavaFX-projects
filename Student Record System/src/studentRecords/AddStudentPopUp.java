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

public class AddStudentPopUp extends Stage {

    public AddStudentPopUp(MainMenu parent){

        this.initModality(Modality.APPLICATION_MODAL);

        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));

        Label numberLbl = new Label("Student Number: ");
        Label firstnameLbl = new Label("First Name:");
        Label surnameLbl = new Label("Surname:");
        Label addressLbl = new Label("Address: ");
        Label courseLbl = new Label("Course: ");


        TextField numberTF = new TextField();
        TextField firstnameTF = new TextField();
        TextField surnameTF = new TextField();
        TextField addressTF = new TextField();
        TextField courseTF = new TextField();

        Button btn = new Button("Add");
        btn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                String n = numberTF.getText();
                String fn = firstnameTF.getText();
                String sn = surnameTF.getText();
                String ad = addressTF.getText();
                String c = courseTF.getText();
                parent.setAddStudent(n,fn,sn,ad,c);
                AddStudentPopUp.this.close();
            }
        });

        grid.add(numberLbl,0,0);
        grid.add(numberTF,1,0);
        grid.add(firstnameLbl,0,1);
        grid.add(firstnameTF,1,1);
        grid.add(surnameLbl,0,2);
        grid.add(surnameTF,1,2);
        grid.add(addressLbl,0,3);
        grid.add(addressTF,1,3);
        grid.add(courseLbl,0,4);
        grid.add(courseTF,1,4);
        grid.add(btn,0,5);

        Scene dialogScene = new Scene(grid, 375,300);
        this.setScene(dialogScene);
    }
}