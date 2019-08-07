package com.ti.demo;

import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.StrikethroughSpan;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        // 中等字体
        int middleFontSize = (int) DimensionHelper.spToPx(this, 18);
        // 小字体
        int smallFontSize = (int) DimensionHelper.spToPx(this, 14);
        // 红色 #F65236
        int colorRed = ContextCompat.getColor(this, R.color.fresh_red);
        // 灰色 #999999
        int textColorThird = ContextCompat.getColor(this, R.color.deep_gray);

        SpannableStringBuilder spanBuilder = new SpannableStringBuilder();

        String price = "¥99";
        int start = 0;
        int end = price.length();
        spanBuilder.append(price);
        //添加字体大小样式span
        spanBuilder.setSpan(new AbsoluteSizeSpan(middleFontSize), start, end, Spanned.SPAN_INCLUSIVE_EXCLUSIVE);
        //添加文本颜色样式span
        spanBuilder.setSpan(new ForegroundColorSpan(colorRed), start, end, Spanned.SPAN_INCLUSIVE_EXCLUSIVE);

        String priceUnit = "元/件";
        start = end;
        end += priceUnit.length();
        spanBuilder.append(priceUnit);
        spanBuilder.setSpan(new AbsoluteSizeSpan(smallFontSize), start, end, Spanned.SPAN_INCLUSIVE_EXCLUSIVE);
        spanBuilder.setSpan(new ForegroundColorSpan(colorRed), start, end, Spanned.SPAN_INCLUSIVE_EXCLUSIVE);

        String line = " - 原价¥";
        start = end;
        end += line.length();
        spanBuilder.append(line);
        spanBuilder.setSpan(new AbsoluteSizeSpan(smallFontSize), start, end, Spanned.SPAN_INCLUSIVE_EXCLUSIVE);
        spanBuilder.setSpan(new ForegroundColorSpan(textColorThird), start, end, Spanned.SPAN_INCLUSIVE_EXCLUSIVE);

        String originalPricePrefix = "399";
        start = end;
        end += originalPricePrefix.length();
        spanBuilder.append(originalPricePrefix);
        spanBuilder.setSpan(new AbsoluteSizeSpan(smallFontSize), start, end, Spanned.SPAN_INCLUSIVE_EXCLUSIVE);
        spanBuilder.setSpan(new ForegroundColorSpan(textColorThird), start, end, Spanned.SPAN_INCLUSIVE_EXCLUSIVE);
        //添加删除线样式span
        spanBuilder.setSpan(new StrikethroughSpan(), start, end, Spanned.SPAN_INCLUSIVE_EXCLUSIVE);

        // 最终把SpannableStringBuilder设置给TextView

        TextView mTvPriceTag = findViewById(R.id.tv_price_tag);
        mTvPriceTag.setText(spanBuilder);
    }
}
