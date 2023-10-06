package com.jordan.t04holausuario;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class GreetingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_greeting);

        TextView textViewGreeting = findViewById(R.id.textViewGreeting);
        Bundle bundle = getIntent().getExtras();

        if (bundle != null) {
            String nombre = bundle.getString("nombre");

            textViewGreeting.setText("Hola " + nombre);


        }
    }
}