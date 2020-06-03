package com.example.prueba;

import java.io.Serializable;

public class arraylists implements Serializable {
    double Lat;
    double Lng;
    String Id;



    public arraylists(double lat,double lng,String id){
        Lat=lat;
        Lng=lng;
        Id=id;
    }
    public double getLat(){
        return Lat;
    }
    public void setLat(double lat,double lng){
        this.Lat=lat;
    }
    public double getLng(){
        return Lng;
    }
    public void setLng(double lng){
        this.Lng=lng;
    }

    public String getId(){
        return Id;
    }
    public void setId(String  id){
        this.Id=id;
    }

}
