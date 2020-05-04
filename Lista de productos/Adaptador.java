package com.example.prueba;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import java.util.ArrayList;
public class Adaptador extends BaseAdapter{
    Context contexto;
    int layout;
    ArrayList<Productos> listaprod;
    Adaptador(Context context,int layout,ArrayList<Productos> productos){
        this.contexto = context;
        this.layout = layout;
        this.listaprod = productos;
    }
    @Override
    public int getCount() {
        return this.listaprod.size();
    }

    @Override
    public Object getItem(int position) {
        return this.listaprod.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View vista= convertView;
        LayoutInflater inflador=LayoutInflater.from(this.contexto);
        vista=inflador.inflate(R.layout.item_lista,null);
        Productos productoactual=listaprod.get(position);
        TextView nombreprod=(TextView) vista.findViewById(R.id.titulo);
        nombreprod.setText(productoactual.nombre_producto);
        TextView descripcionprod=(TextView) vista.findViewById(R.id.descripcion);
        descripcionprod.setText(productoactual.descripcion);
        TextView Precio=(TextView) vista.findViewById(R.id.Precio);
        Precio.setText(productoactual.precio+"");
        return vista;
    }
}
