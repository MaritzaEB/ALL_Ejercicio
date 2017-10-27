package com.example.asus_pc.todolist.Dominio;

import com.example.asus_pc.todolist.modelo.Tarea;

import java.util.List;

/**
 * Created by Asus-pc on 12/09/2017.
 */

public interface ILtarea {


    void addTarea(Tarea tarea);

    List<Tarea> getTareas();
    void actualizar (Tarea...tareas);
    Tarea obtenerXID(int id);




}
