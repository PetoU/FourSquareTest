package com.kris.whitbread.api.service;

import com.kris.whitbread.api.model.VenueResponse;

import retrofit.http.GET;
import retrofit.http.Query;
import rx.Observable;

/**
 * Created by PetoU on 23/03/15.
 */
public interface VenueService {

    @GET("/venues/search")
    Observable<VenueResponse> getVenues(
            @Query("ll") String latitudeLongitude,
            @Query("query") String searchQuery);
}
