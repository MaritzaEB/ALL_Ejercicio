package com.example.asus_pc.todolist.Dominio;

/**
 * Created by Asus-pc on 05/09/2017.
 */

import com.example.asus_pc.todolist.modelo.Tarea;
import com.example.asus_pc.todolist.repository.AppDB;

import java.util.ArrayList;
import java.util.List;


public class LTarea implements ILtarea{

   // public static List<Tarea> lstTarea = new ArrayList<>();
    private AppDB database;

    public LTarea(){
        database = AppDB.getInstancia();
    }


    @Override
    public void addTarea(Tarea tarea){
        database.getTareaDao().insert(tarea);
    }

    @Override
    public List<Tarea>getTareas(){
        return database.getTareaDao().obtenerTodos();
    }

    @Override
    public void actualizar(Tarea... tareas) {
        database.getTareaDao().update(tareas);

    }

    @Override
    public Tarea obtenerXID(int id) {
        return database.getTareaDao().obtenerXID(id);
    }
}


