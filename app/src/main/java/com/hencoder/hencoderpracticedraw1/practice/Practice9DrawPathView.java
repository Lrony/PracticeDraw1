package com.hencoder.hencoderpracticedraw1.practice;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import static android.R.attr.path;

public class Practice9DrawPathView extends View {

    private Paint m_paint = null;
    private Path m_path = null;

    public Practice9DrawPathView(Context context) {
        super(context);
        initPaint();
    }

    public Practice9DrawPathView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initPaint();
    }

    public Practice9DrawPathView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initPaint();
    }

    private void initPaint() {
        m_paint = new Paint();
        m_path = new Path();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

//        练习内容：使用 canvas.drawPath() 方法画心形

        m_paint.setAntiAlias(true);

//        m_path.addCircle(200, 200, 100, Path.Direction.CW);
//        m_path.addCircle(300, 200, 100, Path.Direction.CW);

//        m_paint.setStyle(Paint.Style.STROKE);
//        m_paint.setStrokeWidth(5);
//        m_path.moveTo(100,100);
//        m_path.lineTo(200,100);

        m_path.addArc(100, 100, 300, 300, -225, 225);
        m_path.arcTo(300, 100, 500, 300, -180, 225, false);
        m_path.lineTo(300, 442);
        canvas.drawPath(m_path, m_paint);
    }
}
