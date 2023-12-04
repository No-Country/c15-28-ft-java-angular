package com.noCountry.CryptoCoin.repository;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.*;
import com.google.firebase.cloud.FirestoreClient;
import com.noCountry.CryptoCoin.domain.Usuario;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutionException;

import static com.noCountry.CryptoCoin.common.Conexion.db;

@Repository
public class UsuarioRepositoryFirebase {
    public void guardar(String nombre, String email) throws ExecutionException, InterruptedException {
        if (nombre == null || nombre.isEmpty()) {
            throw new IllegalArgumentException("Nombre cannot be empty");
        }



        Map<String, Object> docData = new HashMap<>();
        docData.put("nombre", nombre);
        docData.put("email", email);
        if(db.collection("Usuarios").document(nombre).get().get().getData().get("email").equals(email)){
            throw new IllegalArgumentException("Email duplicado");
        }else{
            ApiFuture<WriteResult> future = db.collection("Usuarios").document(nombre).set(docData);
        }


    }
}