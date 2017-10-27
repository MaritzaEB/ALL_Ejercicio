package com.example.asus_pc.todolist.vista.presentas.presenters;

import com.example.asus_pc.todolist.Dominio.CallBackInteractor;
import com.example.asus_pc.todolist.Dominio.ILUsuario;
import com.example.asus_pc.todolist.Dominio.LUsuario;
import com.example.asus_pc.todolist.vista.presentas.Fragmentos.IRecordarFragmentView;

/**
 * Created by Asus-pc on 26/10/2017.
 */

public class RecordarPresentas implements IRecordarPresentas{

    private IRecordarFragmentView view;
    private ILUsuario lUsuario;

    public RecordarPresentas(IRecordarFragmentView view) {
        this.view = view;
        lUsuario = new LUsuario();
    }

    @Override
    public void Recordar(String email) {
        view.deshabilitarVistas();
        view.irALogin();

        try {
            lUsuario.RecordarUser(email, new CallBackInteractor<String>() {
                @Override
                public void success(String data) {
                    view.habilitarVistas();

                }

                @Override
                public void error(String error) {
                    view.habilitarVistas();

                }
            });
        } catch (Exception e) {
            view.habilitarVistas();
            view.mostrarError(e.getMessage());
        }

    }


}
