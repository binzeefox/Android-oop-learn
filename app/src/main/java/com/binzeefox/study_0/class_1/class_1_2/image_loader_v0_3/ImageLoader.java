package com.binzeefox.study_0.class_1.class_1_2.image_loader_v0_3;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Handler;
import android.os.Looper;
import android.widget.ImageView;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Objects;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ImageLoader {

    // 图片缓存
    private ImageCache mImageCache = new ImageCache();
    // SD缓存
    private DiskCache mDiskCache = new DiskCache();
    // 线程池，CPU数量
    private ExecutorService mExecutorService = Executors.newFixedThreadPool
            (Runtime.getRuntime().availableProcessors());
    // 主线程Handler
    private Handler mUiHandler = new Handler(Looper.getMainLooper());

    private boolean isUseDiskCache = false;

    private Bitmap downloadImage(String imageUrl) {
        Bitmap bitmap = null;
        try {
            URL url = new URL(imageUrl);
            final HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            bitmap = BitmapFactory.decodeStream(conn.getInputStream());
            conn.disconnect();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return bitmap;
    }

    private void updateImageView(final ImageView imageView, final Bitmap bitmap) {
        mUiHandler.post(new Runnable() {
            @Override
            public void run() {
                imageView.setImageBitmap(bitmap);
            }
        });
    }

    ///////////////////////////////////////////////////////////////////////////
    // 公共方法
    ///////////////////////////////////////////////////////////////////////////

    public void displayImage(final String url, final ImageView imageView) {
        Bitmap bitmap = isUseDiskCache ? mDiskCache.get(url) : mImageCache.get(url);
        if (bitmap != null) {
            imageView.setImageBitmap(bitmap);
            return;
        }

        //无缓存，下载图片
        imageView.setTag(url);
        mExecutorService.submit(new Runnable() {
            @Override
            public void run() {
                Bitmap bitmap = downloadImage(url);
                if (bitmap == null) return;
                if (Objects.equals(url, imageView.getTag()))
                    updateImageView(imageView, bitmap);
                mImageCache.put(url, bitmap);
            }
        });
    }

    public void useUseDiskCache(boolean useDiskCache) {
        isUseDiskCache = useDiskCache;
    }
}
