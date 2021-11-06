package com.training.one.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;
import com.training.one.R;
import com.training.one.activity.ContentActivity;
import com.training.one.model.Person;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class PersonAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private final Context context;
    private List<Person> personList;

    public PersonAdapter(Context context, List<Person> personList) {
        this.context = context;
        this.personList = personList;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent, false);

        return new ItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ItemViewHolder myViewHolder = (ItemViewHolder) holder;
        myViewHolder.itemLayout.setAnimation(AnimationUtils.loadAnimation(context,R.anim.item_home_frag));
        myViewHolder.name.setText(personList.get(position).getName());
        myViewHolder.filed.setText(personList.get(position).getField());
        Picasso.get().load(personList.get(position).getImageUrl()).resize(128, 128).into(myViewHolder.circleImageView);

        myViewHolder.itemLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, ContentActivity.class);
                intent.putExtra("ID",personList.get(position).getId());
                intent.putExtra("NAME",personList.get(position).getName());
                intent.putExtra("FIELD",personList.get(position).getField());
                intent.putExtra("DESCRIPTION",personList.get(position).getDescription());
                intent.putExtra("IMAGE",personList.get(position).getImageUrl());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return personList.size();
    }

    @SuppressLint("NotifyDataSetChanged")
    public void filterList(List<Person> filterList) {
        personList = filterList;
        notifyDataSetChanged();
    }

    public class ItemViewHolder extends RecyclerView.ViewHolder {
        private final CircleImageView circleImageView;
        private final TextView name, filed;
        private final RelativeLayout itemLayout;

        public ItemViewHolder(@NonNull View itemView) {
            super(itemView);

            circleImageView = itemView.findViewById(R.id.item_main_img_id);
            name = itemView.findViewById(R.id.item_name_id);
            filed = itemView.findViewById(R.id.item_def_id);
            itemLayout = itemView.findViewById(R.id.item_root_id);

        }
    }
}
