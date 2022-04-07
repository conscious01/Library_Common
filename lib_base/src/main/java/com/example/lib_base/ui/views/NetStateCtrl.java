package com.example.lib_base.ui.views;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.telephony.PhoneStateListener;
import android.telephony.SignalStrength;
import android.telephony.TelephonyManager;
import android.util.AttributeSet;
import android.view.View;

/**
 * 类名: NetStateCtrl <br/>
 * 功能: 用于显示网络状态的控件。
 * 
 * @author 
 *
 */
public class NetStateCtrl extends View {
	
	private static final int NETWORKTYPE_WIFI = 0;
	
	private static final int NETWORKTYPE_4G = 1;
	
	private static final int NETWORKTYPE_2G = 2;
	
	private static final int NETWORKTYPE_NONE = 3;
	
	/**
	 * 是否停止。
	 * 
	 */
	private boolean mIsStop = false;

	/**
	 * 手机管理对象。
	 * 
	 */
	private TelephonyManager mTelephonyManager = null;
	
	/**
	 * 当前网络的类型。
	 * 
	 */
	private int mNetWorkType = 0;
	
	private int mNetSignalLevel = 0;
	
	/**
	 * 构造函数。
	 * 
	 * @param context 上下文。
	 * 
	 */
	public NetStateCtrl(Context context) {
		
		super(context);
		
		/////////////
		//
		// 初始化环境
		init();
	}
	
	/**
	 * 构造函数。
	 * 
	 * @param context 上下文。
	 * @param attrs 属性列表。
	 * 
	 */
	public NetStateCtrl(Context context, AttributeSet attrs) {
		
		super(context, attrs);
		
		/////////////
		//
		// 初始化环境
		init();
	}
	
	/**
	 * 构造函数。
	 * 
	 * @param context 上下文。
	 * @param attrs 属性列表。
	 * @param defStyle 默认样式。
	 * 
	 */
	public NetStateCtrl(Context context, AttributeSet attrs, int defStyle) {
		
		super(context, attrs, defStyle);
		
		/////////////
		//
		// 初始化环境
		init();
	}
	
	/**
	 * 初始化工作环境。
	 * 
	 */
	private void init(){
		
		try{
			/////////////////
			//
			// 初始化监控程序。
			mTelephonyManager = (TelephonyManager) getContext().getSystemService(Context.TELEPHONY_SERVICE);
		}
		catch (Exception e) {
			
		}
		
		 
	}
	
	/**
	 * 用于响应onAttachedToWindow。
	 * 
	 */
	@Override
	protected void onAttachedToWindow() {
		
		mIsStop = false;
		
		new Thread(){
			public void run() {
				
				while (mIsStop == false) {
					
					try{
						
						mTelephonyManager.listen(phoneStateListener, PhoneStateListener.LISTEN_NONE);
						
						mTelephonyManager.listen(phoneStateListener,  
				                PhoneStateListener.LISTEN_SIGNAL_STRENGTHS);
			
					}
					catch (Exception e) {
					}
					 
					
					try {
						sleep(2000);
					} catch (InterruptedException e) {
					
					}
				}
				
			}
        }.start();
		
		
		
		super.onAttachedToWindow();
	}
	
	/**
	 * 用于响应撤销该控件的事件。
	 * 
	 */
	@Override
	protected void onDetachedFromWindow() {
		
		mIsStop = true;
		
		super.onDetachedFromWindow();
	}
	
	/**
	 * 
	 * 
	 */
    private PhoneStateListener phoneStateListener = new PhoneStateListener() {
        
        @Override
        public void onSignalStrengthsChanged(SignalStrength signalStrength) {
            
            super.onSignalStrengthsChanged(signalStrength); 
            
            
            int iA = signalStrength.getGsmSignalStrength(); //(int) ((((float)signalStrength.getGsmSignalStrength()) / 31) * 10);  
            
            int netWorkType = getNetWorkType(getContext());
            
            mNetWorkType = netWorkType;
          
            if(netWorkType == NETWORKTYPE_NONE){
            	
            	mNetSignalLevel = iA;
            	
            	invalidate();
            	
            	return ;
            }
            
            if(netWorkType == NETWORKTYPE_WIFI){
            	
            	int iWifiStrentch = getWifiSignalLevel();
            	
            	mNetSignalLevel =  iWifiStrentch;
            	
            	invalidate();
            	
            	return;
            	
            	//Toast.makeText(getContext(), "WIFI信号强度为:" + iA + ":" + iWifiStrentch, Toast.LENGTH_SHORT).show();
            }
            else{
            	
            	mNetSignalLevel = iA;
            	
            	invalidate();
            	
            	return ;
            	
                //Toast.makeText(getContext(), "手机网络信号强度为:" + iA, Toast.LENGTH_SHORT).show();
            }
            
        
        }  

    }; 
    
    public static int getNetWorkType(Context context) {
    	int mNetWorkType = -1;
    	ConnectivityManager manager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
    	NetworkInfo networkInfo = manager.getActiveNetworkInfo();
    	if (networkInfo != null && networkInfo.isConnected()) {
    		String type = networkInfo.getTypeName();
    		if (type.equalsIgnoreCase("WIFI")) {
    			mNetWorkType = NETWORKTYPE_WIFI;
    		} else if (type.equalsIgnoreCase("MOBILE")) {
    			return isFastMobileNetwork(context) ? NETWORKTYPE_4G : NETWORKTYPE_2G;
    		}
    	} else {
    		mNetWorkType = NETWORKTYPE_NONE;//没有网络
    	}
    	return mNetWorkType;
    }
    
