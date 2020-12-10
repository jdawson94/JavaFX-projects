package calculator;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class CalculatorController {
    public TextField inputTF1;
    public TextField inputTF2;
    public Button addButton;
    public Button subtractButton;
    public Button multiplyButton;
    public Button divideButton;
    public TextField resultTF;

    public void addNumbers(ActionEvent actionEvent) {
        String s1 = inputTF1.getText();
        String s2 = inputTF2.getText();
        try {
            double d1 = Double.parseDouble(s1);
            double d2 = Double.parseDouble(s2);
            double result = d1 + d2;
            resultTF.setText(""+ result);
        } catch (NumberFormatException e) {
            resultTF.setText("Not a number");
        }
    }

    public void subtractNumbers(ActionEvent actionEvent) {
        String s1 = inputTF1.getText();
        String s2 = inputTF2.getText();
        try {
            double d1 = Double.parseDouble(s1);
            double d2 = Double.parseDouble(s2);
            double result = d1 - d2;
            resultTF.setText(""+ result);
        } catch (NumberFormatException e) {
            resultTF.setText("Not a number");
        }
    }

    public void multiplyNumbers(ActionEvent actionEvent) {
        String s1 = inputTF1.getText();
        String s2 = inputTF2.getText();
        try {
            double d1 = Double.parseDouble(s1);
            double d2 = Double.parseDouble(s2);
            double result = d1 * d2;
            resultTF.setText(""+ result);
        } catch (NumberFormatException e) {
            resultTF.setText("Not a number");
        }
    }

    public void divideNumbers(ActionEvent actionEvent) {
        String s1 = inputTF1.getText();
        String s2 = inputTF2.getText();
        try {
            double d1 = Double.parseDouble(s1);
            double d2 = Double.parseDouble(s2);
            double result = d1 / d2;
            resultTF.setText(""+ result);
        } catch (NumberFormatException e) {
            resultTF.setText("Not a number");
        }
    }
}
