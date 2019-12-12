package com.item.testproject2.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Toast;

import com.item.testproject2.R;

public class SearchActivity extends AppCompatActivity {
    private ListView listView;
    private SearchView searchView;
    private final String[] strings={"aaa","bbb","ccc"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_search_view);

        searchView=findViewById(R.id.searchView);
        listView=findViewById(R.id.search_list);
        listView.setAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_dropdown_item_1line,strings));
        listView.setTextFilterEnabled(true);
        listView.setVisibility(View.VISIBLE);
        searchView.setQueryHint("输入查找内容");
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                Toast.makeText(SearchActivity.this,"123",Toast.LENGTH_SHORT).show();
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                if (TextUtils.isEmpty(newText)){
                    listView.setVisibility(View.VISIBLE);
                    listView.clearTextFilter();
                }
                else {
                    listView.setVisibility(View.VISIBLE);
                    listView.setFilterText(newText);
                }
                return true;
            }
        });
    }
}
