package com.bian.dan.dxyj.adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.bian.dan.dxyj.R;
import com.bian.dan.dxyj.bean.LineAndTension;
import com.bian.dan.dxyj.bean.NameBean;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainPopwindowAdapter extends BaseAdapter {

    private Activity activity;
    //直线，耐张的数据集合
    private List<LineAndTension.DataBean> list=new ArrayList<>();
    //工程名，监理单位，施工单位的数据集合
    private List<NameBean> list2=new ArrayList<>();
    public MainPopwindowAdapter(Activity activity) {
        super();
        this.activity = activity;
    }

    public void setData(List<LineAndTension.DataBean> list){
        this.list=list;
    }

    public void setData2(List<NameBean> list2){
        this.list2=list2;
    }

    @Override
    public int getCount() {
        if(list.size()>0){
            return list.size();
        }else{
            return list2.size();
        }
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    ViewHolder holder = null;
    public View getView(int position, View view, ViewGroup parent) {
        if (view == null) {
            view = LayoutInflater.from(activity).inflate(R.layout.item_main_popwindow, null);
            holder = new ViewHolder(view);
            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }
        if(list.size()>0){
            holder.tvName.setText(list.get(position).getApplyWire());
        }else{
            holder.tvName.setText(list2.get(position).getName());
        }
        return view;
    }


    static class ViewHolder {
        @BindView(R.id.tv_name)
        TextView tvName;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
