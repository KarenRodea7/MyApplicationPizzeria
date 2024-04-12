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

public class Pizzas<sum1> extends AppCompatActivity {

    SharedPreferences preferences;

    ImageButton men1, men2, men3, mas1, mas2, mas3;
    Button menu, pagar;

    EditText opc1, opc2, opc3;
    TextView tot;

    int sum1, sum2, sum3;
    int hawa=90, pep=100, veg=80;
    int c1, c2, c3, totalp=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pizzas);

        men1 = (ImageButton)findViewById(R.id.m1);
        men2 = (ImageButton)findViewById(R.id.m2);
        men3 = (ImageButton)findViewById(R.id.m3);
        mas1 = (ImageButton)findViewById(R.id.M1);
        mas2 = (ImageButton)findViewById(R.id.M2);
        mas3 = (ImageButton)findViewById(R.id.M3);

        opc1 = (EditText)findViewById(R.id.Hawa);
        opc2 = (EditText)findViewById(R.id.Pep);
        opc3 = (EditText)findViewById(R.id.Veg);
        tot = (TextView) findViewById(R.id.totP);

        menu = (Button)findViewById(R.id.MenuP);
        pagar = (Button)findViewById(R.id.PagarP);

        leerOpc();



        men1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(sum1>0){
                    sum1--;
                    opc1.setText(String.valueOf(sum1));
                }
                guardarOpc1(sum1);
                c1=sum1*hawa;
                Total();
            }
        });
        mas1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sum1++;
                opc1.setText(String.valueOf(sum1));
                guardarOpc1(sum1);
                c1=sum1*hawa;
                Total();
            }
        });

        men2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(sum2>0){
                    sum2--;
                    opc2.setText(String.valueOf(sum2));
                }
                guardarOpc2(sum2);
                c2=sum2*pep;
                Total();
            }
        });
        mas2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sum2++;
                opc2.setText(String.valueOf(sum2));
                guardarOpc2(sum2);
                c2=sum2*pep;
                Total();
            }
        });

        men3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(sum3>0){
                    sum3--;
                    opc3.setText(String.valueOf(sum3));
                }
                guardarOpc3(sum3);
                c3=sum3*veg;
                Total();
            }
        });
        mas3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sum3++;
                opc3.setText(String.valueOf(sum3));
                guardarOpc3(sum3);
                c3=sum3*veg;
                Total();
            }
        });


        menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Menu.class);
                guardarOpc1(sum1);
                guardarOpc2(sum2);
                guardarOpc3(sum3);
                Total();
                guardarTotp(totalp);
                startActivity(intent);
            }
        });

        pagar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Pago.class);
                guardarOpc1(sum1);
                guardarOpc2(sum2);
                guardarOpc3(sum3);
                Total();
                guardarTotp(totalp);
                startActivity(intent);
            }
        });
    }

    private void guardarTotp(int totalp) {
        preferences=getSharedPreferences("Credenciales", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString("totp", String.valueOf(totalp));
        editor.commit();
    }

    private void Total() {
        guardarc1(c1);
        guardarc2(c2);
        guardarc3(c3);
        totalp=c1 +c2 + c3;
        tot.setText("Total: $ "+totalp);
    }

    private void guardarc3(int c3) {
        preferences=getSharedPreferences("Credenciales", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString("c3p", String.valueOf(c3));
        editor.commit();
    }

    private void guardarc2(int c2) {
        preferences=getSharedPreferences("Credenciales", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString("c2p", String.valueOf(c2));
        editor.commit();
    }

    private void guardarc1(int c1) {
        preferences=getSharedPreferences("Credenciales", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString("c1p", String.valueOf(c1));
        editor.commit();
    }

    private void guardarOpc3(int sum3) {
        preferences=getSharedPreferences("Credenciales", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString("opc3", String.valueOf(sum3));
        editor.commit();
    }

    private void guardarOpc2(int sum2) {
        preferences=getSharedPreferences("Credenciales", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString("opc2", String.valueOf(sum2));
        editor.commit();
    }

    private void guardarOpc1(int sum1) {
        preferences=getSharedPreferences("Credenciales", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString("opc1", String.valueOf(sum1));
        editor.commit();
    }

    private void leerOpc() {
        preferences = getSharedPreferences("Credenciales", Context.MODE_PRIVATE);
        sum1 = Integer.parseInt(preferences.getString("opc1", "0"));
        opc1.setText(String.valueOf(sum1));
        sum2 = Integer.parseInt(preferences.getString("opc2", "0"));
        opc2.setText(String.valueOf(sum2));
        sum3 = Integer.parseInt(preferences.getString("opc3", "0"));
        opc3.setText(String.valueOf(sum3));
    }

}