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


public class touchControl extends View {
    private Paint paint = new Paint();
    private Path path = new Path();
    public static int btn,tri,flag;
    public float oxpos,oypos,nxpos,nypos,tri_startx,tri_starty;
    public int l,t;
    public float[] lines = new float[80];
    public float[] triangles = new float[80];

    public touchControl(Context context, AttributeSet attributes) {
        super(context, attributes);
        paint.setAntiAlias(true);
        paint.setColor(Color.BLUE);
        paint.setStrokeJoin(Paint.Join.ROUND);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(5f);
        btn=1;
        t=0;
        flag=0;
        tri=0;
        for(l=0;l<80;l++) {
            lines[l] = 0;
            triangles[l] = 0;
        }
        l=0;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawPath(path, paint);
        if(btn!=1)
            canvas.drawLine(oxpos, oypos, nxpos, nypos, paint);         //Line live view
        canvas.drawLines(lines, paint);                             //For Straight Lines
        canvas.drawLines(triangles, paint);                         //Triangles
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if(flag==0) {
            reset(event);
            flag=1;
        }
        nxpos=event.getX();
        nypos=event.getY();
        if(btn==1)
            draw_free(event);
        else if(btn==2)
            draw_lines(event);
        else if(btn==3)
            draw_triangle(event);
        if(btn==4)
            draw_box(event);
        invalidate();
        return true;
    }

    public void reset(MotionEvent event){
        oxpos=event.getX();
        oypos=event.getY();
        tri_startx = oxpos;
        tri_starty = oypos;
    }

    public void draw_free(MotionEvent event){
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                path.moveTo(nxpos, nypos);
                break;
            case MotionEvent.ACTION_MOVE:
                path.lineTo(nxpos, nypos);
                break;
            case MotionEvent.ACTION_UP:
                flag=0;
                break;
        }
    }


    public void draw_lines(MotionEvent event){
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                path.moveTo(nxpos, nypos);
                break;
            case MotionEvent.ACTION_MOVE:
                if(btn==1)
                    path.lineTo(nxpos, nypos);
                break;
            case MotionEvent.ACTION_UP:
                //flag=0;                 //Lines array holds x,y points of all lines. (4 value sets [ox,oy,nx,ny])
                lines[l++]=oxpos;
                lines[l++]=oypos;
                lines[l++]=nxpos;
                lines[l++]=nypos;
                oxpos=nxpos;
                oypos=nypos;
                break;
        }
    }


    public void draw_triangle(MotionEvent event){
        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:
                path.moveTo(nxpos,nypos);
                break;
            case MotionEvent.ACTION_MOVE:
                if(btn==1)
                    path.lineTo(nxpos, nypos);
                break;
            case MotionEvent.ACTION_UP:
                    triangles[t++] = oxpos;
                    triangles[t++] = oypos;
                    triangles[t++] = nxpos;
                    triangles[t++] = nypos;
                    oxpos = nxpos;
                    oypos = nypos;
                    tri++;
                    if(tri==2) {
                        triangles[t++] = tri_startx;
                        triangles[t++] = tri_starty;
                        triangles[t++] = nxpos;
                        triangles[t++] = nypos;
                        tri = 0;
                        flag = 0;
                    }
                    break;
        }
    }

    public void draw_box(MotionEvent event){

    }
}

