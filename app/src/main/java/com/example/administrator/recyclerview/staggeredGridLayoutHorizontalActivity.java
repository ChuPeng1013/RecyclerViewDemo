package com.example.administrator.recyclerview;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by ChuPeng on 2017/4/20.
 */

public class staggeredGridLayoutHorizontalActivity extends Activity
{
    private RecyclerView recyclerView;
    private StaggeredGridLayoutManager staggeredGridLayoutManager;
    private List<User> userList;
    private RecyclerViewAdapter adapter;
    private Button addButton;
    private Button removeButton;
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_linear_layout_horizontal);
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        addButton = (Button) findViewById(R.id.add);
        removeButton = (Button) findViewById(R.id.remove);
        staggeredGridLayoutManager = new StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.HORIZONTAL);
        //recyclerView.addItemDecoration(new DividerGridItemDecoration(this));
        userList = new ArrayList<User>();
        for(int i = 0; i <= 20; i++)
        {
            User user = new User();
            user.setImageView(R.mipmap.ic_launcher);
            //用产生随机数的方式，自动生成名字长短不一样的Item
            Random random = new Random();
            int length = random.nextInt(3) + 1;
            StringBuilder stringBuilder = new StringBuilder();
            for(int j = 0; j < length; j++)
            {
                stringBuilder.append("我是Item");
            }
            user.setUserName(stringBuilder.toString() + i);
            userList.add(user);
        }
        recyclerView.setLayoutManager(staggeredGridLayoutManager);
        adapter = new RecyclerViewAdapter(userList, "horizontal");
        adapter.setItemClickListener(new ItemClickListener()
        {
            public void onItemClick(View view, int position)
            {
                Toast.makeText(staggeredGridLayoutHorizontalActivity.this, "你点击了Item", Toast.LENGTH_SHORT).show();
            }

            public void onItemLongClick(View view, int position)
            {
                Toast.makeText(staggeredGridLayoutHorizontalActivity.this, "你长按了Item", Toast.LENGTH_SHORT).show();
            }

            public void onItemSubViewClick(View view, int position)
            {
                Toast.makeText(staggeredGridLayoutHorizontalActivity.this, "你点击了Image", Toast.LENGTH_SHORT).show();
            }
        });
        recyclerView.setAdapter(adapter);

        addButton.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                User user = new User();
                user.setUserName("Insert One");
                user.setImageView(R.mipmap.ic_launcher);
                if(userList.size() > 2)
                {
                    userList.add(2, user);
                    adapter.notifyItemInserted(2);
                }
                else
                {
                    userList.add(0, user);
                    adapter.notifyItemInserted(0);
                }
            }
        });

        removeButton.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                if(userList.size() > 3)
                {
                    userList.remove(2);
                    adapter.notifyItemRemoved(2);
                }
                else
                {
                    if(userList.size() > 0)
                    {
                        userList.remove(0);
                        adapter.notifyItemRemoved(0);
                    }
                    else
                    {
                        Toast.makeText(staggeredGridLayoutHorizontalActivity.this, "列表中无数据", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
}
