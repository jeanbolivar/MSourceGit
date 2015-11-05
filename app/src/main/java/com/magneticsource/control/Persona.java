package com.magneticsource.msource.control;

/**
 * Created by JeanManuel on 02/11/2015.
 */
public class Persona {
    private String dni;
    private String nombres;
    private String apellido_paterno;
    private String apellido_materno;

    public Persona(){}
    public Persona(String dni, String nombres, String apellido_materno, String apellido_paterno)
    {
        this.dni=dni;
        this.nombres=nombres;
        this.apellido_materno=apellido_materno;
        this.apellido_paterno=apellido_paterno;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellido_paterno() {
        return apellido_paterno;
    }

    public void setApellido_paterno(String apellido_paterno) {
        this.apellido_paterno = apellido_paterno;
    }

    public String getApellido_materno() {
        return apellido_materno;
    }

    public void setApellido_materno(String apellido_materno) {
        this.apellido_materno = apellido_materno;
    }


}
