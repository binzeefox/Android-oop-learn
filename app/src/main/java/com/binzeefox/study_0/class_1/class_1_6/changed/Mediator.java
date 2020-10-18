package com.binzeefox.study_0.class_1.class_1_6.changed;

import java.util.ArrayList;
import java.util.List;

/**
 * 中介
 * @author binze
 * 2020/10/18 21:00
 */
public class Mediator {
    private List<Room> mRooms = new ArrayList<>();

    public Mediator() {
        for (int i = 0; i < 5; i++) {
            mRooms.add(new Room(14+i, (14 + i) * 150));
        }
    }

    public Room rentOut(float area, float price) {
        for (Room room: mRooms) {
            if (isSuitable(area, price, room))
                return room;
        }
        return null;
    }

    private boolean isSuitable(float area, float price, Room room) {
        return room.price <= price && room.area >= area;
    }
}
