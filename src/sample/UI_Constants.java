package sample;

import java.util.ArrayList;

/**
 * for testing
 */

public class UI_Constants {
    private ArrayList<UI_Product> productsNames = new ArrayList<UI_Product>(){{
        add(new UI_Product("Milk" , new ArrayList<String>(){{add("All"); add("Drink");}} , 5 , "Today"));
        add(new UI_Product("Gamburger" , new ArrayList<String>(){{add("All"); add("Food"); add("Fast food");}} , 3 , "1 Month"));
        add(new UI_Product("Tomato" , new ArrayList<String>(){{add("All"); add("Food"); add("Vegans");}} , 1 , "1 Week"));
        add(new UI_Product("Cake" , new ArrayList<String>(){{add("All"); add("Food"); add("Desert");}} , 15 , "1 Year"));
        add(new UI_Product("HotDog" , new ArrayList<String>(){{add("All"); add("Food"); add("Fats food");}} , 20 , "1 Month"));
        add(new UI_Product("Fanta" , new ArrayList<String>(){{add("All"); add("Drink"); add("Fast food");}} , 25 , "1 Month"));
        add(new UI_Product("Cola" , new ArrayList<String>(){{add("All"); add("Drink"); add("Fast food");}} , 30 , "Today"));
        add(new UI_Product("Meat" , new ArrayList<String>(){{add("All"); add("Food");}} , 28 , "1 Week"));
        add(new UI_Product("Ice cream" , new ArrayList<String>(){{add("All"); add("Food"); add("Desert");}} , 23 , "1 Week"));
    }};

    private ArrayList<UI_Bill> billOfMonth = new ArrayList<UI_Bill>(){{
        add(new UI_Bill("1", 22));
        add(new UI_Bill("2", 17));
        add(new UI_Bill("3", 33));
        add(new UI_Bill("4", 63));
        add(new UI_Bill("5", 11));
        add(new UI_Bill("6", 5));
        add(new UI_Bill("7", 23));
        add(new UI_Bill("8", 22));
        add(new UI_Bill("9", 17));
        add(new UI_Bill("10", 33));
        add(new UI_Bill("11", 63));
        add(new UI_Bill("12", 11));
        add(new UI_Bill("13", 5));
        add(new UI_Bill("14", 23));
        add(new UI_Bill("15", 22));
        add(new UI_Bill("16", 17));
        add(new UI_Bill("17", 33));
        add(new UI_Bill("18", 63));
        add(new UI_Bill("19", 11));
        add(new UI_Bill("20", 5));
        add(new UI_Bill("21", 50));
        add(new UI_Bill("22", 86));
        add(new UI_Bill("23", 72));
        add(new UI_Bill("24", 34));
        add(new UI_Bill("25", 48));
        add(new UI_Bill("26", 59));
        add(new UI_Bill("27", 61));
        add(new UI_Bill("28", 32));
        add(new UI_Bill("29", 25));
        add(new UI_Bill("30", 22));
        add(new UI_Bill("31", 23));
    }};

    private ArrayList<UI_Bill> billOfYear = new ArrayList<UI_Bill>(){{
        add(new UI_Bill("January", 122));
        add(new UI_Bill("February", 117));
        add(new UI_Bill("March", 133));
        add(new UI_Bill("April", 163));
        add(new UI_Bill("May", 111));
        add(new UI_Bill("June", 15));
        add(new UI_Bill("July", 123));
        add(new UI_Bill("August", 122));
        add(new UI_Bill("September", 117));
        add(new UI_Bill("October", 133));
        add(new UI_Bill("November", 163));
        add(new UI_Bill("December", 123));
    }};

    private ArrayList<UI_Bill> billOfWeek = new ArrayList<UI_Bill>(){{
        add(new UI_Bill("Monday", 30.5));
        add(new UI_Bill("Tuesday", 29.25));
        add(new UI_Bill("Wednesday", 33.25));
        add(new UI_Bill("Thursday", 40.75));
        add(new UI_Bill("Friday", 27.75));
        add(new UI_Bill("Saturday", 3.75));
        add(new UI_Bill("Sunday", 30.75));
    }};

    public ArrayList<UI_Product> getProductsNames() {
        return productsNames;
    }

    public void setProductsNames(ArrayList<UI_Product> productsNames) {
        this.productsNames = productsNames;
    }

    public ArrayList<UI_Bill> getBillOfMonth() {
        return billOfMonth;
    }

    public void setBillOfMonth(ArrayList<UI_Bill> billOfMonth) {
        this.billOfMonth = billOfMonth;
    }

    public ArrayList<UI_Bill> getBillOfYear() {
        return billOfYear;
    }

    public void setBillOfYear(ArrayList<UI_Bill> billOfYear) {
        this.billOfYear = billOfYear;
    }

    public ArrayList<UI_Bill> getBillOfWeek() {
        return billOfWeek;
    }

    public void setBillOfWeek(ArrayList<UI_Bill> billOfWeek) {
        this.billOfWeek = billOfWeek;
    }
}
