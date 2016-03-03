package com.jikexueyuan.test;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    private ListView listview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listview = (ListView) findViewById(R.id.listview);
        View header0 = LayoutInflater.from(this).inflate(R.layout.layout_item, null);
        View header1 = LayoutInflater.from(this).inflate(R.layout.layout_item, null);
        View header2 = LayoutInflater.from(this).inflate(R.layout.layout_item, null);
        listview.addHeaderView(header0);
        listview.addHeaderView(header1);
        listview.addHeaderView(header2);

        MyAdapter adapter = new MyAdapter(this);

        for(int i = 0; i < 15; i ++){
            Person person = new Person();
            person.setName("name : " + i);
            person.setAge(20 + i);
            adapter.addPerson(person);
        }

        View footer0 = LayoutInflater.from(this).inflate(R.layout.layout_item, null);
        View footer1 = LayoutInflater.from(this).inflate(R.layout.layout_item, null);
        View footer2 = LayoutInflater.from(this).inflate(R.layout.layout_item, null);

        listview.addFooterView(footer0);
        listview.addFooterView(footer1);
        listview.addFooterView(footer2);

        //上次显示的效果
        listview.setAdapter(adapter);
    }
}
