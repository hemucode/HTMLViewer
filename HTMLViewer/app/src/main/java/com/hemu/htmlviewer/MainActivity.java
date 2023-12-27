package com.hemu.htmlviewer;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.hemu.htmlviewer.models.InAppUpdate;

public class MainActivity extends AppCompatActivity {
    private InAppUpdate inAppUpdate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inAppUpdate = new InAppUpdate(MainActivity.this);
        inAppUpdate.checkForAppUpdate();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        inAppUpdate.onActivityResult(requestCode, resultCode);
    }

    @Override
    protected void onResume() {
        super.onResume();
        inAppUpdate.onResume();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        inAppUpdate.onDestroy();
    }
}