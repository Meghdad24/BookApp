package com.training.one.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.squareup.picasso.Picasso;
import com.training.one.R;

import de.hdodenhof.circleimageview.CircleImageView;

public class ContentActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageView backBtn;
    private CircleImageView imageTop;
    private TextView field, description, name;
    private FloatingActionButton likeBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_content);

        setupViews();
        getAndSetData();
        backBtn.setOnClickListener(this);
        likeBtn.setOnClickListener(this);
    }

    private void getAndSetData() {
        name.setText(getIntent().getExtras().getString("NAME"));
        field.setText(getIntent().getExtras().getString("FIELD"));
        description.setText(getIntent().getExtras().getString("DESCRIPTION"));
        Picasso.get().load(getIntent().getExtras().getString("IMAGE")).resize(128, 128).into(imageTop);
    }

    private void setupViews() {
        backBtn = findViewById(R.id.content_back_id);
        imageTop = findViewById(R.id.content_main_img_id);
        field = findViewById(R.id.content_name_def_id);
        description = findViewById(R.id.content_definition_id);
        name = findViewById(R.id.content_name_id);
        likeBtn = findViewById(R.id.content_like_button_id);
    }

    @Override
    public void onClick(View view) {
        int viewID = view.getId();

        switch (viewID) {
            case R.id.content_back_id:
                onBackPressed();
                break;
            case R.id.content_like_button_id:
                break;
        }
    }
}