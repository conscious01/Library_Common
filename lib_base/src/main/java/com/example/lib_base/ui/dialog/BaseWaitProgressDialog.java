package com.example.lib_base.ui.dialog;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.widget.TextView;
import com.example.lib_base.R;



public class BaseWaitProgressDialog extends Dialog {

    private TextView messageTextView = null;

    private String mstrMessage = "";

    public BaseWaitProgressDialog(Context context) {
        super(context,  R.style.dialog);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.wait_progress_dialog);

        messageTextView = findViewById(R.id.messageTextView);


        this.setCancelable(false);
        this.setCanceledOnTouchOutside(false);
        // 设置现实的内容。
        messageTextView.setText(mstrMessage);


    }

    public void setMessage(String strMessage){

        mstrMessage = strMessage;
        if(messageTextView == null){
            return ;
        }
        messageTextView.setText(mstrMessage);
    }

}
