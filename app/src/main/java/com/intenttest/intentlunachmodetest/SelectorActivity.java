package com.intenttest.intentlunachmodetest;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/******************************************************************
 * Java Lib For Android, Powered By Shenzhen Jiuzhou.
 * <p>
 * Copyright (c) 2001-2014 Digital Telemedia Co.,Ltd
 * http://www.d-telemedia.com/
 * <p>
 * Package:     com.intenttest.intentlunachmodetest
 * <p>
 * 项目名称：IntentLunachModeTest
 * <p>
 * Description: ${TODO}(用一句话描述该文件做什么)
 * <p>
 * Copyright:   Copyright (c) 2001-2014
 * <p>
 * Company:     Digital Telemedia Co.,Ltd
 *
 * @author: zhao
 * @version: 1.0.0
 * <p>
 * Create at:   2017/2/20 8:41
 * <p>
 * Revision:
 * <p>
 * 2017/2/20 8:41
 * - first revision
 *****************************************************************/
public class SelectorActivity extends AppCompatActivity {
    @BindView(R.id.test1)
    TextView test1;
    @BindView(R.id.test2)
    TextView test2;
    @BindView(R.id.test3)
    TextView test3;
    MyApplication myApplication;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        Toast.makeText(this,"oncreate",Toast.LENGTH_LONG).show();

        myApplication= MyApplication.getInstance();
        myApplication.setActivity(this);

        test1.setText("SelectorActivity");
        test2.setText("id:"+getTaskId());
        test3.setVisibility(View.GONE);

    }

    @OnClick(R.id.test2)
    public void onClick() {
        Intent intent=new Intent(this,PhotoActivity.class);
        startActivity(intent);

    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if(keyCode==KeyEvent.KEYCODE_BACK){
            myApplication.appFinish();
        }

        return super.onKeyDown(keyCode, event);
    }


    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        if(intent.getFlags()==Intent.FLAG_ACTIVITY_CLEAR_TOP){
            finish();
        }
    }
}
