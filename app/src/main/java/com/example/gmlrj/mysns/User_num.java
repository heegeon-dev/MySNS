package com.example.gmlrj.mysns;

import android.app.Application;

/**
 * Created by gmlrj on 2017-11-28.
 */

public class User_num extends Application {
    private static int user_num;
    public void onCreate() {
        //전역 변수 초기화
        user_num = 0;
        super.onCreate();
    }

    @Override
    public void onTerminate() {
        super.onTerminate();
    }

    public void setState(int user_num){
        this.user_num = user_num;
    }

    public int getState(){
        return user_num;
    }
}
