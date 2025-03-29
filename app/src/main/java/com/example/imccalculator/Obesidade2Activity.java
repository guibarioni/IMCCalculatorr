package com.example.imccalculator;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class Obesidade2Activity extends AppCompatActivity {

    TextView txtPeso, txtAltura, txtIMC, txtCategoria, txtMensagem;
    ImageView imgCategoria;
    Button btnFechar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_obesidade2);

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
        txtCategoria.setText("Categoria: Obesidade Grau 2");

        imgCategoria.setImageResource(R.drawable.abaixo_peso_image);
        txtMensagem.setText("Obesidade Grau 2 é um quadro grave que pode afetar a saúde. Procure orientação médica.");

        btnFechar.setOnClickListener(v -> {
            Intent intent = new Intent(Obesidade2Activity.this, MainActivity.class);
            startActivity(intent);
            finish();
        });
    }
}
