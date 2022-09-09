package com.example.projetolp3b;

import android.content.Context;
import android.icu.text.SymbolTable;
import android.location.Address;
import android.location.Geocoder;
import android.os.Bundle;
import android.os.Message;
import android.os.Handler;

import com.google.android.gms.maps.model.LatLng;

import java.io.IOException;
import java.net.ContentHandler;
import java.util.List;
import java.util.Locale;

public class GeoLocation {
    public static void getAddress(String locationAddress, final Context context, Handler handler) {
        Thread thread = new Thread() {
            @Override
            public void run() {
                Geocoder geocoder = new Geocoder(context, Locale.getDefault());
                String result = null;
                String result2 = null;
                String result3 = null;
                String lat = null;
                String lon = null;
                //LatLng local1 = new LatLng(0, 0);
                try{
                    List addressList = geocoder.getFromLocationName(locationAddress, 1);
                    if(addressList != null && addressList.size() > 0){
                        Address address = (Address)  addressList.get(0);
                        StringBuilder stringBuilder = new StringBuilder();
                        stringBuilder.append(address.getLatitude()).append("\n");
                        stringBuilder.append(address.getLongitude()).append("\n");
                        lat =  String.valueOf(address.getLatitude());
                        lon =  String.valueOf(address.getLongitude());
                        result = stringBuilder.toString();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }finally {
                    Message message = Message.obtain();
                    message.setTarget(handler);
                    if (result != null){
                        message.what = 1;
                        Bundle bundle = new Bundle();
                        result = "Endereço : " + locationAddress + "\nLatitude e Longitude\n" + result;
                        result2 = lat;
                        result3 = lon;
                        bundle.putString("address", result);
                        bundle.putString("lat", result2);
                        bundle.putString("long", result3);
                        message.setData(bundle);
                    }
                    message.sendToTarget();

                }
            }
        };
        thread.start();
    }
}
