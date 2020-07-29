package sample;

import java.net.URL;
import java.util.*;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.layout.AnchorPane;

public class UI_ProductCategoryStatistic2 {

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
    private AnchorPane UsersDates;

    @FXML
    private DatePicker FirstDate;

    @FXML
    private DatePicker SecondDate;

    @FXML
    private Button buttonToBuildGrafic;

    @FXML
    void initialize() {
        ObservableList<String> langs = FXCollections.observableArrayList("Drink", "Food", "Fast food", "Desert" , "Vegans" ,  "All");
        categorySelectionDropdown.setValue("All");
        categorySelectionDropdown.getItems().setAll(langs);

        ObservableList<String> langs2 = FXCollections.observableArrayList("Today" , "1 Week", "1 Month", "1 Year", "Выбор даты");
        timeSelectionDropdown.setValue("1 Year");
        timeSelectionDropdown.getItems().setAll(langs2);

        //Делаю Pane пользовательского ввода времени не доступным пока он не выберет "Выбрать дату"
        UsersDates.setVisible(false);

        //Даю название диаграмме и ее осям
        mainGraphbarChart.setTitle("Products Popularity");
        xAxis.setLabel("Products");
        yAxis.setLabel("Value");

        InitBarChart();

        //Ининциализирую настройки BarChart, если удалить setAnimated - нижние подписи будут съезжать из-за коллайда анимаций
        mainGraphbarChart.setAnimated(false);
        mainGraphbarChart.setBarGap(3);
        mainGraphbarChart.setCategoryGap(20);

        categorySelectionDropdown.setOnAction(event -> {
            InitBarChart();
        });

        timeSelectionDropdown.setOnAction(event -> {
            if (!timeSelectionDropdown.getValue().equals("Выбор даты")) {
                //Делаю Pane пользовательского ввода времени не доступным пока он не выберет "Выбрать дату"
                UsersDates.setVisible(false);
                InitBarChart();
            }else{
                //Делаю Pane пользовательского ввода времени видимым
                UsersDates.setVisible(true);
                buttonToBuildGrafic.setOnAction(event1 -> {
                    if (isRightInterval(FirstDate.getValue().toString() , SecondDate.getValue().toString())){
                        System.out.println(FirstDate.getValue());
                        System.out.println(SecondDate.getValue());
                    }else{
                        System.out.println("ERROR");
                    }
                });
            }
        });
    }

    private boolean isRightInterval(String value1, String value2) {
        if (Integer.parseInt(value1.substring(0 , 4)) > Integer.parseInt(value2.substring(0 , 4))){
            return false;
        }
        if (Integer.parseInt(value1.substring(5 , 7)) > Integer.parseInt(value2.substring(5 , 7))){
            return false;
        }
        if (Integer.parseInt(value1.substring(8)) > Integer.parseInt(value2.substring(8))){
            return false;
        }
        return true;
    }

    private void InitBarChart(){
        //Создаю новый series и присваиваю ему имя
        XYChart.Series<String , Number> series2 = new XYChart.Series<>();
        series2.setName(timeSelectionDropdown.getValue());
        //Очищаю BarChart, чтобы на место старого series вставить новый
        mainGraphbarChart.getData().clear();
        //Инициализирую мой series для будующей вставки в BarChart
        for (UI_Product i : new UI_ProductManager().getProducts(new UI_Constants().getProductsNames() , categorySelectionDropdown.getValue() , timeSelectionDropdown.getValue())) {
            series2.getData().add(new XYChart.Data(i.getName(), i.getCount()));
        }
        //Добавляю в BarChart новый series
        mainGraphbarChart.getData().add(series2);
    }

}
