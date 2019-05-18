package com.panshi.facebookkit;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class FooterFragment extends Fragment {

    private TextView textView;

    @Override
    public View onCreateView(final LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // 将myfragment Layout文件转化为View
        //返回转化来的View
        View view=inflater.inflate(R.layout.fragment_footer, container, false);
        textView=view.findViewById(R.id.tv_fragment);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(),LoginActivity.class));
           /*   Intent intent=new Intent();
                getActivity().setResult(10, intent);
                getActivity().finish();*/
            }
        });
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);


    }
}
