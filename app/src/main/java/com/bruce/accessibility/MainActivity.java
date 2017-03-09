package com.bruce.accessibility;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onStart() {
        super.onStart();
        checkAccessibilityService();
    }

    public void checkAccessibilityService() {
        if (MonitorAccessibilityService.getInstance() == null) {
            new AlertDialog.Builder(this)
                    .setMessage(R.string.dialog_enable_accessibility_msg)
                    .setPositiveButton(R.string.dialog_enable_accessibility_positive_btn
                            , new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    Intent intent = new Intent();
                                    intent.setAction("android.settings.ACCESSIBILITY_SETTINGS");
                                    startActivity(intent);
                                }
                            })
                    .setNegativeButton(android.R.string.cancel
                            , new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {

                                }
                            })
                    .create()
                    .show();
        }
    }
}
