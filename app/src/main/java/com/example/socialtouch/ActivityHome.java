package com.example.socialtouch;

import android.app.TabActivity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.widget.TabHost;
import android.widget.TabHost.TabSpec;

import com.example.socialwidget.R;

@SuppressWarnings("deprecation")
public class ActivityHome extends TabActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        init();

    }

    private void init() {
        // TODO Auto-generated method stub
        @SuppressWarnings("unused")
        Resources ressources = getResources();
        final TabHost tabHost = getTabHost();
//		tabHost.setBackgroundColor(Color.RED);
        Intent tabOtherActTab = new Intent().setClass(this,
                OtherAppAct.class);
        TabSpec tabOtherAct = tabHost.newTabSpec("OtherAppAct")
                .setIndicator("OtherApp", ressources.getDrawable(R.drawable.other_appss))
                .setContent(tabOtherActTab);

        Intent tabHelpActTab = new Intent().setClass(this,
                HelpAct.class);
        TabSpec tabHelpAct = tabHost.newTabSpec("HelpAct")
                .setIndicator("Help", ressources.getDrawable(R.drawable.help))
                .setContent(tabHelpActTab);

//		Intent tabAboutUsActTab = new Intent().setClass(this,
//				AboutUsAct.class);
//		TabSpec tabAboutUsAct = tabHost.newTabSpec("AboutUsAct")
//				.setIndicator("AboutUs")// ressources.getDrawable(R.drawable.android_dark))
//				.setContent(tabAboutUsActTab);

//		Intent tabShareActTab = new Intent().setClass(this,
//				ShareAct.class);
//		TabSpec tabShareAct = tabHost.newTabSpec("ShareAct")
//				.setIndicator("Share")// ressources.getDrawable(R.drawable.android_dark))
//				.setContent(tabShareActTab);

        Intent tabFeedBackActTab = new Intent().setClass(this,
                FeedBackAct.class);
        TabSpec tabFeedBackAct = tabHost.newTabSpec("FeedBackAct")
                .setIndicator("Feedback", ressources.getDrawable(R.drawable.feed_back))
                .setContent(tabFeedBackActTab);


//		tabHost.setOnTabChangedListener(new OnTabChangeListener() {
//
//	        @SuppressLint("ResourceAsColor")
//			public void onTabChanged(String arg0) {
//	            for (int i = 0; i < tabHost.getTabWidget().getChildCount(); i++) {
//	            	tabHost.getTabWidget().getChildAt(i)
//	                        .setBackgroundColor(Color.BLUE);// unselected
//	            }
//	            tabHost.getTabWidget().getChildAt(tabHost.getCurrentTab())
//	                    .setBackgroundColor(Color.RED); // selected
//
//	        }
//	    });

        tabHost.addTab(tabHelpAct);
        tabHost.addTab(tabOtherAct);
//		tabHost.addTab(tabAboutUsAct);
        tabHost.addTab(tabFeedBackAct);


        tabHost.setCurrentTab(0);
    }
}
