package com.hemu.htmlviewer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.widget.TextView;

public class LoadingActivity extends AppCompatActivity {

    Handler handler;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loading);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        textView = findViewById(R.id.textView2);

        PackageManager manager = this.getPackageManager();

        try {
            PackageInfo info = manager.getPackageInfo(this.getPackageName(),PackageManager.GET_ACTIVITIES);
            String versionName = info.versionName;
            textView.setText(versionName);

        } catch (PackageManager.NameNotFoundException e) {
            throw new RuntimeException(e);
        }


        handler = new Handler();

        handler.postDelayed(()->{
            LoadingActivity.this.startActivity(new Intent(LoadingActivity.this, MainActivity.class));
            finish();
        },2000);


    }
}