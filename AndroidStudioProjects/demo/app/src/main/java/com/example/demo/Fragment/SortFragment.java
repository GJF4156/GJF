package com.example.demo.Fragment;


import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.demo.R;
import com.example.demo.activity.SearchActivity;


/**
 * A simple {@link Fragment} subclass.
 */
public class SortFragment extends Fragment implements View.OnClickListener {

    private TextView searchTextView,searchtv;
    private ImageView kehuishoulaji,chuyulaji,youhailaji,qitalaji;

    public SortFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_sort, container, false);

        kehuishoulaji=view.findViewById(R.id.kehuishoulaji);
        chuyulaji=view.findViewById(R.id.chuyulaji);
        youhailaji=view.findViewById(R.id.youhailaji);
        qitalaji=view.findViewById(R.id.qitalaji);
        searchtv=view.findViewById(R.id.searchtv);

        searchtv.setOnClickListener(this);
        kehuishoulaji.setOnClickListener(this);
        chuyulaji.setOnClickListener(this);
        youhailaji.setOnClickListener(this);
        qitalaji.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.kehuishoulaji:
                Toast.makeText(getActivity(),"可回收垃圾",Toast.LENGTH_SHORT).show();
                break;
            case R.id.chuyulaji:
                Toast.makeText(getActivity(),"厨余垃圾",Toast.LENGTH_SHORT).show();
                break;
            case R.id.youhailaji:
                Toast.makeText(getActivity(),"有害垃圾",Toast.LENGTH_SHORT).show();
                break;
            case R.id.qitalaji:
                Toast.makeText(getActivity(),"其他垃圾",Toast.LENGTH_SHORT).show();
                break;
            case R.id.searchtv:
                startActivity(new Intent(getActivity(), SearchActivity.class));
                break;
                default:break;
        }
    }
}
