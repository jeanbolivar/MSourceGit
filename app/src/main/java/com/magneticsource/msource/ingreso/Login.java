package com.magneticsource.msource.ingreso;


import android.content.Context;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.widget.Toast;

import com.magneticsource.msource.R;
import com.magneticsource.msource.conexion.UserClient;
import com.magneticsource.msource.control.Data;
import com.magneticsource.msource.control.Persona;

import java.util.List;

/**
 * Created by JeanManuel on 04/11/2015.
 */
public class Login {

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
            return UserClient.sesionValida(username, password);
        }

        @Override
        protected void onPostExecute(Boolean inicioSesion) {
            if (inicioSesion == null) {
                /*Toast.makeText(context,
                        R.string.error_service, Toast.LENGTH_SHORT)
                        .show();*/
            } else {
                if (inicioSesion) {
                    /*SharedPreferences.Editor editor = context.getSharedPreferences(Data.MyPREFERENCES, Context.MODE_PRIVATE).edit();
                    editor.putString(Data.usuario, username);
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

    public Login(){}
    public Persona iniciarSesion(String dni, String clave)
    {
        AsyncIniciarSesion s = new AsyncIniciarSesion(dni,clave);
        return new Persona(dni, "","","","");
    }


}
