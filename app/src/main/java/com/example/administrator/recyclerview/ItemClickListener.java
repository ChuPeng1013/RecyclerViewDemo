package com.example.administrator.recyclerview;

import android.view.View;

/**
 * Created by ChuPeng on 2017/3/31.
 */

public interface ItemClickListener
{
    //Item 普通点击
    public void onItemClick(View view, int position);

    //Item 长按
    public void onItemLongClick(View view, int position);

    //Item 内部View点击
    public void onItemSubViewClick(View view, int position);
}
