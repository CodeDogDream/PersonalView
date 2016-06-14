package dream.jugg.com.personalview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by steven on 2016/6/13.
 */
public class MyView extends View {
    private float currentX;
    private float currentY;

    public MyView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        //初始化画布，设置颜色为白色
        canvas.drawColor(Color.WHITE);

        Paint paint=new Paint();
        paint.setAntiAlias(true);//设置抗锯齿
        paint.setColor(Color.BLUE);//设置画笔颜色
        paint.setStyle(Paint.Style.STROKE);//设置填充风格
        paint.setStrokeWidth(3);//设置画笔笔触宽度

        //画圆形
        canvas.drawCircle(40,40,30,paint);
        //绘制正方形，即设置矩形四边长相等
        canvas.drawRect(10,80,70,140,paint);
        //绘制矩形
        canvas.drawRect(10,150,70,190,paint);
        RectF re1=new RectF(10,200,70,230);
        //绘制圆角矩形
        canvas.drawRoundRect(re1,15,15,paint);
        RectF re11=new RectF(10,240,70,270);
        //绘制椭圆
        canvas.drawOval(re11,paint);
        /*
        用path绘制图形
        先定义path对象
        将其封闭成三角形
        三角形
        */
        Path path1=new Path();
        path1.moveTo(10,340);
        path1.lineTo(70,340);
        path1.lineTo(40,290);
        path1.close();
        canvas.drawPath(path1,paint);
        //封闭成五边形
        Path path2=new Path();
        path2.moveTo(26,360);
        path2.lineTo(54,360);
        path2.lineTo(70,392);
        path2.lineTo(40,420);
        path2.lineTo(10,392);
        path2.close();
        canvas.drawPath(path2,paint);

        //随着手指移动的小球绘制
        paint.setColor(Color.RED);
        paint.setStyle(Paint.Style.FILL_AND_STROKE);
        canvas.drawCircle(currentX,currentY,15,paint);

    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        //触摸事件
        this.currentX=event.getX();
        this.currentY=event.getY();
        this.invalidate();
        return true;
    }
}
