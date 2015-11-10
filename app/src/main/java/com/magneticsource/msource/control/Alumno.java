package com.magneticsource.msource.control;

/**
 * Created by tony on 02/11/15.
 */
public class Alumno extends Persona{
    Alumno(String dni, String nombres, String apellidoPa,
           String apellidoMa, String imageURL){
        super( dni,  nombres,  apellidoPa,
                 apellidoMa,  imageURL);
    }

    public static Alumno fromString(String informacion){
        String[] inf = informacion.split(Datos.SEPARADOR1);
        if (inf.length == 9) {
            return new Alumno(inf[0],inf[1],inf[2],inf[3],inf[8]);
        } else return null;
    }

}
