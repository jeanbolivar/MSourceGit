package com.magneticsource.msource.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.magneticsource.msource.control.Alumno;
import com.magneticsource.msource.control.Datos;
import com.magneticsource.msource.R;
import com.magneticsource.msource.control.Persona;

public class AlumnoActivity extends AppCompatActivity {

    private TextView txvAlumno;
    private Alumno alumno;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alumno);

        txvAlumno = (TextView) findViewById(R.id.ala_txvAlumno);

        Datos d =new Datos(getApplicationContext());
        alumno = Alumno.fromString(d.getString(Datos.USUARIO));

        txvAlumno.setText(alumno.getNombreCompleto());

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_alumno, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
