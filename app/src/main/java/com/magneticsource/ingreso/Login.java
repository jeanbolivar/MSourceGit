package com.magneticsource.msource.ingreso;


import com.magneticsource.msource.control.Persona;

import java.util.List;

/**
 * Created by JeanManuel on 04/11/2015.
 */
public class Login {

    private List<Persona> personas;
    public Login(){}
    public void cerrarSesion(){}
    public Persona iniciarSesion(String dni, String clave)
    {
        Persona persona = new Persona();
        for (int i = 0; i < personas.size(); i++) {
            if(personas.get(i).getDni()==dni)
            {
                persona.setDni(dni);
                persona.setNombres(personas.get(i).getNombres());
                persona.setApellido_paterno(personas.get(i).getApellido_paterno());
                persona.setApellido_materno(personas.get(i).getApellido_materno());
            }

        }
        return persona;
    }


}
