package com.magneticsource.msource.asistencia;

import com.magneticsource.msource.control.Profesor;

import java.util.List;

/**
 * Created by JeanManuel on 04/11/2015.
 */
public class TomarAsistencia {
    private Profesor profesor;
    private List<String> asistentes;

    public TomarAsistencia(Profesor profesor){
        this.profesor = profesor;
    }
    public void iniciarAsistencia(){}
    public void recibirAsistente(String dni){}
    public void cerrarAsistencia(){}
    public void grabarAsistencia(){}

}
