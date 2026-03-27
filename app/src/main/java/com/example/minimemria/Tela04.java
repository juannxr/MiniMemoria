package com.example.minimemria;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Tela04 extends AppCompatActivity {
    private TextView texto, vezes;
    private String nome;
    private int vezesJogadas;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_tela04);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        texto = findViewById(R.id.textView10);
        vezes = findViewById(R.id.textView11);

        Intent i = new Intent();
        i = getIntent();
        if(i !=null){
            Bundle caixa = new Bundle();
            caixa = i.getExtras();
            if(caixa != null){
                nome = caixa.getString("nome");
                vezesJogadas = caixa.getInt("vezes");
                texto.setText(nome);
                vezes.setText(Integer.toString(vezesJogadas));
            }
        }

    }
}