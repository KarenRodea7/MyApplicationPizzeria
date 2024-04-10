package com.example.myapplicationpizzas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btnIniciar;
    EditText user, pass;
    SharedPreferences preferences;

    int sum = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnIniciar = (Button) findViewById(R.id.Iniciar);
        user = (EditText)findViewById(R.id.User);
        pass = (EditText)findViewById(R.id.Pass);
        btnIniciar.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                if(sum<3){
                    sum = sum + 1;

                    Intent intent = new Intent(getApplicationContext(), Menu.class);
                    String datos = user.getText().toString();
                    guardarMensaje(datos);
                    String contr = pass.getText().toString();

                    if(datos.equals("Pizzario1") & contr.equals("PizzaPass")){
                        startActivity(intent);
                    }else {
                        Toast.makeText(getApplicationContext(),"Cuenta o contraseña incorrectos, te quedan:  " +(3-sum)+" intentos",Toast.LENGTH_SHORT).show();
                    }
                }else{
                    Toast.makeText(getApplicationContext(),"Excediste tus oportunidades",Toast.LENGTH_SHORT).show();
                    btnIniciar.setEnabled(false);
                }
            }
        });
    }

    private void guardarMensaje(String datos) {
        preferences=getSharedPreferences("Credenciales", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString("user",datos);
        editor.commit();
    }
}