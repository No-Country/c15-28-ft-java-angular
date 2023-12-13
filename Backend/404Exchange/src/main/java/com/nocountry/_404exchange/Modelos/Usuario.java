package com.nocountry._404exchange.Modelos;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Entity
@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)//Hace que todas las variables sean privadas
@Table(name = "usuario")
public class Usuario {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
     long id;

    @Column(name = "usuario", unique = true, nullable = false)
    String usuario;

    @Column(name = "nombre")
    String nombre;

    @Column(name = "apellido")
    String apellido;

    @Column(name = "email", unique = true, nullable = false)
    @Email(message = "Por favor, introduce una dirección de correo electrónico válida")
    @NotEmpty(message = "El correo electrónico no puede estar vacío")
    String email;

    @Column(name = "contrasena", nullable = false)
    String contrasena;

    //Relacion con la wallet
    @OneToOne(targetEntity = Wallet.class, cascade = CascadeType.ALL)// para que cada cambio hecho en Usuario, tambien afecte a Wallet
    // como actualizar o eliminar
    @JoinColumn(name = "wallet_id", nullable = false)
    Wallet wallet;
}
