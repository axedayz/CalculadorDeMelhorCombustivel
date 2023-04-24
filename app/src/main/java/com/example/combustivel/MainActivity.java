package com.example.combustivel;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText gasolinaText;
    EditText etanolText;
    TextView resultadoText;
    ImageView imagemCombustivel;
    TextView gasolinaLabel;
    TextView etanolLabel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gasolinaText = findViewById(R.id.gasolinaText);
        etanolText = findViewById(R.id.etanolText);
        resultadoText = findViewById(R.id.resultadoText);
        imagemCombustivel = findViewById(R.id.imagemCombustivel);
        gasolinaLabel = findViewById(R.id.gasolinaLabel);
        etanolLabel = findViewById(R.id.etanolLabel);

        gasolinaText.setHint("Digite o valor do litro da gasolina");
        etanolText.setHint("Digite o valor do litro do etanol");
        gasolinaLabel.setText("Gasolina");
        etanolLabel.setText("Etanol");
    }

    public void calcularMelhorCombustivel(View view) {
        double gasolina = 0, etanol = 0;

        try {
            gasolina = Double.parseDouble(gasolinaText.getText().toString());
        } catch (NumberFormatException e) {
            resultadoText.setText("Por favor, digite um valor válido para a gasolina.");
            imagemCombustivel.setImageResource(0);
            return;
        }

        try {
            etanol = Double.parseDouble(etanolText.getText().toString());
        } catch (NumberFormatException e) {
            resultadoText.setText("Por favor, digite um valor válido para o etanol.");
            imagemCombustivel.setImageResource(0);
            return;
        }

        if (gasolina == 0 || etanol == 0) {
            resultadoText.setText("Por favor, digite os valores de ambos os combustíveis");
            imagemCombustivel.setImageResource(0);
        } else {
            if (etanol <= gasolina * 0.7) {
                resultadoText.setText("É melhor abastecer com:");
                imagemCombustivel.setImageResource(R.drawable.etanol);
            } else {
                resultadoText.setText("É melhor abastecer com:");
                imagemCombustivel.setImageResource(R.drawable.gasolina);
            }
        }


        InputMethodManager imm = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }
}
