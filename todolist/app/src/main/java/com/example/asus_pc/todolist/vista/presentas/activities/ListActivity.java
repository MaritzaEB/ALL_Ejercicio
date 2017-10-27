package com.example.asus_pc.todolist.vista.presentas.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.EditText;

import com.example.asus_pc.todolist.R;
import com.example.asus_pc.todolist.modelo.Tarea;
import com.example.asus_pc.todolist.vista.presentas.presenters.IListPresentas;
import com.example.asus_pc.todolist.vista.presentas.presenters.ListPresentas;
import com.example.asus_pc.todolist.vista.presentas.adaptadores.TodoListAdaptador;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Asus-pc on 26/10/2017.
 */

public class ListActivity extends AppCompatActivity implements IListView, TodoListAdaptador.OnListenerItemCheck{

    private IListPresentas listPresentas;
    private TodoListAdaptador adaptador;

    @BindView(R.id.rvListTODO)
    RecyclerView rvListTODO;

    @BindView(R.id.txtTarea)
    EditText txtTarea;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        ButterKnife.bind(this);

        listPresentas = new ListPresentas(this);

        LinearLayoutManager llm=new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);

        rvListTODO.setLayoutManager(llm);

        List<Tarea> lsTarea=listPresentas.obtenerTareas();

        adaptador = new TodoListAdaptador(lsTarea, this);



        rvListTODO.setAdapter(adaptador);



    }


    @OnClick(R.id.btnEnviarTarea)


    @Override
    public void clickAddTarea() {
        String descTarea = txtTarea.getText().toString();
        listPresentas.addTarea(descTarea);

    }

    @Override
    public void refrescarListaTareas(List<Tarea> lstTareas) {
        adaptador.setDataset(lstTareas);
        rvListTODO.getAdapter().notifyDataSetChanged();

        rvListTODO.scrollToPosition(rvListTODO.getAdapter().getItemCount()-1);

        txtTarea.setText("");

    }

    @Override
    public void refrescarTarea( Tarea tarea, int Posicion) {
        adaptador.setItemDataset(tarea,Posicion);
        rvListTODO.getAdapter().notifyItemChanged(Posicion);

    }

    @Override
    public void itemCambioEstado(int Posicion, boolean realizada) {
        listPresentas.itemCambioEstado(Posicion,realizada);

    }
}
