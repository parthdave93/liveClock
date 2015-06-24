package bugle.in.circularview;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by BUGLE4 on 6/4/2015.
 */
public class Constants {
//    public static String basic_url = "http://192.168.1.70/sagar/sufirecipe/api";

    public static String basic_url = "http://sampleserver.org/sufiapp/api";

    public static String Userid = "1";

    public static boolean haveNetworkConnection(Context context) {
        boolean haveConnectedWifi = false;
        boolean haveConnectedMobile = false;

        ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo[] netInfo = cm.getAllNetworkInfo();
        for (NetworkInfo ni : netInfo) {
            if (ni.getTypeName().equalsIgnoreCase("WIFI"))
                if (ni.isConnected())
                    haveConnectedWifi = true;
            if (ni.getTypeName().equalsIgnoreCase("MOBILE"))
                if (ni.isConnected())
                    haveConnectedMobile = true;
        }
        return haveConnectedWifi || haveConnectedMobile;
    }

    public static Typeface roboto;

    public static Typeface roboto_light;

    public static Typeface roboto_thin;

    public static Typeface getRoboto(Context context){
        roboto = Typeface.createFromAsset(context.getAssets(), "fonts/Roboto-Regular.ttf");

        return roboto;
    }

    public static Typeface getRoboto_light(Context context){
        roboto_light = Typeface.createFromAsset(context.getAssets(), "fonts/Roboto-Regular.ttf");

        return roboto_light;
    }

    public static Typeface getRoboto_thin(Context context){

        roboto_thin = Typeface.createFromAsset(context.getAssets(), "fonts/Roboto-Thin.ttf");

        return roboto_thin;
    }

    public static int width;

    public static int getWidth() {
        return width;
    }

    public static void setWidth(int width) {
        Constants.width = width;
    }

    public static int getHeight() {
        return height;
    }

    public static void setHeight(int height) {
        Constants.height = height;
    }

    public static int height;





    /*For Menu Storing navigation item*/
    public static String PREFS_NAME = "SimplySufi";
    public static String PREFS_KEY_ID = "id";
    public static String PREFS_KEY_NAME = "name";
    public static String PREFS_KEY_MENU_ITEM = "menu_item";

    public static void save(Context context, HashMap<String, String> values) {
        SharedPreferences settings;
        SharedPreferences.Editor editor;
        settings = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE); //1
        editor = settings.edit(); //2

        Iterator it = values.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry pair = (Map.Entry) it.next();
            System.out.println("save:" + pair.getKey() + " = " + pair.getValue());
            editor.putString(pair.getKey().toString(), pair.getValue().toString());
        }

        editor.commit(); //4
        getValue(context, values);
    }


    public static HashMap<String, String> getValue(Context context, HashMap<String, String> values) {
        SharedPreferences settings;
        settings = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE); //1

        HashMap<String, String> values1 = new HashMap<String, String>();
        Iterator it = values.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry pair = (Map.Entry) it.next();
            System.out.println("getValue:" + pair.getKey() + " = " + pair.getValue());
            values1.put(pair.getKey().toString(), settings.getString(pair.getKey().toString(), ""));
        }
        return values1;
    }



    /*Recipe Tags*/

    public static int All_Recipe = 1;
    public static int My_Recipe = 2;
    public static String RecipeFragment_bundle = "loadRecipe";
    public static int My_Fav_Recipe_Counter =0;
    public static int My_Fav_Recipe = 3;
    public static String My_Fav_Recipe_Count = "my_Fav_recip";

}
