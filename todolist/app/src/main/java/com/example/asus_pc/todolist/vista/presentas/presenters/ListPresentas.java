package com.example.asus_pc.todolist.vista.presentas.presenters;

import com.example.asus_pc.todolist.Dominio.ILtarea;
import com.example.asus_pc.todolist.Dominio.LTarea;
import com.example.asus_pc.todolist.vista.presentas.activities.IListView;
import com.example.asus_pc.todolist.modelo.Tarea;
import com.example.asus_pc.todolist.vista.presentas.presenters.IListPresentas;

import java.util.List;

/**
 * Created by Asus-pc on 12/09/2017.
 */

public class ListPresentas implements IListPresentas {

    private IListView view;
    private ILtarea ltarea;

    public ListPresentas(IListView view)
    {

        this.view=view;
        ltarea=new LTarea();
    }


    @Override
    public void addTarea(String descTarea) {
        Tarea objTarea= new Tarea();
        objTarea.setNombre(descTarea);
        objTarea.setRealizada(false);

        ltarea.addTarea(objTarea);

        view.refrescarListaTareas(ltarea.getTareas());
    }

    @Override
    public List<Tarea> obtenerTareas() {
        return ltarea.getTareas();


    }

    @Override
    public void itemCambioEstado(int Posicion, boolean realizado) {
        Tarea tarea = ltarea.obtenerXID(Posicion+1);
        tarea.setRealizada(realizado);
        ltarea.actualizar(tarea);

       // ltarea.getTareas().get(Posicion).setRealizada(realizado);
        view.refrescarTarea(tarea,Posicion);

    }
}
