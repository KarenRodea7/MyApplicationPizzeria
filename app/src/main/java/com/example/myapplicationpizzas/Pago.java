package com.example.myapplicationpizzas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.EditText;

public class Pago extends AppCompatActivity {

    SharedPreferences preferences;

    EditText user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pago);

        user = (EditText)findViewById(R.id.User);
        leerCredenciales();
    }

    private void leerCredenciales() {
        preferences = getSharedPreferences("Credenciales", Context.MODE_PRIVATE);
        String datos = preferences.getString("user","no hubo datos");
        user.setText(datos);
    }
}