    private int getWifiSignalLevel() {  
        WifiManager wifiManager = (WifiManager) getContext().getSystemService(Context.WIFI_SERVICE);
        WifiInfo wifiInfo = wifiManager.getConnectionInfo();
        if (wifiInfo.getBSSID() != null) {  
            //wifi名称  
            String ssid = wifiInfo.getSSID();
            //wifi信号强度  
            int signalLevel = WifiManager.calculateSignalLevel(wifiInfo.getRssi(), 10);
            
           
            
            return signalLevel;
//            //wifi速度  
//            int speed = wifiInfo.getLinkSpeed();  
//            //wifi速度单位  
//            String units = WifiInfo.LINK_SPEED_UNITS;  
//            wifi.setText("wifi_level:"+signalLevel +"_speed:"+speed +"_units:"+units);  
//            wifiDrawView.setType(signalLevel);  
        }  
        
        return 0;
    }  


    @SuppressLint("MissingPermission")
	private static boolean isFastMobileNetwork(Context context) {
    	TelephonyManager telephonyManager = (TelephonyManager)context.getSystemService(Context.TELEPHONY_SERVICE);
        //这里只简单区分两种类型网络，认为4G网络为快速，但最终还需要参考信号值
        return telephonyManager.getNetworkType() == TelephonyManager.NETWORK_TYPE_LTE;
    }

    /**
     * 用于绘制界面的函数。
     * 
     * @param canvas 场景。
     * 
     */
	@Override
	protected void onDraw(Canvas canvas) {
		
		/////////////////
		//
		// 使用父类绘制。
		super.onDraw(canvas);
		
		////////////////
		//
		// 绘制背景。
		canvas.drawColor(Color.TRANSPARENT);

		
		///////////////
		//
		// 如果没有网络。
		if(mNetWorkType == NETWORKTYPE_NONE){
			
			for(int i = 0; i < 5; i++){
				
				doDrawLine(canvas, i, false);
			}
			
			return ;
		}
		
		//////////////
		//
		// 获取信号的强度。
		int iIndex = (int) Math.ceil((float)mNetSignalLevel / (float)2);
		
		for(int i = 0; i < 5; i++){
			
			if(i <= (iIndex - 1)){
				
				doDrawLine(canvas, i, true);
			}
			else{
				doDrawLine(canvas, i, false);
			}
			
		}
		
		
	}
	
	/**
	 * 用于绘制信号的线条。
	 * 
	 * @param canvas 画布。
	 * @param iLineIndex 线的索引。
	 * @param isHasSignal 是否有信号。
	 * 
	 */
	private void doDrawLine(Canvas canvas, int iLineIndex, boolean isHasSignal){
		
		/////////////////
		//
		// 构造画笔。
		Paint paint = new Paint();
		
		////////////////
		//
		// 去除锯齿。
		paint.setAntiAlias(true);  
		
		////////////////
		//
		// 根据信号强度，绘制线条。
		if(isHasSignal == true){
			
			paint.setColor(Color.argb(0xff, 0x00, 0x66, 0x33)); //线条填充的颜色
		}
		else{
			
			paint.setColor(Color.LTGRAY);
		}
			
		paint.setStyle(Paint.Style.STROKE);
		
        paint.setStrokeWidth(dip2px(getContext(), 3)); //设置线条的宽度  
        
        canvas.drawLine(dip2px(getContext(), iLineIndex * 5 + 1), dip2px(getContext(), (4 - iLineIndex) * 3),  
        		dip2px(getContext(), iLineIndex * 5 + 1) , dip2px(getContext(), 15),  
                paint);  
        
	}
	
	@Override
	public boolean isInEditMode() {
		return true;
	}
	
	/**
	 * 获取控件需要的高度。
	 * 
	 * @param measureSpec 参数。
	 * 
	 * @return
	 * 
	 */
	private int measureHeight(int measureSpec) {
		
		int specMode = MeasureSpec.getMode(measureSpec);
		int specSize = MeasureSpec.getSize(measureSpec);
		
		int result = dip2px(getContext(), 15);
		
		if (specMode == MeasureSpec.AT_MOST) {
			// result = specSize;
			return result ;
		} else if (specMode == MeasureSpec.EXACTLY) {
			// result = specSize;
			return specSize;
		}
		
		return specSize ;
	}
	
	/**
	 * 获取控件需要的宽度。
	 * 
	 * @param measureSpec 参数。
	 * 
	 * @return
	 * 
	 */
	private int measureWidth(int measureSpec) {
		
		int specMode = MeasureSpec.getMode(measureSpec);
		int specSize = MeasureSpec.getSize(measureSpec);
		
		int result = dip2px(getContext(), 23);
		
		if (specMode == MeasureSpec.AT_MOST) {
			// result = specSize;
			return result ;
		} else if (specMode == MeasureSpec.EXACTLY) {
			// result = specSize;
			return specSize;
		}
		
		return specSize ;
	}
	
	/**
	 * 获取高度。
	 * 
	 */
	@Override
	protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
		
		super.onMeasure(widthMeasureSpec, heightMeasureSpec);
		
		setMeasuredDimension(measureWidth(widthMeasureSpec), measureHeight(heightMeasureSpec));
	}
	
	
	/**  
     * 根据手机的分辨率从 dp 的单位 转成为 px(像素)  
     * 
     * @param context 上下文。
     * @param dpValue dp单位的高度。
     * 
     */  
    public int dip2px(Context context, float dpValue) {
        final float scale = context.getResources().getDisplayMetrics().density;  
        return (int) (dpValue * scale + 0.5f);  
    }  

}
