package com.data;

public class dataex3 {
    private String color;
    private String value;

    public dataex3(){

    }
    public dataex3(String color, String value) {
        this.color = color;
        this.value = value;
    }
    public String getColor() {
        return color;
    }
    public void setColor(String color) {
        this.color = color;
    }
    public String getValue() {
        return value;
    }
    public void setValue(String value) {
        this.value = value;
    }
    public String toString() {
        return "dataex3{" +
                "color='" + color + '\'' +
                ", value='" + value + '\'' +
                '}';
    }


}
