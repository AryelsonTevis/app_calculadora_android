package com.example.prjcalculadora;

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
    double vlV1=0;
    double vlV2=0;

    double vlMemoria=0;
    int flag=0;
    double vlResultado=0;



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
        Button btnSomar =(Button) findViewById(R.id.btnSomar);
        Button btnSubtrair =(Button) findViewById(R.id.btnSubtrair);
        Button btnMultiplicar =(Button) findViewById(R.id.btnMultiplicar);
        Button btnDividir =(Button) findViewById(R.id.btnDividir);
        Button btnLimpar =(Button) findViewById(R.id.btnLimpar);
        Button btnSair = (Button) findViewById(R.id.btnSair);
        EditText edtValor1 = (EditText) findViewById(R.id.edtValor1);
        EditText edtValor2 = (EditText) findViewById(R.id.edtValor2);
        TextView txtResultadoVl = (TextView) findViewById(R.id.txvResultadoVl);
        Button btnMemoMais =(Button) findViewById(R.id.btnMemoMais);
        Button btnMemoMenos =(Button) findViewById(R.id.btnMemoMenos);
        Button btnMemoReco =(Button) findViewById(R.id.btnMemoReco);
        Button btnMemoClear =(Button) findViewById(R.id.btnMemoClear);
        Button btnMemo=(Button) findViewById(R.id.btnSomar);
        Button btnMh = (Button) findViewById(R.id.btnMh);
        TextView txvMemoriaVl = (TextView) findViewById(R.id.txvMemoriaVl);
        btnMemoReco.setEnabled(false);
        btnMemoClear.setEnabled(false);
        btnMh.setEnabled(false);



        btnSomar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vlV1= Double.valueOf(edtValor1.getText().toString());
                vlV2= Double.valueOf(edtValor2.getText().toString());
                if (edtValor2 != null && edtValor1  != null ){
                    vlResultado = vlV1 + vlV2;
                    txtResultadoVl.setText(String.valueOf(vlResultado));
                    flag=1;
                } else {
                    txtResultadoVl.setText(String.valueOf("Erro!!!"));

                }


            }
        });
        btnSubtrair.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vlV1= Double.valueOf(edtValor1.getText().toString());
                vlV2= Double.valueOf(edtValor2.getText().toString());
                vlResultado = vlV1 - vlV2;
                txtResultadoVl.setText(String.valueOf(vlResultado));
                flag=1;
            }
        });btnMultiplicar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vlV1= Double.valueOf(edtValor1.getText().toString());
                vlV2= Double.valueOf(edtValor2.getText().toString());
                vlResultado = vlV1 * vlV2;
                txtResultadoVl.setText(String.valueOf(vlResultado));
                flag=1;
            }
        });btnDividir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vlV1= Double.valueOf(edtValor1.getText().toString());
                vlV2= Double.valueOf(edtValor2.getText().toString());
                vlResultado = vlV1 / vlV2;
                txtResultadoVl.setText(String.valueOf(vlResultado));
                flag=1;
            }
        });btnLimpar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edtValor1.setText("");
                edtValor2.setText("");
                txtResultadoVl.setText(String.valueOf(""));
                flag=1;
            }
        });btnSair.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.exit(0);
            }
        });
        btnMemoMais.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (flag!=0) {
                    vlMemoria = vlMemoria + vlResultado;
                    txvMemoriaVl.setText(String.valueOf(vlMemoria));

                    btnMemoReco.setEnabled(true);
                    btnMemoClear.setEnabled(true);
                    btnMh.setEnabled(true);
                }

            }
        });
        btnMemoMenos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (flag!=0){
                vlMemoria=vlMemoria-vlResultado;
                txvMemoriaVl.setText(String.valueOf(vlMemoria));

                btnMemoReco.setEnabled(true);
                btnMemoClear.setEnabled(true);
                btnMh.setEnabled(true);
            }}
        });
        btnMemoReco.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edtValor1.setText(String.valueOf(vlMemoria));




            }
        });
        btnMemoClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btnMemoReco.setEnabled(false);
                btnMemoClear.setEnabled(false);
                btnMh.setEnabled(false);
                vlMemoria = 0;
                txvMemoriaVl.setText(String.valueOf(""));
                edtValor1.setText("");
                edtValor2.setText("");
                txtResultadoVl.setText(String.valueOf(""));
                flag=1;
            }
        });
    }
}