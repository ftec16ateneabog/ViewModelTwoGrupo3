package com.atenea.viewmodeltwo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SumaSimple extends AppCompatActivity {

    private TextView contadorTextView;
    private Button sumaButton;
    int cuenta = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_suma_simple);
        contadorTextView = findViewById(R.id.ContadorTextView);
        sumaButton = findViewById(R.id.SumaButton);

        sumaButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cuenta += 1;
                contadorTextView.setText(String.valueOf(cuenta));
            }
        });

    }
}