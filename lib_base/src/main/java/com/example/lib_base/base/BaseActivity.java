/*
 * Copyright 2017 JessYan
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on
 * an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations under the License.
 */
package com.example.lib_base.base;

import android.text.TextUtils;
import com.blankj.utilcode.util.LogUtils;
import com.example.lib_base.R;
import com.example.lib_base.common.ConS;
import com.example.lib_base.common.utils.AndroidUtil;
import com.example.lib_base.common.utils.ThemeUtil;
import com.example.lib_base.moddule.BaseEvent;
import com.google.gson.Gson;
import org.greenrobot.eventbus.EventBus;

import com.blankj.utilcode.util.KeyboardUtils;
import com.blankj.utilcode.util.NetworkUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.jaeger.library.StatusBarUtil;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ActivityInfo;
import android.content.res.Resources;
import android.net.ConnectivityManager;
import android.os.Build.VERSION;
import android.os.Build.VERSION_CODES;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager.LayoutParams;
import android.widget.EditText;
import androidx.annotation.ColorInt;
import androidx.annotation.ColorRes;
import androidx.annotation.DrawableRes;
import androidx.annotation.IntegerRes;
import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import me.jessyan.autosize.AutoSizeCompat;
import me.yokeyword.fragmentation.ExtraTransaction;
import me.yokeyword.fragmentation.ISupportFragment;
import me.yokeyword.fragmentation.SupportActivity;
import me.yokeyword.fragmentation.SupportActivityDelegate;
import me.yokeyword.fragmentation.SupportHelper;
import me.yokeyword.fragmentation.anim.FragmentAnimator;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

public abstract class BaseActivity extends SupportActivity {

    protected final String TAG = getClass().getSimpleName();

    private Unbinder mUnbinder;
    protected Context mContext;

    protected abstract @LayoutRes
    int getContentLayoutId();

    /*默认子类的activity不需要复写，目前只有融云聊天界面才需要复写返回true表示点击其他非输入框不进行键盘隐藏的操作*/
    protected boolean ifNotDealKeyboard() {
        return false;
    }

    protected abstract void initialize(Bundle savedInstanceState);

    protected @ColorInt
    int getBackgroundColor() {
        return ThemeUtil.getBackgroundColor(getTheme());
    }

    protected int getColorForRes(@ColorRes int id) {
        return getResources().getColor(id);
    }

    public int getInteger(@IntegerRes int id) {
        return getResources().getInteger(id);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mDelegate.onCreate(savedInstanceState);

        mContext = this;

        // 屏幕方向
        setRequestedOrientation(screenOrientation());

        if (VERSION.SDK_INT < VERSION_CODES.N) {
            AndroidUtil.onAttach(mContext);// 不加这一行的话7.0以下的手机切换完之后，杀掉再进就不行了
        }

        // view内容
        setAppContentView();
        // 状态栏
        initStatusBar();
        // 弹出键盘
        if (popKeyboard()) {
            getWindow().setSoftInputMode(LayoutParams.SOFT_INPUT_ADJUST_RESIZE);
        }
        // 背景色
        if (getBackgroundColor() != 0) {
            getWindow().getDecorView().setBackgroundColor(getBackgroundColor());
        }
        // 初始化事件总线
        if (useEventBus()) {
            EventBus.getDefault().register(this);
        }
        // 初始化黄油刀
        mUnbinder = ButterKnife.bind(this);
        // 初始化
        initialize(savedInstanceState);
        registerReceiver();
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        mDelegate.onDestroy();
        unregisterReceiver();
        if (useEventBus()) {
            EventBus.getDefault().unregister(this);
        }
        if (mUnbinder != null && mUnbinder != Unbinder.EMPTY) {
            mUnbinder.unbind();
        }
        mUnbinder = null;

    }

    public void startActivityAndFinish(Intent intent) {
        startActivity(intent);
        finish();
    }

