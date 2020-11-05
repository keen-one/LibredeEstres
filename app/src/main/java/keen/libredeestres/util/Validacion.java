package keen.libredeestres.util;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;

public final class Validacion {

  public Validacion() {

  }

  public final boolean tieneInternet(Context context) {
    ConnectivityManager connectivityManager = (ConnectivityManager) context
        .getSystemService(Context.CONNECTIVITY_SERVICE);
    if (connectivityManager == null) {
      return false;
    }
    Network network = connectivityManager.getActiveNetwork();
    NetworkCapabilities capa = connectivityManager.getNetworkCapabilities(network);
    if (capa != null) {
      return capa.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) || capa
          .hasTransport(NetworkCapabilities.TRANSPORT_WIFI);
    } else {
      return false;
    }

  }
}
