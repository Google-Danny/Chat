package com.cm.xingyu.chat;

import android.content.Context;
import android.database.DataSetObserver;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Administrator on 2017/9/9.
 */
public class ChatListViewAdapter extends BaseAdapter {
    LayoutInflater mlayoutInflater;
    List<chatListInfo> chatListInfos;

    public ChatListViewAdapter(Context context, List<chatListInfo> infos) {
        chatListInfos = infos;
        mlayoutInflater = LayoutInflater.from(context);
    }


    @Override
    public int getCount() {
        return chatListInfos.size();
    }

    @Override
    public Object getItem(int position) {
        return chatListInfos.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHoler viewHoler;
        if (convertView == null) {
            convertView = mlayoutInflater.inflate(R.layout.mainpage_fragment_chatlistview_layout, null);
            viewHoler = new ViewHoler();
            viewHoler.image = (ImageView) convertView.findViewById(R.id.imageView);
            viewHoler.chatContent = (TextView) convertView.findViewById(R.id.chatContent);
            viewHoler.friendName = (TextView) convertView.findViewById(R.id.username);
            convertView.setTag(viewHoler);
        } else {
            viewHoler = (ViewHoler) convertView.getTag();
        }
        Log.e("d",chatListInfos.get(position).getFriendName());
        viewHoler.image.setImageResource(chatListInfos.get(position).getImage());
        viewHoler.friendName.setText(chatListInfos.get(position).getFriendName());
        viewHoler.chatContent.setText(chatListInfos.get(position).getChatContent());
        return convertView;
    }

    public static class ViewHoler {
        private int id;
        private TextView friendName;
        private ImageView image;
        private TextView chatContent;
    }
}
