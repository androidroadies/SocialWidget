package com.example.socialtouch;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import android.widget.Toast;

import com.example.socialwidget.R;

public class FeedBackAct extends BaseActivity {
    String shareBody, socialWidgetApp, subject;
    EditText etSubject, emailBody;
    Button send, clear;
    ImageView imgShare;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setContentView(R.layout.md_email_send);
        init();

        // Intent sendIntent = new Intent();
        // sendIntent.setAction(Intent.ACTION_SEND);
        //
        // sendIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, subject);
        // sendIntent.putExtra(Intent.EXTRA_TEXT, shareBody + socialWidgetApp);
        // sendIntent.setType("text/plain");
        // startActivity(sendIntent);

    }

    private void init() {
        // TODO Auto-generated method stub
        socialWidgetApp = getResources().getString(R.string.socialWidgetApp);
        shareBody = getResources().getString(R.string.emailbodymsg);
        subject = getResources().getString(R.string.app_name);
        send = (Button) findViewById(R.id.btnSend);
        clear = (Button) findViewById(R.id.btnClear);
        etSubject = (EditText) findViewById(R.id.etsubject);
        emailBody = (EditText) findViewById(R.id.etemailBody);
        imgShare = (ImageView) findViewById(R.id.ivShare);

        emailBody.setOnEditorActionListener(new OnEditorActionListener() {

            @Override
            public boolean onEditorAction(TextView v, int actionId,
                                          KeyEvent event) {
                // TODO Auto-generated method stub
                send();
                return false;
            }
        });
        send.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                send();
            }
        });
        clear.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                etSubject.setText("");
                emailBody.setText("");
            }
        });
        imgShare.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub

                Intent sharingIntent = new Intent(
                        Intent.ACTION_SEND);
                sharingIntent.setType("text/plain");
                sharingIntent.putExtra(Intent.EXTRA_SUBJECT,
                        subject);
                sharingIntent.putExtra(Intent.EXTRA_TEXT,
                        shareBody + socialWidgetApp);
                startActivity(Intent.createChooser(sharingIntent, "Share via"));

            }
        });
    }

    protected void send() {
        // TODO Auto-generated method stub
        if (etSubject.getText().toString().trim().length() > 0) {
            if (emailBody.getText().toString().trim().length() > 0) {
                Uri uri = Uri.parse("mailto: yasin@multidots.com");
                Intent intent = new Intent(Intent.ACTION_SENDTO, uri);
                intent.putExtra(Intent.EXTRA_SUBJECT, etSubject
                        .getText().toString());
                intent.putExtra(Intent.EXTRA_TEXT, emailBody.getText().toString()
                        + socialWidgetApp);
                startActivity(intent);
            } else {
                Toast.makeText(getApplicationContext(), "Please write in somthing email body.",
                        Toast.LENGTH_LONG).show();
            }
        } else {
            Toast.makeText(getApplicationContext(), "Please Enter subject.",
                    Toast.LENGTH_LONG).show();
        }
    }


    @Override
    public void onBackPressed() {
        loadInterstitial(null);
        super.onBackPressed();
    }
}
