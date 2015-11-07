package com.magneticsource.msource.conexion;

import org.ksoap2.serialization.SoapObject;

/**
 * Cliente del servicio web de usuario
 * @author César Calle
 *
 */
public class UserClient extends WebServiceClient {
	private static String URL = HOST + "/services/usuario?wsdl";

	public static Boolean sesionValida(String usuario, String password) {
		String Metodo = "sesionValida";
		SoapObject request = new SoapObject(NAMESPACE, Metodo);

		request.addProperty(createProperty("dni", usuario, String.class));
		request.addProperty(createProperty("password", password, String.class));

		return getBoolean(Metodo, request, URL);
	}

	public static String getInformacion(String usuario) {
		String Metodo = "getInformacion";
		SoapObject request = new SoapObject(NAMESPACE, Metodo);

		request.addProperty(createProperty("dni", usuario, String.class));

		return getString(Metodo, request, URL);
	}
}
