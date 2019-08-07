package com.ti.demo;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;

public class DimensionHelper {
    /**
     * 根据手机的分辨率从 dp 的单位 转成为 px(像素)
     */
    public static float dipToPx(Context context, float dp) {
        Resources resources = context.getResources();
        DisplayMetrics metrics = resources.getDisplayMetrics();
        float px = dp * ((float) metrics.densityDpi / DisplayMetrics.DENSITY_DEFAULT);
        return px;
    }

    /**
     * 根据手机的分辨率从 px(像素) 的单位 转成为 dp
     */
    public static float pxToDip(Context context, float px) {
        Resources resources = context.getResources();
        DisplayMetrics metrics = resources.getDisplayMetrics();
        float dp = px / ((float) metrics.densityDpi / DisplayMetrics.DENSITY_DEFAULT);
        return dp;
    }

    /**
     * 将px值转换为sp值，保证文字大小不变
     *
     * @param px      像素值
     * @param context 上下文
     * @return px转换后的sp
     */
    public static float pxToSp(Context context, float px) {
        Resources resources = context.getResources();
        DisplayMetrics metrics = resources.getDisplayMetrics();
        float sp = px / metrics.scaledDensity + 0.5f;
        return sp;
    }

    /**
     * 将sp值转换为px值，保证文字大小不变
     *
     * @param sp      字体sp大小
     * @param context （上下文
     * @return sp转换后的px值
     */
    public static float spToPx(Context context, float sp) {
        Resources resources = context.getResources();
        DisplayMetrics metrics = resources.getDisplayMetrics();
        float px = sp * metrics.scaledDensity + 0.5f;
        return px;
    }
}
