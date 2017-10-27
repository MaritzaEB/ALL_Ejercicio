package com.example.asus_pc.todolist.modelo;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

/**
 * Created by Asus-pc on 05/09/2017.
 */

@Entity(tableName = "tareas")

public class Tarea {

    @PrimaryKey(autoGenerate = true)
    private int id;


    @ColumnInfo
    private String nombre;

    @ColumnInfo
    private boolean realizada;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Tarea(){



    }



    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public boolean isRealizada() {
        return realizada;
    }

    public void setRealizada(boolean realizada) {
        this.realizada = realizada;
    }



}
