package com.example.prueba;
import java.util.Scanner;
public class Productos {
    String nombre_producto;
    String descripcion;
    float precio;
    int cantidad;
    public Productos(String nom,String des,float preci,int cant){
        nombre_producto=nom;
        descripcion=des;
        precio=preci;
        cantidad=cant;
    }
    public String getNombre(){
        return nombre_producto;
    }
    public String getDescripcion(){
        return nombre_producto;
    }
    public float getPrecio(){
        return precio;
    }
    public int getCantidad(){
        return cantidad;
    }
}
