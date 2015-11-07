package com.magneticsource.msource.conexion;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

public class Conexion {

	private Context _context;
	public boolean WifiConn;
	public boolean MobileConn;

	public Conexion(Context context) {
		this._context = context;
	}

	public boolean verificarConexionInternet() {
		WifiConn = this.verificarWifiInternet();
		MobileConn = this.verificarMobileInternet();
		return WifiConn || MobileConn;
	}

	private boolean verificarWifiInternet() {
		// Create object for ConnectivityManager class which returns network
		// related info
		ConnectivityManager connectivity = (ConnectivityManager) _context
				.getSystemService(Context.CONNECTIVITY_SERVICE);
		// If connectivity object is not null
		if (connectivity != null) {
			// Get network info - WIFI internet access
			NetworkInfo info = connectivity
					.getNetworkInfo(ConnectivityManager.TYPE_WIFI);

			if (info != null) {
				// Look for whether device is currently connected to WIFI
				// network
				if (info.isConnected()) {
					return true;
				}
			}
		}
		return false;
	}

	private boolean verificarMobileInternet() {
		// Create object for ConnectivityManager class which returns network
		// related info
		ConnectivityManager connectivity = (ConnectivityManager) _context
				.getSystemService(Context.CONNECTIVITY_SERVICE);
		// If connectivity object is not null
		if (connectivity != null) {
			// Get network info - Mobile internet access
			NetworkInfo info = connectivity
					.getNetworkInfo(ConnectivityManager.TYPE_MOBILE);

			if (info != null) {
				// Look for whether device is currently connected to Mobile
				// internet
				if (info.isConnected()) {
					return true;
				}
			}
		}
		return false;
	}
}
