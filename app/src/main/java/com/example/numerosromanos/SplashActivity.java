package com.example.numerosromanos;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Establece el layout con la imagen de fondo
        setContentView(R.layout.activity_splash);

        // Inicia un hilo para esperar 2 segundos antes de iniciar MainActivity
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    // Retraso de 2 segundos
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                // Iniciar MainActivity
                Intent intent = new Intent(SplashActivity.this, MainActivity.class);
                startActivity(intent);

                // Finalizar SplashActivity para que no regrese a ella
                finish();
            }
        }).start();
    }
}
