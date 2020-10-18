package com.binzeefox.study_0.class_1.class_1_2.image_loader_v0_5;

import android.graphics.Bitmap;

import androidx.annotation.NonNull;
import androidx.collection.LruCache;

public class MemoryCache implements ImageCache {
    private LruCache<String, Bitmap> mImageCache;

    public MemoryCache(){
        initImageCache();
    }

    private void initImageCache() {
        //最大缓存容量
        final int maxMemory = (int) (Runtime.getRuntime().maxMemory() / 1024);

        mImageCache = new LruCache<String, Bitmap>(maxMemory / 4) {
            @Override
            protected int sizeOf(@NonNull String key, @NonNull Bitmap value) {
                return value.getRowBytes() * value.getHeight() / 1024;
            }
        };
    }

    public void put(String url, Bitmap bitmap) {
        mImageCache.put(url, bitmap);
    }

    public Bitmap get(String url) {
        return mImageCache.get(url);
    }
}