    public BaseActivity startActivity(Class<?> cls) {
        startActivity(new Intent(this, cls));

        return this;
    }

    public String getStringExtra(String name) {
        return getIntent().getStringExtra(name);
    }

    public void finish(int resultCode, Intent intent) {
        setResult(resultCode, intent);
        super.finish();
    }

    public void finish(int resultCode) {
        setResult(resultCode);
        super.finish();
    }

    /**
     * 根据EditText所在坐标和用户点击的坐标相对比，来判断是否隐藏键盘，因为当用户点击EditText时则不能隐藏
     *
     * @param v
     * @param event
     * @return
     */
    private boolean isShouldHideKeyboard(View v, MotionEvent event) {

        if (ifNotDealKeyboard()) {
            return false;
        }

        if (v != null && (v instanceof EditText)) {
            int[] l = {0, 0};
            v.getLocationInWindow(l);
            int left = l[0], top = l[1], bottom = top + v.getHeight(), right = left + v.getWidth();
            // 点击EditText的事件，忽略它。
            return !(event.getX() > left) || !(event.getX() < right) || !(event.getY() > top)
                    || !(event.getY() < bottom);
        }
        // 如果焦点不是EditText则忽略，这个发生在视图刚绘制完，第一个焦点不在EditText上，和用户用轨迹球选择其他的焦点
        return false;
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {

        if (ev.getAction() == MotionEvent.ACTION_DOWN) {
            View v = getCurrentFocus();
            if (isShouldHideKeyboard(v, ev)) {
                v.clearFocus();
                KeyboardUtils.hideSoftInput(v);
            }
        }
        try {
            return mDelegate.dispatchTouchEvent(ev) || super.dispatchTouchEvent(ev);
        } catch (Exception e) {
            return false;
        }

    }

    /**
     * 网络状态变化Receiver
     */
    private class NetworkChangedReceiver extends BroadcastReceiver {

        // private static final String TAG = NetworkChangedReceiver.class.getSimpleName();
        @Override
        public void onReceive(Context context, Intent intent) {
            boolean isConnected = NetworkUtils.isConnected();
            boolean isWifiConnected =
                    NetworkUtils.getNetworkType() == NetworkUtils.NetworkType.NETWORK_WIFI;
            // KLog.w("wangluo", String.format("网络已连接：%s, 是wifi：%s ---- %s", isConnected,
            // isWifiConnected, BaseCommActivity.this.getClass().getSimpleName() + intent
            // .getAction()));
            onNetworkChanged(isConnected, isWifiConnected);
        }

    }

    private NetworkChangedReceiver mNetworkChangedReceiver;

    /**
     * 注册网络变化的广播
     */
    private void registerReceiver() {
        if (null == mNetworkChangedReceiver) {
            mNetworkChangedReceiver = new NetworkChangedReceiver();
        }
        IntentFilter filter = new IntentFilter();
        filter.addAction(ConnectivityManager.CONNECTIVITY_ACTION);
        registerReceiver(mNetworkChangedReceiver, filter);
    }

    /**
     * 解注册网络变化的广播
     */
    private void unregisterReceiver() {
        if (null != mNetworkChangedReceiver) {
            unregisterReceiver(mNetworkChangedReceiver);
        }
    }

    /**
     * 网络变化的回调方法
     *
     * @param isConnected     网络连接正常
     * @param isWifiConnected 网络为WiFi
     */
    protected void onNetworkChanged(boolean isConnected, boolean isWifiConnected) {
        if (isWifiConnected) {

        } else if (isConnected) {

        } else {
            ToastUtils.showShort(R.string.tv_net_tips_1);

        }
    }

    final SupportActivityDelegate mDelegate = new SupportActivityDelegate(this);

    @Override
    public SupportActivityDelegate getSupportDelegate() {
        return mDelegate;
    }

    /**
     * Perform some extra transactions. 额外的事务：自定义Tag，添加SharedElement动画，操作非回退栈Fragment
     */
    @Override
    public ExtraTransaction extraTransaction() {
        return mDelegate.extraTransaction();
    }

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        mDelegate.onPostCreate(savedInstanceState);
    }

