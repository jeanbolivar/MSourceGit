package com.magneticsource.msource.control;

/**
 * Created by JeanManuel on 02/11/2015.
 */
public class Persona {
        private String dni;
        private String nombres;
        private String apellidoPa;
        private String apellidoMa;
        private String imageURL;

        public Persona(String dni, String nombres, String apellidoPa,
                    String apellidoMa, String imageURL) {
            super();
            this.dni = dni;
            this.nombres = nombres;
            this.apellidoPa = apellidoPa;
            this.apellidoMa = apellidoMa;
            this.imageURL = imageURL;
        }

        public static Persona fromString(String informacion) {
            String[] inf = informacion.split(Datos.SEPARADOR1);
            if (inf.length == 9) {
                return new Persona(inf[0],inf[1],inf[2],inf[3],inf[8]);
            } else return null;
        }

        /*private void borrar() {
            dni = "";
            nombres = "";
            apellidoPa = "";
            apellidoMa = "";
            imageURL = "";
        }*/

        public String getDni() {
            return dni;
        }

        public String getNombres() {
            return nombres;
        }

        public String getApellidoPa() {
            return apellidoPa;
        }

        public String getApellidoMa() {
            return apellidoMa;
        }

        public String getImageURL() {
            return imageURL;
        }
}
