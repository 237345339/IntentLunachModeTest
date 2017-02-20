package com.intenttest.intentlunachmodetest;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class MainActivity extends AppCompatActivity {

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

        test1.setText("L");
        test2.setText("id:"+getTaskId());
        test3.setVisibility(View.GONE);

        test3.setText("L3");
        //fuck
    }

    @OnClick(R.id.test2)
    public void onClick() {
        Intent intent = new Intent(this, SelectorActivity.class);
        startActivity(intent);
        finish();
    }
}
