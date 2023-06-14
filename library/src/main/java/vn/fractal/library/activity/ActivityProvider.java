package vn.fractal.library.activity;

import android.content.Context;

import com.google.android.gms.location.DetectedActivity;

import vn.fractal.library.OnActivityUpdatedListener;
import vn.fractal.library.activity.config.ActivityParams;
import vn.fractal.library.utils.Logger;

/**
 * Created by mrm on 3/1/15.
 */
public interface ActivityProvider {
    void init(Context context, Logger logger);

    void start(OnActivityUpdatedListener listener, ActivityParams params);

    void stop();

    DetectedActivity getLastActivity();
}
