package com.example.administrator.recyclerview;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by ChuPeng on 2017/3/31.
 */

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.RecyclerViewHolder>
{
    private List<User> userList;
    private String orientation;
    private ItemClickListener itemClickListener;

    public RecyclerViewAdapter(List<User> userList, String orientation)
    {
        super();
        this.userList = userList;
        this.orientation = orientation;
    }

    public void setItemClickListener(ItemClickListener itemClickListener)
    {
        this.itemClickListener = itemClickListener;
    }

    public int getItemCount()
    {
        return userList.size();
    }

    public RecyclerViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType)
    {
        View view;
        if("vertical".equals(orientation))
        {
            view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.recyclerview_item_vertical, null);
        }
        else
        {
            view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.recyclerview_item_horizontal, null);
        }
        //创建一个ViewHolder
        RecyclerViewHolder viewHolder = new RecyclerViewHolder(view);
        return viewHolder;
    }

    public void onBindViewHolder(final RecyclerViewHolder holder, final int position)
    {
        User user = userList.get(position);
        holder.userNmae.setText(user.getUserName());
        holder.imageName.setBackgroundResource(user.getImageView());
        //为image添加监听回调
        holder.imageName.setOnClickListener(new View.OnClickListener()
        {
            public void onClick(View v)
            {
                if(itemClickListener != null)
                {
                    itemClickListener.onItemSubViewClick(holder.imageName, position);
                }
            }
        });
    }

    public class RecyclerViewHolder extends RecyclerView.ViewHolder
    {
        private TextView userNmae;
        private ImageView imageName;

        public RecyclerViewHolder(final View itemView)
        {
            super(itemView);
            this.imageName = (ImageView) itemView.findViewById(R.id.image);
            this.userNmae = (TextView) itemView.findViewById(R.id.name);
            //为item添加普通点击回调
            itemView.setOnClickListener(new View.OnClickListener()
            {
                public void onClick(View v)
                {
                    if(itemClickListener != null)
                    {
                        itemClickListener.onItemClick(itemView, getPosition());
                    }
                }
            });
            //为item添加长按回调
            itemView.setOnLongClickListener(new View.OnLongClickListener()
            {
                public boolean onLongClick(View v)
                {
                    if(itemClickListener != null)
                    {
                        itemClickListener.onItemLongClick(itemView, getPosition());
                    }
                    return true;
                }
            });

        }
    }


}
