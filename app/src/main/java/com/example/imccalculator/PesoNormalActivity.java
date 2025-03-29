package com.example.imccalculator;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class PesoNormalActivity extends AppCompatActivity {

    TextView txtPeso, txtAltura, txtIMC, txtCategoria, txtMensagem;
    ImageView imgCategoria;
    Button btnFechar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_peso_normal);

        txtPeso = findViewById(R.id.txtPeso);
        txtAltura = findViewById(R.id.txtAltura);
        txtIMC = findViewById(R.id.txtIMC);
        txtCategoria = findViewById(R.id.txtCategoria);
        txtMensagem = findViewById(R.id.txtMensagem);
        imgCategoria = findViewById(R.id.imgCategoria);
        btnFechar = findViewById(R.id.btnFechar);

        float peso = getIntent().getFloatExtra("peso", 0);
        float altura = getIntent().getFloatExtra("altura", 0);
        float imc = getIntent().getFloatExtra("imc", 0);

        txtPeso.setText("Peso: " + peso + " kg");
        txtAltura.setText("Altura: " + altura + " m");
        txtIMC.setText("IMC: " + String.format("%.2f", imc));
        txtCategoria.setText("Categoria: Peso normal");

        imgCategoria.setImageResource(R.drawable.abaixo_peso_image); // Adicione sua imagem aqui
        txtMensagem.setText("Parabéns! Continue mantendo um estilo de vida saudável.");

        btnFechar.setOnClickListener(v -> {
            Intent intent = new Intent(PesoNormalActivity.this, MainActivity.class);
            startActivity(intent);
            finish();
        });
    }
}
