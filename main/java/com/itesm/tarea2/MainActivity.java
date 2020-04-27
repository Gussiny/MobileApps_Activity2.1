package com.itesm.tarea2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Parcelable;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements Handler.Callback, View.OnClickListener{

    private Handler dataHandler;
    private ArrayList<Amigos> amigos;
    private RecyclerView lista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lista = findViewById(R.id.listaAmigos);
        lista.setHasFixedSize(true);
        amigos = new ArrayList<>();
        dataHandler = new Handler(Looper.getMainLooper(), this);
    }

    public void request(View v){
        Request r = new Request("https://raw.githubusercontent.com/Gussiny/AndroidRequestHTTP/master/BestFriends.json", dataHandler);
        r.start();
    }

    @Override
    public boolean handleMessage(@NonNull Message msg) {
        JSONArray resultado = (JSONArray) msg.obj;

        try {
            for(int i = 0; i < resultado.length(); i++){
                String name, hobby, age, phone, address;
                JSONObject actual = resultado.getJSONObject(i);
                Log.wtf("JSON", "{");
                Log.wtf("JSON", actual.getString("name"));
                Log.wtf("JSON", actual.getString("hobby"));
                Log.wtf("JSON", actual.getString("age"));
                Log.wtf("JSON", actual.getString("phone"));
                Log.wtf("JSON", actual.getString("address"));
                Log.wtf("JSON", "}");

                name = actual.getString("name");
                hobby = actual.getString("hobby");
                age = actual.getString("age");
                phone = actual.getString("phone");
                address = actual.getString("address");

                Amigos amigo = new Amigos(name, hobby, age, phone, address);
                amigos.add(amigo);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }

        AmigosAdapter amigosAdapter = new AmigosAdapter(amigos, this);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(RecyclerView.VERTICAL);
        lista.setLayoutManager(llm);
        lista.setAdapter(amigosAdapter);

        Toast.makeText(this, "Data loaded successfully", Toast.LENGTH_SHORT).show();
        return false;
    }

    @Override
    public void onClick(View v) {
        int pos = lista.getChildLayoutPosition(v);
        //Toast.makeText(this, amigos.get(pos).getName(), Toast.LENGTH_SHORT).show();
        Intent intent =  new Intent(this, InfoActivity.class);
        intent.putExtra("name", amigos.get(pos).getName());
        intent.putExtra("hobby", amigos.get(pos).getHobby());
        intent.putExtra("age", amigos.get(pos).getAge());
        intent.putExtra("phone", amigos.get(pos).getPhone());
        intent.putExtra("address", amigos.get(pos).getAddress());
        startActivity(intent);
    }
}
