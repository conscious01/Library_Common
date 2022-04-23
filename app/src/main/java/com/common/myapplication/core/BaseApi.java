package com.common.myapplication.core;

import com.common.lib_base.base_view.BaseResEntity;
import com.common.lib_base.base_view.BaseResListEntity;
import com.common.myapplication.bean.EntityLoginResult;
import com.common.myapplication.bean.EntityMsg;
import com.google.gson.JsonObject;
import io.reactivex.Observable;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface BaseApi {

    @POST("/idcApi/v1/operatorLogin")
    Observable<BaseResEntity<EntityLoginResult>> doLogin(@Body JsonObject jsonObject);

    @POST("http://parking.unioncore.vip/api/v1/queryOperatorMsg")
    Observable<BaseResListEntity<EntityMsg>> getMsgList(@Body JsonObject jsonObject);

}
