package com.example.lib_base.network;


import com.example.lib_base.base.BasicResponseEntity;
import io.reactivex.Observable;

/**
 * 数据源
 */
public interface BaseIDataSource {

    Observable<BasicResponseEntity<String>> doLogin(String name, String password,
            String deviceId);

}
