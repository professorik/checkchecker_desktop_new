package sample;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.chart.*;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

public class UI_ProductCategoryStatistic3 {


    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private LineChart<String, Number> LineChart;

    @FXML
    private CategoryAxis xAxis;

    @FXML
    private NumberAxis yAxis;

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
    private Font x3;

    @FXML
    private Color x4;

    @FXML
    void initialize() {
        ObservableList<String> langs = FXCollections.observableArrayList("Доходы", "Расходы", "Доходы - Расходы");
        categorySelectionDropdown.setValue("Доходы");
        categorySelectionDropdown.getItems().setAll(langs);

        ObservableList<String> langs2 = FXCollections.observableArrayList("1 Week", "1 Month", "1 Year" , "Выбрать даты");
        timeSelectionDropdown.setValue("1 Year");
        timeSelectionDropdown.getItems().setAll(langs2);

        //Делаю Pane пользовательского ввода времени не доступным пока он не выберет "Выбрать дату"
        UsersDates.setVisible(false);

        xAxis = new CategoryAxis();
        xAxis.setLabel("Interval");

        yAxis = new NumberAxis();
        yAxis.setLabel("Visits");

        LineChart.getData().addAll(initChart(categorySelectionDropdown.getValue(), timeSelectionDropdown.getValue()));
        LineChart.setAnimated(false);

        timeSelectionDropdown.setOnAction(event -> {
            LineChart.getData().clear();
            if (!timeSelectionDropdown.getValue().equals("Выбрать даты")) {
                //Делаю Pane пользовательского ввода времени не доступным пока он не выберет "Выбрать дату"
                UsersDates.setVisible(false);
                LineChart.getData().addAll(initChart(categorySelectionDropdown.getValue(), timeSelectionDropdown.getValue()));
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
                LineChart.getData().addAll(initChart(categorySelectionDropdown.getValue(), "1 Month"));
            }
        });
        categorySelectionDropdown.setOnAction(event -> {
            LineChart.getData().clear();
            LineChart.getData().addAll(initChart(categorySelectionDropdown.getValue() , timeSelectionDropdown.getValue()));
        });
    }

    //Можно перевести в миллисекунды с момента прошлых лет 20 века, но с течением времени такое значение не будет
    //влазить даже в BigInteger, а String будет работать до 10'000 года (10-ое тысячилетие)
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

    private XYChart.Series initChart(String categorySelectionDropdown, String timeSelectionDropdown) {
        XYChart.Series dataSeries1 = new XYChart.Series();
        dataSeries1.setName("Desktop");
        switch (timeSelectionDropdown){
            case "1 Week":
                for (UI_Bill i: new UI_Constants().getBillOfWeek()){
                    dataSeries1.getData().add(new XYChart.Data(i.getTime() , i.getCount()));
                }
                break;
            case "1 Month":
                for (UI_Bill i: new UI_Constants().getBillOfMonth()){
                    dataSeries1.getData().add(new XYChart.Data(i.getTime() , i.getCount()));
                }
                break;
            case "1 Year":
                for (UI_Bill i: new UI_Constants().getBillOfYear()){
                    dataSeries1.getData().add(new XYChart.Data(i.getTime() , i.getCount()));
                }
                break;
        }
        return dataSeries1;
    }
}
