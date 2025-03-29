package com.example.imccalculator;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

import com.example.imccalculator.AbaixoDoPesoActivity;
import com.example.imccalculator.Obesidade1Activity;
import com.example.imccalculator.Obesidade2Activity;
import com.example.imccalculator.Obesidade3Activity;
import com.example.imccalculator.PesoNormalActivity;
import com.example.imccalculator.R;
import com.example.imccalculator.SobrePesoActivity;
import com.example.imccalculator.SobrePesoActivity;

public class CalculoIMCActivity extends AppCompatActivity {

    EditText editPeso, editAltura;
    Button btnCalcularIMC, btnLimpar, btnFechar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculo_imc);

        editPeso = findViewById(R.id.editPeso);
        editAltura = findViewById(R.id.editAltura);
        btnCalcularIMC = findViewById(R.id.btnCalcularIMC);
        btnLimpar = findViewById(R.id.btnLimpar);
        btnFechar = findViewById(R.id.btnFechar);

        btnCalcularIMC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calcularIMC();
            }
        });

        btnLimpar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editPeso.setText("");
                editAltura.setText("");
            }
        });

        btnFechar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void calcularIMC() {
        String pesoStr = editPeso.getText().toString();
        String alturaStr = editAltura.getText().toString();

        if (pesoStr.isEmpty() || alturaStr.isEmpty()) {
            Toast.makeText(this, "Por favor, insira o peso e a altura.", Toast.LENGTH_SHORT).show();
            return;
        }

        float peso = Float.parseFloat(pesoStr);
        float altura = Float.parseFloat(alturaStr);

        float imc = peso / (altura * altura);

        String classificacao = "";
        if (imc < 18.5) {
            classificacao = "Abaixo do peso";
            irParaAbaixoDoPeso(peso, altura, imc, classificacao);  // Navega para AbaixoDoPesoActivity
        } else if (imc >= 18.5 && imc < 25) {
            classificacao = "Peso normal";
            irParaPesoNormal(peso, altura, imc, classificacao); // Navega para PesoNormalActivity
        } else if (imc >= 25 && imc < 30) {
            classificacao = "Sobrepeso";
            irParaSobrepeso(peso, altura, imc, classificacao); // Navega para SobrepesoActivity
        } else if (imc >= 30 && imc < 35) {
            classificacao = "Obesidade grau 1";
            irParaObesidade1(peso, altura, imc, classificacao); // Navega para Obesidade1Activity
        } else if (imc >= 35 && imc < 40) {
            classificacao = "Obesidade grau 2";
            irParaObesidade2(peso, altura, imc, classificacao); // Navega para Obesidade2Activity
        } else if (imc >= 40) {
            classificacao = "Obesidade grau 3";
            irParaObesidade3(peso, altura, imc, classificacao); // Navega para Obesidade3Activity
        }
    }

    private void irParaAbaixoDoPeso(float peso, float altura, float imc, String classificacao) {
        Intent intent = new Intent(CalculoIMCActivity.this, AbaixoDoPesoActivity.class);
        intent.putExtra("peso", peso);
        intent.putExtra("altura", altura);
        intent.putExtra("imc", imc);
        startActivity(intent);
    }

    private void irParaPesoNormal(float peso, float altura, float imc, String classificacao) {
        Intent intent = new Intent(CalculoIMCActivity.this, PesoNormalActivity.class);
        intent.putExtra("peso", peso);
        intent.putExtra("altura", altura);
        intent.putExtra("imc", imc);
        startActivity(intent);
    }

    private void irParaSobrepeso(float peso, float altura, float imc, String classificacao) {
        Intent intent = new Intent(CalculoIMCActivity.this, SobrePesoActivity.class);
        intent.putExtra("peso", peso);
        intent.putExtra("altura", altura);
        intent.putExtra("imc", imc);
        startActivity(intent);
    }

    private void irParaObesidade1(float peso, float altura, float imc, String classificacao) {
        Intent intent = new Intent(CalculoIMCActivity.this, Obesidade1Activity.class);
        intent.putExtra("peso", peso);
        intent.putExtra("altura", altura);
        intent.putExtra("imc", imc);
        startActivity(intent);
    }

    private void irParaObesidade2(float peso, float altura, float imc, String classificacao) {
        Intent intent = new Intent(CalculoIMCActivity.this, Obesidade2Activity.class);
        intent.putExtra("peso", peso);
        intent.putExtra("altura", altura);
        intent.putExtra("imc", imc);
        startActivity(intent);
    }

    private void irParaObesidade3(float peso, float altura, float imc, String classificacao) {
        Intent intent = new Intent(CalculoIMCActivity.this, Obesidade3Activity.class);
        intent.putExtra("peso", peso);
        intent.putExtra("altura", altura);
        intent.putExtra("imc", imc);
        startActivity(intent);
    }
}
