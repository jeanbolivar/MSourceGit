package com.magneticsource.msource.conexion;

import org.ksoap2.serialization.SoapObject;

/**
 * Cliente del servicio web de usuario
 * @author César Calle
 *
 */
public class UsuarioCliente extends ServicioWebCliente {
	private static String URL = HOST + "/services/usuario?wsdl";

	public static Boolean verificarDatos(String dni, String clave) {
		String Metodo = "sesionValida";
		SoapObject request = new SoapObject(NAMESPACE, Metodo);

		request.addProperty(crearPropiedad("dni", dni, String.class));
		request.addProperty(crearPropiedad("password", clave, String.class));

		return getBoolean(Metodo, request, URL);
	}

	public static String getInformacion(String dni) {
		String Metodo = "getInformacion";
		SoapObject request = new SoapObject(NAMESPACE, Metodo);

		request.addProperty(crearPropiedad("dni", dni, String.class));

		return getString(Metodo, request, URL);
	}
}
