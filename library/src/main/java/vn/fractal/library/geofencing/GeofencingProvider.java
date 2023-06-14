package vn.fractal.library.geofencing;

import android.content.Context;

import java.util.List;

import vn.fractal.library.OnGeofencingTransitionListener;
import vn.fractal.library.geofencing.model.GeofenceModel;
import vn.fractal.library.utils.Logger;

/**
 * Created by mrm on 20/12/14.
 */
public interface GeofencingProvider {
    void init(Context context, Logger logger);

    void start(OnGeofencingTransitionListener listener);

    void addGeofence(GeofenceModel geofence);

    void addGeofences(List<GeofenceModel> geofenceList);

    void removeGeofence(String geofenceId);

    void removeGeofences(List<String> geofenceIds);

    void stop();

}
