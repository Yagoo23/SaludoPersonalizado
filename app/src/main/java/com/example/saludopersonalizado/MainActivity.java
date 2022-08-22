package com.example.saludopersonalizado;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView tvNombre;
    private EditText etNombre;
    private TextView tvEdad;
    private EditText etEdad;
    private TextView tvRespuesta;
    private Button btnSaludar;
    private RadioButton rbSra;
    private RadioButton rbSr;
    private CheckBox chkDespedida;
    private RadioGroup rgDespedida;
    private RadioButton rbAdios;
    private RadioButton rbHastaP;
    private TextView tvDespedida;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        inicializar_datos();
        rbAdios.setVisibility(View.GONE);
        rbHastaP.setVisibility(View.GONE);
        tvDespedida.setVisibility(View.GONE);


        btnSaludar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String str2=etEdad.getText().toString();
                String str = etNombre.getText().toString();

                if(str.isEmpty() || str2.isEmpty()){
                    tvRespuesta.setText("Faltan datos.");
                    tvRespuesta.setTextColor(getResources().getColor(R.color.red));
                    tvRespuesta.setTextSize(getResources().getDimension(R.dimen.datos));
                }else{
                    int edad=2021-Integer.parseInt(str2);

                        if(rbSra.isChecked()){
                            if(edad>=18){
                                tvRespuesta.setText("Hola,Sra." + str+".\nEres mayor de edad.");
                                tvRespuesta.setTextColor(getResources().getColor(R.color.red));
                                tvRespuesta.setTextSize(getResources().getDimension(R.dimen.datos));
                            }else{
                                tvRespuesta.setText("Hola,Sra." + str+".\nEres menor de edad.");
                                tvRespuesta.setTextColor(getResources().getColor(R.color.red));
                                tvRespuesta.setTextSize(getResources().getDimension(R.dimen.datos));
                            }
                        }else if(rbSr.isChecked())
                            if(edad>=18){
                                tvRespuesta.setText("Hola,Sr." + str+".\nEres mayor de edad.");
                                tvRespuesta.setTextColor(getResources().getColor(R.color.red));
                                tvRespuesta.setTextSize(getResources().getDimension(R.dimen.datos));
                            }else{
                                tvRespuesta.setText("Hola,Sr." + str+".\nEres menor de edad.");
                                tvRespuesta.setTextColor(getResources().getColor(R.color.red));
                                tvRespuesta.setTextSize(getResources().getDimension(R.dimen.datos));
                            }
                        if(rbAdios.isChecked()) {
                            tvRespuesta.append("\nAdiós.");
                            tvRespuesta.setTextColor(getResources().getColor(R.color.red));
                            tvRespuesta.setTextSize(getResources().getDimension(R.dimen.datos));
                        }else if (rbHastaP.isChecked()){
                            tvRespuesta.append("\nHasta pronto.");
                            tvRespuesta.setTextColor(getResources().getColor(R.color.red));
                            tvRespuesta.setTextSize(getResources().getDimension(R.dimen.datos));
                        }



                }
            }
        });

        chkDespedida.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(chkDespedida.isChecked()) {
                    tvDespedida.setVisibility(View.VISIBLE);
                    rbAdios.setVisibility(View.VISIBLE);
                    rbHastaP.setVisibility(View.VISIBLE);
                }else{
                    tvDespedida.setVisibility(View.GONE);
                    rbAdios.setVisibility(View.GONE);
                    rbHastaP.setVisibility(View.GONE);
                }
            }
        });

    }

    public void inicializar_datos(){
        tvNombre=findViewById(R.id.tvNombre);
        etNombre=findViewById(R.id.etNombre);
        tvEdad=findViewById(R.id.tvEdad);
        etEdad=findViewById(R.id.etEdad);
        tvRespuesta=findViewById(R.id.tvRespuesta);
        btnSaludar=findViewById(R.id.btnSaludar);
        rbSra=findViewById(R.id.rbSra);
        rbSr=findViewById(R.id.rbSr);
        chkDespedida=findViewById(R.id.chkDespedida);
        rgDespedida=findViewById(R.id.rgDespedida);
        rbAdios=findViewById(R.id.rbAdios);
        rbHastaP=findViewById(R.id.rbHastaP);
        tvDespedida=findViewById(R.id.tvDespedida);
    }
}