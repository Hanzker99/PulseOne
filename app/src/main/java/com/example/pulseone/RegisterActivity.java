package com.example.pulseone;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class RegisterActivity extends AppCompatActivity {

    private EditText editTextPassword;
    private EditText editTextPasswordConfirm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        editTextPassword = findViewById(R.id.editTextPassword);
        editTextPasswordConfirm = findViewById(R.id.editTextPasswordConfirm);
        Button buttonRegister = findViewById(R.id.buttonRegister);
        Button buttonBack = findViewById(R.id.buttonBack);
        Button buttonConfirm = findViewById(R.id.buttonConfirm);

        buttonRegister.setOnClickListener(v -> {
            // Logica pentru înregistrarea utilizatorului
            // ...

            // Afisare mesaj de confirmare
            Toast.makeText(RegisterActivity.this, "Contul a fost creat cu succes", Toast.LENGTH_SHORT).show();

            // Redirectionare către activitatea de autentificare (MainActivity)
            Intent intent = new Intent(RegisterActivity.this, MainActivity.class);
            startActivity(intent);
        });

        buttonBack.setOnClickListener(v -> {
            // Redirectionare către activitatea principală (MainActivity)
            Intent intent = new Intent(RegisterActivity.this, MainActivity.class);
            startActivity(intent);
        });

        buttonConfirm.setOnClickListener(v -> {
            String password = editTextPassword.getText().toString();
            String confirmPassword = editTextPasswordConfirm.getText().toString();

            if (password.equals(confirmPassword)) {
                // Parolele coincid
                Toast.makeText(RegisterActivity.this, "Parola a fost confirmată", Toast.LENGTH_SHORT).show();
                // Aici poți adăuga codul pentru înregistrarea utilizatorului
            } else {
                // Parolele nu coincid
                Toast.makeText(RegisterActivity.this, "Parolele nu coincid", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
