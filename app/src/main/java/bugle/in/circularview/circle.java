package bugle.in.circularview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.RectF;
import android.util.Log;
import android.view.View;

import java.util.ArrayList;

/**
 * Created by User on 23-06-2015.
 */
public class circle extends View {
    Paint circuler1, circuler1Arc;
    int firstRadius, firstCenterX, firstCenterY, firstArcCenterY, firstArcCenterX;
    int secondRadius, secondCenterX, secondCenterY, secondArcCenterY, secondArcCenterX;


    ArrayList<Point> AnglesPoints60, AnglesPoints12;

    ArrayList<Integer> degree60,degree12;

    int Hour,Minutes;
    boolean AM;


    int StrokeWidth = 5;

    public circle(Context context, int firstCenterX, int firstCenterY, int firstRadius, int hr, int minutes, boolean am) {
        super(context);
        this.firstCenterX = firstCenterX;
        this.firstCenterY = firstCenterY;
        this.firstRadius = firstRadius;

        this.firstArcCenterX = firstCenterX;
        this.firstArcCenterY = firstCenterY;

        this.secondCenterX = firstCenterX;
        this.secondCenterY = firstCenterY;
        this.secondRadius = firstRadius + 30;

        this.secondArcCenterX = firstArcCenterX;
        this.secondArcCenterY = firstArcCenterY;

        AnglesPoints60 = new ArrayList<>();
        AnglesPoints12 = new ArrayList<>();

        degree60 = new ArrayList<>();
        degree12 = new ArrayList<>();

        AM = am;
        Hour = hr;
        Minutes = minutes;

        initAngles();
    }

    double PI = 3.42857142857;

    private void initAngles() {

        for(int i=0;i<=360;i+=6) {
            int x = (int) (firstCenterX + firstRadius  * Math.cos(i*Math.PI/180d));
            int y = (int) (firstCenterY + firstRadius  * Math.sin(i*Math.PI/180d));
            Point p = new Point();
            p.set(x,y);
            AnglesPoints60.add(p);
            degree60.add(i);
            Log.e("Degree60:", "" + i);
            Log.e("AnglesPoints60:", "x:"+x+",y:"+y);
        }

        for(int i=0;i<=360;i+=30) {
            int x = (int) (secondCenterX + secondRadius * Math.cos(i*Math.PI/180d));
            int y = (int) (secondCenterY + secondRadius * Math.sin(i*Math.PI/180d));
            Point p = new Point();
            p.set(x,y);
            AnglesPoints12.add(p);
            degree12.add(i);
            Log.e("Degree12:", "" + i);
            Log.e("AnglesPoints12:", "x:" + x + ",y:" + y);
        }

        Log.e("AnglesPoints12:", ""+AnglesPoints12.toString());
        Log.e("Degree60:",degree60.toString());

    }

    public int getHour() {
        return Hour;
    }

    public void setHour(int hour) {
        Hour = hour;
    }

    public int getMinutes() {
        return Minutes;
    }

    public void setMinutes(int minutes) {
        Minutes = minutes;
    }

    public boolean isAM() {
        return AM;
    }

    public void setAM(boolean AM) {
        this.AM = AM;
    }

    public void setFirstParams(int firstCenterX, int firstCenterY, int firstRadius) {
        this.firstCenterX = firstCenterX;
        this.firstCenterY = firstCenterY;
        this.firstRadius = firstRadius;
    }



