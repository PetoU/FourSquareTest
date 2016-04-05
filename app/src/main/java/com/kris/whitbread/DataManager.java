package com.kris.whitbread;

import android.content.Context;
import android.content.SharedPreferences;

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

public class DataManager  {

    private static final String API_URL = "https://api.foursquare.com/v2/";

    private final SharedPreferences mSharedPref;
    private final Context mContext;

    private final VenueService mVenueService;

    public DataManager(SharedPreferences prefs, Context context) {
        this.mSharedPref = prefs;
        this.mContext = context;
        this.mVenueService = getService(VenueService.class, API_URL, new ApiInterceptor());
    }


    public Observable<VenueResponse> getVenues(String postCode) {
        return mVenueService.getVenues(postCode, "latitudeLongitude")
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread());
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

}
