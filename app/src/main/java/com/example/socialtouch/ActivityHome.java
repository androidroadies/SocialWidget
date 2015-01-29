package com.example.socialtouch;

import android.app.TabActivity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.provider.Settings;
import android.util.Log;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TabHost;
import android.widget.TabHost.TabSpec;

import com.example.socialwidget.R;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;

@SuppressWarnings("deprecation")
public class ActivityHome extends TabActivity {

    AdRequest request;
    AdView adView;
    LinearLayout llAd;
    private InterstitialAd interstitial;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        LoadAdd();
        loadInterstitial(null);
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

    public void LoadAdd() {
        llAd = (LinearLayout) findViewById(R.id.llAd);
        // adView = new AdView(this, AdSize.SMART_BANNER, "ca-app-pub-7940680036537699/3690981363");
        AdView adView = new AdView(this);
        adView.setAdUnitId(getString(R.string.banner_ad_unit_id));
        adView.setAdSize(AdSize.SMART_BANNER);
//            adView.setId(0x05607);
        FrameLayout.LayoutParams param = null;
        param = new FrameLayout.LayoutParams(FrameLayout.LayoutParams.MATCH_PARENT, FrameLayout.LayoutParams.WRAP_CONTENT);

        adView.setLayoutParams(param);
        adView.setBackgroundColor(getResources().getColor(android.R.color.black));
        llAd.addView(adView, param);
//        String deviceid = Secure.getString(getContentResolver(), Secure.ANDROID_ID);
        request = new AdRequest.Builder().build();
        // request.addTestDevice(deviceid);
        adView.loadAd(request);
    }


    void loadInterstitial(final Intent intent) {
        String deviceid = Settings.Secure.getString(getContentResolver(), Settings.Secure.ANDROID_ID);
        // request = new AdRequest.Builder().addTestDevice(deviceid).build();

        // Create ad request.
        AdRequest adRequest = new AdRequest.Builder().build();
        interstitial = new InterstitialAd(this);
        interstitial.setAdUnitId(getString(R.string.interstitial_ad_unit_id));
        // interstitial.loadAd(request);
        interstitial.setAdListener(new AdListener() {
            @Override
            public void onAdClosed() {
                Log.e("Ad", "Ad closed");
                super.onAdClosed();
                if (intent != null)
                    startActivity(intent);
//                finish();
            }

            @Override
            public void onAdFailedToLoad(int errorCode) {
                Log.e("Ad", "Ad Failed" + errorCode);
                super.onAdFailedToLoad(errorCode);
                if (intent != null)
                    startActivity(intent);
//                finish();
            }

            @Override
            public void onAdLoaded() {
                super.onAdLoaded();
                Log.e("Ad", "Ad loaded");
                interstitial.show();
            }
        });
        // Begin loading your interstitial.
        interstitial.loadAd(adRequest);
    }

    @Override
    public void onBackPressed() {
        loadInterstitial(null);
        super.onBackPressed();
    }
}
