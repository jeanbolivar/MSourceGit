package com.magneticsource.msource.control;

/**
 * Created by JeanManuel on 02/11/2015.
 */
public class Persona {
        private String Dni;
        private String Nombres;
        private String ApellidoPa;
        private String ApellidoMa;
        private String ImageUrl;
        private String Separador = "█";

        public Persona(String dni, String nombres, String apellidoPa,
                    String apellidoMa, String imageUrl) {
            super();
            Dni = dni;
            Nombres = nombres;
            ApellidoPa = apellidoPa;
            ApellidoMa = apellidoMa;
            ImageUrl = imageUrl;
        }

        public Persona(String info) {
            super();
            String[] informacion = info.split(Separador);
            if (informacion.length == 9) {
                Dni = informacion[0];
                Nombres = informacion[1];
                ApellidoPa = informacion[2];
                ApellidoMa = informacion[3];
                ImageUrl = informacion[8];
            } else {
                borrar();
            }
        }

        public Persona() {
            super();
            borrar();
        }

        private void borrar() {
            Dni = "";
            Nombres = "";
            ApellidoPa = "";
            ApellidoMa = "";
            ImageUrl = "";
        }

        public String getDni() {
            return Dni;
        }

        public String getNombres() {
            return Nombres;
        }

        public String getApellidoPa() {
            return ApellidoPa;
        }

        public String getApellidoMa() {
            return ApellidoMa;
        }

        public String getImageUrl() {
            return ImageUrl;
        }

        public boolean isEmpthy() {
            return Dni.length() == 0;
        }

}
