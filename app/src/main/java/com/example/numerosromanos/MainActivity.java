package com.example.numerosromanos;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private EditText etNumero;
    private Button btnConvertir;
    private TextView tvResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        // Configurar el listener de la ventana para manejar insets
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Obtener referencias de los elementos UI
        etNumero = findViewById(R.id.etNumero);
        btnConvertir = findViewById(R.id.btnConvertir);
        tvResultado = findViewById(R.id.tvResultado);

        // Configurar el botón para convertir el número
        btnConvertir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String numeroStr = etNumero.getText().toString();
                if (!numeroStr.isEmpty()) {
                    int numero = Integer.parseInt(numeroStr);
                    String numeroRomano = convertirANumerosRomanos(numero);
                    tvResultado.setText("Número Romano: " + numeroRomano);
                }
            }
        });
    }

    private String convertirANumerosRomanos(int numero) {
        if (numero <= 0 || numero > 3999) {
            return "Número fuera de rango (1-3999)";
        }

        String[] valores = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        int[] numeros = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};

        StringBuilder romano = new StringBuilder();
        for (int i = 0; i < valores.length; i++) {
            while (numero >= numeros[i]) {
                romano.append(valores[i]);
                numero -= numeros[i];
            }
        }
        return romano.toString();
    }
}
