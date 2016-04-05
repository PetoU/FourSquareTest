package com.kris.whitbread;

import android.content.Context;
import android.content.SharedPreferences;
import android.location.Location;
import android.os.Bundle;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.LocationListener;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationServices;
import com.kris.whitbread.api.model.VenueResponse;
import com.kris.whitbread.api.service.ApiInterceptor;
import com.kris.whitbread.api.service.VenueService;
import com.squareup.okhttp.OkHttpClient;

import retrofit.Endpoints;
import retrofit.RestAdapter;
import retrofit.client.OkClient;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import rx.subjects.PublishSubject;

public class DataManager implements GoogleApiClient.ConnectionCallbacks, GoogleApiClient.OnConnectionFailedListener,
        LocationListener {

    private static final String API_URL = "https://api.foursquare.com/v2/";

    private final SharedPreferences mSharedPref;
    private final Context mContext;

    private final VenueService mVenueService;
    private LocationRequest mLocationRequest;
    private GoogleApiClient mGoogleApiClient;
    private String mLatitude;
    private String mLongitude;
    private PublishSubject<VenueResponse> mVenueBehaviourSubject;
    private PublishSubject<String> mLatLongPublishSubject;

    public DataManager(SharedPreferences prefs, Context context) {
        this.mSharedPref = prefs;
        this.mContext = context;
        this.mVenueService = getService(VenueService.class, API_URL, new ApiInterceptor());
        mVenueBehaviourSubject = PublishSubject.create();
        mLatLongPublishSubject = PublishSubject.create();
    }


    public Observable<VenueResponse> getVenues(String searchQuery) {
        createLocationRequest();
        buildGoogleApiClient(mContext);

        mLatLongPublishSubject
                .flatMap(latLong -> {
                    return mVenueService.getVenues(latLong, searchQuery);
                })
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(mVenueBehaviourSubject);

        return mVenueBehaviourSubject;
    }


    private <T> T getService(Class<T> clazz, String url, ApiInterceptor headers) {
        final RestAdapter adapter = new RestAdapter.Builder()
                .setClient(new OkClient(new OkHttpClient()))
                .setEndpoint(Endpoints.newFixedEndpoint(url))
                .setRequestInterceptor(headers)
                .build();
        adapter.setLogLevel(RestAdapter.LogLevel.FULL);

        return adapter.create(clazz);
    }


    protected void createLocationRequest() {
        mLocationRequest = new LocationRequest();
        mLocationRequest.setInterval(500);
        mLocationRequest.setNumUpdates(1);
        mLocationRequest.setFastestInterval(500);
        mLocationRequest.setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY);
    }

    protected void startLocationUpdates() {
        LocationServices.FusedLocationApi.requestLocationUpdates(mGoogleApiClient, mLocationRequest, this);
    }

    private void buildGoogleApiClient(final Context context) {
        mGoogleApiClient = new GoogleApiClient.Builder(context)
                .addApi(LocationServices.API)
                .addConnectionCallbacks(this)
                .addOnConnectionFailedListener(this)
                .build();
        mGoogleApiClient.connect();
    }

    @Override
    public void onConnected(Bundle bundle) {
        startLocationUpdates();
    }

    @Override
    public void onConnectionSuspended(int i) {

    }

    @Override
    public void onConnectionFailed(ConnectionResult connectionResult) {

    }

    @Override
    public void onLocationChanged(Location location) {
        if (location != null) {
            mLatitude = String.valueOf(Utils.round(location.getLatitude(), 2));
            mLongitude = String.valueOf(Utils.round(location.getLongitude(), 2));

            final String latLong = mLatitude + "," + mLongitude;

            mLatLongPublishSubject.onNext(latLong);

        }
    }

}
