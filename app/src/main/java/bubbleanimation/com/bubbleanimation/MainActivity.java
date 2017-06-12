package bubbleanimation.com.bubbleanimation;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;


public class MainActivity extends AppCompatActivity {
    boolean isButtonClicked = true;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }



    public void didTapButtonone(View view) {
        Button button = (Button)findViewById(R.id.button);
        Button button1 = (Button) findViewById(R.id.button1);
        Button button2 = (Button) findViewById(R.id.button2);
        Button button3 = (Button) findViewById(R.id.button3);

        final Animation myAnim = AnimationUtils.loadAnimation(this, R.anim.bounce);
        //myAnim.setRepeatCount(Animation.INFINITE);
        final Animation myAnim1 = AnimationUtils.loadAnimation(this, R.anim.bounce1);
        //myAnim1.setRepeatCount(Animation.INFINITE);
        final Animation myAnim2 = AnimationUtils.loadAnimation(this, R.anim.bounce2);
        if(isButtonClicked) {


            button1.startAnimation(myAnim1);

            button2.startAnimation(myAnim);
            button3.startAnimation(myAnim2);
            isButtonClicked=false;
            //Log.d("isbutton","false should be play now");
            Log.d("isbutton", "Value: " + Boolean.toString(isButtonClicked));

            NotificationCompat.Builder mBuilder =
                    new NotificationCompat.Builder(this);

            mBuilder.setSmallIcon(R.drawable.notification_icon);
            //.setSmallIcon(R.drawable.notification_icon)
            mBuilder.setContentTitle("BuBBle Notification ");
            mBuilder.setContentText("Bubble Popping started");
            NotificationManager mNotificationManager =
                    (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
// mId allows you to update the notification later on.

            //Uri alarmSound = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
            //mBuilder.setSound(alarmSound);
            mBuilder.setDefaults(Notification.DEFAULT_SOUND);
            mNotificationManager.notify(0, mBuilder.build());



        }
        else{
            //myAnim.cancel();
            button1.clearAnimation();
            button2.clearAnimation();
            button3.clearAnimation();
            //myAnim.reset();
            //myAnim1.cancel();
            //myAnim1.reset();
            //myAnim2.cancel();
            //myAnim2.reset();
            isButtonClicked=true;
           // Log.d("isbutton ","true should be stopped now");

            //Log.d("isbutton", "Value: " + Boolean.toString(isButtonClicked));
            NotificationCompat.Builder mBuilder =
                    new NotificationCompat.Builder(this)
                            .setSmallIcon(R.drawable.notification_icon)
                            .setContentTitle("BuBBle Notification ")
                            .setContentText("Bubble Popping Stopped");
            NotificationManager mNotificationManager =
                    (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
// mId allows you to update the notification later on.

            //Uri alarmSound = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
            //mBuilder.setSound(alarmSound);
            mBuilder.setDefaults(Notification.DEFAULT_SOUND);
            mNotificationManager.notify(1, mBuilder.build());
        }

    }


}

