package com.hencoder.hencoderpracticedraw1.practice;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.hencoder.hencoderpracticedraw1.model.Data;

import java.util.ArrayList;
import java.util.List;

import static android.R.attr.data;
import static android.R.attr.max;
import static android.R.attr.startX;
import static android.R.attr.width;

public class Practice10HistogramView extends View {

    private Paint m_paint = null;
    private Path m_path = null;

    private int m_Yaxis;
    private int m_Xaxis;
    private float m_RectWidth;
    private float m_RectGap;
    private float m_StartX;
    private float m_Max;

    private List<Data> datas = new ArrayList<>();

    public Practice10HistogramView(Context context) {
        super(context);
        initPaint();
    }

    public Practice10HistogramView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initPaint();
    }

    public Practice10HistogramView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initPaint();
    }

    private void initPaint() {
        m_paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        m_path = new Path();

        initData();
    }

    private void initData() {
        Data data = new Data("Froyo", 50, Color.BLACK);
        datas.add(data);
        data = new Data("ICS", 80, Color.BLACK);
        datas.add(data);
        data = new Data("JB", 10, Color.BLACK);
        datas.add(data);
        data = new Data("KK", 120, Color.BLACK);
        datas.add(data);
        data = new Data("L", 200, Color.BLACK);
        datas.add(data);
        data = new Data("M", 100, Color.BLACK);
        datas.add(data);
        data = new Data("GB", 300, Color.BLACK);
        datas.add(data);
        m_Max = Float.MIN_VALUE;
        for (Data d : datas) {
            m_Max = Math.max(max, d.getNumber());
        }
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

//        综合练习
//        练习内容：使用各种 Canvas.drawXXX() 方法画直方图

        m_Yaxis = canvas.getHeight() - 80;
        m_Xaxis = canvas.getWidth() - 150;

        m_RectGap = 20;
        m_StartX = m_RectGap;
        // 动态算出每个直方的宽度
        m_RectWidth = (m_Xaxis - (m_RectGap * datas.size())) / datas.size();

        // 画X,Y轴 (一)
        m_paint.setStyle(Paint.Style.STROKE);
        m_paint.setColor(Color.WHITE);
        m_paint.setStrokeWidth(3);
        canvas.drawLine(50, 50, 50, m_Yaxis, m_paint);
        canvas.drawLine(50, m_Yaxis, m_Xaxis + (m_RectGap * 4), m_Yaxis, m_paint);

//        // 画X,Y轴 (二)
//        m_path.moveTo(50, 50);
//        m_path.lineTo(50, m_Yaxis);
//        m_path.rLineTo(m_Xaxis, 0);
//        canvas.drawPath(m_path, m_paint);

        // 将画图原点移动直方图的原点位置
        canvas.translate(50, m_Yaxis - 3);

        for (Data data : datas) {
            // 画直方
            m_paint.setStyle(Paint.Style.FILL);
            m_paint.setColor(data.getColor());

            // 动态获取直方高度(待完善)
            int rectHight = data.getNumber();

            canvas.drawRect(m_StartX, -(rectHight), m_StartX + m_RectWidth, 0, m_paint);
            m_paint.setTextSize(20);
            m_paint.setColor(Color.WHITE);
            canvas.drawText(data.getName(), m_StartX, 25, m_paint);
            m_StartX += m_RectWidth + m_RectGap;
        }
    }
}
