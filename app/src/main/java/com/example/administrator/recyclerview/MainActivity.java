package com.example.administrator.recyclerview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity
{
    private RecyclerView recyclerView;
    private List<User> userList;
    private RecyclerViewAdapter adapter;
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        //创建一个线性布局管理器
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        //设置布局管理器
        recyclerView.setLayoutManager(layoutManager);
        userList = new ArrayList<User>();
        for(int i = 0; i <= 20; i++)
        {
            User user = new User();
            user.setImageView(R.mipmap.ic_launcher);
            user.setUserName("我是Item" + i);
            userList.add(user);
        }

        adapter = new RecyclerViewAdapter(MainActivity.this, userList);
        adapter.setItemClickListener(new ItemClickListener()
        {
            public void onItemClick(View view, int position)
            {
                Toast.makeText(MainActivity.this, "你点击了Item", Toast.LENGTH_SHORT).show();
            }

            public void onItemLongClick(View view, int position)
            {
                Toast.makeText(MainActivity.this, "你长按了Item", Toast.LENGTH_SHORT).show();
            }

            public void onItemSubViewClick(View view, int position)
            {
                Toast.makeText(MainActivity.this, "你点击了Image", Toast.LENGTH_SHORT).show();
            }
        });
        recyclerView.setAdapter(adapter);
    }
}
