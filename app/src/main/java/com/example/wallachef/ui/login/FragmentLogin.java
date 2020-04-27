package com.example.wallachef.ui.login;



import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.example.wallachef.R;

public class FragmentLogin extends Fragment {

    private EditText etNombre;
    private EditText etpassword;
    private RelativeLayout btnEntrar;
    private RelativeLayout btnRegistro;

    public static FragmentLogin newInstance() {
        return new FragmentLogin();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_login_fragment, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        llamarVistas();

    }

    private void llamarVistas(){
        this.etNombre = getView().findViewById(R.id.etLoginNombre);
        this.etpassword = getView().findViewById(R.id.etLoginPassword);
        this.btnEntrar = getView().findViewById(R.id.relativeLoginBoton);
        this.btnRegistro = getView().findViewById(R.id.relativeRegistroBoton);
        this.btnEntrar.setOnClickListener(listener);
        this.btnRegistro.setOnClickListener(listener);

    }


    public View.OnClickListener listener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            switch (view.getId()){

                case R.id.relativeLoginBoton:
                    Toast.makeText(getContext(), "Calvo", Toast.LENGTH_LONG).show();
                    break;
                case R.id.relativeRegistroBoton:
                    Toast.makeText(getContext(), "Registro", Toast.LENGTH_LONG).show();
                    break;
                default:
                    break;

            }
        }
    };

}
