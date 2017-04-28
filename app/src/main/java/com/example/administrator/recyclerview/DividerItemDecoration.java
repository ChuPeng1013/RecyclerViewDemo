package com.example.administrator.recyclerview;


import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

public class DividerItemDecoration extends RecyclerView.ItemDecoration
{
    //使用系统主题中的分割线
    private static final int[] ATTRS = new int[]{
            android.R.attr.listDivider
    };

    public static final int HORIZONTAL_LIST = LinearLayoutManager.HORIZONTAL;

    public static final int VERTICAL_LIST = LinearLayoutManager.VERTICAL;

    private Drawable mDivider;

    private int mOrientation;

    public DividerItemDecoration(Context context, int orientation)
    {
        final TypedArray a = context.obtainStyledAttributes(ATTRS);
        mDivider = a.getDrawable(0);
        a.recycle();
        setOrientation(orientation);
    }

    //判断方向参数是否合法
    public void setOrientation(int orientation)
    {
        if (orientation != HORIZONTAL_LIST && orientation != VERTICAL_LIST)
        {
            throw new IllegalArgumentException("invalid orientation");
        }
        mOrientation = orientation;
    }

    public void onDraw(Canvas c, RecyclerView parent)
    {
        if (mOrientation == VERTICAL_LIST)
        {
            //竖直
            drawVertical(c, parent);
        }
        else
        {
            //水平
            drawHorizontal(c, parent);
        }
    }

    //竖直方向
    public void drawVertical(Canvas c, RecyclerView parent)
    {
        //得到RecyclerView距界面左边的距离，其实就是item左上角的横坐标
        final int left = parent.getPaddingLeft();
        //得到RecyclerView距界面右边的距离，其实就是item右下角的横坐标
        final int right = parent.getWidth() - parent.getPaddingRight();
        //得到Item的数量
        final int childCount = parent.getChildCount();
        for (int i = 0; i < childCount; i++)
        {
            //得到Item的对象
            final View child = parent.getChildAt(i);
            //得到Item参数
            final RecyclerView.LayoutParams params = (RecyclerView.LayoutParams) child.getLayoutParams();
            //计算item左上角的纵坐标
            final int top = child.getBottom() + params.bottomMargin;
            //计算item右下角的纵坐标
            final int bottom = top + mDivider.getIntrinsicHeight();
            //根据Item的左上角和右下角坐标绘制矩形
            mDivider.setBounds(left, top, right, bottom);
            mDivider.draw(c);
        }
    }

    //水平方向
    public void drawHorizontal(Canvas c, RecyclerView parent)
    {
        final int top = parent.getPaddingTop();
        final int bottom = parent.getHeight() - parent.getPaddingBottom();
        final int childCount = parent.getChildCount();
        for (int i = 0; i < childCount; i++)
        {
            final View child = parent.getChildAt(i);
            final RecyclerView.LayoutParams params = (RecyclerView.LayoutParams) child.getLayoutParams();
            final int left = child.getRight() + params.rightMargin;
            final int right = left + mDivider.getIntrinsicHeight();
            mDivider.setBounds(left, top, right, bottom);
            mDivider.draw(c);
        }
    }

    public void getItemOffsets(Rect outRect, int itemPosition, RecyclerView parent)
    {
        if (mOrientation == VERTICAL_LIST)
        {
            outRect.set(0, 0, 0, mDivider.getIntrinsicHeight());
        }
        else
        {
            outRect.set(0, 0, mDivider.getIntrinsicWidth(), 0);
        }
    }
}
