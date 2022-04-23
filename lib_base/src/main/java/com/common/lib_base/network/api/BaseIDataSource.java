package com.common.lib_base.network.api;


import com.common.lib_base.base_view.BaseResponseEntity;
import io.reactivex.Observable;

/**
 * 数据源
 */
public interface BaseIDataSource {

    Observable<BaseResponseEntity<String>> doLogin(String name, String password,
            String deviceId);

}