    @Override
    protected void onDraw(Canvas canvas) {


        Paint circuler1dropshadow = new Paint();
        circuler1dropshadow.setAntiAlias(true);
        circuler1dropshadow.setStyle(Paint.Style.STROKE);
        circuler1dropshadow.setStrokeWidth(StrokeWidth);
        circuler1dropshadow.setColor(Color.parseColor("#35040505"));
        canvas.drawCircle(firstCenterX-1, firstCenterY-1, firstRadius, circuler1dropshadow);


        Paint circuler1dropshadow1 = new Paint();
        circuler1dropshadow1.setAntiAlias(true);
        circuler1dropshadow1.setStyle(Paint.Style.STROKE);
        circuler1dropshadow1.setStrokeWidth(StrokeWidth);
        circuler1dropshadow1.setColor(Color.parseColor("#35040505"));
        canvas.drawCircle(firstCenterX+1, firstCenterY+1, firstRadius, circuler1dropshadow1);

        Paint circuler1dropshadow2 = new Paint();
        circuler1dropshadow2.setAntiAlias(true);
        circuler1dropshadow2.setStyle(Paint.Style.STROKE);
        circuler1dropshadow2.setStrokeWidth(StrokeWidth);
        circuler1dropshadow2.setColor(Color.parseColor("#35040505"));
        canvas.drawCircle(firstCenterX+1, firstCenterY-1, firstRadius, circuler1dropshadow2);

        Paint circuler1dropshadow3 = new Paint();
        circuler1dropshadow3.setAntiAlias(true);
        circuler1dropshadow3.setStyle(Paint.Style.STROKE);
        circuler1dropshadow3.setStrokeWidth(StrokeWidth);
        circuler1dropshadow3.setColor(Color.parseColor("#35040505"));
        canvas.drawCircle(firstCenterX-1, firstCenterY+1, firstRadius, circuler1dropshadow3);


        circuler1 = new Paint();
        circuler1.setAntiAlias(true);
        circuler1.setStyle(Paint.Style.STROKE);
        circuler1.setStrokeWidth(StrokeWidth);
        circuler1.setColor(Color.WHITE);
        canvas.drawCircle(firstCenterX, firstCenterY, firstRadius, circuler1);




        circuler1Arc = new Paint();
        circuler1Arc.setAntiAlias(true);
        circuler1Arc.setStyle(Paint.Style.STROKE);
        circuler1Arc.setStrokeWidth(StrokeWidth);
        circuler1Arc.setColor(Color.YELLOW);

        final RectF oval = new RectF();
//        point1.x - radius, point1.y - radius, point1.x + radius, point1.y + radius
        oval.set(firstCenterX - firstRadius, firstCenterY - firstRadius, firstCenterX + firstRadius, firstCenterY + firstRadius);

        Log.e("Degree to Draw:", "" + degree60.get(Minutes));
        canvas.drawArc(oval, -90, degree60.get(Minutes), false, circuler1Arc);

        Paint circuler1smallback = new Paint();
        circuler1smallback.setAntiAlias(false);
        circuler1smallback.setColor(Color.RED);
        circuler1smallback.setStyle(Paint.Style.FILL);
        circuler1smallback.setStrokeWidth(3);

//        int x = (int) (firstCenterX + firstRadius * Math.cos(degree60.get(Minutes)));
//        int y = (int) (firstCenterY + firstRadius * Math.sin(degree60.get(Minutes)));

        int x = (int) (firstCenterX + firstRadius * Math.cos((degree60.get(Minutes)-90)*Math.PI/180d));
        int y = (int) (firstCenterY + firstRadius * Math.sin((degree60.get(Minutes)-90)*Math.PI/180d));

        canvas.drawCircle(x,y, 10, circuler1smallback);

        Paint circuler1small = new Paint();
        circuler1small.setAntiAlias(true);
        circuler1small.setColor(Color.YELLOW);
        circuler1small.setStyle(Paint.Style.STROKE);
        circuler1small.setStrokeWidth(2);

//        int x = (int) (firstCenterX + firstRadius * Math.cos(firstArcAngle));
//        int y = (int) (firstCenterY + firstRadius * Math.sin(firstArcAngle));

        canvas.drawCircle(x,y, 10, circuler1small);




        /*Hour Cicle*/

        Paint hrcirculer1dropshadow = new Paint();
        circuler1dropshadow.setAntiAlias(true);
        circuler1dropshadow.setStyle(Paint.Style.STROKE);
        circuler1dropshadow.setStrokeWidth(StrokeWidth);
        circuler1dropshadow.setColor(Color.parseColor("#35040505"));
        canvas.drawCircle(secondCenterX-1, secondCenterY-1, secondRadius, circuler1dropshadow);


        Paint hrcirculer1dropshadow1 = new Paint();
        circuler1dropshadow1.setAntiAlias(true);
        circuler1dropshadow1.setStyle(Paint.Style.STROKE);
        circuler1dropshadow1.setStrokeWidth(StrokeWidth);
        circuler1dropshadow1.setColor(Color.parseColor("#35040505"));
        canvas.drawCircle(secondCenterX+1, secondCenterY+1, secondRadius, circuler1dropshadow1);

        Paint hrcirculer1dropshadow2 = new Paint();
        hrcirculer1dropshadow2.setAntiAlias(true);
        hrcirculer1dropshadow2.setStyle(Paint.Style.STROKE);
        hrcirculer1dropshadow2.setStrokeWidth(StrokeWidth);
        hrcirculer1dropshadow2.setColor(Color.parseColor("#35040505"));
        canvas.drawCircle(secondCenterX+1, secondCenterY-1, secondRadius, hrcirculer1dropshadow2);

        Paint hrcirculer1dropshadow3 = new Paint();
        hrcirculer1dropshadow3.setAntiAlias(true);
        hrcirculer1dropshadow3.setStyle(Paint.Style.STROKE);
        hrcirculer1dropshadow3.setStrokeWidth(StrokeWidth);
        hrcirculer1dropshadow3.setColor(Color.parseColor("#35040505"));
        canvas.drawCircle(secondCenterX-1, secondCenterY+1, secondRadius, hrcirculer1dropshadow3);

        Paint hrcirculer1 = new Paint();
        hrcirculer1.setAntiAlias(true);
        hrcirculer1.setStyle(Paint.Style.STROKE);
        hrcirculer1.setStrokeWidth(StrokeWidth);
        hrcirculer1.setColor(Color.WHITE);
        canvas.drawCircle(secondCenterX, secondCenterY, secondRadius, hrcirculer1);


        Paint hrcirculer1Arc = new Paint();
        hrcirculer1Arc.setAntiAlias(true);
        hrcirculer1Arc.setStyle(Paint.Style.STROKE);
        hrcirculer1Arc.setStrokeWidth(StrokeWidth);
        hrcirculer1Arc.setColor(Color.YELLOW);

        final RectF hroval = new RectF();
//        point1.x - radius, point1.y - radius, point1.x + radius, point1.y + radius
        hroval.set(secondCenterX - secondRadius, secondCenterY - secondRadius, secondCenterX + secondRadius, secondCenterY + secondRadius);

        Log.e("Degree to Draw:", "" + degree12.get(Hour));
        canvas.drawArc(hroval, -90, degree12.get(Hour), false, hrcirculer1Arc);

        Paint hrcirculer1smallback = new Paint();
        hrcirculer1smallback.setAntiAlias(false);
        hrcirculer1smallback.setColor(Color.RED);
        hrcirculer1smallback.setStyle(Paint.Style.FILL);
        hrcirculer1smallback.setStrokeWidth(StrokeWidth);

        int hrx = (int) (secondCenterX + secondRadius * Math.cos((degree12.get(Hour)-90)*Math.PI/180d));
        int hry = (int) (secondCenterY + secondRadius * Math.sin((degree12.get(Hour)-90)*Math.PI/180d));
        canvas.drawCircle(hrx, hry, 10, hrcirculer1smallback);

        Paint hrcirculer1small = new Paint();
        hrcirculer1small.setAntiAlias(true);
        hrcirculer1small.setColor(Color.YELLOW);
        hrcirculer1small.setStyle(Paint.Style.STROKE);
        hrcirculer1small.setStrokeWidth(3);
        canvas.drawCircle(hrx, hry, 10, hrcirculer1small);

        Paint currenttime = new Paint();
        currenttime.setColor(Color.YELLOW);
        currenttime.setAntiAlias(true);
        currenttime.setStrokeWidth(10);
        currenttime.setTextSize(40);

        Paint aftertime = new Paint();
        aftertime.setColor(Color.WHITE);
        aftertime.setAntiAlias(true);
        aftertime.setStrokeWidth(10);
        aftertime.setTextSize(40);

        Paint time = new Paint();
        time.setColor(Color.WHITE);
        time.setAntiAlias(true);
        time.setStrokeWidth(10);
        time.setTextSize(60);

        canvas.drawText("AM", firstCenterX-30, firstCenterY - 80, (AM == true) ? currenttime : aftertime);

        String hour = ""+Hour;

        hour = (hour.length()<=1)?"0"+hour:hour;

        String minute = ""+Minutes;

        minute = (minute.length()<=1)?"0"+minute:minute;

        canvas.drawText(""+hour+":"+minute,firstCenterX-75,firstCenterY+30,time);

        canvas.drawText("PM", firstCenterX-30, firstCenterY + 110, (AM == false) ? currenttime : aftertime);

//        canvas.drawArc(firstArcCenterX,firstArcCenterY,firstArcCenterX+firstRadius,firstArcCenterY+firstRadius,firstArcAngle,true,circuler1Arc);
    }

}
