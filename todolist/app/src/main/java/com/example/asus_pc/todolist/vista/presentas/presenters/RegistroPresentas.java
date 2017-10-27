package com.example.asus_pc.todolist.vista.presentas.presenters;

import com.example.asus_pc.todolist.Dominio.CallBackInteractor;
import com.example.asus_pc.todolist.Dominio.ILUsuario;
import com.example.asus_pc.todolist.Dominio.LUsuario;
import com.example.asus_pc.todolist.modelo.Usuario;
import com.example.asus_pc.todolist.vista.presentas.Fragmentos.IRegistroFragmentView;
import com.example.asus_pc.todolist.vista.presentas.Fragmentos.RegistroFragment;

/**
 * Created by Asus-pc on 26/10/2017.
 */

public class RegistroPresentas implements IRegistroPresentas{


    private IRegistroFragmentView view;
    private ILUsuario lUsuario;

    public RegistroPresentas(IRegistroFragmentView view) {
        this.view = view;
        lUsuario = new LUsuario();
    }



    @Override
    public void registrar(String nombres, String email,
                          String password) {

        view.deshabilitarControles();
        view.mostrarProgress();

        try {
            Usuario usuario = new Usuario();
            usuario.setEmail(email);
            usuario.setNombres(nombres);

            lUsuario.crearUsuario(password, usuario, new CallBackInteractor<String>() {
                @Override
                public void success(String data) {
                    view.habilitarControles();
                    view.ocultarProgress();
                    view.finalizarRegistro();
                }

                @Override
                public void error(String error) {
                    view.habilitarControles();
                    view.ocultarProgress();
                    view.mostrarError(error);
                }
            });


        } catch (Exception e) {
            view.habilitarControles();
            view.ocultarProgress();
            view.mostrarError(e.getMessage());
        }

    }
}
