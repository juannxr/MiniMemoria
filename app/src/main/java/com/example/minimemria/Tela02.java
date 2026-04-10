package com.example.minimemria;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.text.method.Touch;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Tela02 extends AppCompatActivity implements View.OnClickListener {

    private Button btn;
    private EditText textNome,textIdade;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_tela02);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        btn = findViewById(R.id.button2);
        btn.setOnClickListener(this);
        textNome = findViewById(R.id.editTextText5);
        textIdade = findViewById(R.id.editTextText6);
    }

    @SuppressLint("NewApi")
    @Override
    public void onClick(View v) {
        if(v == btn){
   if(!textNome.getText().isEmpty() && !textIdade.getText().isEmpty()){
    Intent i = new Intent(this, Tela03.class);
    Bundle caixa = new Bundle();
    caixa.putString("nome", textNome.getText().toString());
    i.putExtras(caixa);
    startActivity(i);
}else{
       Toast.makeText(this,"*Campo obrigatório",Toast.LENGTH_SHORT).show();

   }
        }
    }
}