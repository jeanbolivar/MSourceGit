package com.magneticsource.msource.asistencia;

import com.magneticsource.msource.control.Profesor;

import java.util.List;

/**
 * Created by JeanManuel on 04/11/2015.
 */
public class TomarAsistencia {
    private Profesor profesor;
    private List<String> asistentes;

    public TomarAsistencia(){}
    public void iniciarAsistencia(){}
    public boolean recibirAsistentes(String dni){return true;}
    public boolean grabarAsistencia(){return true;}
    public void cerrarAsistencia(){}

}
