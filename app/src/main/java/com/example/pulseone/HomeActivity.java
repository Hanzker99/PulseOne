package com.example.pulseone;

import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class HomeActivity extends AppCompatActivity {
    @Override
    public void onBackPressed() {
        // Adăugați aici logica suplimentară, dacă este necesară,
        // înainte de a apela metoda super.onBackPressed()

        super.onBackPressed();
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        Button buttonECG = findViewById(R.id.buttonECG);
        Button buttonUmiditate = findViewById(R.id.buttonUmiditate);
        Button buttonTemperatura = findViewById(R.id.buttonTemperatura);
        findViewById(R.id.buttonPuls);
        Button buttonBack = findViewById(R.id.buttonBack);
        buttonBack.setOnClickListener(v -> onBackPressed());


        buttonECG.setOnClickListener(v -> {
            // Logica pentru afișarea stării ECG a pacientului
        });

        buttonUmiditate.setOnClickListener(v -> {
            // Logica pentru afișarea stării de umiditate a pacientului
        });

        buttonTemperatura.setOnClickListener(v -> {
            // Logica pentru afișarea stării de temperatură a pacientului
        });
    }
}

