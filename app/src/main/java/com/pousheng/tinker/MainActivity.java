package com.pousheng.tinker;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.pousheng.tinkerlibrary.TinkerManager;

import java.io.File;

public class MainActivity extends AppCompatActivity {

    private static final String END_FILE=".apk";
    private String mPath;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        initView();

    }

    private void initView() {
       TextView tvHotFix= findViewById(R.id.tvHotFix);
       TextView name= findViewById(R.id.name);
        tvHotFix.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TinkerManager.load(mPath.concat("pousheng").concat(END_FILE));
            }
        });
        name.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this,"有没有修复吗？？？",Toast.LENGTH_LONG).show();
            }
        });
    }

    private void init() {
        mPath=getExternalCacheDir().getAbsolutePath()+"/apatch/";
        File file=new File(mPath);
        if (file==null||!file.exists()){
            file.mkdir();
        }
        Log.d("很低调",mPath);
        Log.d("很低调11", Environment.getExternalStorageDirectory().getAbsolutePath());
    }
}