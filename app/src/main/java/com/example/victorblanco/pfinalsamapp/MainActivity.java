package com.example.victorblanco.pfinalsamapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    //Creacion de variables miembro
    private Button mMaButton;
    // Boton
    private Button mProyectButton;
    private TextView mPrincipalText;
    private String mNameR;
    private String mNameC;
    //creacion de cosntantes
    private static final int REQUEST_CODE_NAME=0;
    private static final String TAG="Etiqueta";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Probando Android Studio - GitHub

        //Inflar widgets
        mMaButton=(Button)findViewById(R.id.ma_button);
        mProyectButton=(Button)findViewById(R.id.proyec_button);
        mPrincipalText=(TextView)findViewById(R.id.principal_text);
        //Metodo para mandar al modulo de Reservacion de medios Audiovisuales
        mMaButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String message = mPrincipalText.getText().toString();
                Intent i = ReservarAudiovisual.newIntent(MainActivity.this, message);
                //esperando a boton back
                startActivityForResult(i, 0);
            }
        });

        //Metodo para mandar al modulo consulta de proyectores
        mProyectButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String message = mPrincipalText.getText().toString();
                Intent i = ConsultarProyector.newIntent(MainActivity.this, message);
                //esperando a boton back
                startActivityForResult(i, 0);
            }
        });

    }
}
