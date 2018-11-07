package com.example.victorblanco.pfinalsamapp;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ConsultarProyector extends AppCompatActivity {


    // Crear constante tag
    private final static String TAG ="etiqueta";
    private final static String KEY_INDEX="indice";
    private static final String SEND_MESSAGE="message";
    private static final String EXTRA_NAME_SHOWN="extraName";

    //Creacion de variable miembro widgets
    private TextView mProyectorTextView;
    private Button mNextButton;
    private Button mPreviousButton;

    // Creacion de arreglo de estudiantes (MODELO)
    private Proyector[] mProyectores = new Proyector[]{
            new Proyector(111,"Epson",100,"Ocupado"),
            new Proyector(222,"Acer",60,"Disponible"),
            new Proyector(333,"Hitachi",95,"Disponible")
    };

    private int mCurrentIndex = 0;
    // actualizacion de vista con el modelo
    private void updateStudent(){
        mProyectorTextView.setText(mProyectores[mCurrentIndex].getMarca() + "\n"
                + mProyectores[mCurrentIndex].getModelo() + "\n"
                + mProyectores[mCurrentIndex].getDisponible()
        );
    }

    //Asignacion del valor de la variable mensage a la constante
    //SEND_MESSAGE
    public static Intent newIntent(Context packageContext, String message){
        Intent i= new Intent(packageContext,ConsultarProyector.class);
        i.putExtra(SEND_MESSAGE,message);
        return i;
    }
    //Metodo que se manda llamar desde la MainACTIVITY PARA OBTENER EL VALOR DE LA VARIABLE NAME Que se arguardp en la ocnstante
    public static String wasNameShown(Intent result){
        return result.getStringExtra(EXTRA_NAME_SHOWN);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consultar_proyector);

        // Inflar widgets (Conectar la VISTA con el CONTROLADOR)
        mProyectorTextView = (TextView)findViewById(R.id.proyector_textView);
        mNextButton = (Button)findViewById(R.id.next_button);
        mPreviousButton = (Button)findViewById(R.id.previous_button);

        // Establecer listeners
        mNextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mCurrentIndex = (mCurrentIndex + 1) % (mProyectores.length);
                updateStudent();
            }
        });
        mPreviousButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mCurrentIndex = (mCurrentIndex+(mProyectores.length-1)) % mProyectores.length;
                updateStudent();
            }
        });

        if(savedInstanceState != null)
        {
            mCurrentIndex = savedInstanceState.getInt(KEY_INDEX,0);
        }
        updateStudent();
        Log.d(TAG,"onCreate() llamado");
    }
    // Guarda el valor de indice en KEY_INDEX
    @Override
    public void onSaveInstanceState(Bundle savedInstanceState){
        super.onSaveInstanceState(savedInstanceState);
        Log.d(TAG,"onSavedInstanceState() llamado");
        savedInstanceState.putInt(KEY_INDEX,
                mCurrentIndex);
    }
}
