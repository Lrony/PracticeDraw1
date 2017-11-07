package com.hencoder.hencoderpracticedraw1.practice;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import com.hencoder.hencoderpracticedraw1.model.Data;

import java.util.ArrayList;
import java.util.List;

import static android.R.attr.max;
import static android.content.ContentValues.TAG;

public class Practice11PieChartView extends View {

    private static final String TAG = "Practice11PieChartView";

    private Paint m_paint = null;

    private int m_scrollWight;
    private int m_scrollHeight;
    private float m_circleSize;
    private float m_circleGap;
    private float m_start;
    private float m_allNum;

    private List<Data> datas = new ArrayList<>();

    private RectF m_rectfCircle;

    public Practice11PieChartView(Context context) {
        super(context);
        initPaint();
    }

    public Practice11PieChartView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initPaint();
    }

    public Practice11PieChartView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initPaint();
    }

    private void initPaint() {
        m_paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        initData();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

//        综合练习
//        练习内容：使用各种 Canvas.drawXXX() 方法画饼图

        m_circleGap = 5;
        m_start = 0;
        m_scrollWight = canvas.getWidth();
        m_scrollHeight = canvas.getHeight();
        m_circleSize = getCircleSize();
        canvas.translate(m_scrollWight / 2, m_scrollHeight / 2);

        // View中最大的圆
        m_rectfCircle = new RectF(-m_circleSize, -m_circleSize, m_circleSize, m_circleSize);
        m_paint.setStyle(Paint.Style.FILL);

        // 待完善...
        for (Data data : datas) {
            m_paint.setColor(data.getColor());
            canvas.drawArc(m_rectfCircle, m_start, (data.getNumber() / m_allNum) * 360, true, m_paint);
            m_start += (data.getNumber() / m_allNum) * 360 + m_circleGap;
            Log.i(TAG, "onDraw: " + (data.getNumber() / m_allNum) * 360);
        }
    }

    private void initData() {
        Data data = new Data("Froyo", 50, Color.RED);
        datas.add(data);
        data = new Data("ICS", 80, Color.YELLOW);
        datas.add(data);
        data = new Data("JB", 10, Color.BLUE);
        datas.add(data);
        data = new Data("KK", 120, Color.CYAN);
        datas.add(data);
        data = new Data("L", 200, Color.MAGENTA);
        datas.add(data);
        data = new Data("M", 100, Color.GREEN);
        datas.add(data);
        data = new Data("GB", 300, Color.LTGRAY);
        datas.add(data);

        for (Data d : datas) {
            m_allNum = m_allNum + data.getNumber();
        }
        Log.i(TAG, "initData: " + m_allNum);
    }

    private float getCircleSize() {
        if (m_scrollWight > m_scrollHeight) {
            return m_scrollHeight / 2 - 20;
        } else {
            return m_scrollWight / 2 - 20;
        }
    }
}
