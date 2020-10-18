package com.binzeefox.study_0.class_2.class_2_5;

import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class Company {
    private static final String TAG = "Company";
    private List<Staff> allStaffs = new ArrayList<>();

    public void addStaff(Staff per) {
        allStaffs.add(per);
    }

    public void showAllStaffs() {
        for (Staff per: allStaffs)
            Log.d(TAG, "showAllStaffs: " + per.toString());
    }
}
