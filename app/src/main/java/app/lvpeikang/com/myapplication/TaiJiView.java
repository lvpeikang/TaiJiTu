package app.lvpeikang.com.myapplication;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by 吕培康 on 2019/7/22.
 */

public class TaiJiView extends View {
    private Paint whitePaint;//白色画笔
    private Paint blackPaint;//黑色画笔
    private float degrees=0;
    public TaiJiView(Context context) {
        super(context);
        initPaints();
    }

    public TaiJiView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initPaints();
    }

    public TaiJiView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initPaints();
    }
    @TargetApi(21)
    public TaiJiView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        initPaints();
    }
    private void initPaints(){
        whitePaint=new Paint();
        whitePaint.setAntiAlias(true);
        whitePaint.setColor(Color.WHITE);
        blackPaint=new Paint();
        blackPaint.setAntiAlias(true);
        blackPaint.setColor(Color.BLACK);
    }
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int width=canvas.getWidth();
        int height=canvas.getHeight();
        Point centerPoint=new Point(width/2,height/2);
        canvas.translate(centerPoint.x,centerPoint.y);
        canvas.drawColor(Color.GRAY);
        canvas.rotate(degrees);
        int radius=Math.min(width,height)/2-100;
        RectF rectF=new RectF(-radius,-radius,radius,radius);//绘制区域
        canvas.drawArc(rectF,90,180,true,blackPaint);//区域，起始偏移角度，扫过角度，是否启用中心，画笔
        canvas.drawArc(rectF,-90,180,true,whitePaint);
        //绘制小圆
        int smallRadius=radius/2;
        canvas.drawCircle(0,-smallRadius,smallRadius,blackPaint);//x坐标，Y坐标，半径，画笔
        canvas.drawCircle(0,smallRadius,smallRadius,whitePaint);
        //绘制鱼眼
        canvas.drawCircle(0,-smallRadius,smallRadius/4,whitePaint);//绘制一个半径更小的圆，并且使用相反颜色画笔
        canvas.drawCircle(0,smallRadius,smallRadius/4,blackPaint);
        //动起来
    }
    public void setRotate(float degrees){
        this.degrees=degrees;
        invalidate();
    }
}
