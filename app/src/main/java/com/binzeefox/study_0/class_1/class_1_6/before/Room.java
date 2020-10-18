package com.binzeefox.study_0.class_1.class_1_6.before;

/**
 * 房间
 * @author binze
 * 2020/10/18 21:00
 */
public class Room {
    //面积
    public float area;
    //价格
    public float price;

    public Room(float area, float price) {
        this.area = area;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Room{" +
                "area=" + area +
                ", price=" + price +
                '}';
    }
}
