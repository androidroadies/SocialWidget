package com.example.socialtouch;

import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.socialwidget.R;

public class Download extends BaseActivity implements View.OnClickListener {
    Button btnMarket;
    String click;
    String packge;
    String appName;
    SharedPreferences sharedPref;
    SharedPreferences shpf;
    TextView txtDownload;

    public void onClick(View paramView) {

    }

    protected void onCreate(Bundle paramBundle) {
        super.onCreate(paramBundle);
        setContentView(R.layout.new_main);
        LoadAdd();
        Intent intent = getIntent();
        packge = intent.getStringExtra("packge");
        appName = intent.getStringExtra("appName");
        System.out.println("32 " + packge + appName);

        btnMarket = (Button) findViewById(R.id.btn_market);
        TextView tvDownload = (TextView) findViewById(R.id.txtdownload);
        tvDownload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myClickMethod(v);
            }
        });

        String message = "Click here to download ";
        if (appName.equals(AppConfig.aFACEBOOK)) {
            btnMarket.setBackgroundResource(R.drawable.fbicon);
            message += "Facebook.";
        } else if (appName.equals(AppConfig.aGPLUS)) {
            btnMarket.setBackgroundResource(R.drawable.gplusicon);
            message += "Google Plus.";
        } else if (appName.equals(AppConfig.aHIKE)) {
            btnMarket.setBackgroundResource(R.drawable.hikeicon);
            message += "Hike.";
        } else if (appName.equals(AppConfig.aINSTAGRAM)) {
            btnMarket.setBackgroundResource(R.drawable.instaicon);
            message += "Instagram";
        } else if (appName.equals(AppConfig.aLINE)) {
            btnMarket.setBackgroundResource(R.drawable.lineicon);
            message += "Line.";
        } else if (appName.equals(AppConfig.aSKYP)) {
            btnMarket.setBackgroundResource(R.drawable.skypeicon);
            message += "Skype.";
        } else if (appName.equals(AppConfig.aTWITTER)) {
            btnMarket.setBackgroundResource(R.drawable.tweeticon);
            message += "Twitter.";
        } else if (appName.equals(AppConfig.aVIBER)) {
            btnMarket.setBackgroundResource(R.drawable.vibericon);
            message += "Viber.";
        } else if (appName.equals(AppConfig.aWECHAT)) {
            btnMarket.setBackgroundResource(R.drawable.wechaticon);
            message += "Wechat.";
        } else if (appName.equals(AppConfig.aWHATSAPP)) {
            btnMarket.setBackgroundResource(R.drawable.whatsappicon);
            message += "Whatsapp.";
        }

        tvDownload.setText(message);
//		btnMarket.setOnClickListener(new OnClickListener() {
//
//			@Override
//			public void onClick(View v) {
//				// TODO Auto-generated method stub
//				startActivity(new Intent("android.intent.action.VIEW", Uri
//						.parse("market://details?id=" + packge)));
//				finish();
//			}
//		});

    }

    public void myClickMethod(View v) {
        startActivity(new Intent("android.intent.action.VIEW",
                Uri.parse("market://details?id=" + this.packge)));
        finish();
    }


    @Override
    public void onBackPressed() {
        loadInterstitial(null);
        super.onBackPressed();
    }
}