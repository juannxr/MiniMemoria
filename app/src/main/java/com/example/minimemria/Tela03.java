package com.example.minimemria;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class Tela03 extends AppCompatActivity implements View.OnClickListener{

    private TextView texto;
    private boolean flag;

    private ImageView img1, img2, img3, img4, img5, img6, img7, img8, imgPrimeiroToque, imgSegundoToque;

    private LinearLayout l;

    private Button btn3, btn4;

    private String nome;

    private int imagemPrimeiroToque, imagemSegundoToque, ContaToque, paresEncontrados, vezes;
    private ArrayList<Integer> lista;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_tela03);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        l = findViewById(R.id.linearcima);
        texto = findViewById(R.id.textView3);
        btn3 = findViewById(R.id.button3);
        btn3.setOnClickListener(this);
        btn4 = findViewById(R.id.button4);
        btn4.setOnClickListener(this);
        Intent i = new Intent();
        i = getIntent();
        if(i !=null){
            //Significa que não veio corrompido
            Bundle caixa = new Bundle();
            caixa = i.getExtras();
            if(caixa != null){
                //Significa que a caixa veio corrompida
                nome = caixa.getString("nome");
                texto.setText(nome);
            }
        }

        vezes = 1;

        img1 = findViewById(R.id.imageView1);
        img2 = findViewById(R.id.imageView2);
        img3 = findViewById(R.id.imageView3);
        img4 = findViewById(R.id.imageView4);
        img5 = findViewById(R.id.imageView5);
        img6 = findViewById(R.id.imageView6);
        img7 = findViewById(R.id.imageView7);
        img8 = findViewById(R.id.imageView8);
        img1.setOnClickListener(this);
        img2.setOnClickListener(this);
        img3.setOnClickListener(this);
        img4.setOnClickListener(this);
        img5.setOnClickListener(this);
        img6.setOnClickListener(this);
        img7.setOnClickListener(this);
        img8.setOnClickListener(this);
        lista = new ArrayList<>();
        lista.add(R.drawable.ic_action_name_4);
        lista.add(R.drawable.ic_action_name_4);
        lista.add(R.drawable.ic_action_name_5);
        lista.add(R.drawable.ic_action_name_5);
        lista.add(R.drawable.ic_action_name_3);
        lista.add(R.drawable.ic_action_name_3);
        lista.add(R.drawable.ic_action_name);
        lista.add(R.drawable.ic_action_name);
        imgPrimeiroToque = new ImageView(this);
      imgSegundoToque = new ImageView(this);
      carregaTudo();
    }
    public void carregaTudo(){
        img1.setEnabled(false);
        img2.setEnabled(false);
        img3.setEnabled(false);
        img4.setEnabled(false);
        img5.setEnabled(false);
        img6.setEnabled(false);
        img7.setEnabled(false);
        img8.setEnabled(false);
        Collections.shuffle(lista);
        img1.setImageResource(lista.get(0));
        img2.setImageResource(lista.get(1));
        img3.setImageResource(lista.get(2));
        img4.setImageResource(lista.get(3));
        img5.setImageResource(lista.get(4));
        img6.setImageResource(lista.get(5));
        img7.setImageResource(lista.get(6));
        img8.setImageResource(lista.get(7));
        Handler handler = new Handler();
        ;handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                img1.setImageResource(R.drawable.ic_action_name_2);
                img2.setImageResource(R.drawable.ic_action_name_2);
                img3.setImageResource(R.drawable.ic_action_name_2);
                img4.setImageResource(R.drawable.ic_action_name_2);
                img5.setImageResource(R.drawable.ic_action_name_2);
                img6.setImageResource(R.drawable.ic_action_name_2);
                img7.setImageResource(R.drawable.ic_action_name_2);
                img8.setImageResource(R.drawable.ic_action_name_2);
                img1.setEnabled(true);
                img2.setEnabled(true);
                img3.setEnabled(true);
                img4.setEnabled(true);
                img5.setEnabled(true);
                img6.setEnabled(true);
                img7.setEnabled(true);
                img8.setEnabled(true);
            }
        }, 2000);

        ContaToque = 0;
    }

    public void compare(int imagem1, int imagem2){
        flag = false;


        if(imagem1 == imagem2){
           flag=true;
            imgPrimeiroToque.setEnabled(false);
            imgPrimeiroToque.setBackgroundColor(Color.parseColor("#159D1E"));
            imgSegundoToque.setEnabled(false);
            imgSegundoToque.setBackgroundColor(Color.parseColor("#159D1E"));
            paresEncontrados++;
            if(paresEncontrados == 4){
                l.setBackgroundColor(Color.parseColor("#159D1E"));

            }
        }else{
            imgPrimeiroToque.setBackgroundColor(Color.RED);
            imgPrimeiroToque.setEnabled(true);
            imgSegundoToque.setBackgroundColor(Color.RED);
            imgSegundoToque.setEnabled(true);
            Handler h = new Handler();
            h.postDelayed(new Runnable() {
                @Override
                public void run() {
                    imgPrimeiroToque.setImageResource(R.drawable.ic_action_name_2);
                    imgSegundoToque.setImageResource(R.drawable.ic_action_name_2);
                    imgPrimeiroToque.setBackgroundColor(Color.parseColor("#B11313"));
                    imgSegundoToque.setBackgroundColor(Color.parseColor("#B11313"));
                }
            },1500);
        }
        ContaToque = 0;
        Handler h1 = new Handler();
        h1.postDelayed(new Runnable() {
            @Override
            public void run() {
                if((imgPrimeiroToque != img1)){
                    img1.setEnabled(true);
                }
                if(imgPrimeiroToque != img2){
                    img2.setEnabled(true);
                }
                if(imgPrimeiroToque != img3){
                    img3.setEnabled(true);
                }
                if(imgPrimeiroToque != img4){
                    img4.setEnabled(true);
                }
                if(imgPrimeiroToque != img5){
                    img5.setEnabled(true);
                }
                if(imgPrimeiroToque != img6){
                    img7.setEnabled(true);
                }
                if(imgPrimeiroToque != img8){
                    img8.setEnabled(true);
                }

                if(imgSegundoToque != img1){
                    img1.setEnabled(true);
                }
                if(imgSegundoToque != img2){
                    img2.setEnabled(true);
                }
                if(imgSegundoToque != img3){
                    img3.setEnabled(true);
                }
                if(imgSegundoToque != img4){
                    img4.setEnabled(true);
                }
                if(imgSegundoToque != img5){
                    img5.setEnabled(true);
                }
                if(imgSegundoToque != img6){
                    img6.setEnabled(true);
                }
                if(imgSegundoToque != img7){
                    img7.setEnabled(true);
                }
                if(imgSegundoToque != img8){
                    img8.setEnabled(true);
                }


                if(flag)
                {
                    imgPrimeiroToque.setEnabled(false);
                    imgSegundoToque.setEnabled(false);
                }
            }
        }, 3000);
    }

    @Override
    public void onClick(View v) {
        ContaToque++;
        if(ContaToque == 2){
            img1.setEnabled(false);
            img2.setEnabled(false);
            img3.setEnabled(false);
            img4.setEnabled(false);
            img5.setEnabled(false);
            img6.setEnabled(false);
            img7.setEnabled(false);
            img8.setEnabled(false);
        }
    if(v == img1){
        img1.setImageResource(lista.get(0));
        if(ContaToque==1){
            imgPrimeiroToque = img1;
            imagemPrimeiroToque = lista.get(0);
            img1.setEnabled(false);
        }else{
            imgSegundoToque = img1;
            imagemSegundoToque = lista.get(0);
            compare(imagemPrimeiroToque, imagemSegundoToque);
            ContaToque = 0;
        }
    }
    if(v == img2){
        img2.setImageResource(lista.get(1));
        if(ContaToque==1){
            imgPrimeiroToque = img2;
            imagemPrimeiroToque = lista.get(1);
            img2.setEnabled(false);
        }else{
            imgSegundoToque = img2;
            imagemSegundoToque = lista.get(1);
            compare(imagemPrimeiroToque, imagemSegundoToque);
            ContaToque = 0;
        }
        }
    if(v == img3){
        img3.setImageResource(lista.get(2));
        if(ContaToque==1){
            imgPrimeiroToque = img3;
            imagemPrimeiroToque = lista.get(2);
            img3.setEnabled(false);
        }else{
            imgSegundoToque = img3;
            imagemSegundoToque = lista.get(2);
            compare(imagemPrimeiroToque, imagemSegundoToque);
            ContaToque = 0;
        }
        }
    if(v == img4) {
        img4.setImageResource(lista.get(3));
        if (ContaToque == 1) {
            imgPrimeiroToque = img4;
            imagemPrimeiroToque = lista.get(3);
            img4.setEnabled(false);
        } else {
            imgSegundoToque = img4;
            imagemSegundoToque = lista.get(3);
            compare(imagemPrimeiroToque, imagemSegundoToque);
            ContaToque = 0;
        }
    }
    if(v == img5) {
        img5.setImageResource(lista.get(4));
        if (ContaToque == 1) {
            imgPrimeiroToque = img5;
            imagemPrimeiroToque = lista.get(4);
            img5.setEnabled(false);
        } else {
            imgSegundoToque = img5;
            imagemSegundoToque = lista.get(4);
            compare(imagemPrimeiroToque, imagemSegundoToque);
            ContaToque = 0;
        }
    }
    if(v == img6) {
        img6.setImageResource(lista.get(5));
        if (ContaToque == 1) {
            imgPrimeiroToque = img6;
            imagemPrimeiroToque = lista.get(5);
            img6.setEnabled(false);
        } else {
            imgSegundoToque = img6;
            imagemSegundoToque = lista.get(5);
            compare(imagemPrimeiroToque, imagemSegundoToque);
            ContaToque = 0;
        }
    }
    if(v == img7) {
            img7.setImageResource(lista.get(6));
            if (ContaToque == 1) {
                imgPrimeiroToque = img7;
                imagemPrimeiroToque = lista.get(6);
                img7.setEnabled(false);
            } else {
                imgSegundoToque = img7;
                imagemSegundoToque = lista.get(6);
                compare(imagemPrimeiroToque, imagemSegundoToque);
                ContaToque = 0;
            }
        }
        if(v == img8) {
            img8.setImageResource(lista.get(7));
            if (ContaToque == 1) {
                imgPrimeiroToque = img8;
                imagemPrimeiroToque = lista.get(7);
                img8.setEnabled(false);
            } else {
                imgSegundoToque = img8;
                imagemSegundoToque = lista.get(7);
                compare(imagemPrimeiroToque, imagemSegundoToque);
                ContaToque = 0;
            }
        }
        if(v == btn3){
            vezes++;
            paresEncontrados = 0;
            carregaTudo();
            l.setBackgroundColor(Color.parseColor("#B11313"));
            img1.setBackgroundColor(Color.parseColor("#B11313"));
            img2.setBackgroundColor(Color.parseColor("#B11313"));
            img3.setBackgroundColor(Color.parseColor("#B11313"));
            img4.setBackgroundColor(Color.parseColor("#B11313"));
            img5.setBackgroundColor(Color.parseColor("#B11313"));
            img6.setBackgroundColor(Color.parseColor("#B11313"));
            img7.setBackgroundColor(Color.parseColor("#B11313"));
            img8.setBackgroundColor(Color.parseColor("#B11313"));
        }
        if(v == btn4){
            Intent i = new Intent(this, Tela04.class);
            Bundle caixa = new Bundle();
            caixa.putString("nome",nome);
            caixa.putInt("vezes",vezes);
            i.putExtras(caixa);
            startActivity(i);
        }
        }
    }
