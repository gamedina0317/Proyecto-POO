package com.example.prueba;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class Lista_productos extends AppCompatActivity {

    String Id;
    final ArrayList<Productos> lista=new ArrayList<Productos>();
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent intento=getIntent();
        Id=intento.getStringExtra("ID");//a partir de ID debe encontrar los cuatro datos de cada producto dentro de la base de datos y llenar la lista
        lista.add(new Productos("Arepa de Carne","Arepa rellena con carne desmechada",""+300,""+40));
        lista.add(new Productos("Arepa Vegana","Arepa rellena con vegetales asados",""+400,""+20));
        lista.add(new Productos("Arepa trifacica","Arepa rellena con res, pollo y cerdo",""+300,""+30));
        lista.add(new Productos("Arepa de huevo","Arepa rellena con un huevo ",""+200,""+50));
        lista.add(new Productos("Arepa de mondongo","Arepa rellena de mondongo de pollo ",""+1000,""+50));
        lista.add(new Productos("Coca-Cola","Bebida gaseosa",""+30,""+100));
        lista.add(new Productos("Pepsi","Bebida gaseosa ",""+55,""+110));
        lista.add(new Productos("Cola Condor","Bebida gaseosa ",""+40,""+140));
        lista.add(new Productos("Arsenico alta concentracion","Bebida gaseosa ",""+150,""+90));
        lista.add(new Productos("Manzana Postobon","Bebida gaseosa ",""+10,""+90));
        Adaptador miadaptador=new Adaptador(this, R.layout.item_lista,lista);
        ListView listView=(ListView) findViewById(R.id.lista);
        listView.setAdapter(miadaptador);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Productos seleccionado=lista.get(position);
                Intent intento=new Intent(getApplicationContext(),perfilProducto.class);
                intento.putExtra("nombre",  seleccionado.nombre_producto);
                intento.putExtra("descripcion",  seleccionado.descripcion);
                intento.putExtra("precio",  seleccionado.precio+"");
                intento.putExtra("cantidad",  seleccionado.cantidad+"");
                intento.putExtra("objeto",seleccionado);
                startActivity(intento);
            }
        });
    }
}
