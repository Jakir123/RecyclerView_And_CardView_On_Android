package com.hrfsoftlab.jakir.recyclerview_and_cardview_on_android.test;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.hrfsoftlab.jakir.recyclerview_and_cardview_on_android.R;

import java.util.ArrayList;

/**
 * Created by RFsoftLab on 6/12/2016.
 */
public class TestAdapter extends RecyclerView.Adapter<TestAdapter.View_holder>{

    private Context context;
    private ArrayList<String> list;

    private String[] arrTemp;

    public TestAdapter(Context context, ArrayList<String> list) {
        this.context = context;
        this.list = list;

        arrTemp = new String[list.size()];
    }

    @Override
    public View_holder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.sample_design_test,parent,false);
        View_holder pvh=new View_holder(v);
        return pvh;
    }

    @Override
    public void onBindViewHolder(final View_holder holder, final int position) {

        holder.textView.setText(list.get(position));
        holder.textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "Index "+position, Toast.LENGTH_SHORT).show();
            }
        });

        holder.ref=position;
        holder.etAmount.setText(arrTemp[position]);
        holder.etAmount.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                arrTemp[holder.ref] = s.toString();
            }
        });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class View_holder extends RecyclerView.ViewHolder{
        CardView cardView;
        TextView textView;
        EditText etAmount;
        int ref;
        public View_holder(View itemView) {
            super(itemView);
            cardView= (CardView) itemView.findViewById(R.id.cvTest);
            textView= (TextView) itemView.findViewById(R.id.tvTest);
            etAmount= (EditText) itemView.findViewById(R.id.etAmountTest);


        }
    }
}
