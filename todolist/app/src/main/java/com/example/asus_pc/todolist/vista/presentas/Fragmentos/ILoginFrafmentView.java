package com.example.asus_pc.todolist.vista.presentas.Fragmentos;

/**
 * Created by Asus-pc on 26/10/2017.
 */

public interface ILoginFrafmentView {
    void habilitarVistas();
    void deshabilitarVistas();
    void mostrarProgress();
    void ocultarProgress();
    void login();
    void irARegistro();
    void irARecordar();
    void finalizarLogin();
    void mostrarError(String mensaje);
}
