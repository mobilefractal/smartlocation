package vn.fractal.library.location.providers;


import androidx.annotation.NonNull;

import vn.fractal.library.location.LocationProvider;
import vn.fractal.library.location.ServiceLocationProvider;
import vn.fractal.library.utils.ServiceConnectionListener;

/**
 * A decorator for a {@link ServiceConnectionListener} used to execute the {@link
 * MultiFallbackProvider}'s failover.
 *
 * @author abkaplan07
 */
class FallbackListenerWrapper implements ServiceConnectionListener {

    private final ServiceConnectionListener listener;
    private final MultiFallbackProvider fallbackProvider;
    private final ServiceLocationProvider childProvider;


    public FallbackListenerWrapper(@NonNull MultiFallbackProvider parentProvider,
                                   ServiceLocationProvider childProvider) {
        this.fallbackProvider = parentProvider;
        this.childProvider = childProvider;
        this.listener = childProvider.getServiceListener();
    }

    @Override
    public void onConnected() {
        if (listener != null) {
            listener.onConnected();
        }
    }

    @Override
    public void onConnectionSuspended() {
        if (listener != null) {
            listener.onConnectionSuspended();
        }
        runFallback();

    }

    @Override
    public void onConnectionFailed() {
        if (listener != null) {
            listener.onConnectionFailed();
        }
        runFallback();
    }

    private void runFallback() {
        LocationProvider current = fallbackProvider.getCurrentProvider();
        if (current != null && current.equals(childProvider)) {
            fallbackProvider.fallbackProvider();
        }
    }
}
