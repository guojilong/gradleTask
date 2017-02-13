package com.gradletask;

import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ((TextView)findViewById(R.id.text)).setText(BuildConfig.SERVER_CFG+"");

        StringBuilder verisonBuilder=new StringBuilder();
        PackageManager packageManager=getPackageManager();
        try {
            PackageInfo packageInfo=packageManager.getPackageInfo(getApplication().getPackageName(),0);
            verisonBuilder.append("versionName :").append(packageInfo.versionName).append("\n")
                    .append("versionCode :").append(packageInfo.versionCode);
            ((TextView)findViewById(R.id.version)).setText(verisonBuilder.toString()+"");
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }

    }
}
