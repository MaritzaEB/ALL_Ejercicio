package com.example.asus_pc.todolist.vista.presentas.Fragmentos;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.asus_pc.todolist.R;
import com.example.asus_pc.todolist.vista.presentas.presenters.IRecordarPresentas;
import com.example.asus_pc.todolist.vista.presentas.presenters.RecordarPresentas;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class RecordarFragment extends Fragment implements IRecordarFragmentView {

    @BindView(R.id.txtEmailRecordar)
    EditText txtEmailRecordar;
    @BindView(R.id.btnRecordarContraseña)
    Button btnRecordarContrasena;

    private IRecordarPresentas iRecordarPresentas;

    private OnrecordarFragmentInteraction Listener;

    public RecordarFragment() {
        // Required empty public constructor
    }

    public static RecordarFragment newInstance() {
        RecordarFragment fragment = new RecordarFragment();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_recordar, container, false);
        ButterKnife.bind(this, view);

        iRecordarPresentas = new RecordarPresentas(this);

        return view;
    }

    @OnClick(R.id.btnRecordarContraseña)
    public void recordar() {
        String email = txtEmailRecordar.getText().toString();
        iRecordarPresentas.Recordar(email);
    }

    @Override
    public void irALogin() {
        if (Listener != null) {
            Listener.irALogin();
        }
    }


    @Override
    public void habilitarVistas() {
        txtEmailRecordar.setEnabled(true);
        btnRecordarContrasena.setEnabled(true);
    }

    @Override
    public void deshabilitarVistas() {
        txtEmailRecordar.setEnabled(false);
        btnRecordarContrasena.setEnabled(false);
    }

    @Override
    public void mostrarError(String mensaje) {
        Snackbar.make(getView(), mensaje, Snackbar.LENGTH_LONG).show();
    }

    public interface OnrecordarFragmentInteraction {
        void irALogin();

    }
}


