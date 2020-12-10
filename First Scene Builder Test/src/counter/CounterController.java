package counter;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;

public class CounterController {

    public Button countingButton;

    public void updateCount(ActionEvent actionEvent) {
        String currentString = countingButton.getText();
        int currentValue = Integer.parseInt(currentString);
        int newValue = currentValue + 1;
        countingButton.setText("" + newValue);
    }
}
