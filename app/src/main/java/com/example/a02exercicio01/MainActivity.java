package com.example.a02exercicio01;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private EditText etA;
    private EditText etB;
    private EditText etC;
    private TextView tvX1;
    private TextView tvX2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        etA = findViewById(R.id.etA);
        etB = findViewById(R.id.etB);
        etC = findViewById(R.id.etC);
        Button btCalc = findViewById(R.id.btCalc);
        tvX1 = findViewById(R.id.tvX1);
        tvX2 = findViewById(R.id.tvX2);

        btCalc.setOnClickListener(op -> calcBhask());
    }

    private void calcBhask() {
        tvX1.setText("");
        tvX2.setText("");
        float a = Float.parseFloat(etA.getText().toString());
        float b = Float.parseFloat(etB.getText().toString());
        float c = Float.parseFloat(etC.getText().toString());

        float delta = (b * b) - 4 * a * c;

        if (delta > 0) {
            double x1 = (-b + Math.sqrt(delta)) / (2 * a);
            double x2 = (-b - Math.sqrt(delta)) / (2 * a);

            String resX1 = getString(R.string.x1) + " " + x1;
            String resX2 = getString(R.string.x2) + " " + x2;
            tvX1.setText(resX1);
            tvX2.setText(resX2);
        } else if (delta == 0) {
            double x = -b / (2 * a);
            String resX = getString(R.string.x) + " " + x;
            tvX1.setText(resX);
            tvX2.setText(getString(R.string.nao_segundo_grau));
        } else {
            tvX1.setText(R.string.sem_raiz);
        }
        etA.setText("");
        etB.setText("");
        etC.setText("");
    }
}