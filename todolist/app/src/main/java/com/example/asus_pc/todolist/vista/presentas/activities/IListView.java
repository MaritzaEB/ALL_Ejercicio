package com.example.asus_pc.todolist.vista.presentas.activities;

import com.example.asus_pc.todolist.modelo.Tarea;

import java.util.List;

/**
 * Created by Asus-pc on 12/09/2017.
 * Patron Modelo vista Controlador
 */

public interface IListView {


    void clickAddTarea();

    void refrescarListaTareas(List<Tarea> lstTarea);

    void refrescarTarea(Tarea tarea, int Posicion);

}
