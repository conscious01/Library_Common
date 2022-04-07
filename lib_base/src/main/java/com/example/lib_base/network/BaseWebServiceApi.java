package com.example.lib_base.network;

import com.example.lib_base.base.BasicResponseEntity;
import com.google.gson.JsonObject;

import io.reactivex.Observable;
import okhttp3.RequestBody;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.PartMap;
import retrofit2.http.Query;

public interface BaseWebServiceApi {

    @POST("/api/v1/operatorLogin")
    Observable<BasicResponseEntity<String>> doLogin(@Body JsonObject jsonObject);


}
