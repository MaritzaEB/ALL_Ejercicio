package com.example.asus_pc.todolist.vista.presentas.adaptadores;

import android.graphics.Paint;
import android.support.v7.widget.AppCompatCheckBox;
import android.support.v7.widget.RecyclerView;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;

import com.example.asus_pc.todolist.R;
import com.example.asus_pc.todolist.modelo.Tarea;

import java.util.List;

/**
 * el primer @override trae o es contatenado con xlm.
 * Created by Asus-pc on 12/09/2017.
 */

public class TodoListAdaptador extends RecyclerView.Adapter<TodoListAdaptador.ItemTodoList>{

    private List<Tarea>dataset;
    private OnListenerItemCheck onListernerItemCheck;


    public TodoListAdaptador(List<Tarea> dataset, OnListenerItemCheck onListenerItemCheck){
        super();
        this.dataset=dataset;
        this.onListernerItemCheck =  onListenerItemCheck;
    }

    @Override
    public ItemTodoList onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list,parent,false);

        return new ItemTodoList(view);
    }

    @Override
    public void onBindViewHolder(ItemTodoList holder, int position) {

        Tarea tarea = dataset.get(position);

        if (tarea.isRealizada()){
            holder.tvTarea.setPaintFlags(holder.tvTarea.getPaintFlags()
            | Paint.STRIKE_THRU_TEXT_FLAG);
        }
        else{
            holder.tvTarea.setPaintFlags(holder.tvTarea.getPaintFlags()
                    & ~Paint.STRIKE_THRU_TEXT_FLAG);
        }


        holder.tvTarea.setText(tarea.getNombre());
        holder.chkTarea.setChecked(tarea.isRealizada());

    }

    public void setDataset(List<Tarea>dataset){
        this.dataset=dataset;
    }

    public void setItemDataset(Tarea tarea, int index){
        this.dataset.set(index,tarea);
    }


    @Override
    public int getItemCount() {
        return dataset.size();
    }

    public class ItemTodoList extends RecyclerView.ViewHolder{

        @BindView(R.id.chkTarea)
        AppCompatCheckBox chkTarea;

        @BindView(R.id.tvTarea)
        TextView tvTarea;

        public ItemTodoList(View itemView){
            super(itemView);

            ButterKnife.bind(this, itemView);
         //   chkTarea = (AppCompatCheckBox) itemView.findViewById(R.id.chkTarea);
          //  tvTarea= (TextView) itemView.findViewById(R.id.tvTarea);

            if(onListernerItemCheck!=null){
                chkTarea.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        onListernerItemCheck.itemCambioEstado(getAdapterPosition(),chkTarea.isChecked());
                    }
                });
            }



        }

    }

    public interface OnListenerItemCheck{

        void itemCambioEstado(int Posicion, boolean realizada);



    }

}
