package com.hrfsoftlab.jakir.recyclerview_and_cardview_on_android;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * @author Jakir Hossain
 * @version 1.3.0
 * @desc description of the class
 * @link n/a
 * @created on 21-Oct-15
 * @updated on
 * @modified by
 * @updated on
 * @since 1.0
 */
public class PersonAdapter extends RecyclerView.Adapter<PersonAdapter.PersonViewHolder> {

    private ArrayList<Person> personsList;
    private Context context;
    public PersonAdapter(Context context,ArrayList<Person> persons) {
        this.context=context;
        this.personsList=persons;
    }

    @Override
    public PersonViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.sample_design,parent,false);
        PersonViewHolder pvh=new PersonViewHolder(v);
        return pvh;
    }

    @Override
    public void onBindViewHolder(PersonViewHolder holder, int position) {
        holder.imvPersonPhoto.setImageResource(personsList.get(position).getPhotoId());
        holder.tvPersonName.setText(personsList.get(position).getName());
        holder.tvPersonAge.setText(personsList.get(position).getAge());

    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    @Override
    public int getItemCount() {
        return personsList.size();
    }

    public static class PersonViewHolder extends RecyclerView.ViewHolder{
        CardView cardView;
        TextView tvPersonName;
        TextView tvPersonAge;
        ImageView imvPersonPhoto;

        public PersonViewHolder(View itemView) {
            super(itemView);
            cardView= (CardView) itemView.findViewById(R.id.cv);
            tvPersonAge= (TextView) itemView.findViewById(R.id.tvPersonAge);
            tvPersonName= (TextView) itemView.findViewById(R.id.tvPersonName);
            imvPersonPhoto= (ImageView) itemView.findViewById(R.id.imvPersonPhoto);



        }
    }
}
