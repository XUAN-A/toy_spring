package com.axuan.toyspring;

/**
 * @author ZhouXuan
 * @version 1.0
 * @date 2021/12/7 15:02
 */
public class Car {
    private String name;
    private String length;
    private String width;
    private String height;
    private Wheel wheel;

    public Car() {

    }

    public Car(String name, String length, String width, String height, Wheel wheel) {
        this.name = name;
        this.length = length;
        this.width = width;
        this.height = height;
        this.wheel = wheel;
    }

    @Override
    public String toString() {
        return "Car{" +
                "name='" + name + '\'' +
                ", length='" + length + '\'' +
                ", width='" + width + '\'' +
                ", height='" + height + '\'' +
                ", wheel=" + wheel +
                '}';
    }
}
