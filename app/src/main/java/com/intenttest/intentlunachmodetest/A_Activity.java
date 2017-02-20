package com.intenttest.intentlunachmodetest;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.View;
import android.widget.TextView;

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
public class A_Activity extends AppCompatActivity {
    @BindView(R.id.test1)
    TextView test1;
    @BindView(R.id.test2)
    TextView test2;
    @BindView(R.id.test3)
    TextView test3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        MyApplication myApplication= MyApplication.getInstance();
        myApplication.setActivity(this);
        test1.setText("A_Activity");
        test2.setText("id:"+getTaskId());

    }



    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            Intent intent = new Intent(this, PhotoActivity.class);
            startActivity(intent);
        }

        return super.onKeyDown(keyCode, event);
    }

    @OnClick({R.id.test2, R.id.test3})
    public void onClick(View view) {
        Intent intent=null;
        switch (view.getId()) {
            case R.id.test2:
                intent= new Intent(this, B_Activity.class);
                startActivity(intent);

                break;
            case R.id.test3:
                intent = new Intent(this, PhotoActivity.class);
                startActivity(intent);
                break;
        }
    }
}
