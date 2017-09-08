package com.cm.xingyu.chat;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Administrator on 2017/9/8.
 */
public class DataGenerator {
    public static final int[] mTabRes = new int[]{R.drawable.mainpage_unpress, R.drawable.watchlivestream_unpress,
            R.drawable.createlivestream_unpress, R.drawable.myaccount_unpress};
    public static final int[] mTabResPressed = new int[]{R.drawable.mainpage_press, R.drawable.watchlivestream_press,
            R.drawable.createlivestream_press, R.drawable.myaccount_press};
    public static final String[] mTabTitle = new String[]{"首页", "看直播", "我要直播", "我的"};

    public static Fragment[] getFragments(String form) {
        Fragment fragments[] = new Fragment[4];
        fragments[0] = MainPageFragment.newInstance(form);
        fragments[1] = WatchLiveStreamFragment.newInstance(form);
        fragments[2] = CreateLiveStreamFragment.newInstance(form);
        fragments[3] = MyAccountFragment.newInstance(form);
        return fragments;
    }

    /**
     * 获取Tab 显示的内容
     *
     * @param context
     * @param position
     * @return
     */
    public static View getTabView(Context context, int position) {
        View view = LayoutInflater.from(context).inflate(R.layout.home_tab_content, null);
        ImageView tabIcon = (ImageView) view.findViewById(R.id.tab_content_image);
        tabIcon.setImageResource(DataGenerator.mTabRes[position]);
        TextView tabText = (TextView) view.findViewById(R.id.tab_content_text);
        tabText.setText(mTabTitle[position]);
        return view;
    }
}
