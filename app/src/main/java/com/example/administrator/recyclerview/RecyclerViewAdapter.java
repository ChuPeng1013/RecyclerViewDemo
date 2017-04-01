package com.example.administrator.recyclerview;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
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

    private Context context;
    private List<User> userList;
    private ItemClickListener itemClickListener;

    public RecyclerViewAdapter(Context context, List<User> userList)
    {
        super();
        this.context = context;
        this.userList = userList;
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
        View view = View.inflate(viewGroup.getContext(), R.layout.recyclerview_item, null);
        //创建一个ViewHolder
        RecyclerViewHolder viewHolder = new RecyclerViewHolder(view)
        {
            public String toString()
            {
                return super.toString();
            }
        };
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
