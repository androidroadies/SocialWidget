package com.example.socialtouch;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;

import com.example.socialwidget.R;

public class HelpAct extends Activity {
    ImageView imgShare;
    String shareBody, socialWidgetApp, subject;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help);
        init();

    }

    private void init() {
        shareBody = getResources().getString(R.string.emailbodymsg);
        socialWidgetApp = getResources().getString(R.string.socialWidgetApp);
        subject = getResources().getString(R.string.app_name);
        imgShare = (ImageView) findViewById(R.id.imgShare);
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
