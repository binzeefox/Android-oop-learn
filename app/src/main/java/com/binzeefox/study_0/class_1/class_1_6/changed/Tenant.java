package com.binzeefox.study_0.class_1.class_1_6.changed;

import android.util.Log;

/**
 * 租户
 * @author binze
 * 2020/10/18 21:03
 */
public class Tenant {
    private static final String TAG = "Tenant";

    public void rentRoom(float roomArea, float roomPrice, Mediator mediator) {
        Log.d(TAG, "rentRoom: achieve!! " + mediator.rentOut(roomArea, roomPrice));
    }

    private boolean isSuitable(float roomArea, float roomPrice, Room room) {
        return room.price <= roomPrice && room.area >= roomArea;
    }
}
