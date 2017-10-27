package com.example.asus_pc.todolist.vista.presentas.Fragmentos;

/**
 * Created by Asus-pc on 26/10/2017.
 */

public interface IRecordarFragmentView {
    void habilitarVistas();
    void deshabilitarVistas();
    void recordar();
    void irALogin();
    void mostrarError(String mensaje);
}
