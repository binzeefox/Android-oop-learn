package com.binzeefox.study_0.class_1.class_1_2.image_loader_v0_5;

import android.graphics.Bitmap;

public interface ImageCache {
    Bitmap get(String url);
    void put(String url, Bitmap bitmap);
}
