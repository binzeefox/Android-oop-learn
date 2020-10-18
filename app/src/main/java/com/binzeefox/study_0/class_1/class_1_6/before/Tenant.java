package com.binzeefox.study_0.class_1.class_1_6.before;

import android.util.Log;

import java.util.List;

/**
 * 租户
 * @author binze
 * 2020/10/18 21:03
 */
public class Tenant {
    private static final String TAG = "Tenant";

    public void rentRoom(float roomArea, float roomPrice, Mediator mediator) {
        List<Room> rooms = mediator.getAllRooms();
        for (Room room : rooms) {
            if (isSuitable(roomArea, roomPrice, room)){
                Log.d(TAG, "rentRoom: achieve! " + room);
                break;
            }
        }
    }

    private boolean isSuitable(float roomArea, float roomPrice, Room room) {
        return room.price <= roomPrice && room.area >= roomArea;
    }
}
