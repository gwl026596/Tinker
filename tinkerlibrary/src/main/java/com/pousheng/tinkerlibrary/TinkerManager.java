package com.pousheng.tinkerlibrary;

import android.content.Context;

import com.tencent.tinker.entry.ApplicationLike;
import com.tencent.tinker.lib.tinker.Tinker;
import com.tencent.tinker.lib.tinker.TinkerInstaller;

public class TinkerManager {

    private static boolean isInstalled=false;//是否安装过tinker
    private static ApplicationLike mAppLike;//

    /**
     * Tinker初始化
     *
     * @param applicationLike
     */
    public static void init(ApplicationLike applicationLike){
        mAppLike=applicationLike;
        if (isInstalled){
            return;
        }
        TinkerInstaller.install(mAppLike);
        isInstalled=true;
    }

    //Patch的加载
    public static  void  load(String path){
        if (Tinker.isTinkerInstalled()){
            TinkerInstaller.onReceiveUpgradePatch(getContext(),path);
        }
    }

    private static Context getContext(){
        if (mAppLike!=null){
            return mAppLike.getApplication().getApplicationContext();
        }
        return null;
    }
}
