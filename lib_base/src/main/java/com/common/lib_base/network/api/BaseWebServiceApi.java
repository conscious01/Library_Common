package com.common.lib_base.network.api;

import com.common.lib_base.base_view.BaseResponseEntity;
import com.google.gson.JsonObject;
import io.reactivex.Observable;

public interface BaseWebServiceApi {

    Observable<BaseResponseEntity<String>> doLogin(JsonObject jsonObject);
}
