package com.example.prueba;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.fragment.app.FragmentActivity;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;

public class Mapa<lugares> extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    ArrayList<arraylists> lugares;
    boolean estado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Intent intento=getIntent();
        this.estado=(boolean)intento.getBooleanExtra("estado",true);
        this.lugares = (ArrayList<arraylists>)intento.getSerializableExtra("cordenadas");
        super.onCreate(savedInstanceState);
        System.out.println("ya tiene la lista");
        setContentView(R.layout.activity_mapa);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        lugares.add(new LatLng(4.637862702334999,-74.08292440664117));
        lugares.add(new LatLng(4.636404559796773,-74.08373344648129));
        lugares.add(new LatLng(4.635666692168087,-74.08301450329569));
        lugares.add(new LatLng(4.635329839242644,-74.08289916830648));
        lugares.add(new LatLng(4.635420796834211,-74.08253700911179));*/
        System.out.println("Llego hasta el mapa");
        if(estado==true) {//para los clientes
            Button boton= (Button)findViewById(R.id.boton);
            boton.setVisibility(View.INVISIBLE);
            for (int i = 0; i < lugares.size(); i++) {
                /*LatLng pos=new LatLng(lugares.get(i)[0],lugares.get(i)[1]);*/
                Marker marcador = mMap.addMarker(new MarkerOptions().position(new LatLng(lugares.get(i).getLat(), lugares.get(i).getLng())).title("Marker in la Nacho"));
                marcador.setTag(i);
                System.out.println("crea los marcadores");
                final int x = i;
                mMap.setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener() {
                    @Override
                    public boolean onMarkerClick(Marker marker) {
                        Intent Intento = new Intent(getApplicationContext(), Perfilchaza.class);
                        int posicion = (int) marker.getTag();
                        Intento.putExtra("Nombre", lugares.get(posicion).getId());
                        Intento.putExtra("estado",true);
                        startActivity(Intento);
                        return true;
                    }
                });
            }
        }
        else{//para cuando son chazas

            /*LatLng pos=new LatLng(lugares.get(i)[0],lugares.get(i)[1]);*/
            final  Marker marcador = mMap.addMarker(new MarkerOptions().position(new LatLng(lugares.get(0).getLat(), lugares.get(0).getLng())).title("Marker in la Nacho").draggable(true));
            System.out.println("crea los marcadores");
                /*mMap.setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener() {
                    @Override
                    public boolean onMarkerClick(Marker marker) {
                        Intent Intento = new Intent(getApplicationContext(), Main2Activity.class);
                        int posicion = (int) marker.getTag();
                        Double lat = marker.getPosition().latitude;
                        Double lon = marker.getPosition().longitude;
                        String pasa=lat+"  "+lon+"";
                        Intento.putExtra("Nombre", pasa);
                        startActivity(Intento);
                        return true;
                    }
                });*/

            mMap.setOnMarkerDragListener(new GoogleMap.OnMarkerDragListener() {
                LatLng temp=null;
                @Override
                public void onMarkerDragStart(Marker marker) {

                }

                @Override
                public void onMarkerDrag(Marker marker) {
                    temp=marker.getPosition();
                }

                @Override
                public void onMarkerDragEnd(Marker marker) {
                    marker.setPosition(temp);
                }
            });
            Button boton= (Button)findViewById(R.id.boton);
            boton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent Intento = new Intent(getApplicationContext(), Perfilchaza.class);
                    Double lat = marcador.getPosition().latitude;
                    Double lon = marcador.getPosition().longitude;
                    String pasa=lat+"  "+lon+"";
                    Toast.makeText(getApplicationContext(), pasa, Toast.LENGTH_SHORT).show();
                    //Intento.putExtra("Nombre", pasa);
                    //Intento.putExtra("estado",false);
                    startActivity(Intento);
                }
            });

        }

    }
}
