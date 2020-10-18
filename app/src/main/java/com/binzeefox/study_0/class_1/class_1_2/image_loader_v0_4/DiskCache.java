package com.binzeefox.study_0.class_1.class_1_2.image_loader_v0_4;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import java.io.FileOutputStream;
import java.io.IOException;

public class DiskCache {
    private static String cacheDir = "sdcard/cache/";

    public Bitmap get(String url) {
        return BitmapFactory.decodeFile(cacheDir + url);
    }

    public void put(String url, Bitmap bmp) {
        try (FileOutputStream fos = new FileOutputStream(cacheDir + url)){
            bmp.compress(Bitmap.CompressFormat.PNG, 100, fos);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
