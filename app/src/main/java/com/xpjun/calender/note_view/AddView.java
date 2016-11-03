package com.xpjun.calender.note_view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import com.xpjun.calender.R;

/**
 * Created by nookia on 2016/10/31.
 */

public class AddView extends View{

    private int radius;
    private int backGroundColorRes,addSympolColorRes,width,height;
    private Paint paintCircle;
    private Paint paintAddSysbol;
    private Context context;
    private boolean changeBig;

    public int getAddSympolColorRes() {
        return addSympolColorRes;
    }

    public void setAddSympolColorRes(int addSympolColorRes) {
        this.addSympolColorRes = addSympolColorRes;
    }

    public int getBackGroundColorRes() {
        return backGroundColorRes;
    }

    public void setBackGroundColorRes(int backGroundColorRes) {
        this.backGroundColorRes = backGroundColorRes;
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    public AddView(Context context) {
        super(context);
        radius = 0;
        this.context = context;
        backGroundColorRes = R.color.cardview_dark_background;
        addSympolColorRes = R.color.cardview_light_background;
        initPaint();
    }

    public AddView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
        TypedArray typedArray = context.obtainStyledAttributes(attrs,R.styleable.addView);
        radius = typedArray.getInteger(R.styleable.addView_radius,80);
        backGroundColorRes = typedArray.getColor(R.styleable.addView_backgroundColor,0xffFFEA00);
        addSympolColorRes = typedArray.getColor(R.styleable.addView_addSymbolColor,0xffffffff);
        initPaint();
        typedArray.recycle();
    }

    private void initPaint() {
        paintCircle = new Paint(Paint.ANTI_ALIAS_FLAG);
        paintCircle.setColor(getBackGroundColorRes());
        paintCircle.setStyle(Paint.Style.FILL);
        paintCircle.setStrokeWidth(10);
        paintAddSysbol = new Paint(Paint.ANTI_ALIAS_FLAG);
        paintAddSysbol.setColor(getAddSympolColorRes());
        paintAddSysbol.setStyle(Paint.Style.FILL);
        paintAddSysbol.setStrokeWidth(5);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        width = this.getMeasuredWidth();
        height = this.getMeasuredHeight();
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawCircle(width/2,height/2,radius,paintCircle);
        canvas.save();
        canvas.translate(width/2,height/2);
        canvas.drawLine(0,0,(radius*1)/4,0,paintAddSysbol);
        canvas.drawLine(0,0,-(radius*1)/4,0,paintAddSysbol);
        canvas.drawLine(0,0,0,(radius*1)/4,paintAddSysbol);
        canvas.drawLine(0,0,0,-(radius*1)/4,paintAddSysbol);
        canvas.restore();
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        AddSymbolSizeChangeThread add = new AddSymbolSizeChangeThread();
        Thread thread = new Thread(add);
        int x = (int) event.getX();
        int y = (int) event.getY();
        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:
                changeBig = true;
                thread.start();
                break;
            case MotionEvent.ACTION_UP:
                if (listener!=null&&(x + getLeft() < getRight() && y + getTop() < getBottom())) {
                    changeBig = false;
                    listener.addViewOnClick();
                    thread.start();
                }
                break;
        }
        return true;
    }

    public class AddSymbolSizeChangeThread implements Runnable{
        @Override
        public void run() {
            synchronized (this){
                int i = 2;
                if (changeBig) {
                    while (radius < 90) {
                        if (!changeBig) {
                            radius = 90;
                            break;
                        }
                        radius = radius + i;
                        postInvalidate();
                        try {
                            Thread.sleep(18);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                } else {
                    while (radius > 80) {
                        radius = radius - i;
                        postInvalidate();
                        try {
                            Thread.sleep(18);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
    }

    private AddViewClickListener listener;

    public void setAddViewClickListener(AddViewClickListener listener){
        this.listener = listener;
    }

    public interface AddViewClickListener{
        void addViewOnClick();
    }
}
