package com.example.asus_pc.todolist.Dominio;

import com.example.asus_pc.todolist.modelo.Usuario;

/**
 * Created by Asus-pc on 26/10/2017.
 */


public interface ILUsuario {

    void crearUsuario(String password, Usuario usuario,
                      CallBackInteractor<String> callBackInteractor);

    void authUsuario(String email, String password,
                     CallBackInteractor<String> callBackInteractor);
    void RecordarUser(String email,
                      CallBackInteractor<String> callBackInteractor);

}
