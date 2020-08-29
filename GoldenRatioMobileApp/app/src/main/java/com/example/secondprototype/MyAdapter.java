package com.example.secondprototype;



import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DataSnapshot;

import de.hdodenhof.circleimageview.CircleImageView;


/*This is the Adapter for Recycler View*/

public class MyAdapter extends FirebaseRecyclerAdapter<Model,MyAdapter.MyViewHolder> {

    private OnItemClickListener listener;                                  //This is the implementation of the onItemClickListener interface



    public MyAdapter(@NonNull FirebaseRecyclerOptions<Model> options) {     // Constructor
        super(options);
    }

    @Override
    protected void onBindViewHolder(@NonNull MyViewHolder holder, int position, @NonNull Model model) {
        holder.nameTextView.setText(model.getName());
        Glide.with(holder.imageView.getContext()).load(model.getImgURL()).into(holder.imageView);
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.simple_row,parent,false);
        return new MyViewHolder(view);
    }

    class MyViewHolder extends RecyclerView.ViewHolder{                            // Inner class to give the prototype of the viewHolder

        TextView nameTextView;                                       //To set the name from Firebase Database
        CircleImageView imageView;                                   //To set the image from Firebase Storage


        public MyViewHolder(@NonNull View itemView) {                //Constructor
            super(itemView);


            nameTextView = (TextView)itemView.findViewById(R.id.nameTextView);
            imageView = (CircleImageView) itemView.findViewById(R.id.imageView);

            itemView.setOnClickListener(new View.OnClickListener() {               //To play the video in seperate activity on clicking a particular item in recycler view
                @Override
                public void onClick(View v) {
                     int position = getAdapterPosition();
                     if(position !=-1 && listener!=null)
                     {
                          listener.onItemClick(getSnapshots().getSnapshot(position),position);
                     }
                }
            });
        }
    }
    public interface OnItemClickListener{                                           //Interface with onItemClick() method
         void onItemClick(DataSnapshot documentSnapshot, int position);
    }
    public void setListener(OnItemClickListener listener) {                 //Setting up the listener
        this.listener = listener;
    }
}

