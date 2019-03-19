package com.xpf.basemodule.image;

import android.content.Context;
import android.net.Uri;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;
import com.bumptech.glide.request.RequestOptions;
import com.xpf.basemodule.R;

import java.io.File;

/**
 * 参考设置：http://www.tuicool.com/articles/3Af6Zby
 * DiskCacheStrategy.NONE:什么都不缓存
 * DiskCacheStrategy.SOURCE:仅缓存原图(全分辨率的图片)
 * DiskCacheStrategy.RESULT:仅缓存最终的图片,即修改了尺寸或者转换后的图片
 * DiskCacheStrategy.ALL:缓存所有版本的图片,默认模式
 * <p>
 * url =    url.replaceAll("http:/", "http://");
 */
public class ImageLoaderHelper {  //待封装

    public static int IMG_LOADING = R.drawable.ic_image_loading;
    public static int IMG_ERROR = R.drawable.ic_empty_picture;

    private static volatile ImageLoaderHelper instance;

    private ImageLoaderHelper() {

    }

    public static ImageLoaderHelper getInstance() {
        if (instance == null) {
            synchronized (ImageLoaderHelper.class) {
                if (instance == null) {
                    instance = new ImageLoaderHelper();
                }
            }
        }

        return instance;
    }

    private int optionsInit(int flag) {
        int sourceId = 0;
        if (flag == 0) {
            sourceId = R.drawable.ic_image_loading;
        }
        return sourceId;
    }

    public void load(Context context, String url, ImageView imageView) {
        if (imageView != null && context != null && url != null) {
            RequestOptions options = new RequestOptions()
                    // 加载中显示的图片
                    .placeholder(optionsInit(0))
                    // 图像则位于视图的中央
                    .centerCrop()
                    // .override(1090, 1090*3/4)
                    // 加载失败时显示的图片centerCrop().
                    .error(IMG_ERROR)
                    // 图片缓存
                    .diskCacheStrategy(DiskCacheStrategy.ALL);
            Glide.with(context).load(url).apply(options).into(imageView);
        }
    }

    public void loadV2(Context context, String url, ImageView imageView) {
        if (imageView != null && context != null && url != null) {
            RequestOptions options = new RequestOptions()
                    .placeholder(IMG_LOADING)
                    .diskCacheStrategy(DiskCacheStrategy.ALL);
            Glide.with(context).load(url).apply(options).into(imageView);
        }
    }

    public void load(Context context, Uri url, ImageView imageView) {
        if (imageView != null) {
            RequestOptions options = new RequestOptions()
                    .placeholder(IMG_LOADING)
                    .centerCrop()
                    .diskCacheStrategy(DiskCacheStrategy.ALL);
            Glide.with(context).load(url).apply(options).into(imageView);
        }
    }

    public void load(Context context, String url, ImageView imageView, int radius) {
        if (imageView != null) {
            RequestOptions options = new RequestOptions()
                    .placeholder(IMG_LOADING)
                    .transform(new GlideRoundTransform(context))
                    //.centerCrop()
                    .diskCacheStrategy(DiskCacheStrategy.ALL);

            Glide.with(context)
                    .load(url)
                    .transition(new DrawableTransitionOptions().crossFade(200))
                    .apply(options).into(imageView);
        }

    }

    public void load(Context context, File fileName, ImageView imageView) {
        if (imageView != null) {
            RequestOptions options = new RequestOptions()
                    .placeholder(IMG_LOADING)
                    .centerCrop()//centerCrop是利用图片图填充ImageView设置的大小
                    .diskCacheStrategy(DiskCacheStrategy.ALL);
            Glide.with(context).load(fileName).apply(options).into(imageView);
        }
    }

    /**
     * 加载资源图片
     *
     * @param context
     * @param resourceId
     * @param imageView
     */
    public void load(Context context, Integer resourceId, ImageView imageView) {
        if (imageView != null) {
            RequestOptions options = new RequestOptions()
                    .placeholder(IMG_LOADING)
                    .diskCacheStrategy(DiskCacheStrategy.ALL);
            Glide.with(context).load(resourceId).apply(options).into(imageView);
        }
    }

}
