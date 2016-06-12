package com.hrfsoftlab.jakir.recyclerview_and_cardview_on_android.test;

import android.support.v4.text.TextDirectionHeuristicCompat;
import android.support.v4.widget.TextViewCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import com.hrfsoftlab.jakir.recyclerview_and_cardview_on_android.R;

import java.util.ArrayList;

public class TestActivity extends AppCompatActivity {

    private RecyclerView rvTest;
    private TestAdapter adapter;
    private ArrayList<String> list;

    private TextView tvTotalAmount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        rvTest= (RecyclerView) findViewById(R.id.rvTest);
        tvTotalAmount= (TextView) findViewById(R.id.tvTotalAmount);
        rvTest.setHasFixedSize(true);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        rvTest.setLayoutManager(llm);

        list=new ArrayList<>();
        for (int i=0;i<20;i++){
            list.add("test "+i);
        }
        adapter=new TestAdapter(TestActivity.this,list);
        rvTest.setAdapter(adapter);
    }
}
