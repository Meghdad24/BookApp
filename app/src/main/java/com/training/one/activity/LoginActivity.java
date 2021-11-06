package com.training.one.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.training.one.R;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText name;
    private Button next;
    private Boolean isLogin = false;
    private final static String LOGIN = "login";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        setupViews();
    }

    private void setupViews() {
        name = findViewById(R.id.login_et_name);
        next = findViewById(R.id.login_enter_button);
        next.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.login_enter_button) {
            nameValidation();
        }
    }

    private void nameValidation() {
        String nameTxt = name.getText().toString().trim();

        if (nameTxt.isEmpty()) {
            Toast.makeText(this,"نام خود را وارد کنید!",Toast.LENGTH_SHORT).show();
        } else {
            saveName(nameTxt);
        }
    }

    private void saveName(String nameTxt) {
        isLogin = true;

        SharedPreferences sharedPreferences = getSharedPreferences(LOGIN,MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("NAME",nameTxt);
        editor.putBoolean("IS_LOGIN",isLogin);
        editor.apply();

        goToHomePage();

    }

    private void goToHomePage() {
        startActivity(new Intent(this, MainActivity.class));
        finish();
    }
}