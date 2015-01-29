package com.example.socialtouch;

import android.annotation.SuppressLint;
import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.hardware.Camera;
import android.hardware.Camera.Parameters;
import android.widget.RemoteViews;

import com.example.socialwidget.R;

@SuppressLint("NewApi")
public class WidgetProvider extends AppWidgetProvider {


    Parameters params;
    @SuppressWarnings("unused")
    private Camera camera;

    @Override
    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {
        RemoteViews remoteViews;
        ComponentName watchWidget;

        remoteViews = new RemoteViews(context.getPackageName(), R.layout.widget1);
        watchWidget = new ComponentName(context, WidgetProvider.class);

        remoteViews.setOnClickPendingIntent(R.id.facebook, getPendingSelfIntent(context, AppConfig.aFACEBOOK));
        remoteViews.setOnClickPendingIntent(R.id.wechat, getPendingSelfIntent(context, AppConfig.aWECHAT));
        remoteViews.setOnClickPendingIntent(R.id.whatsapp, getPendingSelfIntent(context, AppConfig.aWHATSAPP));
        remoteViews.setOnClickPendingIntent(R.id.twit, getPendingSelfIntent(context, AppConfig.aTWITTER));
        remoteViews.setOnClickPendingIntent(R.id.skyp, getPendingSelfIntent(context, AppConfig.aSKYP));
        remoteViews.setOnClickPendingIntent(R.id.gtalk, getPendingSelfIntent(context, AppConfig.aGPLUS));
        remoteViews.setOnClickPendingIntent(R.id.instagram, getPendingSelfIntent(context, AppConfig.aINSTAGRAM));
        remoteViews.setOnClickPendingIntent(R.id.hike, getPendingSelfIntent(context, AppConfig.aHIKE));
        remoteViews.setOnClickPendingIntent(R.id.line, getPendingSelfIntent(context, AppConfig.aLINE));
        remoteViews.setOnClickPendingIntent(R.id.viber, getPendingSelfIntent(context, AppConfig.aVIBER));


        appWidgetManager.updateAppWidget(watchWidget, remoteViews);
    }

