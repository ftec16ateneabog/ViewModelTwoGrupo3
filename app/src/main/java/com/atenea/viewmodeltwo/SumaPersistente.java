package com.atenea.viewmodeltwo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.atenea.viewmodeltwo.Persistencia.MyViewModel;

public class SumaPersistente extends AppCompatActivity {

    private TextView contadorTextView;
    private Button sumaButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_suma_persistente);

        ViewConfiguration();
    }

    private void ViewConfiguration() {
        MyViewModel myViewModel = new ViewModelProvider(this).get(MyViewModel.class);

        contadorTextView = findViewById(R.id.ContadorTextViewPersistencia);
        sumaButton = findViewById(R.id.SumaButtonPersistencia);

        sumaButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myViewModel.aumentar(Integer.parseInt(contadorTextView.getText().toString()));
            }
        });

        Observer<Integer> observer = new Observer<Integer>() {
            @Override
            public void onChanged(Integer result) {
                contadorTextView.setText(String.valueOf(result));
            }
        };

        myViewModel.getResultado().observe(this,observer);

    }
}