package com.intenttest.intentlunachmodetest;

import android.app.Activity;
import android.app.Application;

import java.util.ArrayList;
import java.util.List;

/******************************************************************
 * Java Lib For Android, Powered By Shenzhen Jiuzhou.
 * <p/>
 * Copyright (c) 2001-2014 Digital Telemedia Co.,Ltd
 * http://www.d-telemedia.com/
 * <p/>
 * Package:     com.intenttest.intentlunachmodetest
 * <p/>
 * 项目名称：IntentLunachModeTest
 * <p/>
 * Description: ${TODO}(用一句话描述该文件做什么)
 * <p/>
 * Copyright:   Copyright (c) 2001-2014
 * <p/>
 * Company:     Digital Telemedia Co.,Ltd
 *
 * @author: zhao
 * @version: 1.0.0
 * <p/>
 * Create at:   2017/2/20 10:06
 * <p/>
 * Revision:
 * <p/>
 * 2017/2/20 10:06
 * - first revision
 *****************************************************************/
public class MyApplication extends Application{
   private static volatile MyApplication myApplication;
    private  List<Activity> activities=new ArrayList<>();

    private MyApplication() {
    }


    public static MyApplication getInstance(){
        if(myApplication==null){
            synchronized (MyApplication.class){
                if(myApplication==null){
                    myApplication=new MyApplication();
                }
            }
        }
        return myApplication;
    }

    public  void setActivity(Activity activity){
        activities.add(activity);
    }

    public void appFinish(){
        for(Activity activity:activities){
            activity.finish();
        }
        System.exit(0);
    }


}