    /**
     * 该方法回调时机为,Activity回退栈内Fragment的数量 小于等于1 时,默认finish Activity 请尽量复写该方法,避免复写onBackPress(),以保证SupportFragment内的onBackPressedSupport()回退事件正常执行
     */
    @Override
    public void onBackPressedSupport() {
        mDelegate.onBackPressedSupport();
    }

    /**
     * 获取设置的全局动画 copy
     *
     * @return FragmentAnimator
     */
    @Override
    public FragmentAnimator getFragmentAnimator() {
        return mDelegate.getFragmentAnimator();
    }

    /**
     * Set all fragments animation. 设置Fragment内的全局动画
     */
    @Override
    public void setFragmentAnimator(FragmentAnimator fragmentAnimator) {
        mDelegate.setFragmentAnimator(fragmentAnimator);
    }

    /**
     * Set all fragments animation. 构建Fragment转场动画
     * <p/>
     * 如果是在Activity内实现,则构建的是Activity内所有Fragment的转场动画, 如果是在Fragment内实现,则构建的是该Fragment的转场动画,此时优先级 >
     * Activity的onCreateFragmentAnimator()
     *
     * @return FragmentAnimator对象
     */
    @Override
    public FragmentAnimator onCreateFragmentAnimator() {
        return mDelegate.onCreateFragmentAnimator();
    }

    @Override
    public void post(Runnable runnable) {
        mDelegate.post(runnable);
    }

    /****************************************
     * 以下为可选方法(Optional methods)
     ******************************************************/

    /**
     * 加载根Fragment, 即Activity内的第一个Fragment 或 Fragment内的第一个子Fragment
     *
     * @param containerId 容器id
     * @param toFragment  目标Fragment
     */
    @Override
    public void loadRootFragment(int containerId, @NonNull ISupportFragment toFragment) {
        mDelegate.loadRootFragment(containerId, toFragment);
    }

    @Override
    public void loadRootFragment(int containerId, ISupportFragment toFragment,
            boolean addToBackStack,
            boolean allowAnimation) {
        mDelegate.loadRootFragment(containerId, toFragment, addToBackStack, allowAnimation);
    }

    /**
     * 加载多个同级根Fragment,类似Wechat, QQ主页的场景
     */
    @Override
    public void loadMultipleRootFragment(int containerId, int showPosition,
            ISupportFragment... toFragments) {
        mDelegate.loadMultipleRootFragment(containerId, showPosition, toFragments);
    }

    /**
     * show一个Fragment,hide其他同栈所有Fragment 使用该方法时，要确保同级栈内无多余的Fragment,(只有通过loadMultipleRootFragment()载入的Fragment)
     * <p>
     * 建议使用更明确的{@link #showHideFragment(ISupportFragment, ISupportFragment)}
     *
     * @param showFragment 需要show的Fragment
     */
    @Override
    public void showHideFragment(ISupportFragment showFragment) {
        mDelegate.showHideFragment(showFragment);
    }

    /**
     * show一个Fragment,hide一个Fragment ; 主要用于类似微信主页那种 切换tab的情况
     */
    @Override
    public void showHideFragment(ISupportFragment showFragment, ISupportFragment hideFragment) {
        mDelegate.showHideFragment(showFragment, hideFragment);
    }

    @Override
    public void start(ISupportFragment toFragment) {
        mDelegate.start(toFragment);
    }

    @Override
    public void start(ISupportFragment toFragment, @ISupportFragment.LaunchMode int launchMode) {
        mDelegate.start(toFragment, launchMode);
    }

    @Override
    public void startForResult(ISupportFragment toFragment, int requestCode) {
        mDelegate.startForResult(toFragment, requestCode);
    }

    @Override
    public void startWithPop(ISupportFragment toFragment) {
        mDelegate.startWithPop(toFragment);
    }

