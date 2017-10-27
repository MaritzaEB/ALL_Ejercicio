package com.example.asus_pc.todolist.app;

import android.app.Application;

import com.example.asus_pc.todolist.repository.AppDB;

/**
 * Created by Asus-pc on 03/10/2017.
 */

public class ApplicationTODO extends Application{

    @Override
    public void onCreate(){
        super.onCreate();
        AppDB.init(getApplicationContext());
    }
}
