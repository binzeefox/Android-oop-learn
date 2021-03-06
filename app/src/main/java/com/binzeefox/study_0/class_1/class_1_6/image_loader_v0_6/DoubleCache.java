package com.binzeefox.study_0.class_1.class_1_6.image_loader_v0_6;

import android.graphics.Bitmap;

public class DoubleCache implements ImageCache {
    private MemoryCache mMemoryCache = new MemoryCache();
    private DiskCache mDiskCache = new DiskCache();

    public Bitmap get(String url) {
        Bitmap bitmap = mMemoryCache.get(url);
        if (bitmap == null) bitmap = mDiskCache.get(url);
        return bitmap;
    }

    public void put(String url, Bitmap bmp) {
        mMemoryCache.put(url, bmp);
        mDiskCache.put(url, bmp);
    }
}
