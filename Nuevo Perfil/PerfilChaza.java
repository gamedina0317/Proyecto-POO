package com.example.prueba;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class Perfilchaza extends AppCompatActivity {
    boolean tipo;
    String Id;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfilchaza);
        Intent intento=getIntent();
        tipo=intento.getBooleanExtra("estado",false);
        this.Id=intento.getStringExtra("ID");
        Button boton_productos =(Button) findViewById(R.id.verproductos);
        boton_productos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),Lista_productos.class);
                intent.putExtra("ID",Id);
                startActivity(intent);
            }
        });
        Button guardar=(Button) findViewById(R.id.guardardatos);//Boton para guardar datos
        Button ubicacion=(Button) findViewById(R.id.ubicacionchaza);//Boton para entrar al mapa y cambiar la ubicacion
        Button cerrar_sesion=(Button) findViewById(R.id.cerrar_sesion);//Boton para cerrar sesion
        if (tipo){//cuando se es cliente
            guardar.setVisibility(View.INVISIBLE);
            ubicacion.setVisibility(View.INVISIBLE);
            cerrar_sesion.setVisibility(View.INVISIBLE);
        }
        else{
            guardar.setVisibility(View.VISIBLE);
            ubicacion.setVisibility(View.VISIBLE);
            cerrar_sesion.setVisibility(View.VISIBLE);
            ubicacion.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intento=new Intent(getApplicationContext(),Mapa.class);
                    ArrayList<arraylists> lista = new ArrayList<arraylists>();
                    lista.add(new arraylists(4.636404559796773,-74.08373344648129,"1"));//Esta coordenada es de prueba, encontrar como obtener estos datos de la base de datos
                    intento.putExtra("estado",false);
                    intento.putExtra("cordenadas",lista);
                    startActivity(intento);
                }
            });
            guardar.setOnClickListener(new View.OnClickListener() {//Aca debe ir el cambiar los datos que tieene la base de datos
                @Override
                public void onClick(View v) {

                }
            });
            cerrar_sesion.setOnClickListener(new View.OnClickListener() {//Toca averiguar como matar las actividades
                @Override
                public void onClick(View v) {

                }
            });
        }
    }
}
