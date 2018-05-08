package com.plataformas.anahernandez.laboratorio1;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

/** Ana Lucia Hernandez 17138
 * Esteban Cabrera 17781
 * 08/05/2017
 * Laboratorio 1: Plataformas Moviles y Juegos
 *
  */

public class MainActivity extends AppCompatActivity {

    ListView listView;
    Hospital hospital1;
    Hospital hospital2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = (ListView)findViewById(R.id.lvhospitales);

        List<Hospital> hospitales = new ArrayList<>();


        Doctor doc11 =  new Doctor("Luis Perez", "Pediatria", "7438291", 8439117);
        Doctor doc12 =  new Doctor("Carlos Martinez", "Cardiologia", "3859", 8543995);
        Enfermera enf11 = new Enfermera("Ada Lovelace", 843921, "Trauma");
        Enfermera enf12 = new Enfermera("Ana Hernandez", 5483290, "Emergencias");

        hospital1 = new Hospital("Hospital Esperanza", doc11, doc12, enf11, enf12);
        hospitales.add(hospital1);

        Doctor doc21 =  new Doctor("Fernanda Lopez", "Pediatria", "32718", 453875);
        Doctor doc22 =  new Doctor("Juana de Arco", "Cardiologia", "237541", 342185);
        Enfermera enf21 = new Enfermera("Rihanna Fenty", 843921, "Intensivo");
        Enfermera enf22 = new Enfermera("Eva Longoria", 5483290, "Maternidad");

        hospital2 = new Hospital("Hospital Herrera Llerandi", doc21, doc22, enf21, enf22);
        hospitales.add(hospital2);

            /* Para enviar a la segunda actividad cuando se presiona un objeto del listview */
        ArrayAdapter<Hospital> adapter = new ArrayAdapter<Hospital>(this,android.R.layout.simple_list_item_1,hospitales);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(
                new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                        //Abre la activity 2, mandando como objeto el hospital
                        Intent test = new Intent(view.getContext(), SecondActivity.class);
                        test.putExtra("Hospital", (Hospital)listView.getItemAtPosition(i));
                        startActivity(test);

                    }
                }
        );
        /* Para enviar a la segunda actividad cuando se presiona el floating action button */
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.floatingActionButton);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                //solo para enviar un objeto al momento de presionar el floating button
                intent.putExtra("Hospital", hospital1);
                startActivity(intent);



                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }
}
