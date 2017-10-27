package com.example.asus_pc.todolist.vista.presentas.Fragmentos;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;

import com.example.asus_pc.todolist.R;
import com.example.asus_pc.todolist.vista.presentas.presenters.ILoginPresentas;
import com.example.asus_pc.todolist.vista.presentas.presenters.IRecordarPresentas;
import com.example.asus_pc.todolist.vista.presentas.presenters.LoginPresentas;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginFragments extends Fragment implements ILoginFrafmentView {


    @BindView(R.id.txtEmailLogin)
    EditText txtEmail;

    @BindView(R.id.txtPasswordLogin)
    EditText txtPasswoord;

    @BindView(R.id.progress)
    ProgressBar progress;

    @BindView(R.id.btnIngresarLogin)
    Button btnIngresarLogin;

    @BindView(R.id.btnCrearCuenta)
    Button btnCrearCuenta;


    FirebaseAuth firebaseAuth;

    private ILoginPresentas loginPresentas;
    private IRecordarPresentas recordarPresenter;


    private OnLoginFragmentInteraction mListener;

    public LoginFragments() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     */

    public static LoginFragments newInstance() {
        LoginFragments fragment = new LoginFragments();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_login_fragments, container, false);
        ButterKnife.bind(this, view);

        loginPresentas = new LoginPresentas(this);

        return view;
    }

    @OnClick(R.id.btnIngresarLogin)
    public void login(){

        final String Correo = txtEmail.getText().toString();
        String Contra = txtPasswoord.getText().toString();

        loginPresentas.Registrarse(Correo,Contra);

    }

    @OnClick(R.id.txtRecordarContrasena)
    public void recordar(){
        mListener.irARecordar();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnLoginFragmentInteraction) {
            mListener = (OnLoginFragmentInteraction) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    @Override
    public void habilitarVistas() {
        txtPasswoord.setEnabled(true);
        txtEmail.setEnabled(true);
        btnIngresarLogin.setEnabled(true);
        btnCrearCuenta.setEnabled(true);
    }

    @Override
    public void deshabilitarVistas() {
        txtPasswoord.setEnabled(false);
        txtEmail.setEnabled(false);
        btnIngresarLogin.setEnabled(false);
        btnCrearCuenta.setEnabled(false);
    }


    @Override
    public void mostrarProgress() {
        progress.setVisibility(View.VISIBLE);
    }

    @Override
    public void ocultarProgress() {
        progress.setVisibility(View.GONE);
    }

    @OnClick(R.id.btnCrearCuenta)
    @Override
    public void irARegistro() {
        if (mListener != null) {
            mListener.irARegistro();
        }
    }
    @OnClick(R.id.txtRecordarContrasena)
    @Override
    public void irARecordar() {
        if (mListener != null) {
            mListener.irARecordar();
        }
    }

    @Override
    public void finalizarLogin() {
        if (mListener != null) {
            mListener.finalizarLogin();
        }
    }

    @Override
    public void mostrarError(String mensaje) {
        Snackbar.make(getView(), mensaje, Snackbar.LENGTH_LONG).show();
    }



    public interface OnLoginFragmentInteraction {

        void finalizarLogin();

        void irARegistro();

        void irARecordar();
         void irALogin();
    }

  }
