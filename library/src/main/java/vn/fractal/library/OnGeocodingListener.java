package vn.fractal.library;

import java.util.List;

import vn.fractal.library.geocoding.utils.LocationAddress;

/**
 * Created by mrm on 4/1/15.
 */
public interface OnGeocodingListener {
    void onLocationResolved(String name, List<LocationAddress> results);
}