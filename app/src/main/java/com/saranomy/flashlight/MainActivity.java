package com.saranomy.flashlight;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;

public class MainActivity extends Activity {
    private View a;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.m);
        WindowManager.LayoutParams l = getWindow().getAttributes();
        l.screenBrightness = 1;
        getWindow().setAttributes(l);

        a = findViewById(R.id.m);
        a.setOnClickListener(v -> {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT)
                h();
        });
        findViewById(R.id.r)
                .setOnClickListener(v -> {
                    try {
                        startActivity(new Intent(Intent.ACTION_VIEW).setData(Uri
                                .parse("market://details?id=com.saranomy.flashlight")));
                    } catch (ActivityNotFoundException anfe) {
                        startActivity(new Intent(Intent.ACTION_VIEW).setData(Uri
                                .parse("http://play.google.com/store/apps/details?id=com.saranomy.flashlight")));
                    }
                });
    }

    @Override
    public void onWindowFocusChanged(boolean h) {
        super.onWindowFocusChanged(h);
        if (h && Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT)
            s();
    }

    @TargetApi(Build.VERSION_CODES.KITKAT)
    public void h() {
        a.setSystemUiVisibility(View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
                | View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_FULLSCREEN
                | View.SYSTEM_UI_FLAG_IMMERSIVE);
    }

    @TargetApi(Build.VERSION_CODES.KITKAT)
    public void s() {
        a.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                | View.SYSTEM_UI_FLAG_FULLSCREEN
                | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);
    }
}
