package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.util.ArrayList;

public class Controller {
    @FXML
    TextField nameField;

    @FXML
    TextField emailField;

    @FXML
    TableView<User> usersView;

    @FXML
    TableColumn<User, String> columnName;

    @FXML
    TableColumn<User, String> columnEmail;

    ObservableList<User> users ;

    public void initialize(){
        columnName.setCellValueFactory(new PropertyValueFactory<>("name"));
        columnEmail.setCellValueFactory(new PropertyValueFactory<>("email"));
        users = FXCollections.observableArrayList(new ArrayList<>());
        usersView.setItems(users);
    }

    public void addUser(ActionEvent actionEvent) {
        String name = nameField.getText();
        String email = emailField.getText();
        User user = new User(name, email);
        users.add(user);
        System.out.println("USER ADDED");
    }
}
