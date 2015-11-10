package com.magneticsource.msource.ingreso;


import android.content.Context;
import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.widget.Toast;

import com.magneticsource.msource.R;
import com.magneticsource.msource.conexion.UsuarioCliente;
import com.magneticsource.msource.control.Validador;
import com.magneticsource.msource.conexion.Conexion;

/**
 * Created by JeanManuel on 04/11/2015.
 */
public class Login {
    private Context context;
    private ProgressDialog dialog;

    private class AsyncIniciarSesion extends AsyncTask<String, Void, Boolean> {
        //private Context context;
        private String password;
        private String username;

        public AsyncIniciarSesion(String user, String pass/*, Context context*/) {
            username = user;
            password = pass;
            //this.context =context;
        }


        @Override
        protected Boolean doInBackground(String... params) {
            return UsuarioCliente.verificarDatos(username, password);
        }

        @Override
        protected void onPostExecute(Boolean inicioSesion) {
            if (inicioSesion == null) {
                /*Toast.makeText(context,
                        R.string.error_service, Toast.LENGTH_SHORT)
                        .show();*/
            } else {
                if (inicioSesion) {
                    /*SharedPreferences.Editor editor = context.getSharedPreferences(Datos.MyPREFERENCES, Context.MODE_PRIVATE).edit();
                    editor.putString(Datos.USUARIO, username);
                    editor.commit();
                    Toast.makeText(context,
                            R.string.bienvenido, Toast.LENGTH_LONG)
                            .show();*/
                } /*else
                    Toast.makeText(context,
                            R.string.error_sesion,
                            Toast.LENGTH_SHORT).show();*/
            }
            //progress.dismiss();

        }

        @Override
        protected void onPreExecute() {
            if (username.length() <= 0) {
                /*Toast.makeText(context, R.string.error_sesion,
                        Toast.LENGTH_SHORT).show();*/
                cancel(true);
            }

        }

        @Override
        protected void onCancelled() {
            //progress.dismiss();
        }
    }

    public Login(ProgressDialog dialog){
        this.dialog =dialog;
        this.context = dialog.getContext();
    }

    public void iniciarSesion(String dni, String clave)
    {
        if(verificarDatos(dni,clave)){
            Conexion  c =new Conexion(context);
            if(c.verificarConexionInternet()){
                IniciarSesionTask iniciar =new IniciarSesionTask(dialog, dni, clave);
                iniciar.execute();
            } else {
                c.showError();
            }

        }
    }

    private boolean verificarDatos(String dni, String clave){
        if(!Validador.validarDni(dni)){
            Toast.makeText(context, R.string.error_dni, Toast.LENGTH_SHORT).show();
            return false;
        }

        if(!Validador.validarClave(clave)){
            Toast.makeText(context, R.string.error_clave, Toast.LENGTH_SHORT).show();
            return false;
        }

        return true;
    }

    public void cerrarSesion(){

    }


}
