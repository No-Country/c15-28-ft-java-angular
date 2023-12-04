package com.noCountry.CryptoCoin.service;

import com.google.cloud.firestore.CollectionReference;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.Firestore;
import com.google.firebase.cloud.FirestoreClient;
import com.noCountry.CryptoCoin.domain.Usuario;
import com.noCountry.CryptoCoin.repository.UsuarioRepositoryFirebase;
import com.noCountry.CryptoCoin.repository.UsuarioRepositoryJPA;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.ExecutionException;

@Service
@AllArgsConstructor
public class UsuarioService {

    private final UsuarioRepositoryJPA usuarioRepositoryJPA;
    private final UsuarioRepositoryFirebase usuarioRepositoryFirebase;

    public void guardarUsuario(String nombre, String email) throws ExecutionException, InterruptedException {
        if (nombre == null || nombre.isEmpty()) {
            throw new IllegalArgumentException("El nombre no puede estar vacio");
        } else {
            usuarioRepositoryFirebase.guardar(nombre, email);
        }

    }

    public List<Usuario> getAll() {
        return usuarioRepositoryJPA.findAll();
    }
}
