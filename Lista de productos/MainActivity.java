package com.example.prueba;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ArrayList<Productos> lista=new ArrayList<Productos>();
        lista.add(new Productos("Arepa de Carne","Arepa rellena con carne desmechada",300,40));
        lista.add(new Productos("Arepa Vegana","Arepa rellena con vegetales asados",400,20));
        lista.add(new Productos("Arepa trifacica","Arepa rellena con res, pollo y cerdo",300,30));
        lista.add(new Productos("Arepa de huevo","Arepa rellena con un huevo ",200,50));
        lista.add(new Productos("Arepa de mondongo","Arepa rellena de mondongo de pollo ",1000,50));
        lista.add(new Productos("Coca-Cola","Bebida gaseosa",30,100));
        lista.add(new Productos("Pepsi","Bebida gaseosa ",55,110));
        lista.add(new Productos("Cola Condor","Bebida gaseosa ",40,140));
        lista.add(new Productos("Arsenico alta concentracion","Bebida gaseosa ",150,90));
        lista.add(new Productos("Manzana Postobon","Bebida gaseosa ",10,90));
        Adaptador miadaptador=new Adaptador(this, R.layout.item_lista,lista);
        ListView listView=(ListView) findViewById(R.id.lista);
        listView.setAdapter(miadaptador);
        /*ArrayList<String> lista=new ArrayList<String>();
        ArrayAdapter<String> adaptador=new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, lista);
        ListView listView=(ListView) findViewById(R.id.lista);*/

    }
}
