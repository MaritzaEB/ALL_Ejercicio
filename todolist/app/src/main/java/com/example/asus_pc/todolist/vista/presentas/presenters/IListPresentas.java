package com.example.asus_pc.todolist.vista.presentas.presenters;

import com.example.asus_pc.todolist.modelo.Tarea;

import java.util.List;

/**
 * Created by Asus-pc on 12/09/2017.
 */

public interface IListPresentas {

    void addTarea(String descTarea);


    List<Tarea> obtenerTareas();

    void itemCambioEstado(int Posicion, boolean realizado);

}
