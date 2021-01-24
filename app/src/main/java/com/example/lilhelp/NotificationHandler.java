package com.example.lilhelp;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.util.Log;

import androidx.annotation.RequiresApi;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import java.io.FileNotFoundException;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@RequiresApi(api = Build.VERSION_CODES.O)
public class NotificationHandler {

    public static final String CHANNEL_ID = "motivation_sender";
    private static Context ctx;
    public static boolean started = false;
    private static ExecutorService es = Executors.newSingleThreadExecutor();
    private static LocalDateTime time = LocalDateTime.now();
    private static int timeStep = 86400 / Settings.getNotifsPerDay();
    private static int amountSentToday = 0;

    public static void setContext(Context cotx) {
        ctx = cotx;
    }

    public static void createNotificationChannel(String channelName, String channelDescription, Context context)
    {
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O)
        {
            int importance = NotificationManager.IMPORTANCE_DEFAULT;
            NotificationChannel channel = new NotificationChannel(CHANNEL_ID, channelName, importance);
            channel.setDescription(channelDescription);
            NotificationManager notificationManager = context.getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannel(channel);
        }
    }

    //for testing
    public static void sendNotification(String msg)
    {
        NotificationCompat.Builder builder = new NotificationCompat.Builder(ctx, CHANNEL_ID)
                .setSmallIcon(R.mipmap.ic_launcher)
                .setLargeIcon(BitmapFactory.decodeResource(ctx.getResources(), R.mipmap.ic_launcher))
                .setContentTitle("Lil Help")
                .setContentText(msg)
                .setStyle(new NotificationCompat.BigTextStyle()
                            .bigText(msg))
                .setPriority(NotificationCompat.PRIORITY_DEFAULT)
                .setAutoCancel(true);

        NotificationManagerCompat notificationManager = NotificationManagerCompat.from(ctx);

        final int id = 5;
        notificationManager.notify(id, builder.build());
    }

    public static void startNotif() {
        if(!started) {
            started = true;
            es.execute(new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(10000);
                        sendNotification("Congratulations on accomplishing " + DataHandler.get(ctx, "2021-01-24").getAq().getAnswer() + "!");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
    }
}
