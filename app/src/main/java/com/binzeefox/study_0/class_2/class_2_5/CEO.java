package com.binzeefox.study_0.class_2.class_2_5;

import android.util.Log;

/**
 * CEO
 * @author binze
 * 2020/10/18 21:42
 */
public class CEO extends Staff {
    private static final String TAG = "CEO";
    private static final CEO mCeo = new CEO();

    private CEO(){}

    public static CEO getCeo() {
        return mCeo;
    }

    @Override
    public void work() {
        Log.d(TAG, "work: ");
    }
}
