package menu;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class MenuSelectionScreen extends Stage {

    private ListView<Meal> startersListView;
    private ListView<Meal> mainsListView;
    private ListView<Meal> dessertsListView;

    private Label selectedNameLbl;
    private Label selectedDescriptionLbl;
    private Label selectedCaloriesLbl;
    private Label selectedCostLbl;
    private Label selectedTypeLbl;

    public MenuSelectionScreen(MenuInterface parent){

        this.initModality(Modality.APPLICATION_MODAL);

        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));

        Customer listOfStarters = new Customer();
        listOfStarters.addMeal("Pate on Toast","Pate on Toast",5.00,300, Meal.Type.STARTER);
        listOfStarters.addMeal("Garlic Bread","Garlic Bread",7.50,600, Meal.Type.STARTER);

        Customer listOfMains = new Customer();
        listOfMains.addMeal("Fish and Chips","Fish and Chips,",10.00,850, Meal.Type.MAIN);
        listOfMains.addMeal("Chicken Curry","Chicken Curry",12.50,900, Meal.Type.MAIN);

        Customer listOfDesserts = new Customer();
        listOfDesserts.addMeal("Vanilla Ice cream","Vanilla Ice cream",5.00,700, Meal.Type.DESSERT);
        listOfDesserts.addMeal("Chocolate Eclairs","Chocolate Eclairs",5.50,650, Meal.Type.DESSERT);

        startersListView = new ListView<>();
        startersListView.setPrefSize(150, 220);
        startersListView.setItems(listOfStarters);

        mainsListView = new ListView<>();
        mainsListView.setPrefSize(150,220);
        mainsListView.setItems(listOfMains);

        dessertsListView = new ListView<>();
        dessertsListView.setPrefSize(150,220);
        dessertsListView.setItems(listOfDesserts);

        selectedNameLbl = new Label();
        selectedDescriptionLbl = new Label();
        selectedCaloriesLbl = new Label();
        selectedCostLbl = new Label();
        selectedTypeLbl = new Label();

        Button addSBtn = new Button("Add Starter");
        Button addMBtn = new Button("Add Main");
        Button addDBtn = new Button("Add Dessert");
        Button doneBtn = new Button("Done");
        addSBtn.setDisable(true);
        addMBtn.setDisable(true);
        addDBtn.setDisable(true);
        doneBtn.setDisable(true);

        startersListView.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                starterSelectionMade();
                addSBtn.setDisable(false);
            }
        });

        startersListView.setOnKeyReleased(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                starterSelectionMade();
                addSBtn.setDisable(false);
            }
        });

        mainsListView.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                mainsSelectionMade();
                addMBtn.setDisable(false);
            }
        });

        mainsListView.setOnKeyReleased(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                mainsSelectionMade();
                addMBtn.setDisable(false);
            }
        });

        dessertsListView.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                dessertsSelectionMade();
                addDBtn.setDisable(false);
            }
        });

        dessertsListView.setOnKeyReleased(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                dessertsSelectionMade();
                addDBtn.setDisable(false);
            }
        });

        addSBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                    String n = selectedNameLbl.getText();
                    String d = selectedDescriptionLbl.getText();
                    int ca = Integer.parseInt(selectedCaloriesLbl.getText());
                    Double co = Double.parseDouble(selectedCostLbl.getText());
                    Meal.Type ty = Meal.Type.valueOf(selectedTypeLbl.getText());
                    parent.setAddMeal(n, d, co, ca, ty);
                    parent.setTotalCalories();
                    parent.setTotalCost();
                    doneBtn.setDisable(false);
                    addSBtn.setDisable(true);
                    startersListView.setDisable(true);
            }
        });

        addMBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                String n = selectedNameLbl.getText();
                String d = selectedDescriptionLbl.getText();
                int ca = Integer.parseInt(selectedCaloriesLbl.getText());
                Double co = Double.parseDouble(selectedCostLbl.getText());
                Meal.Type ty = Meal.Type.valueOf(selectedTypeLbl.getText());
                parent.setAddMeal(n, d, co, ca, ty);
                parent.setTotalCalories();
                parent.setTotalCost();
                doneBtn.setDisable(false);
                addMBtn.setDisable(true);
                mainsListView.setDisable(true);
            }
        });

        addDBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                String n = selectedNameLbl.getText();
                String d = selectedDescriptionLbl.getText();
                int ca = Integer.parseInt(selectedCaloriesLbl.getText());
                Double co = Double.parseDouble(selectedCostLbl.getText());
                Meal.Type ty = Meal.Type.valueOf(selectedTypeLbl.getText());
                parent.setAddMeal(n, d, co, ca, ty);
                parent.setTotalCalories();
                parent.setTotalCost();
                doneBtn.setDisable(false);
                addDBtn.setDisable(true);
                dessertsListView.setDisable(true);
            }
        });

        doneBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                MenuSelectionScreen.this.close();
            }
        });

        grid.addRow(0, startersListView, mainsListView, dessertsListView);
        grid.addRow(1,selectedNameLbl,selectedDescriptionLbl,selectedCaloriesLbl,selectedCostLbl,selectedTypeLbl);
        grid.addRow(2, addSBtn,addMBtn,addDBtn);
        grid.addRow(2,doneBtn);
        Scene dialogScene = new Scene(grid, 600,200);
        this.setScene(dialogScene);

    }

    private void starterSelectionMade(){
        Meal selectedMeal = startersListView.getSelectionModel().getSelectedItem();
        if (selectedMeal != null) {
            selectedNameLbl.setText(selectedMeal.getName());
            selectedDescriptionLbl.setText(selectedMeal.getDescription());
            selectedCaloriesLbl.setText("" + selectedMeal.getCalories());
            selectedCostLbl.setText("" + selectedMeal.getCost());
            selectedTypeLbl.setText("" + selectedMeal.getType());
        }
    }

    private void mainsSelectionMade(){
        Meal selectedMeal = mainsListView.getSelectionModel().getSelectedItem();
        if (selectedMeal != null) {
            selectedNameLbl.setText(selectedMeal.getName());
            selectedDescriptionLbl.setText(selectedMeal.getDescription());
            selectedCaloriesLbl.setText("" + selectedMeal.getCalories());
            selectedCostLbl.setText("" + selectedMeal.getCost());
            selectedTypeLbl.setText("" + selectedMeal.getType());
        }
    }

    private void dessertsSelectionMade(){
        Meal selectedMeal = dessertsListView.getSelectionModel().getSelectedItem();
        if (selectedMeal != null) {
            selectedNameLbl.setText(selectedMeal.getName());
            selectedDescriptionLbl.setText(selectedMeal.getDescription());
            selectedCaloriesLbl.setText("" + selectedMeal.getCalories());
            selectedCostLbl.setText("" + selectedMeal.getCost());
            selectedTypeLbl.setText("" + selectedMeal.getType());
        }
    }

}
