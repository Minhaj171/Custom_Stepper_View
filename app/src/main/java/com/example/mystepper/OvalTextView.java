package com.example.mystepper;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 * Created by Md Minhajul Islam on 10/04/2023.
 */
public class OvalTextView extends androidx.appcompat.widget.AppCompatTextView {

    private Paint backgroundPaint;
    private boolean showImage;
    private Drawable imageDrawable;

    private int providedColor;

    public OvalTextView(Context context) {
        super(context);
        init();
    }

    public OvalTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public OvalTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }


    private void init() {
        backgroundPaint = new Paint();
        backgroundPaint.setColor(0xFFD3D3D3);
        backgroundPaint.setStyle(Paint.Style.FILL_AND_STROKE);
        backgroundPaint.setAntiAlias(true);
        showImage = false;
    }

    public void setShowImage(boolean showImage) {
        this.showImage = showImage;
        if (showImage) {
            setText("");
        }
        invalidate();
    }

    public void setImageDrawable(Drawable imageDrawable) {
        this.imageDrawable = imageDrawable;
        invalidate();
    }

    public void setBackgroundPaintColor(int colorId){
        this.providedColor = colorId;
        invalidate();
    }


//    @Override
//    protected void onDraw(Canvas canvas) {
//        if (showImage) {
//            if (imageDrawable != null) {
//                imageDrawable.setBounds(0, 0, getWidth(), getHeight());
//                imageDrawable.draw(canvas);
//            }
//        } else {
//            canvas.drawOval(0, 0, getWidth(), getHeight(), backgroundPaint);
//            super.onDraw(canvas);
//        }
//    }

    @Override
    protected void onDraw(Canvas canvas) {
        int diameter = Math.min(getWidth() - 8, getHeight() - 8);
        if (showImage) {
            if (imageDrawable != null) {
                imageDrawable.setBounds(0, 0, diameter, diameter);
                canvas.drawOval(0, 0, getWidth(), getHeight(), backgroundPaint);
                canvas.save();
                canvas.translate((getWidth() - diameter) / 2f, (getHeight() - diameter) / 2f);
                imageDrawable.draw(canvas);
                canvas.restore();
            }
        } else {
            backgroundPaint.setColor(providedColor);
            canvas.drawOval(0, 0, getWidth(), getHeight(), backgroundPaint);
            super.onDraw(canvas);
        }
    }

}
