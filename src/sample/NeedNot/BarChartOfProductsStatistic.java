package sample.NeedNot;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;

public class BarChartOfProductsStatistic {

    private ArrayList<String> productsNames = new ArrayList<>();

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private BarChart<String , Number> BarChartProductsBarChartProducts;

    @FXML
    private CategoryAxis xAxis = new CategoryAxis();
    @FXML
    private NumberAxis yAxis = new NumberAxis();

    @FXML
    void initialize() {
        productsNames.add("milk"); productsNames.add("bread"); productsNames.add("egg"); productsNames.add("coca-cola");
        productsNames.add("meat"); productsNames.add("water"); productsNames.add("oil"); productsNames.add("tomato");
        productsNames.add("cake"); productsNames.add("tea"); productsNames.add("fanta"); productsNames.add("sprite");
        productsNames.add("candy"); productsNames.add("coffee"); productsNames.add("potato"); productsNames.add("pizza");
        productsNames.add("burger"); productsNames.add("souse"); productsNames.add("sugar"); productsNames.add("borch");

        BarChartProductsBarChartProducts.setTitle("Products Popularity");
        xAxis.setLabel("Products");
        yAxis.setLabel("Value");

        XYChart.Series<String , Number> series1 = new XYChart.Series<>();
        series1.setName("1 Week");
        for (String i : productsNames){
            series1.getData().add(new XYChart.Data(i, Integer.valueOf(i.charAt(0))));
        }

        BarChartProductsBarChartProducts.setBarGap(3);
        BarChartProductsBarChartProducts.setCategoryGap(20);
        BarChartProductsBarChartProducts.getData().add(series1);
    }
}
