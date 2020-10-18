package com.binzeefox.study_0.class_1.class_1_6.before;

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

    public List<Room> getAllRooms() {
        return mRooms;
    }
}
