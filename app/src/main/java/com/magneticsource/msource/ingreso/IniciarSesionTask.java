package com.magneticsource.msource.ingreso;

import android.content.Context;
import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.widget.Toast;

import com.magneticsource.msource.R;
import com.magneticsource.msource.conexion.UsuarioCliente;

/**
 * Created by tony on 10/11/15.
 */
public class IniciarSesionTask extends AsyncTask<String, Void, Boolean> {
    private Context context;
    private ProgressDialog dialog;
    private String dni;
    private String clave;

    public IniciarSesionTask(ProgressDialog dialog, String dni, String clave){
        this.dialog =dialog;
        this.dni =dni;
        this.clave =clave;
        context =dialog.getContext();
    }

    @Override
    protected void onPreExecute() {
        dialog.dismiss();
        dialog.setTitle(R.string.mensaje_espere);
        dialog.setMessage(context.getString(R.string.mensaje_inciando_sesion));
        dialog.show();
    }

    @Override
    protected Boolean doInBackground(String... params) {
        return UsuarioCliente.verificarDatos(dni, clave);
    }

    @Override
    protected void onPostExecute(Boolean aBoolean) {
        super.onPostExecute(aBoolean);
        if(aBoolean==null){
            dialog.dismiss();
            Toast.makeText(context, R.string.error_service, Toast.LENGTH_SHORT).show();
        } else if(aBoolean){
            ObtenerInformacionTask obtenerInfo =new ObtenerInformacionTask(dialog, dni);
            obtenerInfo.execute();
        } else {
            dialog.dismiss();
            Toast.makeText(context, R.string.error_sesion, Toast.LENGTH_SHORT).show();
        }

    }

    @Override
    protected void onCancelled(Boolean aBoolean) {
        super.onCancelled(aBoolean);
    }
}
