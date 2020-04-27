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
    private EditText etPassword;
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
        this.etPassword = getView().findViewById(R.id.etLoginPassword);
        this.btnEntrar = getView().findViewById(R.id.relativeLoginBoton);
        this.btnRegistro = getView().findViewById(R.id.relativeRegistroBoton);
        this.btnEntrar.setOnClickListener(listener);
        this.btnRegistro.setOnClickListener(listener);

    }


    private View.OnClickListener listener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            switch (view.getId()){

                case R.id.relativeLoginBoton:
                    evtBotonLogin();
                    break;
                case R.id.relativeRegistroBoton:
                    lanzarAviso("Registro");
                    break;
                default:
                    break;
            }
        }
    };

    private void evtBotonLogin(){
        String mensaje;
        if(comprobarCampos()){
            mensaje = "Login";
        }else{
            mensaje = "Debes rellenar los campos";
        }
        lanzarAviso(mensaje);
    }

    private boolean comprobarCampos(){
        boolean correcto = true;
        if (etNombre.getText().toString().isEmpty() || etPassword.getText().toString().isEmpty()){
            correcto = false;
        }
        return correcto;
    }

    private void lanzarAviso(String mensaje){
        Toast.makeText(getContext(), mensaje, Toast.LENGTH_LONG).show();
    }

}
