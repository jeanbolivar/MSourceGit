package com.magneticsource.msource.conexion;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.widget.Toast;

import com.magneticsource.msource.R;

public class Conexion {

	private Context context;
	public boolean wifiConexion;
	public boolean mobileConexion;

	public Conexion(Context context) {
		this.context = context;
	}

	public boolean verificarConexionInternet() {
		wifiConexion = this.verificarWifiConexion();
		mobileConexion = this.verificarMobilConexion();
		return wifiConexion || mobileConexion;
	}

	private boolean verificarWifiConexion() {
		// Create object for ConnectivityManager class which returns network
		// related info
		ConnectivityManager connectivity = (ConnectivityManager) context
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

	private boolean verificarMobilConexion() {
		// Create object for ConnectivityManager class which returns network
		// related info
		ConnectivityManager connectivity = (ConnectivityManager) context
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

	public void showError(){
        Toast.makeText(context, R.string.error_internet, Toast.LENGTH_SHORT).show();
	}
}
