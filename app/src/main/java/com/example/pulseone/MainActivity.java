package com.example.pulseone;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.simplexml.SimpleXmlConverterFactory;

import androidx.appcompat.app.AppCompatActivity;

import java.io.IOException;

public class MainActivity<LoginResponse> extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       TextView editTextEmail = findViewById(R.id.editTextEmail);
       TextView editTextPassword = findViewById(R.id.editTextPassword);
        Button buttonLogin = findViewById(R.id.buttonLogin);
        Button buttonRegister = findViewById(R.id.buttonRegister);

        buttonLogin.setOnClickListener(v -> {
            // Obțineți valorile introduse în câmpurile de e-mail și parolă
            String email = editTextEmail.getText().toString();
            String parola = editTextPassword.getText().toString();

            // Construiți obiectul de cerere XML pentru login
            String requestXml = "<?xml version=\"1.0\" encoding=\"ISO-8859-1\"?>\n" +
                    "<loginPacient>\n" +
                    "<user_email>" + email + "</user_email>\n" +
                    "<password>" + parola + "</password>\n" +
                    "</loginPacient>";

            // Creați instanța Retrofit
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl("https://pulseone.presta.ro/")
                    .addConverterFactory(SimpleXmlConverterFactory.create())
                    .build();

            // Creați instanța serviciului ApiService utilizând Retrofit
            ApiService apiService = retrofit.create(ApiService.class);

            // Realizați cererea de login
            Call<LoginResponse> call = (Call<LoginResponse>) apiService.login(requestXml).clone();
            call.enqueue(new Callback<LoginResponse>() {
                @Override
                public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                    if (response.isSuccessful()) {
                        // Răspunsul de succes de la server
                        // Redirecționează către activitatea HomeActivity
                        Intent intent = new Intent(MainActivity.this, HomeActivity.class);
                        startActivity(intent);
                    } else {
                        // Răspunsul de eroare de la server
                        // Tratează eroarea în consecință
                        if (response.errorBody() != null) {
                            try {
                                String errorXml = response.errorBody().string();
                                // Aici poți trata răspunsul de eroare XML
                                // Poți extrage informațiile relevante din XML și afișa un mesaj de eroare
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        } else {
                            // Nu s-a primit un răspuns de eroare valid din partea serverului
                            // Tratează această situație în consecință
                        }
                    }
                }

                @Override
                public void onFailure(Call<LoginResponse> call, Throwable t) {

                }
            });
        });
    }
}
