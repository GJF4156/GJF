package com.example.demo;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;
import android.os.Bundle;
import com.chaychan.library.BottomBarLayout;
import com.example.demo.Fragment.HomeFragment;
import com.example.demo.Fragment.MeFragment;
import com.example.demo.Fragment.ShopFragment;
import com.example.demo.Fragment.SortFragment;
import java.util.ArrayList;
import java.util.List;

public class BottomBarLayoutActivity extends AppCompatActivity {
    private List<Fragment> pageLists;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bottom_bar_layout);
        init();
    }

    private void init() {
        ViewPager viewPager = findViewById(R.id.vp_content);
        BottomBarLayout bottomBarLayout = findViewById(R.id.bbl);
        pageLists = new ArrayList<>();
        pageLists.add(new HomeFragment());
        pageLists.add(new SortFragment());
        pageLists.add(new ShopFragment());
        pageLists.add(new MeFragment());
        viewPager.setAdapter(new fragmentAdapter(getSupportFragmentManager()));
        bottomBarLayout.setViewPager(viewPager);
        //bottomBarLayout.setUnread(1, 101);//设置第二个页签的未读书
        bottomBarLayout.showNotify(2);//设置第三个页签显示提示的小红点
        //bottomBarLayout.setMsg(3, "NEW");//设置第四个页签显示NEW提示文字
//        bottomBarLayout.setOnItemSelectedListener(new BottomBarLayout.OnItemSelectedListener() {
//            @Override
//            public void onItemSelected(BottomBarItem bottomBarItem, int i) {
//                Toast.makeText(BottomBarLayoutActivity.this,"这是第"+i+"页",Toast.LENGTH_SHORT).show();
//            }
//        });
    }

    public class fragmentAdapter extends FragmentPagerAdapter {
        public fragmentAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return pageLists.get(position);
        }

        @Override
        public int getCount() {
            return pageLists.size();
        }
    }
}
