package sample;

import java.util.ArrayList;

public class UI_Product {

    private String name;
    private String time;
    private ArrayList<String> categoryes;
    private Number count;

    public UI_Product(String name , ArrayList<String> categoryes , Number count, String time){
        this.name = name;
        this.categoryes = categoryes;
        this.count = count;
        this.time = time;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public ArrayList<String> getCategoryes() {
        return categoryes;
    }

    public void setCategoryes(ArrayList<String> categoryes) {
        this.categoryes = categoryes;
    }

    public Number getCount() {
        return count;
    }

    public void setCount(Number count) {
        this.count = count;
    }
}
