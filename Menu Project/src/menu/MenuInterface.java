package menu;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.text.NumberFormat;
import java.util.Locale;

public class MenuInterface extends Application {

    private Customer orderList;
    private ListView<Meal> orderListView;

    private Label ca2Lbl;
    private Label co2Lbl;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        orderList = new Customer();

        Label topLbl = new Label("Click below to add a meal.");
        HBox topBox = new HBox(topLbl);
        topBox.setAlignment(Pos.CENTER);

        Button btn1 = new Button("Add Order");
        HBox middleBox = new HBox(btn1);
        middleBox.setAlignment(Pos.CENTER);

        orderListView = new ListView<>();
        orderListView.setPrefSize(200,200);
        orderListView.setItems(orderList);
        orderListView.setVisible(false);
        HBox listBox = new HBox(orderListView);
        listBox.setAlignment(Pos.CENTER);

        Label infoLbl = new Label("Your calories and cost totals:");
        HBox infoBox = new HBox(infoLbl);
        infoBox.setAlignment(Pos.CENTER);

        Label caLbl = new Label("Total calories: ");
        ca2Lbl = new Label();
        Label coLbl = new Label("Total cost: ");
        co2Lbl = new Label();
        HBox totalsBox = new HBox(caLbl,ca2Lbl,coLbl,co2Lbl);
        totalsBox.setAlignment(Pos.CENTER);

        btn1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                MenuSelectionScreen popup = new MenuSelectionScreen(MenuInterface.this);
                popup.initOwner(primaryStage);
                popup.show();
                orderListView.setVisible(true);
            }
        });

        VBox vbox = new VBox(topBox,middleBox, listBox, infoBox, totalsBox);

        Scene scene = new Scene(vbox,300,300);
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();

    }

    void setAddMeal(String number, String description, Double cost, int calories, Meal.Type type) {
        orderList.addMeal(number, description, cost, calories, type);
    }

    void setTotalCost(){
        NumberFormat gb = NumberFormat.getCurrencyInstance(Locale.UK);
        int co = orderList.calculateCost();
        co2Lbl.setText("" + gb.format(co));
    }

    void setTotalCalories(){
        int ca = orderList.calculateCalories();
        ca2Lbl.setText("" + ca);
    }

}
