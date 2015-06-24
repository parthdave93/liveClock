package bugle.in.circularview;

import android.os.Handler;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.widget.LinearLayout;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.StringTokenizer;

import bugle.in.circulerview.R;


public class MainActivity extends ActionBarActivity {


    public static DisplayMetrics display = new DisplayMetrics();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        LinearLayout addCircle = (LinearLayout) findViewById(R.id.addCircle);

        display = getResources().getDisplayMetrics();
        int height = display.heightPixels;
        int width = display.widthPixels;

        Constants.setHeight(height);
        Constants.setWidth(width);

        LinearLayout.LayoutParams addCricleParams = new LinearLayout.LayoutParams(540*Constants.getWidth()/540,960*Constants.getHeight()/960);

        addCircle.setLayoutParams(addCricleParams);

        final circle c = new circle(this,540*Constants.getWidth()/540/2,960*Constants.getHeight()/960/2/2,150*Constants.getWidth()/540,7,15,true);

        addCircle.addView(c);


        final Handler handler = new Handler();
        Runnable r = new Runnable(){
            public void run(){

                DateFormat dateFormat = new SimpleDateFormat("h:mm:ss:a");
                Date date = new Date();
                System.out.println(dateFormat.format(date));

                StringTokenizer tk = new StringTokenizer(dateFormat.format(date),":");
                int hour =0 ;
                int minutes = 0;
                int seconds = 0;
                boolean am = false;
                if(tk.hasMoreTokens()){
                    hour = Integer.parseInt(tk.nextToken());
                }
                if(tk.hasMoreTokens()){
                    minutes = Integer.parseInt(tk.nextToken());
                }
                if(tk.hasMoreTokens()){
                    seconds = Integer.parseInt(tk.nextToken());
                }
                if(tk.hasMoreTokens()){
                    am = (tk.nextToken()).equals("am")?true:false;
                }

                c.setAM(am);
                c.setHour(hour);
                c.setMinutes(minutes);
                c.invalidate();
                if(seconds!=0)
                    handler.postDelayed(this, (60-seconds)*1000);
                else
                    handler.postDelayed(this, 60*1000);

            }
        };

        r.run();
//        this.addContentView(c,new LinearLayout.LayoutParams(LinearLayout.LayoutParams.FILL_PARENT,LinearLayout.LayoutParams.FILL_PARENT));

    }





}
