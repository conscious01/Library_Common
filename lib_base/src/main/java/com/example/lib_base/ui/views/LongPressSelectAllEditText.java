package com.example.lib_base.ui.views;

import android.content.Context;
import android.os.Handler;
import android.util.AttributeSet;

/**
 * 
 * 
 * @author lenovo
 *
 */
public class LongPressSelectAllEditText extends androidx.appcompat.widget.AppCompatEditText {
	
	private Handler mHandler = null;

	public LongPressSelectAllEditText(Context context) {
		super(context);
		
		mHandler = new Handler();
		
		//initA950();
	}

	public LongPressSelectAllEditText(Context context, AttributeSet attrs) {
		super(context, attrs);
		
		mHandler = new Handler();
		
		//initA950();
	}

	public LongPressSelectAllEditText(Context context, AttributeSet attrs,
                                      int defStyle) {
		super(context, attrs, defStyle);
		
		mHandler = new Handler();
		
		//initA950();
	}
	
	
	
	
	private Runnable delayRunnable = new Runnable() {
		@Override
		public void run() {
			
			LongPressSelectAllEditText.this.setFocusable(true);
			LongPressSelectAllEditText.this.requestFocus();
			LongPressSelectAllEditText.this.selectAll();
		}
	};
	
//	protected void onCreateContextMenu(ContextMenu menu) {
//		
//		mHandler.postDelayed(delayRunnable, 1000);
//	};
// 
	
	
//	@Override
//	public boolean onTouchEvent(MotionEvent event) {
//		
//		if(event.getAction() == MotionEvent.ACTION_DOWN){
//			
//			mHandler.postDelayed(delayRunnable, 1000);
//			
//			return super.onTouchEvent(event);
//		}
//		
//		if(event.getAction() == MotionEvent.ACTION_UP){
//			mHandler.removeCallbacks(delayRunnable);
//			
//			return super.onTouchEvent(event);
//		}
//		
//		
//		
//		return super.onTouchEvent(event);
//	}
	

}
