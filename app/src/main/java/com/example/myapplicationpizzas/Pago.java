package com.example.myapplicationpizzas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Pago extends AppCompatActivity {

    SharedPreferences preferences;

    EditText user;
    TextView Totalf, C1,C2,C3,C4,C5,C6;
    Button menu, pagar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pago);

        user = (EditText)findViewById(R.id.User);
        menu = (Button)findViewById(R.id.MenuP);
        pagar = (Button)findViewById(R.id.PagarP);
        Totalf = (TextView) findViewById(R.id.TotalF);

        C1 = (TextView)findViewById(R.id.C1);
        C2 = (TextView)findViewById(R.id.C2);
        C3 = (TextView)findViewById(R.id.C3);
        C4 = (TextView)findViewById(R.id.C4);
        C5 = (TextView)findViewById(R.id.C5);
        C6 = (TextView)findViewById(R.id.C6);

        leerCredenciales();

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
                //if(Total>0){
                    Toast.makeText(getApplicationContext(), "Gracias por tu compra "+preferences.getString("user","No hay datos"), Toast.LENGTH_LONG).show();
                //}
            }
        });
    }

    private void leerCredenciales() {
        preferences = getSharedPreferences("Credenciales", Context.MODE_PRIVATE);
        String datos = preferences.getString("user","no hubo datos");
        user.setText(datos);
        sum1 = Integer.parseInt(preferences.getString("opc1", "0"));
        C1.setText(String.valueOf(sum1));
        sum2 = Integer.parseInt(preferences.getString("opc2", "0"));
        C2.setText(String.valueOf(sum2));
        sum3 = Integer.parseInt(preferences.getString("opc3", "0"));
        C3.setText(String.valueOf(sum3));

    }
}