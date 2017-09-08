package com.cm.xingyu.chat;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by Administrator on 2017/9/8.
 */
public class WatchLiveStreamFragment extends Fragment {
    private String mFrom;

    static WatchLiveStreamFragment newInstance(String from) {
        WatchLiveStreamFragment watchLiveStreamFragment = new WatchLiveStreamFragment();
        Bundle bundle = new Bundle();
        bundle.putString("from", from);
        watchLiveStreamFragment.setArguments(bundle);
        return watchLiveStreamFragment;
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
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.watch_livestream_fragment_layout,null);
        TextView textView = (TextView) view.findViewById(R.id.title_from);
        TextView content = (TextView) view.findViewById(R.id.fragment_content);
        textView.setText(mFrom);

        return view;
    }
}
