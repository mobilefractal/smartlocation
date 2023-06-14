package vn.fractal.library.geocoding;

import android.content.Context;
import android.location.Location;

import vn.fractal.library.OnGeocodingListener;
import vn.fractal.library.OnReverseGeocodingListener;
import vn.fractal.library.utils.Logger;

/**
 * Created by mrm on 20/12/14.
 */
public interface GeocodingProvider {
    void init(Context context, Logger logger);

    void addName(String name, int maxResults);

    void addLocation(Location location, int maxResults);

    void start(OnGeocodingListener geocodingListener, OnReverseGeocodingListener reverseGeocodingListener);

    void stop();

}
