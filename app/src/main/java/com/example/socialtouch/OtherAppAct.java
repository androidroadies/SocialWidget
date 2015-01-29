package com.example.socialtouch;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;

import com.example.socialwidget.R;

public class OtherAppAct extends Activity {
    ImageView btnAutometer, btnAma, btnAdani, btnTictac;
    String autometer = "https://play.google.com/store/apps/details?id=com.multidots.ahmedabadautometer";
    String adani = "https://play.google.com/store/apps/details?id=com.multidots.adanigasmeter";
    String ama = "https://play.google.com/store/apps/details?id=com.multidots.ama_events_ahmedabad";
    String tictac = "https://play.google.com/store/apps/details?id=com.multidots.OOs";
    ImageView imgShare;
    String socialWidgetApp, shareBody, subject;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setContentView(R.layout.other_app);
        init();

    }

    private void init() {
        // TODO Auto-generated method stub
        shareBody = getResources().getString(R.string.emailbodymsg);
        socialWidgetApp = getResources().getString(R.string.socialWidgetApp);
        subject = getResources().getString(R.string.app_name);
        btnAutometer = (ImageView) findViewById(R.id.btn_download1);
        btnAma = (ImageView) findViewById(R.id.btn_download2);
        btnAdani = (ImageView) findViewById(R.id.btn_download3);
        btnTictac = (ImageView) findViewById(R.id.btn_download4);

        imgShare = (ImageView) findViewById(R.id.imgShare);
        imgShare.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub

                Intent sharingIntent = new Intent(Intent.ACTION_SEND);
                sharingIntent.setType("text/plain");
                sharingIntent.putExtra(Intent.EXTRA_SUBJECT, subject);
                sharingIntent.putExtra(Intent.EXTRA_TEXT, shareBody + socialWidgetApp);
                startActivity(Intent.createChooser(sharingIntent, "Share via"));

            }
        });
        btnAutometer.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri
                        .parse(autometer));
                startActivity(browserIntent);
            }
        });
        btnAma.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri
                        .parse(ama));
                startActivity(browserIntent);
            }
        });
        btnAdani.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri
                        .parse(adani));
                startActivity(browserIntent);
            }
        });
        btnTictac.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri
                        .parse(tictac));
                startActivity(browserIntent);
            }
        });
    }
}
