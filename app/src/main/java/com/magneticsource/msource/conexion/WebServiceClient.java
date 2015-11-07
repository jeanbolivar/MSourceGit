package com.magneticsource.msource.conexion;

import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.PropertyInfo;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapPrimitive;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;

/**
 * Cliente de servicio web
 * 
 * @author César Calle
 * 
 */
public class WebServiceClient {
	protected static String NAMESPACE = "http://services.academico.ulasalle.com";
	protected static String HOST = "http://academico.ulasalle.edu.pe:8080/services";

	protected static String getString(String Metodo, SoapObject request,
			String URL) {
		String resTxt = null;
		SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(
				SoapEnvelope.VER11);
		envelope.setOutputSoapObject(request);
		HttpTransportSE androidHttpTransport = new HttpTransportSE(URL);

		try {
			androidHttpTransport.call(Metodo, envelope);
			SoapPrimitive response = (SoapPrimitive) envelope.getResponse();
			resTxt = response.toString();
		} catch (Exception e) {
			e.printStackTrace();
			resTxt = null;
		}
		return resTxt;
	}

	protected static Boolean getBoolean(String Metodo, SoapObject request,
			String URL) {
		Boolean resTxt = false;
		SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(
				SoapEnvelope.VER11);
		envelope.setOutputSoapObject(request);
		HttpTransportSE androidHttpTransport = new HttpTransportSE(URL);

		try {
			androidHttpTransport.call(Metodo, envelope);
			SoapPrimitive response = (SoapPrimitive) envelope.getResponse();
			resTxt = Boolean.valueOf(response.toString());
		} catch (Exception e) {
			e.printStackTrace();
			resTxt = null;
		}
		return resTxt;
	}

	protected static Integer getInteger(String Metodo, SoapObject request,
			String URL) {
		Integer resTxt = null;
		SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(
				SoapEnvelope.VER11);
		envelope.setOutputSoapObject(request);
		HttpTransportSE androidHttpTransport = new HttpTransportSE(URL);

		try {
			androidHttpTransport.call(Metodo, envelope);
			SoapPrimitive response = (SoapPrimitive) envelope.getResponse();
			resTxt = Integer.valueOf(response.toString());
		} catch (Exception e) {
			e.printStackTrace();
			resTxt = null;
		}
		return resTxt;
	}

	/**
	 * Crea un propertyinfo
	 * @param name nombre
	 * @param value el dato a enviar
	 * @param type tipo de dato
	 * @return propertyinfo
	 */
	protected static PropertyInfo createProperty(String name, Object value,
			Object type) {
		PropertyInfo p = new PropertyInfo();
		p.setName(name);
		p.setValue(value);
		p.setType(type);
		return p;
	}
}
