package com.cm.xingyu.chat;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class ChatInterfaceActivity extends AppCompatActivity {
    Intent intent;
    Bundle bundle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        bundle = getIntent().getBundleExtra("data");
        String data = bundle.getString("username");
        this.setTitle(data);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat_interface);
    }
}
