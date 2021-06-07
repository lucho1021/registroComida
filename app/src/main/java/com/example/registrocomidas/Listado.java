package com.example.registrocomidas;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.api.Distribution;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;

public class Listado extends AppCompatActivity {

    ArrayList<Comidas> listadeComidas = new ArrayList<>();
    RecyclerView listado;
    FirebaseFirestore db = FirebaseFirestore.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listado);

        listado=findViewById(R.id.listado);
        listado.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));

        crearListado();

    }

    private void crearListado() {

        db.collection("comidas")
                .get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
            @Override
            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                if (task.isSuccessful()){

                    for (QueryDocumentSnapshot document : task.getResult()){

                        String titulo=document.get("titulo").toString();
                        String descripcion=document.get("descripcion").toString();
                        String foto=document.get("foto").toString();

                        listadeComidas.add(new Comidas(titulo,descripcion, foto));

                    }
                    Adaptador adaptador = new Adaptador(listadeComidas);
                    listado.setAdapter(adaptador);

                }
                else {

                    Toast.makeText(getApplicationContext(),"Error consultando los datos ",Toast.LENGTH_LONG).show();

                }
            }
        });

    }
}