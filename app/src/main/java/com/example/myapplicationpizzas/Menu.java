package com.example.myapplicationpizzas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Menu extends AppCompatActivity {

    Button pizza, bebida;
    EditText user;

    SharedPreferences preferences;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        pizza = (Button)findViewById(R.id.Pizzas);
        bebida = (Button)findViewById(R.id.Bebidas);
        user = (EditText)findViewById(R.id.User);

        leerCredenciales();

        pizza.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Pizzas.class);
                startActivity(intent);
            }
        });

        bebida.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Bebidas.class);
                startActivity(intent);
            }
        });




    }

    private void leerCredenciales() {
        preferences = getSharedPreferences("Credenciales", Context.MODE_PRIVATE);
        String datos = preferences.getString("user","no hubo datos");
        user.setText(datos);
    }
}