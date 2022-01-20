package com.ks.testepmedia;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.Field;

import VideoHandle.EpEditor;
import VideoHandle.EpVideo;
import VideoHandle.OnEditorListener;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void openCamera(View view) {
        EpVideo epVideo = new EpVideo(App.video);
//输出选项，参数为输出文件路径(目前仅支持mp4格式输出)
        EpEditor.OutputOption outputOption = new EpEditor.OutputOption(App._video);
        outputOption.setWidth(480);//输出视频宽，如果不设置则为原始视频宽高
        outputOption.setHeight(360);//输出视频高度
        outputOption.frameRate = 30;//输出视频帧率,默认30
        outputOption.bitRate = 10;//输出视频码率,默认10
        EpEditor.exec(epVideo, outputOption, new OnEditorListener() {
            @Override
            public void onSuccess() {
                Log.e(MainActivity.class.getSimpleName(), "成功");
            }

            @Override
            public void onFailure() {
                Log.e(MainActivity.class.getSimpleName(), "失败");
            }

            @Override
            public void onProgress(float progress) {
                Log.e(MainActivity.class.getSimpleName(), "正在执行：" + progress);
            }
        });
    }
}