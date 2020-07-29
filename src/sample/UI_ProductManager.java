package sample;

import java.util.ArrayList;

public class UI_ProductManager {

    public ArrayList<UI_Product> getProducts(ArrayList<UI_Product> list , String category , String time){
        ArrayList<UI_Product> finishList = new ArrayList<>();
        for (UI_Product i: list){
            if (indexing(i.getTime()) < indexing(time)){
                continue;
            }
            for (String categI: i.getCategoryes()) {
                if (categI.toLowerCase().equals(category.toLowerCase())){
                    finishList.add(i);
                    break;
                }
            }
        }
        return finishList;
    }

    private int indexing(String args){
        switch (args){
            case "Today":
                return 4;
            case "1 Week":
                return 3;
            case "1 Month":
                return 2;
            case "1 Year":
                return 1;
        }
        return 0;
    }

    public static String category = "All";
    public static String time = "1 Year";

    public void initSeries(String category , String time){
        this.category = category;
        this.time = time;
    }
}
