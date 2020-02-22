package com.example.demo.Fragment;


import android.app.Dialog;
import android.content.Intent;
import android.graphics.Point;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.demo.R;
import com.example.demo.Utils.DrawableUtils;
import com.example.demo.activity.SearchActivity;
import com.example.demo.adapter.SearchRvAdapter;
import com.example.demo.base.BaseFragment;
import com.example.demo.beans.Sorts;
import com.example.demo.beans.SortsBean;
import com.example.demo.myView.CustomDialog;
import com.google.gson.Gson;

import java.util.List;
import java.util.stream.Collectors;


/**
 * A simple {@link Fragment} subclass.
 */
public class SortFragment extends BaseFragment implements View.OnClickListener {

    private TextView searchtv;
    private ImageView kehuishoulaji, chuyulaji, youhailaji, qitalaji;
    private List<SortsBean.DatalistBean> resultBeanList;
    private String url;

    public SortFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_sort, container, false);
        url = "http://129.211.75.130:8080/demo/garbage/selectbytype?type=";

        kehuishoulaji = view.findViewById(R.id.kehuishoulaji);
        chuyulaji = view.findViewById(R.id.chuyulaji);
        youhailaji = view.findViewById(R.id.youhailaji);
        qitalaji = view.findViewById(R.id.qitalaji);
        searchtv = view.findViewById(R.id.searchtv);

        kehuishoulaji.setImageDrawable(DrawableUtils.ZoomDrawable(getResources().getDrawable(R.drawable.kehuishoulaji), 2300, 3800));
        chuyulaji.setImageDrawable(DrawableUtils.ZoomDrawable(getResources().getDrawable(R.drawable.chuyulaji), 2300, 3800));
        youhailaji.setImageDrawable(DrawableUtils.ZoomDrawable(getResources().getDrawable(R.drawable.youhailaji), 2300, 3800));
        qitalaji.setImageDrawable(DrawableUtils.ZoomDrawable(getResources().getDrawable(R.drawable.qitalaji), 2300, 3800));

        searchtv.setOnClickListener(this);
        kehuishoulaji.setOnClickListener(this);
        chuyulaji.setOnClickListener(this);
        youhailaji.setOnClickListener(this);
        qitalaji.setOnClickListener(this);


        return view;
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.kehuishoulaji:
                loadData(url + 0);
                break;
            case R.id.chuyulaji:
                loadData(url + 2);
                break;
            case R.id.youhailaji:
                loadData(url + 1);
                break;
            case R.id.qitalaji:
                loadData(url + 3);
                break;
            case R.id.searchtv:
                startActivity(new Intent(getActivity(), SearchActivity.class));
                break;
            default:
                break;
        }
    }

    @Override
    public void onSuccess(String result) {
        SortsBean sortsBean = new Gson().fromJson(result, SortsBean.class);
        if (sortsBean.getCode() == 200) {
            resultBeanList = sortsBean.getDatalist();
            ShowData(resultBeanList);
            Log.d("TAG", "===============================================\n" + resultBeanList.get(0).getContain());
        } else {
            Toast.makeText(getActivity(), "没有数据", Toast.LENGTH_SHORT);
        }
    }

    @Override
    public void onError(Throwable ex, boolean isOnCallback) {
        Toast.makeText(getActivity(), "请求数据失败", Toast.LENGTH_SHORT).show();
    }

    private void ShowData(List<SortsBean.DatalistBean> data) {
        Dialog dialog = new Dialog(getActivity(), R.style.custom_dialog);
        //设置布局
        dialog.setContentView(R.layout.dialog_rv_layout);
        RecyclerView rv = dialog.findViewById(R.id.dialog_rv);
        LinearLayoutManager ms = new LinearLayoutManager(getActivity());
        ms.setOrientation(LinearLayoutManager.VERTICAL);
        rv.setLayoutManager(ms);
        rv.setAdapter(new SearchRvAdapter(getActivity(), data, new SearchRvAdapter.OnItemClickListener() {
            @Override
            public void onClick(int position) {

            }
        }));
        WindowManager manager = getActivity().getWindow().getWindowManager();
        Display display = manager.getDefaultDisplay();
        final WindowManager.LayoutParams params = dialog.getWindow().getAttributes();
        dialog.show();
        // 设置宽度
        Point size = new Point();
        display.getSize(size);
        // 宽度为当前屏幕的90%
        params.width = (int) (size.x * 0.95);
        params.height = (int) (size.y * 0.9);
        dialog.getWindow().setAttributes(params);
    }

    /**
     * 显示dialog的方法
     *
     * @param mStrs    数据源列表
     * @param position 列表下标
     */
    public void toshowDialog(List<Sorts.ResultBean> mStrs, int position) {
        CustomDialog dialog = new CustomDialog(getActivity(), R.style.custom_dialog);
        dialog.setName(mStrs.get(position - 1).getName())
                .setDescription(mStrs.get(position - 1).getExplain())
                .setChangjian("常见包括")
                .setChangjiancontent(mStrs.get(position - 1).getCommon())
                .setDelivery("投放要求")
                .setDeliverycontent(mStrs.get(position - 1).getRequire());
        switch (position) {
            case 1:
                //可回收垃圾
                dialog.setIcon(R.string.recyclableFont);
                dialog.setCardVieDgColor(getActivity().getColor(R.color.recyclableFontColor));
                dialog.setIconColor(getActivity().getColor(R.color.recyclableFontColor));
                dialog.setSortNameColor(getActivity().getColor(R.color.recyclableFontColor));
                dialog.setChangJianColor(getActivity().getColor(R.color.recyclableFontColor));
                dialog.setDeliveryColor(getActivity().getColor(R.color.recyclableFontColor));
                dialog.setSortname("可回收垃圾");
                break;
            case 2:
                //有害垃圾
                dialog.setIcon(R.string.hazardousFont);
                dialog.setCardVieDgColor(getActivity().getColor(R.color.hazardousFontColor));
                dialog.setIconColor(getActivity().getColor(R.color.hazardousFontColor));
                dialog.setSortNameColor(getActivity().getColor(R.color.hazardousFontColor));
                dialog.setChangJianColor(getActivity().getColor(R.color.hazardousFontColor));
                dialog.setDeliveryColor(getActivity().getColor(R.color.hazardousFontColor));
                dialog.setSortname("有害垃圾");
                break;
            case 3:
                //厨余垃圾
                dialog.setIcon(R.string.kitchenFont);
                dialog.setCardVieDgColor(getActivity().getColor(R.color.kitchenFontColor));
                dialog.setIconColor(getActivity().getColor(R.color.kitchenFontColor));
                dialog.setSortNameColor(getActivity().getColor(R.color.kitchenFontColor));
                dialog.setChangJianColor(getActivity().getColor(R.color.kitchenFontColor));
                dialog.setDeliveryColor(getActivity().getColor(R.color.kitchenFontColor));
                dialog.setSortname("厨余垃圾");
                break;
            case 4:
                //其他垃圾
                dialog.setIcon(R.string.otherFont);
                dialog.setCardVieDgColor(getActivity().getColor(R.color.otherFontColor));
                dialog.setIconColor(getActivity().getColor(R.color.otherFontColor));
                dialog.setSortNameColor(getActivity().getColor(R.color.otherFontColor));
                dialog.setChangJianColor(getActivity().getColor(R.color.otherFontColor));
                dialog.setDeliveryColor(getActivity().getColor(R.color.otherFontColor));
                dialog.setSortname("其他垃圾");
                break;
            default:
                break;
        }
        dialog.show();
    }
}