    @SuppressWarnings("unused")
    @Override
    public void onReceive(Context context, Intent intent) {
        super.onReceive(context, intent);

        if (AppConfig.aFACEBOOK.equals(intent.getAction())) {

            AppWidgetManager appWidgetManager = AppWidgetManager.getInstance(context);

            RemoteViews remoteViews;
            ComponentName watchWidget;

            remoteViews = new RemoteViews(context.getPackageName(), R.layout.widget1);
            watchWidget = new ComponentName(context, WidgetProvider.class);

            remoteViews.setTextViewText(R.id.f, "TESTING");
            //your code

//           context.startActivity(context.getPackageManager().getLaunchIntentForPackage("com.zenpeak.jobalerts"));
            try {
                context.startActivity(context.getPackageManager().getLaunchIntentForPackage(AppConfig.pNameFacebook));
                return;
            } catch (Exception localException6) {
                Intent localIntent5 = new Intent(context, Download.class);
                localIntent5.setFlags(268435456);
                localIntent5.putExtra("appName", AppConfig.aFACEBOOK);
                localIntent5.putExtra("packge", AppConfig.pNameFacebook);
                localIntent5.putExtra("click", "2");
                context.startActivity(localIntent5);
                return;
            }
//            appWidgetManager.updateAppWidget(watchWidget, remoteViews);

        } else if (AppConfig.aWECHAT.equals(intent.getAction())) {


            AppWidgetManager appWidgetManager = AppWidgetManager.getInstance(context);

            RemoteViews remoteViews;
            ComponentName watchWidget;

            remoteViews = new RemoteViews(context.getPackageName(), R.layout.widget1);
            watchWidget = new ComponentName(context, WidgetProvider.class);

            remoteViews.setTextViewText(R.id.yt, "done");
            //your code

            try {
                context.startActivity(context.getPackageManager().getLaunchIntentForPackage(AppConfig.pNameWechat));
                return;
            } catch (Exception localException6) {
                Intent localIntent5 = new Intent(context, Download.class);
                localIntent5.setFlags(268435456);
                localIntent5.putExtra("appName", AppConfig.aWECHAT);
                localIntent5.putExtra("packge", AppConfig.pNameWechat);
                localIntent5.putExtra("click", "2");
                context.startActivity(localIntent5);
                return;
            }
//            appWidgetManager.updateAppWidget(watchWidget, remoteViews);

        } else if (AppConfig.aWHATSAPP.equals(intent.getAction())) {
            AppWidgetManager appWidgetManager = AppWidgetManager.getInstance(context);

            RemoteViews remoteViews;
            ComponentName watchWidget;

            remoteViews = new RemoteViews(context.getPackageName(), R.layout.widget1);
            watchWidget = new ComponentName(context, WidgetProvider.class);

            remoteViews.setTextViewText(R.id.yt, "done");
            //your code
            try {
                context.startActivity(context.getPackageManager().getLaunchIntentForPackage(AppConfig.pNameWhatsApp));
                return;
            } catch (Exception localException6) {
                Intent localIntent5 = new Intent(context, Download.class);
                localIntent5.setFlags(268435456);
                localIntent5.putExtra("appName", AppConfig.aWHATSAPP);
                localIntent5.putExtra("packge", AppConfig.pNameWhatsApp);
                localIntent5.putExtra("click", "2");
                context.startActivity(localIntent5);
                return;
            }
//            appWidgetManager.updateAppWidget(watchWidget, remoteViews);
        } else if (AppConfig.aTWITTER.equals(intent.getAction())) {
            AppWidgetManager appWidgetManager = AppWidgetManager.getInstance(context);

            RemoteViews remoteViews;
            ComponentName watchWidget;

            remoteViews = new RemoteViews(context.getPackageName(), R.layout.widget1);
            watchWidget = new ComponentName(context, WidgetProvider.class);

            remoteViews.setTextViewText(R.id.yt, "done");
            //your code
            try {
                context.startActivity(context.getPackageManager().getLaunchIntentForPackage(AppConfig.pNameTwitter));
                return;
            } catch (Exception localException6) {
                Intent localIntent5 = new Intent(context, Download.class);
                localIntent5.setFlags(268435456);
                localIntent5.putExtra("appName", AppConfig.aTWITTER);
                localIntent5.putExtra("packge", AppConfig.pNameTwitter);
                localIntent5.putExtra("click", "2");
                context.startActivity(localIntent5);
                return;
            }
//            appWidgetManager.updateAppWidget(watchWidget, remoteViews);
        } else if (AppConfig.aSKYP.equals(intent.getAction())) {
            AppWidgetManager appWidgetManager = AppWidgetManager.getInstance(context);

            RemoteViews remoteViews;
            ComponentName watchWidget;

            remoteViews = new RemoteViews(context.getPackageName(), R.layout.widget1);
            watchWidget = new ComponentName(context, WidgetProvider.class);

            remoteViews.setTextViewText(R.id.yt, "done");
            //your code
            try {
                context.startActivity(context.getPackageManager().getLaunchIntentForPackage(AppConfig.pNameSkyp));
                return;
            } catch (Exception localException6) {
                Intent localIntent5 = new Intent(context, Download.class);
                localIntent5.setFlags(268435456);
                localIntent5.putExtra("appName", AppConfig.aSKYP);
                localIntent5.putExtra("packge", AppConfig.pNameSkyp);
                localIntent5.putExtra("click", "2");
                context.startActivity(localIntent5);
                return;
            }
//            appWidgetManager.updateAppWidget(watchWidget, remoteViews);
        } else if (AppConfig.aGPLUS.equals(intent.getAction())) {
            AppWidgetManager appWidgetManager = AppWidgetManager.getInstance(context);

            RemoteViews remoteViews;
            ComponentName watchWidget;

            remoteViews = new RemoteViews(context.getPackageName(), R.layout.widget1);
            watchWidget = new ComponentName(context, WidgetProvider.class);

            remoteViews.setTextViewText(R.id.yt, "done");
            //your code
            try {
                context.startActivity(context.getPackageManager().getLaunchIntentForPackage(AppConfig.pNameGplus));
                return;
            } catch (Exception localException6) {
                Intent localIntent5 = new Intent(context, Download.class);
                localIntent5.setFlags(268435456);
                localIntent5.putExtra("appName", AppConfig.aGPLUS);
                localIntent5.putExtra("packge", AppConfig.pNameGplus);
                localIntent5.putExtra("click", "2");
                context.startActivity(localIntent5);
                return;
            }
//            appWidgetManager.updateAppWidget(watchWidget, remoteViews);
        } else if (AppConfig.aINSTAGRAM.equals(intent.getAction())) {
            AppWidgetManager appWidgetManager = AppWidgetManager.getInstance(context);

            RemoteViews remoteViews;
            ComponentName watchWidget;

            remoteViews = new RemoteViews(context.getPackageName(), R.layout.widget1);
            watchWidget = new ComponentName(context, WidgetProvider.class);

            remoteViews.setTextViewText(R.id.yt, "done");
            //your code
            try {
                context.startActivity(context.getPackageManager().getLaunchIntentForPackage(AppConfig.pNameInstagram));
                return;
            } catch (Exception localException6) {
                Intent localIntent5 = new Intent(context, Download.class);
                localIntent5.setFlags(268435456);
                localIntent5.putExtra("appName", AppConfig.aINSTAGRAM);
                localIntent5.putExtra("packge", AppConfig.pNameInstagram);
                localIntent5.putExtra("click", "2");
                context.startActivity(localIntent5);
                return;
            }
//            appWidgetManager.updateAppWidget(watchWidget, remoteViews);
        } else if (AppConfig.aHIKE.equals(intent.getAction())) {
            AppWidgetManager appWidgetManager = AppWidgetManager.getInstance(context);

            RemoteViews remoteViews;
            ComponentName watchWidget;

            remoteViews = new RemoteViews(context.getPackageName(), R.layout.widget1);
            watchWidget = new ComponentName(context, WidgetProvider.class);

            remoteViews.setTextViewText(R.id.yt, "done");
            //your code
            try {
                context.startActivity(context.getPackageManager().getLaunchIntentForPackage(AppConfig.pNameHike));
                return;
            } catch (Exception localException6) {
                Intent localIntent5 = new Intent(context, Download.class);
                localIntent5.setFlags(268435456);
                localIntent5.putExtra("appName", AppConfig.aHIKE);
                localIntent5.putExtra("packge", AppConfig.pNameHike);
                localIntent5.putExtra("click", "2");
                context.startActivity(localIntent5);
                return;
            }
//            appWidgetManager.updateAppWidget(watchWidget, remoteViews);
        } else if (AppConfig.aVIBER.equals(intent.getAction())) {
            AppWidgetManager appWidgetManager = AppWidgetManager.getInstance(context);

            RemoteViews remoteViews;
            ComponentName watchWidget;

            remoteViews = new RemoteViews(context.getPackageName(), R.layout.widget1);
            watchWidget = new ComponentName(context, WidgetProvider.class);

            remoteViews.setTextViewText(R.id.yt, "done");
            //your code
            try {
                context.startActivity(context.getPackageManager().getLaunchIntentForPackage(AppConfig.pNameViber));
                return;
            } catch (Exception localException6) {
                Intent localIntent5 = new Intent(context, Download.class);
                localIntent5.setFlags(268435456);
                localIntent5.putExtra("appName", AppConfig.aVIBER);
                localIntent5.putExtra("packge", AppConfig.pNameViber);
                localIntent5.putExtra("click", "2");
                context.startActivity(localIntent5);
                return;
            }
//            appWidgetManager.updateAppWidget(watchWidget, remoteViews);
        } else if (AppConfig.aLINE.equals(intent.getAction())) {
            AppWidgetManager appWidgetManager = AppWidgetManager.getInstance(context);

            RemoteViews remoteViews;
            ComponentName watchWidget;

            remoteViews = new RemoteViews(context.getPackageName(), R.layout.widget1);
            watchWidget = new ComponentName(context, WidgetProvider.class);

            remoteViews.setTextViewText(R.id.yt, "done");
            //your code
            try {
                context.startActivity(context.getPackageManager().getLaunchIntentForPackage(AppConfig.pNameLine));
                return;
            } catch (Exception localException6) {
                Intent localIntent5 = new Intent(context, Download.class);
                localIntent5.setFlags(268435456);
                localIntent5.putExtra("appName", AppConfig.aLINE);
                localIntent5.putExtra("packge", AppConfig.pNameLine);
                localIntent5.putExtra("click", "2");
                context.startActivity(localIntent5);
                return;
            }
//            appWidgetManager.updateAppWidget(watchWidget, remoteViews);
        }
    }


    protected PendingIntent getPendingSelfIntent(Context context, String action) {
        Intent intent = new Intent(context, getClass());
        intent.setAction(action);
        return PendingIntent.getBroadcast(context, 0, intent, 0);
    }
}
