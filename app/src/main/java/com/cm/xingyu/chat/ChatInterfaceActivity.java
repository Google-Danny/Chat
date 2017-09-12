package com.cm.xingyu.chat;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class ChatInterfaceActivity extends AppCompatActivity implements View.OnClickListener {

    Bundle bundle;
    List<ChatMessage> infos;
    ListView listview;
    Button pressTalk;
    EditText msg;
    ImageView chatListKeyBoard;
    Button sendMessage;
    ImageView addOther;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        bundle = getIntent().getBundleExtra("data");
        String data = bundle.getString("username");
        this.setTitle(data);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat_interface);
        initView();
        initData();
        initListener();
    }


    private void initView() {
        listview = (ListView) findViewById(R.id.chatListView);
        msg = (EditText) findViewById(R.id.wordContent);
        chatListKeyBoard = (ImageView) findViewById(R.id.chatlistkeyboard);
        sendMessage = (Button) findViewById(R.id.sendMessage);
        pressTalk = (Button) findViewById(R.id.talkButton);
        addOther = (ImageView) findViewById(R.id.addOther);
    }
    private void initData() {
        listview.setAdapter(new ChatInterfaceAdapter(this, getData()));

    }

    private void initListener() {
        msg.setOnClickListener(this);
        chatListKeyBoard.setOnClickListener(this);
        sendMessage.setOnClickListener(this);

    }


    public List<ChatMessage> getData() {
        infos = new ArrayList<ChatMessage>();
        ChatMessage listInfo = new ChatMessage("xiu", R.drawable.headportrait, "xiu xiu xiu 520", "send");
        infos.add(listInfo);
        ChatMessage listinfos = new ChatMessage("xiao yu", R.drawable.headportrait, "xiao yu  520", "receive");
        infos.add(listinfos);
        return infos;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.chatlistkeyboard:
                msg.setVisibility(View.VISIBLE);
                addOther.setVisibility(View.GONE);
                sendMessage.setVisibility(View.VISIBLE);
                pressTalk.setVisibility(View.GONE);
                break;
            case R.id.sendMessage:
                break;
        }
    }
}
