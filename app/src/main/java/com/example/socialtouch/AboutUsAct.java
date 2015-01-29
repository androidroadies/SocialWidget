package com.example.socialtouch;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;

import com.example.socialwidget.R;

public class AboutUsAct extends Activity {
    ImageView imgAboutus, imgShare;
    String strCompany = "http://www.multidots.com/";
    String shareBody, socialWidgetApp, subject;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aboutus);
        init();
    }

    private void init() {
        // TODO Auto-generated method stub

        shareBody = getResources().getString(R.string.shareBody);
        socialWidgetApp = getResources().getString(R.string.socialWidgetApp);
        subject = getResources().getString(R.string.app_name);

        imgAboutus = (ImageView) findViewById(R.id.ivMD);
        imgShare = (ImageView) findViewById(R.id.ivShare);
        imgAboutus.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri
                        .parse(strCompany));
                startActivity(browserIntent);
            }
        });
        imgShare.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub

                Intent sharingIntent = new Intent(
                        Intent.ACTION_SEND);
                sharingIntent.setType("text/plain");
                sharingIntent.putExtra(Intent.EXTRA_SUBJECT, subject);
                sharingIntent.putExtra(Intent.EXTRA_TEXT,
                        shareBody + socialWidgetApp);
                startActivity(Intent.createChooser(sharingIntent, "Share via"));

            }
        });
    }

}
