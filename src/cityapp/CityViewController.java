package cityapp;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.FileChooser;
import javafx.stage.Window;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;


public class CityViewController {

    @FXML
    Button openFileBtn;

    @FXML
    TextField fileNameField;

    @FXML
    TableView cityView;

    @FXML
    TableColumn<City, Integer> columnID;

    @FXML
    TableColumn<City, String> columnName;

    @FXML
    TableColumn<City, BigDecimal> columnLatitude;

    @FXML
    TableColumn<City, BigDecimal> columnLongtitude;

    @FXML
    TableColumn<City, String> columnCountyCode;

    @FXML
    TableColumn<City, Integer> columnPopulation;

    @FXML
    ComboBox<String> filterByCodeCombo;


    List<City> cities;

    public void initialize(){
        columnID.setCellValueFactory(new PropertyValueFactory<>("id"));
        columnName.setCellValueFactory(new PropertyValueFactory<City, String>("name"));
        columnCountyCode.setCellValueFactory(new PropertyValueFactory<>("countryCode"));
        columnLatitude.setCellValueFactory(new PropertyValueFactory<>("latitude"));
        columnLongtitude.setCellValueFactory(new PropertyValueFactory<>("longitude"));
        columnPopulation.setCellValueFactory((new PropertyValueFactory<>("population")));
    }



    public void openfile(ActionEvent actionEvent) {
        Button source = (Button) actionEvent.getSource();
        Window win = source.getParent().getScene().getWindow();

        FileChooser openFileDialog = new FileChooser();
        File file = openFileDialog.showOpenDialog(win);
        if (file != null) {
            fileNameField.setText(file.getName());
            cities = parseFileToCityList(file.getAbsolutePath());
            cityView.setItems(FXCollections.observableArrayList(cities));
            fillComboBox();
        }
    }

    private List<City> parseFileToCityList(String filePath) {
        Path path = Paths.get(filePath);

        try {
            List<String> lines = Files.readAllLines(path);
            return lines.stream().map(line -> {
                String[] tokens = line.split("\\t");
                int id = Integer.parseInt(tokens[0]);
                String name = tokens[1];
                BigDecimal latitude = new BigDecimal(tokens[4]);
                BigDecimal longitude = new BigDecimal(tokens[5]);
                String countryCode = tokens[8];
                int population = Integer.parseInt(tokens[14]);
                return new City(id, name, longitude, latitude, countryCode, population);
            }).collect(Collectors.toList());
        } catch (IOException e) {
            return Collections.EMPTY_LIST;
        }
    }

    public void findByCountryCode(ActionEvent actionEvent) {
        String code = filterByCodeCombo.getValue();
        List<City> filteredList = cities.stream().filter(city -> city.getCountryCode().equals(code)).collect(Collectors.toList());

        if ("ALL".equals(code)){
            cityView.setItems(FXCollections.observableArrayList(cities));
            return;
        }

        cityView.setItems(FXCollections.observableArrayList(filteredList));
    }

    public void fillComboBox(){
        List<String> codes = cities.stream().map(City::getCountryCode).distinct().collect(Collectors.toList());
        codes.add("ALL");
        filterByCodeCombo.setItems(FXCollections.observableArrayList(codes));
    }
}
