package com.example.asus_pc.todolist.vista.presentas.Fragmentos;

/**
 * Created by Asus-pc on 26/10/2017.
 */

public interface IRegistroFragmentView {

    void habilitarControles();
    void deshabilitarControles();
    void mostrarProgress();
    void ocultarProgress();
    void registrar();
    void mostrarError(String error);
    void irALogin();
    void finalizarRegistro();
}
