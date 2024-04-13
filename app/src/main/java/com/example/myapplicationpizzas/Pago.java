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
    TextView Totalf, C1,C2,C3,C4,C5,C6, p1, p2, p3, p4, p5, p6;
    Button pagar;

    int totb, totp, totf;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pago);

        user = (EditText)findViewById(R.id.User);
        //menu = (Button)findViewById(R.id.MenuP);
        pagar = (Button)findViewById(R.id.PagarP);
        Totalf = (TextView) findViewById(R.id.TotalF);

        C1 = (TextView)findViewById(R.id.C1);
        C2 = (TextView)findViewById(R.id.C2);
        C3 = (TextView)findViewById(R.id.C3);
        C4 = (TextView)findViewById(R.id.C4);
        C5 = (TextView)findViewById(R.id.C5);
        C6 = (TextView)findViewById(R.id.C6);

        p1 = (TextView)findViewById(R.id.PH);
        p2 = (TextView)findViewById(R.id.PP);
        p3 = (TextView)findViewById(R.id.PV);
        p4 = (TextView)findViewById(R.id.PC);
        p5 = (TextView)findViewById(R.id.PF);
        p6 = (TextView)findViewById(R.id.PS);

        leerCredenciales();

        totf = totb + totp;
        Totalf.setText("Total: $ "+totf);

        /*menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Menu.class);
                startActivity(intent);
            }
        });*/

        pagar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //if(Total>0){
                Intent intent = new Intent(getApplicationContext(), Menu.class);

                Toast.makeText(getApplicationContext(), "Gracias por tu compra "+preferences.getString("user","No hay datos"), Toast.LENGTH_LONG).show();
                startActivity(intent);
                //}
            }
        });
    }

    private void leerCredenciales() {
        preferences = getSharedPreferences("Credenciales", Context.MODE_PRIVATE);
        String datos = preferences.getString("user","no hubo datos");
        user.setText(datos);
        int sum1 = Integer.parseInt(preferences.getString("opc1", "0"));
        C1.setText(String.valueOf(sum1));
        int sum2 = Integer.parseInt(preferences.getString("opc2", "0"));
        C2.setText(String.valueOf(sum2));
        int sum3 = Integer.parseInt(preferences.getString("opc3", "0"));
        C3.setText(String.valueOf(sum3));
        sum1 = Integer.parseInt(preferences.getString("opcB1", "0"));
        C4.setText(String.valueOf(sum1));
        sum2 = Integer.parseInt(preferences.getString("opcB2", "0"));
        C5.setText(String.valueOf(sum2));
        sum3 = Integer.parseInt(preferences.getString("opcB3", "0"));
        C6.setText(String.valueOf(sum3));
        totb = Integer.parseInt(preferences.getString("totb", "0"));
        totp = Integer.parseInt(preferences.getString("totp", "0"));
        int c1 = Integer.parseInt(preferences.getString("c1p", "0"));
        p1.setText(String.valueOf(c1));
        int c2 = Integer.parseInt(preferences.getString("c2p", "0"));
        p2.setText(String.valueOf(c2));
        int c3 = Integer.parseInt(preferences.getString("c3p", "0"));
        p3.setText(String.valueOf(c3));
        c1 = Integer.parseInt(preferences.getString("c1b", "0"));
        p4.setText(String.valueOf(c1));
        c2 = Integer.parseInt(preferences.getString("c2b", "0"));
        p5.setText(String.valueOf(c2));
        c3 = Integer.parseInt(preferences.getString("c3b", "0"));
        p6.setText(String.valueOf(c3));
    }
}