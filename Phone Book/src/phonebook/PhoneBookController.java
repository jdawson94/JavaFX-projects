package phonebook;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

public class PhoneBookController {

    public ComboBox contactBox;
    public String familyBook;
    public String friendsBook;
    public String workBook;

    public TextField nameTF;
    public TextField numberTF;

    public Button addNumberButton;
    public Button getNumberButton;

    public TextField resultTF;

    private PhoneBook friend = new PhoneBook();
    private PhoneBook family = new PhoneBook();
    private PhoneBook work = new PhoneBook();

    public void addNumber(ActionEvent actionEvent) {
        if (contactBox.getValue() == familyBook){
            family.addNewEntry(nameTF.getText(),numberTF.getText());
            resultTF.setText("Contact added to family");
        }
        else if (contactBox.getValue() == friendsBook){
            friend.addNewEntry(nameTF.getText(),numberTF.getText());
            resultTF.setText("Contact added to friends");
        }
        else if (contactBox.getValue() == workBook){
            work.addNewEntry(nameTF.getText(),numberTF.getText());
            resultTF.setText("Contact added to work");
        }
        else {
            resultTF.setText("Please select a phone book");
        }

    }

    public void getNumber(ActionEvent actionEvent) {
        if (contactBox.getValue() == familyBook){
            String result = family.getNumber(nameTF.getText());
            resultTF.setText(result);
        }
        else if (contactBox.getValue() == friendsBook){
            String result = friend.getNumber(nameTF.getText());
            resultTF.setText(result);
        }
        else if (contactBox.getValue() == workBook){
            String result = work.getNumber(nameTF.getText());
            resultTF.setText(result);
        }
        else {
            resultTF.setText("Please select a phone book");
        }
    }
}
