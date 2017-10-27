package com.example.asus_pc.todolist.repository;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.example.asus_pc.todolist.modelo.Tarea;

import java.util.List;

/**
 * Created by Asus-pc on 03/10/2017.
 */

@Dao
public interface TareaDao {

    @Insert
    public  void insert(Tarea... tareas);

    @Update
    void update(Tarea... tareas);

    @Delete
    void delete(Tarea... tarea);

    @Query("select*from tareas")
    List<Tarea> obtenerTodos();

    @Query("Select * from tareas where id = :id")
    Tarea obtenerXID(int id);


}
