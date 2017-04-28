package com.example.administrator.recyclerview;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.widget.Button;

public class MainActivity extends AppCompatActivity
{

    private Button linearLayoutVerticalButton;
    private Button linearLayoutHorizontalButton;
    private Button gridLayoutVerticalButton;
    private Button gridLayoutHorizontalButton;
    private Button staggeredGridLayoutVerticalButton;
    private Button staggeredGridLayoutHorizontalButton;
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
        linearLayoutVerticalButton = (Button) findViewById(R.id.linearLayoutVertical);
        linearLayoutHorizontalButton = (Button) findViewById(R.id.linearLayoutHorizontal);
        gridLayoutVerticalButton = (Button) findViewById(R.id.gridLayoutVertical);
        gridLayoutHorizontalButton = (Button) findViewById(R.id.gridLayoutHorizontal);
        staggeredGridLayoutVerticalButton = (Button) findViewById(R.id.staggeredGridLayoutVertical);
        staggeredGridLayoutHorizontalButton = (Button) findViewById(R.id.staggeredGridLayoutHorizontal);

        linearLayoutVerticalButton.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                Intent intent = new Intent(MainActivity.this, linearLayoutVerticalActivity.class);
                startActivity(intent);
            }
        });

        linearLayoutHorizontalButton.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                Intent intent = new Intent(MainActivity.this, linearLayoutHorizontalActivity.class);
                startActivity(intent);
            }
        });

        gridLayoutVerticalButton.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                Intent intent = new Intent(MainActivity.this, gridLayoutVerticalActivity.class);
                startActivity(intent);
            }
        });

        gridLayoutHorizontalButton.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                Intent intent = new Intent(MainActivity.this, gridLayoutHorizontalActivity.class);
                startActivity(intent);
            }
        });

        staggeredGridLayoutVerticalButton.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                Intent intent = new Intent(MainActivity.this, staggeredGridLayoutVerticalActivity.class);
                startActivity(intent);
            }
        });

        staggeredGridLayoutHorizontalButton.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                Intent intent = new Intent(MainActivity.this, staggeredGridLayoutHorizontalActivity.class);
                startActivity(intent);
            }
        });
    }
}
