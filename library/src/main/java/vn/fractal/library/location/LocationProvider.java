package vn.fractal.library.location;

import android.content.Context;
import android.location.Location;

import vn.fractal.library.OnLocationUpdatedListener;
import vn.fractal.library.location.config.LocationParams;
import vn.fractal.library.utils.Logger;

/**
 * Created by mrm on 20/12/14.
 */
public interface LocationProvider {
    void init(Context context, Logger logger);

    void start(OnLocationUpdatedListener listener, LocationParams params, boolean singleUpdate);

    void stop();

    Location getLastLocation();

}
