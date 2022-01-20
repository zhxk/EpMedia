package com.ks.testepmedia;

import android.app.Application;
import android.content.Context;

public class App extends Application {
    public static Context sApplication;

    private static String sdPath = FileUtils.getSDPath() + "/videoEdit";
    public static String imagePath = sdPath + "/imagePath/";//选中的表情目录
    public static String musicPath = sdPath + "/musicPath/";//选中的音频目录
    public static String videoPath = sdPath + "/videoPath/"; //输出的视频目录
    public static String videoPathCache = sdPath + "/videoPath/cache/"; //输出的视频目录
    public static String videoInput = FileUtils.getSDPath() + "/DCIM/Camera/inputCamera.mp4"; //相机录入的视频目录
    public static String video = videoPath + "out.mp4"; //输出的视频目录
    public static String _video = videoPath + "music_out.mp4"; //输出的视频目录
    public static String image = imagePath + "merge.png"; //合成的图片

    @Override
    public void onCreate() {
        super.onCreate();
        sApplication = getApplicationContext();

    }

    public static void setsApplication(Context sApplication) {
        App.sApplication = sApplication.getApplicationContext();
    }
}
