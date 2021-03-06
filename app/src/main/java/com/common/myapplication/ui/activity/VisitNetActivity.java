package com.common.myapplication.ui.activity;

import android.os.Bundle;
import android.util.Log;
import com.blankj.utilcode.util.LogUtils;
import com.common.lib_base.base_view.BaseRequestActivity;
import com.common.lib_base.base_view.BaseResEntity;
import com.common.lib_base.network.interceptor.BaseCommonParameterInterceptor;
import com.common.lib_base.network.converter.BaseEncryptGsonConverterFactory;
import com.common.lib_base.network.views.BaseIStatusView;
import com.common.lib_base.network.views.BaseLoadingStatusView;
import com.common.myapplication.bean.EntityLoginResult;
import com.common.myapplication.network.LoginPresenter;
import com.common.myapplication.network.LoginPresenter.View;
import com.example.myapplication.R;
import java.io.Serializable;
import java.util.concurrent.TimeUnit;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * @author Mr.W
 * @since 11/3/2022 10:54 pm
 */
public class VisitNetActivity extends BaseRequestActivity implements View {

    private com.hjq.shape.view.ShapeButton btnVisit;
    private com.hjq.shape.view.ShapeButton btn2;
    private com.hjq.shape.view.ShapeButton btn3;
    private com.hjq.shape.view.ShapeButton btn4;
    private com.hjq.shape.view.ShapeButton btn5;

    @Override
    protected int getContentLayoutId() {
        return R.layout.visit_net_activity;
    }


    private LoginPresenter loginPresenter;

    @Override
    protected void initialize(Bundle savedInstanceState) {

        initView();

        loginPresenter = new LoginPresenter();
        loginPresenter.setModelAndView(this);

        //单个请求演示
        btnVisit.setOnClickListener(v -> {
            HttpLoggingInterceptor logInterceptor = new HttpLoggingInterceptor();
            logInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

            OkHttpClient okHttpClient =
                    new OkHttpClient.Builder().connectTimeout(30, TimeUnit.SECONDS)
                            .readTimeout(30, TimeUnit.SECONDS)
                            .addInterceptor(new BaseCommonParameterInterceptor())
                            .addNetworkInterceptor(logInterceptor).build();
            Retrofit retrofit = new Retrofit.Builder()
                    //设置OKHttpClient
                    .client(okHttpClient)
                    //设置baseUrl,注意，baseUrl必须后缀"/"
                    .baseUrl("http://one.szheros.com/")
                    //添加Gson转换器
                    .addConverterFactory(BaseEncryptGsonConverterFactory.create())
                    .build();

            GitHubAPI gitHubAPI = retrofit.create(GitHubAPI.class);

            EntityUploadInfo uploadInfo = new EntityUploadInfo();
            uploadInfo.setData("34353");
            uploadInfo.setHardSn("34");
            uploadInfo.setMode("1");
            uploadInfo.setTimestamp("45345345324");
            uploadInfo.setKey("rw4lhfdslfhsdlfsd");

            Call<EntityResult> httpGet = gitHubAPI
                    .retrofitGet(uploadInfo.getData(), uploadInfo.getMode(), uploadInfo.getHardSn(),
                            uploadInfo.getTimestamp(), uploadInfo.getKey());
            ;
            httpGet.enqueue(new Callback<EntityResult>() {
                @Override
                public void onResponse(Call<EntityResult> call, Response<EntityResult> response) {
                    EntityResult appEntity = response.body();
                    LogUtils.i(appEntity);
                }

                @Override
                public void onFailure(Call<EntityResult> call, Throwable t) {
                    Log.e("MainActivity", "false");
                }
            });


        });

        btn2.setOnClickListener(v -> {
            onBtn2Clicked();
        });

    }

    @Override
    protected BaseIStatusView createStatusView() {
        return new BaseLoadingStatusView(this);
    }

    private void onBtn2Clicked() {

        loginPresenter.doLogin("0755", "000000");
    }

    @Override
    public void onLoginSuccess(BaseResEntity loginResult) {
        LogUtils.i(loginResult);
        EntityLoginResult loginResult1 = (EntityLoginResult) loginResult.getData();
        LogUtils.i(loginResult1);
    }

    public interface GitHubAPI {

        @GET("check.php?")
        Call<EntityResult> retrofitGet(@Query("data") String data, @Query("Mode") String mode,
                @Query("HardSN") String hardSn, @Query("timestamp") String timestamp,
                @Query("key") String key);
    }

    private void initView() {
        btnVisit = findViewById(R.id.btn_visit);
        btn2 = findViewById(R.id.btn_2);
        btn3 = findViewById(R.id.btn_3);
        btn4 = findViewById(R.id.btn_4);
        btn5 = findViewById(R.id.btn_5);
    }

    class EntityUploadInfo {

        String data, mode, hardSn, timestamp, key;

        public String getData() {
            return data;
        }

        public void setData(String data) {
            this.data = data;
        }

        public String getMode() {
            return mode;
        }

        public void setMode(String mode) {
            this.mode = mode;
        }

        public String getHardSn() {
            return hardSn;
        }

        public void setHardSn(String hardSn) {
            this.hardSn = hardSn;
        }

        public String getTimestamp() {
            return timestamp;
        }

        public void setTimestamp(String timestamp) {
            this.timestamp = timestamp;
        }

        public String getKey() {
            return key;
        }

        public void setKey(String key) {
            this.key = key;
        }
    }

    class EntityResult implements Serializable {

        private int status;
        private String message;
        private String data;

        @Override
        public String toString() {
            return "EntityResult{" +
                    "status=" + status +
                    ", message='" + message + '\'' +
                    ", data='" + data + '\'' +
                    '}';
        }

        public int getStatus() {
            return status;
        }

        public void setStatus(int status) {
            this.status = status;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }

        public String getData() {
            return data;
        }

        public void setData(String data) {
            this.data = data;
        }
    }
}
