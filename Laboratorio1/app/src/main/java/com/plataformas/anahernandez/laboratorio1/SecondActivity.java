package com.plataformas.anahernandez.laboratorio1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

/** Ana Lucia Hernandez 17138
 * Esteban Cabrera 17781
 * 08/05/2017
 * Laboratorio 1: Plataformas Moviles y Juegos
 *
 */

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Bundle receiver = getIntent().getExtras();
        Hospital hospital = receiver.getParcelable("Hospital");

        TextView txt = findViewById(R.id.texto);
        Doctor doc1 = hospital.getDoc1();
        if(doc1 == null){
            doc1 = new Doctor();
            System.out.println("doc1 is null");
        }
        Doctor doc2 = hospital.getDoc2();
        if(doc2 == null){
            doc2 = new Doctor();
            System.out.println("doc2 is null");
        }
        Enfermera enf1 = hospital.getEnf1();
        Enfermera enf2 = hospital.getEnf2();
        String name = hospital.getNombreHospital();
        String doc1txt = doc1.toString();
        String doc2txt = doc2.toString();
        String enf1txt = enf1.toString();
        String enf2txt = enf2.toString();
        String texto = "\nNombre del Hospital: " + name +"\n\nDoctor 1: "+ doc1txt + "\n"+ "\nDoctor 2: "+ doc2txt + "\n"+ "\nEnfermera 1: "+ enf1txt + "\n" + "\nEnfermera 2: "+ enf2txt;
        txt.setText(texto);
    }
}
