package com.hrfsoftlab.jakir.recyclerview_and_cardview_on_android;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements RecyclerItemClickListener.OnItemClickListener{

    private RecyclerView rvPersonInfo;
    private PersonAdapter personAdapter;
    private ArrayList<Person> personsList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initializations();
        eventClickListener();
    }
    private void initializations() {
        rvPersonInfo= (RecyclerView) findViewById(R.id.rvPersonInfo);
        rvPersonInfo.setHasFixedSize(true);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        rvPersonInfo.setLayoutManager(llm);

        personsList=new ArrayList<>();
        personsList.add(new Person("Jakir","25 Years Old",R.drawable.jakir));
        personsList.add(new Person("Ibrahim","8 Years Old",R.drawable.ibrahim));
        personsList.add(new Person("Ismail","1 Years Old",R.drawable.ismail));

        personAdapter=new PersonAdapter(this,personsList);
        rvPersonInfo.setAdapter(personAdapter);
    }

    private void eventClickListener() {
        rvPersonInfo.addOnItemTouchListener(new RecyclerItemClickListener(this,this));
    }

    @Override
    public void onItemClick(View childView, int position) {
        Toast.makeText(MainActivity.this, "Single Click", Toast.LENGTH_SHORT).show();
        Toast.makeText(MainActivity.this, personsList.get(position).getName(), Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onItemLongPress(View childView, int position) {
        Toast.makeText(MainActivity.this,"Long Press", Toast.LENGTH_SHORT).show();
        Toast.makeText(MainActivity.this,personsList.get(position).getName(), Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onItemDoubleTap(View childView, int position) {
        Toast.makeText(MainActivity.this, "Double Tap", Toast.LENGTH_SHORT).show();
        Toast.makeText(MainActivity.this, personsList.get(position).getName(), Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onItemDownTap(View childView, int position) {
        Toast.makeText(MainActivity.this, "Down Tap", Toast.LENGTH_SHORT).show();
        Toast.makeText(MainActivity.this, personsList.get(position).getName(), Toast.LENGTH_SHORT).show();
    }
}
