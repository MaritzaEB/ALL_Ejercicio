package com.example.asus_pc.todolist.vista.presentas.presenters;

import com.example.asus_pc.todolist.vista.presentas.activities.ITestView;

/**
 * Created by Asus-pc on 26/10/2017.
 */

public class TestPresentas implements ITestPresentas{

    private ITestView view;

    public TestPresentas(ITestView view){
        this.view = view;
    }

    @Override
    public void cambiarMayusculaNombre(String nombre) {
        String nomMayuscula = nombre.toUpperCase();
        view.deshabilitarBoton();
        view.mostrarNombre(nomMayuscula);
    }
}
