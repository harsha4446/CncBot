package com.example.harsha.cncbot;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

/**
 * Created by Harsha on 3/6/2017.
 */

public class touchControl extends View {
    private Paint paint = new Paint();
    private Path path = new Path();
    public static int btn;
    public float oxpos,oypos,nxpos,nypos;
    public int flag,l;
    public float[] lines = new float[40];

    public touchControl(Context context, AttributeSet attributes) {
        super(context, attributes);
        paint.setAntiAlias(true);
        paint.setColor(Color.BLUE);
        paint.setStrokeJoin(Paint.Join.ROUND);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(5f);
        btn=1;
        flag=0;
        l=0;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if(btn==1)
            canvas.drawPath(path, paint);
        else
            canvas.drawLines(lines, paint);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if(flag==0) {
            reset(event);
            flag=1;
        }
        nxpos=event.getX();
        nypos=event.getY();
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                path.moveTo(nxpos, nypos);
                return true;
            case MotionEvent.ACTION_MOVE:
                path.lineTo(nxpos, nypos);
                break;
            case MotionEvent.ACTION_UP:
                flag=0;
                break;
            default:
                return false;
        }
        if(btn==2){
            lines[l++]=oxpos;
            lines[l++]=oypos;
            lines[l++]=nxpos;
            lines[l++]=nypos;
        }
        invalidate();
        return true;
    }
    public void reset(MotionEvent event){
        oxpos=event.getX();
        oypos=event.getY();
    }
}

