package com.app.ray.testingtoolbar2;

/**
 * Created by ray on 2017/5/8.
 */

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class PageFragment extends Fragment {
    public static final String ARGS_PAGE = "args_page";
    private int mPage;
    private String test;

    public static PageFragment newInstance(int page, String test) {
        Bundle args = new Bundle();

        // Getting values from MyFragmentPagerAdapter.
        // You have to set a key for using the value
        args.putInt(ARGS_PAGE, page);
        args.putString("ARGS_TEST", test);
        PageFragment fragment = new PageFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Getting values with key.
        mPage = getArguments().getInt(ARGS_PAGE);
        test = getArguments().getString("ARGS_TEST");
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.pager_item,container,false);
        TextView textView = (TextView) view.findViewById(R.id.item_title);
        textView.setText(mPage+test);

        return view;
    }

}