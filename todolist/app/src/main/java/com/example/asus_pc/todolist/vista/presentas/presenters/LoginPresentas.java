package com.example.asus_pc.todolist.vista.presentas.presenters;

import com.example.asus_pc.todolist.Dominio.CallBackInteractor;
import com.example.asus_pc.todolist.Dominio.ILUsuario;
import com.example.asus_pc.todolist.Dominio.LUsuario;
import com.example.asus_pc.todolist.vista.presentas.Fragmentos.ILoginFrafmentView;

/**
 * Created by Asus-pc on 26/10/2017.
 */

public class LoginPresentas implements ILoginPresentas{


    private ILoginFrafmentView view;
    private ILUsuario lUsuario;

    public LoginPresentas(ILoginFrafmentView view) {
        this.view = view;
        lUsuario = new LUsuario();
    }

    @Override
    public void Registrarse(String email, String password) {
        view.deshabilitarVistas();
        view.mostrarProgress();

        try {
            lUsuario.authUsuario(email, password, new CallBackInteractor<String>() {
                @Override
                public void success(String data) {
                    view.habilitarVistas();
                    view.ocultarProgress();
                    view.finalizarLogin();
                    view.irARecordar();
                }

                @Override
                public void error(String error) {
                    view.habilitarVistas();
                    view.ocultarProgress();
                    view.mostrarError(error);
                }
            });
        } catch (Exception e) {
            view.habilitarVistas();
            view.ocultarProgress();
            view.mostrarError(e.getMessage());
        }
    }
}
