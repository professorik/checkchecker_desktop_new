package sample.NeedNot;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.ChoiceBox;
import javafx.stage.Stage;
import sample.UI_Constants;
import sample.UI_Product;
import sample.UI_ProductManager;

import static sample.UI_ProductManager.*;

public class ProductCategoryStatistic {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private BarChart<String , Number> mainGraphbarChart;

    @FXML
    private CategoryAxis xAxis = new CategoryAxis();

    @FXML
    private NumberAxis yAxis = new NumberAxis();

    @FXML
    private ChoiceBox<String> categorySelectionDropdown;

    @FXML
    private ChoiceBox<String> timeSelectionDropdown;

    @FXML
    void initialize() {
        ObservableList<String> langs = FXCollections.observableArrayList("Drink", "Food", "Fast food", "Desert" , "Vegans" ,  "All");
        categorySelectionDropdown.setValue(category);
        categorySelectionDropdown.getItems().setAll(langs);

        ObservableList<String> langs2 = FXCollections.observableArrayList("Today" , "1 Week", "1 Month", "1 Year");
        timeSelectionDropdown.setValue(time);
        timeSelectionDropdown.getItems().setAll(langs2);
        mainGraphbarChart.setTitle("Products Popularity");
        xAxis.setLabel("Products");
        yAxis.setLabel("Value");

        //First init of the series
        XYChart.Series<String , Number> series1 = new XYChart.Series<>();
        for (UI_Product i : new UI_ProductManager().getProducts(new UI_Constants().getProductsNames() , categorySelectionDropdown.getValue() , timeSelectionDropdown.getValue())) {
            series1.getData().add(new XYChart.Data(i.getName(), i.getCount()));
        }
        series1.setName(timeSelectionDropdown.getValue());
        mainGraphbarChart.setBarGap(3);
        mainGraphbarChart.setCategoryGap(20);
        mainGraphbarChart.getData().add(series1);

        //Если мы поменяли категорию выбора
        categorySelectionDropdown.setOnAction(event -> {
            new UI_ProductManager().initSeries(categorySelectionDropdown.getValue() , timeSelectionDropdown.getValue());
            changeScene();
        });

        //Если мы поменяли категорию выбора
        timeSelectionDropdown.setOnAction(event -> {
            new UI_ProductManager().initSeries(categorySelectionDropdown.getValue(), timeSelectionDropdown.getValue());
            changeScene();
        });

    }

    private void changeScene(){
        FXMLLoader loader = new FXMLLoader();
        //Отлавливаю сцену по ее компоненту (кнопке)
        categorySelectionDropdown.getScene().getWindow().hide();

        loader.setLocation(getClass().getResource("/sample/main.fxml"));
        try {
            loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Parent root = loader.getRoot();
        Stage stage = new Stage();
        stage.setScene(new Scene(root , 1280 , 720));
        stage.show();
    }
}
