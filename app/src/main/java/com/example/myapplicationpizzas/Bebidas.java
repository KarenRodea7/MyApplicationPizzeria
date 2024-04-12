package com.example.myapplicationpizzas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

public class Bebidas extends AppCompatActivity {
    SharedPreferences preferences;
    ImageButton men1, men2, men3, mas1, mas2, mas3;
    Button menu, pagar;
    EditText opcB1, opcB2, opcB3;
    TextView tot;
    int sum1, sum2, sum3;

    int coca=20, fan=17, spr=18;
    int c1=0, c2=0, c3=0, totalb;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bebidas);

        men1 = (ImageButton)findViewById(R.id.R1);
        men2 = (ImageButton)findViewById(R.id.R2);
        men3 = (ImageButton)findViewById(R.id.R3);
        mas1 = (ImageButton)findViewById(R.id.S1);
        mas2 = (ImageButton)findViewById(R.id.S2);
        mas3 = (ImageButton)findViewById(R.id.S3);

        opcB1 = (EditText)findViewById(R.id.CC);
        opcB2 = (EditText)findViewById(R.id.fanta);
        opcB3 = (EditText)findViewById(R.id.Sprite);
        tot = (TextView) findViewById(R.id.totB);

        menu = (Button)findViewById(R.id.MenuB);
        pagar = (Button)findViewById(R.id.PagarB);

        leerOpc();

        men1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(sum1>0){
                    sum1--;
                    opcB1.setText(String.valueOf(sum1));
                }
                guardarOpc1(sum1);
                c1= sum1*coca;
                Total();
            }
        });
        mas1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sum1++;
                opcB1.setText(String.valueOf(sum1));
                guardarOpc1(sum1);
                c1= sum1*coca;
                Total();
            }
        });

        men2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(sum2>0){
                    sum2--;
                    opcB2.setText(String.valueOf(sum2));
                }
                guardarOpc2(sum2);
                c2= sum2*fan;
                Total();
            }
        });
        mas2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sum2++;
                opcB2.setText(String.valueOf(sum2));
                guardarOpc2(sum2);

                c2= sum2*fan;
                Total();
            }
        });

        men3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(sum3>0){
                    sum3--;
                    opcB3.setText(String.valueOf(sum3));
                }
                guardarOpc3(sum3);
                c3= sum3*spr;
                Total();
            }
        });
        mas3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sum3++;
                opcB3.setText(String.valueOf(sum3));
                guardarOpc3(sum3);
                c3= sum3*spr;
                Total();
            }
        });


        menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Menu.class);
                startActivity(intent);
            }
        });

        pagar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Pago.class);
                startActivity(intent);
            }
        });


    }

    private void Total() {
        totalb=c1 +c2 + c3;
        tot.setText("Total: $ "+totalb);
    }

    private void guardarOpc3(int sum3) {
        preferences=getSharedPreferences("Credenciales", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString("opcB3", String.valueOf(sum3));
        editor.commit();
    }

    private void guardarOpc2(int sum2) {
        preferences=getSharedPreferences("Credenciales", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString("opcB2", String.valueOf(sum2));
        editor.commit();
    }

    private void guardarOpc1(int sum1) {
        preferences=getSharedPreferences("Credenciales", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString("opcB1", String.valueOf(sum1));
        editor.commit();
    }

    private void leerOpc() {
        preferences = getSharedPreferences("Credenciales", Context.MODE_PRIVATE);
        sum1 = Integer.parseInt(preferences.getString("opcB1", "0"));
        opcB1.setText(String.valueOf(sum1));
        sum2 = Integer.parseInt(preferences.getString("opcB2", "0"));
        opcB2.setText(String.valueOf(sum2));
        sum3 = Integer.parseInt(preferences.getString("opcB3", "0"));
        opcB3.setText(String.valueOf(sum3));
    }

}