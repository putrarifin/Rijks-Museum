package com.chyrus.rijksmuseum.network;

import com.chyrus.rijksmuseum.data.RijksResponse;
import io.reactivex.Single;
import retrofit2.http.GET;

public interface Routes {

    @GET("nl/collection?type=schilderij&f.normalized32Colors.hex=%20%23367614")
    Single<RijksResponse> getRijks();

}
