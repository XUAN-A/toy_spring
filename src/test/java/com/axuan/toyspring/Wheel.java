package com.axuan.toyspring;

/**
 * @author ZhouXuan
 * @version 1.0
 * @date 2021/12/7 15:03
 */
public class Wheel {
    private String brand;
    private String specification;

    public Wheel() {
    }

    public Wheel(String brand, String specification) {
        this.brand = brand;
        this.specification = specification;
    }

    @Override
    public String toString() {
        return "Wheel{" +
                "brand='" + brand + '\'' +
                ", specification='" + specification + '\'' +
                '}';
    }
}
