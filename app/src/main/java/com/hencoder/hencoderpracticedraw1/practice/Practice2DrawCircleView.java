package com.hencoder.hencoderpracticedraw1.practice;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

public class Practice2DrawCircleView extends View {

    private Paint m_paint = null;

    public Practice2DrawCircleView(Context context) {
        super(context);
        initPaint();
    }

    public Practice2DrawCircleView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initPaint();
    }

    public Practice2DrawCircleView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initPaint();
    }

    private void initPaint() {
        m_paint = new Paint();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

//        练习内容：使用 canvas.drawCircle() 方法画圆
//        一共四个圆：1.实心圆 2.空心圆 3.蓝色实心圆 4.线宽为 20 的空心圆

        int canvasWidth = canvas.getWidth();

        m_paint.setAntiAlias(true);

        m_paint.setColor(Color.BLACK);
        canvas.drawCircle(canvasWidth / 2 - 100 - 30, 120, 100, m_paint);

        m_paint.setStyle(Paint.Style.STROKE);
        m_paint.setStrokeWidth(3);
        canvas.drawCircle(canvasWidth / 2 + 100 + 30, 120, 100, m_paint);

        m_paint.setColor(Color.BLUE);
        m_paint.setStyle(Paint.Style.FILL);
        canvas.drawCircle(canvasWidth / 2 - 100 - 30, 120 + 200 + 30, 100, m_paint);

        m_paint.setStyle(Paint.Style.STROKE);
        m_paint.setStrokeWidth(20);
        canvas.drawCircle(canvasWidth / 2 + 100 + 30, 120 + 200 + 30, 100, m_paint);
    }
}
