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
public class CreateLiveStreamFragment extends Fragment {
    private String mFrom;

    static CreateLiveStreamFragment newInstance(String from) {
        CreateLiveStreamFragment createLiveStreamFragment = new CreateLiveStreamFragment();
        Bundle bundle = new Bundle();
        bundle.putString("from", from);
        createLiveStreamFragment.setArguments(bundle);
        return createLiveStreamFragment;
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
        View view = inflater.inflate(R.layout.create_livestream_layout,null);
        TextView textView = (TextView) view.findViewById(R.id.title_from);
        TextView content = (TextView) view.findViewById(R.id.fragment_content);

        return view;
    }
}