    @Override
    public void startWithPopTo(ISupportFragment toFragment, Class<?> targetFragmentClass,
            boolean includeTargetFragment) {
        mDelegate.startWithPopTo(toFragment, targetFragmentClass, includeTargetFragment);
    }

    @Override
    public void replaceFragment(ISupportFragment toFragment, boolean addToBackStack) {
        mDelegate.replaceFragment(toFragment, addToBackStack);
    }

    /**
     * Pop the fragment.
     */
    @Override
    public void pop() {
        mDelegate.pop();
    }

    /**
     * Pop the last fragment transition from the manager's fragment back stack.
     * <p>
     * 出栈到目标fragment
     *
     * @param targetFragmentClass   目标fragment
     * @param includeTargetFragment 是否包含该fragment
     */
    @Override
    public void popTo(Class<?> targetFragmentClass, boolean includeTargetFragment) {
        mDelegate.popTo(targetFragmentClass, includeTargetFragment);
    }

    /**
     * If you want to begin another FragmentTransaction immediately after popTo(), use this method.
     * 如果你想在出栈后, 立刻进行FragmentTransaction操作，请使用该方法
     */
    @Override
    public void popTo(Class<?> targetFragmentClass, boolean includeTargetFragment,
            Runnable afterPopTransactionRunnable) {
        mDelegate.popTo(targetFragmentClass, includeTargetFragment, afterPopTransactionRunnable);
    }

    @Override
    public void popTo(Class<?> targetFragmentClass, boolean includeTargetFragment,
            Runnable afterPopTransactionRunnable,
            int popAnim) {
        mDelegate.popTo(targetFragmentClass, includeTargetFragment, afterPopTransactionRunnable,
                popAnim);
    }

    /**
     * 当Fragment根布局 没有 设定background属性时, Fragmentation默认使用Theme的android:windowbackground作为Fragment的背景,
     * 可以通过该方法改变其内所有Fragment的默认背景。
     */
    @Override
    public void setDefaultFragmentBackground(@DrawableRes int backgroundRes) {
        mDelegate.setDefaultFragmentBackground(backgroundRes);
    }

    /**
     * 得到位于栈顶Fragment
     */
    @Override
    public ISupportFragment getTopFragment() {
        return SupportHelper.getTopFragment(getSupportFragmentManager());
    }

    /**
     * 获取栈内的fragment对象
     */
    @Override
    public <T extends ISupportFragment> T findFragment(Class<T> fragmentClass) {
        return SupportHelper.findFragment(getSupportFragmentManager(), fragmentClass);
    }

    /**
     * 屏幕方向
     */
    protected int screenOrientation() {
        return ActivityInfo.SCREEN_ORIENTATION_PORTRAIT;
    }

    /**
     * 弹出键盘
     */
    protected boolean popKeyboard() {
        return false;
    }

    protected void startActivityForResult(Class<?> cls, int requestCode) {
        startActivityForResult(new Intent(this, cls), requestCode);
    }

    /**
     * 事件总线
     */
    protected boolean useEventBus() {
        return true;
    }

    protected void initStatusBar() {

        // 设置全屏，状态栏也占据
        StatusBarUtil.setTranslucentForImageView(this, 0, null);
    }

    @Override
    public Resources getResources() {
        // 如果没有自定义需求用这个方法
        AutoSizeCompat.autoConvertDensityOfGlobal(super.getResources());
        return super.getResources();
    }

    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(AndroidUtil.onAttach(newBase));
    }

    protected int getContainerViewId() {
        return 0;
    }


    @Subscribe(threadMode = ThreadMode.MAIN)
    public void dealServerMessage(BaseEvent event) {

    }

    protected void setAppContentView() {
        if (getContentLayoutId() == 0) {
            setContentView(getContentView());
        } else {
            setContentView(getContentLayoutId());
        }
    }
    protected View getContentView() {
        return null;
    }
}
