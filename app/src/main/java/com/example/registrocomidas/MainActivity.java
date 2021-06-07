package com.example.registrocomidas;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    EditText cajaTitulo, cajaDescripcion;
    Button botonRegistrar, botonListado;

    FirebaseFirestore db = FirebaseFirestore.getInstance();

    Map<String, Object> comidas = new HashMap<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cajaTitulo=findViewById(R.id.titulo);
        cajaDescripcion=findViewById(R.id.descripcion);
        botonRegistrar=findViewById(R.id.botonRegistrar);
        botonListado=findViewById(R.id.botonBuscar);



        botonRegistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String titulo=cajaTitulo.getText().toString();
                String descripcion=cajaDescripcion.getText().toString();

                comidas.put("titulo", titulo);
                comidas.put("descripcion", descripcion);

                registarComida();

            }
        });

        botonListado.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this,Listado.class);
                startActivity(intent);

            }
        });

    }

    private void registarComida(){

        db.collection("comidas")
        .add(comidas)
        .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
            @Override
            public void onSuccess(DocumentReference documentReference) {

                cajaTitulo.setText("");
                cajaDescripcion.setText("");
                Toast.makeText(getApplicationContext(),"Exito, agregado con exito!",Toast.LENGTH_LONG).show();

            }
        })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {

                        Toast.makeText(getApplicationContext(),"Error: "+e,Toast.LENGTH_LONG).show();

                    }
                });

    }

}