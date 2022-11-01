package com.example.diffutildemo.diffutils.common;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.example.diffutildemo.R;
import com.example.diffutildemo.diffutils.diffutil.TestBean;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Sophia
 * @time 2022/10/31
 */
// ① 创建Adapter
public class NormalAdapter extends RecyclerView.Adapter<NormalAdapter.VH> {

    //② 创建ViewHolder
    public static class VH extends RecyclerView.ViewHolder {

        TextView tv1, tv2;
        ImageView iv;

        public VH(View v) {
            super(v);
            tv1 = (TextView) itemView.findViewById(R.id.tv1);
            tv2 = (TextView) itemView.findViewById(R.id.tv2);
            iv = (ImageView) itemView.findViewById(R.id.iv);
        }
    }

    private List<TestBean> mDatas;

    public void setDatas(List<TestBean> mDatas) {
        this.mDatas = mDatas;
    }

    public void updateData(List<TestBean> data) {
        this.mDatas = data;
        notifyDataSetChanged();
    }

    // 添加新的Item
    public void addNewItem(TestBean bean) {
        if (mDatas == null) {
            mDatas = new ArrayList<>();
        }
        mDatas.add(0, bean);
        notifyItemInserted(0);
    }

    // 修改的Item
    public void updateItem(int position) {
        if (mDatas == null) {
            mDatas = new ArrayList<>();
        }
        TestBean bean = mDatas.get(position);
        bean.setDesc("Android+");
        bean.setPic(R.drawable.pic7);//模拟修改数据
        notifyItemChanged(position);
    }

    // 删除Item
    public void deleteItem() {
        if (mDatas == null || mDatas.isEmpty()) {
            return;
        }
        mDatas.remove(1);
        notifyItemRemoved(1);
    }

    public NormalAdapter(List<TestBean> data) {
        this.mDatas = data;
    }

    //③ 在Adapter中实现3个方法
    @Override
    public void onBindViewHolder(VH holder, int position) {
        TestBean bean = mDatas.get(position);
        holder.tv1.setText(bean.getName());
        holder.tv2.setText(bean.getDesc());
        holder.iv.setImageResource(bean.getPic());
        holder.itemView.setOnClickListener(v -> {
            //item 点击事件
            deleteItem();
        });
    }

    @Override
    public int getItemCount() {
        return mDatas.size();
    }

    @Override
    public VH onCreateViewHolder(ViewGroup parent, int viewType) {
        //LayoutInflater.from指定写法
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_diff, parent, false);
        return new VH(v);
    }
}
