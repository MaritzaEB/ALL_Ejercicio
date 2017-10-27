package com.example.asus_pc.todolist.vista.presentas.activities;

import android.content.Intent;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.asus_pc.todolist.R;
import com.example.asus_pc.todolist.vista.presentas.Fragmentos.LoginFragments;
import com.example.asus_pc.todolist.vista.presentas.Fragmentos.RecordarFragment;
import com.example.asus_pc.todolist.vista.presentas.Fragmentos.RegistroFragment;
import com.example.asus_pc.todolist.vista.presentas.presenters.RecordarPresentas;


public class AuthActivity extends AppCompatActivity implements LoginFragments.OnLoginFragmentInteraction,
        RegistroFragment.OnRegistroInteractionListener, RecordarFragment.OnrecordarFragmentInteraction{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auth);

        initFragment();


    }

    private void initFragment() {

        FragmentTransaction transaction=getSupportFragmentManager().beginTransaction();


        transaction.replace(R.id.frameAuthActivity, LoginFragments.newInstance());
        transaction.commit();
    }


    @Override
    public void finalizarRegistro() {
        Intent intent = new Intent(this, ListActivity.class);
        startActivity(intent);
        finish();
    }

    @Override
    public void finalizarLogin() {
        Intent intent = new Intent(this, ListActivity.class);
        startActivity(intent);
        finish();
    }

    @Override
    public void irARegistro() {
        FragmentTransaction transaction =
                getSupportFragmentManager().beginTransaction();

        transaction.replace(R.id.frameAuthActivity, RegistroFragment.newInstance());
        transaction.commit();
    }

    @Override
    public void irARecordar() {
        FragmentTransaction transaction =
                getSupportFragmentManager().beginTransaction();

        transaction.replace(R.id.frameAuthActivity, RecordarFragment.newInstance());
        transaction.commit();
    }

    @Override
    public void irALogin() {
        FragmentTransaction transaction =
                getSupportFragmentManager().beginTransaction();

        transaction.replace(R.id.frameAuthActivity, LoginFragments.newInstance());
        transaction.commit();
    }
}
