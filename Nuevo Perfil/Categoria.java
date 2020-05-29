package com.example.prueba;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Spinner;
import android.widget.ArrayAdapter;
import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;

public class Categoria extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    String seleccion="";
    String finale;
    ArrayList <arraylists> lista = new ArrayList<arraylists>();
    String[] elementos={"Comida","Micelania","Accesorios"};
    String[] comida={"Almuerzo","Mecato","Postres","Panaderia"};
    String[] micelania={"Papaeleria","Electronica","Articulos varios","Otra cosa"};
    String[] accesorios={"Bisuteria","Ropa","Parches","Meh"};
    CheckBox caja1;CheckBox caja2;
    CheckBox caja3;CheckBox caja4;
    Spinner tipo1;
    ArrayList<CheckBox> cajas=new ArrayList<CheckBox>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categoria);
        Button boton=(Button) findViewById(R.id.botonverchazas) ;
        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intento=new Intent(getApplicationContext(),Mapa.class);
                lista.add(new arraylists(4.636404559796773,-74.08373344648129,"1"));
                lista.add(new arraylists(4.635666692168087,-74.08373344648129,"2"));
                lista.add(new arraylists(4.635329839242644,-74.08289916830648,"3"));
                intento.putExtra("cordenadas",lista);
                intento.putExtra("estado",true);
                System.out.println("Lo va a sacar");
                startActivity(intento);
            }
        });
        tipo1=(Spinner) findViewById(R.id.spinner);
        tipo1.setOnItemSelectedListener(this);
        ArrayAdapter<String> adaptador=new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item,elementos);
        adaptador.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        tipo1.setAdapter(adaptador);
        caja1=(CheckBox) findViewById(R.id.checkBox);
        caja1.setVisibility(View.INVISIBLE);
        caja2=(CheckBox) findViewById(R.id.checkBox2);
        caja2.setVisibility(View.INVISIBLE);
        caja3=(CheckBox) findViewById(R.id.checkBox3);
        caja3.setVisibility(View.INVISIBLE);
        caja4=(CheckBox) findViewById(R.id.checkBox4);
        caja4.setVisibility(View.INVISIBLE);
        cajas.add(caja1);
        cajas.add(caja2);
        cajas.add(caja3);
        cajas.add(caja4);
        for (int i=0;i<cajas.size();i++){
            final int seleccion=i;
            cajas.get(i).setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    for(int x=0;x<cajas.size();x++){
                        cajas.get(x).setChecked(false);
                    }
                    cajas.get(seleccion).setChecked(true);
                    finale=cajas.get(seleccion).getText().toString();
                    Toast.makeText(getApplicationContext(), finale, Toast.LENGTH_SHORT).show();
                }
            });
        }
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        seleccion = tipo1.getSelectedItem().toString();
        finale="";
        if(seleccion.equals(elementos[0])){
            this.mostrar(comida);
        }
        if(seleccion.equals(elementos[1])){
            this.mostrar(micelania);
        }
        if(seleccion.equals(elementos[2])){
            this.mostrar(accesorios);
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
    public void mostrar(String[] lista){
        for (int i=0; i<cajas.size();i++){
            try{
                cajas.get(i).setVisibility(View.VISIBLE);
                cajas.get(i).setText(lista[i]);
            }
            catch (Exception e){
                cajas.get(i).setVisibility(View.INVISIBLE);
            }
        }
    }
}
