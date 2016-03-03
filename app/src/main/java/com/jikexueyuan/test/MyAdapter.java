package com.jikexueyuan.test;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.zip.Inflater;

/**
 * Created by lixianfeng on 16/3/1.
 */
public class MyAdapter extends BaseAdapter {

    private ArrayList<Person> list = new ArrayList<>();
    private Context mContext;

    public MyAdapter(Context context){
        mContext = context;
    }

    //也可以通过构造方法来添加数据
    public MyAdapter(Context context, ArrayList<Person> list){
        mContext = context;
        this.list = list;
    }


    //通过这个方法来添加数据
    public void addPerson(Person person){
        list.add(person);
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Person getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        Person person = list.get(position);

//        View view = null;
//        if(position % 2 == 0){
//
//            view = LayoutInflater.from(mContext).inflate(R.layout.layout_item1, null);
//        }else{
//
//            view = LayoutInflater.from(mContext).inflate(R.layout.layout_item, null);
//        }
        Holder holder = null;
        if(convertView == null){//开始的时候，还没有可以回收的View，所以为null
            convertView = LayoutInflater.from(mContext).inflate(R.layout.person_item, null);
            holder = new Holder();
            holder.name = (TextView) convertView.findViewById(R.id.name);
            holder.age = (TextView) convertView.findViewById(R.id.age);

            convertView.setTag(holder);

//            holder.name.setText(person.getName());
//            holder.age.setText("age: " + person.getAge());

        }else{//convertView不为null

            holder = (Holder) convertView.getTag();

        }
//
        holder.name.setText(person.getName());
        holder.age.setText("age: " + person.getAge());


        return convertView;
    }



    class Holder{
        TextView name;
        TextView age;
    }


}
