package com.magneticsource.msource.ingreso;


import android.content.Context;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.widget.Toast;

import com.magneticsource.msource.R;
import com.magneticsource.msource.conexion.UsuarioCliente;
import com.magneticsource.msource.control.Persona;
import com.magneticsource.msource.ui.AlumnoActivity;

/**
 * Created by tony on 10/11/15.
 */
public class ObtenerInformacionTask extends AsyncTask<String, Void, String> {
    private Context context;
    private ProgressDialog dialog;
    private String dni;

    public ObtenerInformacionTask(ProgressDialog dialog, String dni){
        this.dialog =dialog;
        this.dni =dni;
        context =dialog.getContext();
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        dialog.dismiss();
        dialog.setTitle(R.string.mensaje_espere);
        dialog.setMessage(context.getString(R.string.mensaje_obtener_datos));
        dialog.show();
    }

    @Override
    protected String doInBackground(String... params) {
        return UsuarioCliente.getInformacion(dni);
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
        if(s ==null){
            Toast.makeText(context, R.string.error_service, Toast.LENGTH_SHORT).show();
        } else {
            Persona p = Persona.fromString(s);
            if (p == null){
                Toast.makeText(context, R.string.error_sesion, Toast.LENGTH_SHORT).show();
            } else {
                Intent i =new Intent(context, AlumnoActivity.class);
                context.startActivity(i);
                Toast.makeText(context, context.getString(R.string.bienvenido) + p.getNombres(),Toast.LENGTH_SHORT).show();
            }

        }
        dialog.dismiss();
    }

    @Override
    protected void onCancelled() {
        super.onCancelled();
    }
}