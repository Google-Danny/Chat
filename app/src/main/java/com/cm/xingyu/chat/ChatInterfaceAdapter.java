package com.cm.xingyu.chat;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Administrator on 2017/9/11.
 */
public class ChatInterfaceAdapter extends BaseAdapter {
    List<ChatMessage> minfos;
    LayoutInflater mlayoutInfater;

    public ChatInterfaceAdapter(Context context, List<ChatMessage> infos) {
        minfos = infos;
        mlayoutInfater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return minfos.size();
    }

    @Override
    public Object getItem(int position) {
        return minfos.get(position);
    }

    @Override
    public long getItemId(int position) {

        return position;
    }

    @Override
    public int getViewTypeCount() {
        return 2;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView == null) {
            viewHolder = new ViewHolder();
            convertView = mlayoutInfater.inflate(R.layout.activity_chat_interface_listview_layout, null);
            viewHolder.leftLLY = (LinearLayout) convertView.findViewById(R.id.leftLLY);
            viewHolder.leftImageView = (ImageView) convertView.findViewById(R.id.leftImageView);
            viewHolder.leftTextView = (TextView) convertView.findViewById(R.id.leftChatContent);
            viewHolder.rightLLY = (LinearLayout) convertView.findViewById(R.id.rightLLY);
            viewHolder.rightImageView = (ImageView) convertView.findViewById(R.id.rightImageView);
            viewHolder.rightTextView = (TextView) convertView.findViewById(R.id.rightChatContent);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        Log.e("11111", String.valueOf(position));
        Log.e("222222",minfos.get(position).getMsgType());

        if ("send"==minfos.get(position).getMsgType() ) {
            viewHolder.rightLLY.setVisibility(View.GONE);
            viewHolder.leftImageView.setImageResource(minfos.get(position).getImage());
            viewHolder.leftTextView.setText(minfos.get(position).getChatContent());

        } else if ("receive"==minfos.get(position).getMsgType() ) {
            viewHolder.leftLLY.setVisibility(View.GONE);
            viewHolder.rightImageView.setImageResource(minfos.get(position).getImage());
            viewHolder.rightTextView.setText(minfos.get(position).getChatContent());

        }

        return convertView;
    }

    class ViewHolder {
        LinearLayout leftLLY;
        ImageView leftImageView;
        TextView leftTextView;
        LinearLayout rightLLY;
        ImageView rightImageView;
        TextView rightTextView;
    }
}
