package com.cm.xingyu.chat;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Administrator on 2017/9/9.
 */
public class ChatListViewAdapter extends BaseAdapter {
    LayoutInflater mlayoutInflater;
    List<ChatMessage> ChatMessages;

    public ChatListViewAdapter(Context context, List<ChatMessage> infos) {
        ChatMessages = infos;
        mlayoutInflater = LayoutInflater.from(context);

    }


    @Override
    public int getCount() {
        return ChatMessages.size();
    }

    @Override
    public Object getItem(int position) {
        return ChatMessages.get(position);
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
        viewHoler.image.setImageResource(ChatMessages.get(position).getImage());
        viewHoler.friendName.setText(ChatMessages.get(position).getFriendName());
        viewHoler.chatContent.setText(ChatMessages.get(position).getChatContent());
        return convertView;
    }

    public static class ViewHoler {
        private int id;
        private TextView friendName;
        private ImageView image;
        private TextView chatContent;
    }
}
