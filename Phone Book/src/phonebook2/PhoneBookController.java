package phonebook2;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

public class PhoneBookController {

    private ObservableList<phonebook2.PhoneBook> listOfBooks;

    public TextField nameTF;
    public TextField numberTF;

    public Button addNumberButton;
    public Button getNumberButton;

    public TextField resultTF;

    public ListView bookList;

    private PhoneBook family = new PhoneBook("Family");
    private PhoneBook friend = new PhoneBook("Friends");
    private PhoneBook work = new PhoneBook("Work");

    public void initialize(){
        listOfBooks = FXCollections.observableArrayList(family,friend,work);
        bookList.setItems(listOfBooks);
    }

    public void addNumber(ActionEvent actionEvent) {
        if (bookList.getSelectionModel().getSelectedItem() == family){
            family.addNewEntry(nameTF.getText(),numberTF.getText());
            resultTF.setText("Contact added to family");
        }
        else if (bookList.getSelectionModel().getSelectedItem() == friend){
            friend.addNewEntry(nameTF.getText(),numberTF.getText());
            resultTF.setText("Contact added to friends");
        }
        else if (bookList.getSelectionModel().getSelectedItem() == work){
            work.addNewEntry(nameTF.getText(),numberTF.getText());
            resultTF.setText("Contact added to work");
        }
        else {
            resultTF.setText("Please select a phone book");
        }
    }

    public void getNumber(ActionEvent actionEvent) {
        if (bookList.getSelectionModel().getSelectedItem() == family){
            String result = family.getNumber(nameTF.getText());
            resultTF.setText(result);
        }
        else if (bookList.getSelectionModel().getSelectedItem() == friend){
            String result = friend.getNumber(nameTF.getText());
            resultTF.setText(result);
        }
        else if (bookList.getSelectionModel().getSelectedItem() == work){
            String result = work.getNumber(nameTF.getText());
            resultTF.setText(result);
        }
        else {
            resultTF.setText("Please select a phone book");
        }
    }
}
