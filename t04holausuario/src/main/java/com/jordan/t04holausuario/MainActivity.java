package com.jordan.t04holausuario;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button buttonMainSendName = findViewById(R.id.buttonMainSendName);
        TextView textViewMainName = findViewById(R.id.textViewMainName);
        TextView editTextMainName = findViewById(R.id.editTextMainName);

        editTextMainName.setOnClickListener(view -> {
            textViewMainName.setText("Escribe tu nombre");
            textViewMainName.setTextColor(Color.parseColor("#FF000000"));
        });

        buttonMainSendName.setOnClickListener(view -> {
            if (editTextMainName.getText().toString().isEmpty()) {
                textViewMainName.setText("Escribe tu nombre (no puede estar vacío)");
                textViewMainName.setTextColor(Color.parseColor("#C75450"));
                return;
            }
//            textViewMainName.setTextColor(Color.parseColor("#C75450"));

            Bundle bundle = new Bundle();

            bundle.putString("nombre", editTextMainName.getText().toString());

            Intent intent = new Intent(this, GreetingActivity.class);
            intent.putExtras(bundle);

            startActivity(intent);

        });
    }
}