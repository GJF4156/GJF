package com.example.demo.Fragment;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.demo.R;

/**
 * A simple {@link Fragment} subclass.
 * 关于
 */
public class AboutFragment extends Fragment implements View.OnClickListener {
    private TextView tvTitle, btHeaderRight, version;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_about, container, false);
        initView(view);
        initData();
        return view;
    }

    private void initData() {
        tvTitle.setText("关于");
        btHeaderRight.setVisibility(View.GONE);

    }

    private void initView(View view) {
        tvTitle = getActivity().findViewById(R.id.tv_title);
        btHeaderRight = getActivity().findViewById(R.id.bt_header_right);
        version = view.findViewById(R.id.version);

        version.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.version:
                Toast.makeText(getActivity(), "当前为最新版本", Toast.LENGTH_SHORT).show();
                break;
            default:
                break;
        }
    }
}
