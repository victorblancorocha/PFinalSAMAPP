package com.example.victorblanco.pfinalsamapp;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class ReservarAudiovisual extends AppCompatActivity {

    //Variable miembro
    //Declaracion de constante
    private static final String SEND_MESSAGE="message";
    private static final String EXTRA_NAME_SHOWN="extraName";
    //Asignacion del valor de la variable mensage a la constante
    //SEND_MESSAGE
    public static Intent newIntent(Context packageContext, String message){
        Intent i= new Intent(packageContext,ReservarAudiovisual.class);
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
        setContentView(R.layout.activity_reservar_audiovisual);
    }
}
