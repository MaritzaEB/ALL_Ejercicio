package com.example.asus_pc.todolist.Dominio;

/**
 * Created by Asus-pc on 26/10/2017.
 */

public interface CallBackInteractor<T> {

    void success (T data);

    void error (String error);
}
