package com.cm.xingyu.chat;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/9/8.
 */
public class MainPageFragment extends Fragment {
    private String mFrom;
    ChatListViewAdapter chatListViewAdapter;
    List<ChatMessage> infos;
    ChatMessage listInfo;

    static MainPageFragment newInstance(String from) {
        MainPageFragment mainPageFragment = new MainPageFragment();
        Bundle bundle = new Bundle();
        bundle.putString("from", from);
        mainPageFragment.setArguments(bundle);
        return mainPageFragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mFrom = getArguments().getString("from");
        }
    }

    @Nullable
    @Override
    public View onCreateView(final LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.mainpage_fragment_layout, null);
        ListView listView = (ListView) view.findViewById(R.id.listView);
        listView.setAdapter(new ChatListViewAdapter(this.getContext(),getData() ));
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                ChatMessage getObject = infos.get(position);
                Intent intent = new Intent();
                intent.setClass(getActivity(),ChatInterfaceActivity.class);
                Bundle bundle = new Bundle();
                bundle.putString("username",getObject.getFriendName());
                intent.putExtra("data",bundle);
                startActivity(intent);
            }
        });
        return view;
    }

    public List<ChatMessage> getData() {
        infos = new ArrayList<ChatMessage>();
        listInfo = new ChatMessage("xiu",R.drawable.headportrait,"xiu xiu xiu 520","send");
        infos.add(listInfo);
        return infos;
    }
}
