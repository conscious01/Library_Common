package com.common.myapplication.ui.activity;


import android.Manifest;
import android.os.Bundle;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.blankj.utilcode.constant.PermissionConstants;
import com.blankj.utilcode.util.LogUtils;
import com.blankj.utilcode.util.PermissionUtils;
import com.blankj.utilcode.util.PermissionUtils.FullCallback;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.common.lib_base.base_view.BaseActivity;
import com.common.lib_base.common.utils.ViewUtils;
import com.common.lib_base.module.EntityBaseDialog;
import com.common.myapplication.adapter.AdapterDemo;
import com.common.myapplication.MyApp;
import com.common.myapplication.ui.dialog.VBDialog;
import com.example.myapplication.R;

import com.lxj.xpopup.XPopup;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends BaseActivity implements OnItemClickListener {

    private RecyclerView rv;

    private AdapterDemo mAdapter;

    @Override
    protected int getContentLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initialize(Bundle savedInstanceState) {
        rv = findViewById(R.id.rv);

        List<String> showDataList = new ArrayList<>();
        showDataList.add("展示图片");
        showDataList.add("弹窗");
        showDataList.add("请求权限");
        showDataList.add("网络访问");
        showDataList.add("DataBinding 类");
        showDataList.add("使用baseVBActivity");
        showDataList.add("展示使用ViewBinding的弹窗");
        showDataList.add("base 列表使用");
        showDataList.add("状态栏使用");
        showDataList.add("使用butter knife");
        showDataList.add("使用Base VB Request Activity");

        mAdapter = new AdapterDemo(R.layout.item_tv);
        rv.setLayoutManager(new LinearLayoutManager(this));
        rv.addItemDecoration(ViewUtils.getRVVerticalDivider(this));

        rv.setAdapter(mAdapter);
        mAdapter.setNewInstance(showDataList);
        mAdapter.setOnItemClickListener(this);

    }




    @Override
    public void onItemClick(@NonNull BaseQuickAdapter<?, ?> adapter, @NonNull View view,
            int position) {
        switch (position) {
            case 0: //图片展示
                startActivity(ImageActivity.class);

                break;
            case 1://弹窗

//                EntityBaseDialog entityBaseDialog = new EntityBaseDialog();
//                entityBaseDialog.setTitle("主app");
//                entityBaseDialog.setContent("内容");
//                entityBaseDialog.setIfShowCancel(true);
//                BaseCommonFun.showFriendAlertDialog(this, entityBaseDialog);
                break;
            case 2://请求权限

                String[] pers = new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE,
                        Manifest.permission.READ_PHONE_STATE,
                        Manifest.permission.ACCESS_COARSE_LOCATION, Manifest.permission.CAMERA,
                        Manifest.permission.ACCESS_FINE_LOCATION};

                PermissionUtils.permission(PermissionConstants.CAMERA).callback(
                        new FullCallback() {
                            @Override
                            public void onGranted(List<String> permissionsGranted) {

                            }

                            @Override
                            public void onDenied(List<String> permissionsDeniedForever,
                                    List<String> permissionsDenied) {

                            }
                        }).request();
//                EasyPermissions.requestPermissions();
                break;
            case 3:// 网络访问
                startActivity(VisitNetActivity.class);
                break;
            case 4: //databinding 类
                startActivity(DataBindingClass.class);
            case 5://使用baseVBActivity:
                startActivity(UseBaseVBActivity.class);
            case 6://展示使用ViewBinding的弹窗:
                new XPopup.Builder(this)
                        .dismissOnTouchOutside(true)
                        .hasStatusBar(true)
                        .dismissOnBackPressed(true)
                        .asCustom(new VBDialog(this))
                        .show();

                break;
            case 7://base列表使用
                startActivity(ListActivity.class);
                break;
            case 8://状态栏使用
                startActivity(StatusBarActivity.class);
                break;
            case 9://使用butter knife
                startActivity(UseButterKnifeActivity.class);
            case 10: //使用Base VB Request Activity
                startActivity(UseBaseVBRequestActivity.class);
                break;
        }
    }
}