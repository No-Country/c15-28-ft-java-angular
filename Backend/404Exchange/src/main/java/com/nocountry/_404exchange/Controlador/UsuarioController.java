package com.nocountry._404exchange.Controlador;

import com.nocountry._404exchange.Modelos.Usuario;
import com.nocountry._404exchange.Modelos.Wallet;
import com.nocountry._404exchange.Repositorio.UsuarioRepo;
import com.nocountry._404exchange.Repositorio.WalletRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UsuarioController {

    @Autowired
    private UsuarioRepo repoUsuario;

    @Autowired
    private WalletRepo walletRepo;


    @GetMapping(value = "/")
    public String getPage() {
        return "Welcome";
    }

    /**
     * Prueba para revisar datos guardados, Postman GET http://localhost:8080/usuarios
     * @return Todas los usuarios registrados
     */
    @GetMapping(value = "/usuarios")
    public List<Usuario> obtenerUsuario() {
        return repoUsuario.findAll();

    }

    /**
     * http://localhost:8080/guardar
     *
     * Body del Json para guardar un usuario
     * Usuario y email no pueden repetirse
     * usuario y wallet no pueden estar vacios
     * {
     *         "usuario": "1Alex",
     *         "nombre": "Alexx",
     *         "apellido": "Pacheco",
     *         "email": "1@email.com",
     *         "contrasena": "contrasena1234",
     *         "wallet": {
     *             "montoDolares": 0.00,
     *             "cantidadBTC": 0.00,
     *             "cantidadETH": 0.00,
     *             "fechaHoraCompraVenta": null,
     *             "historialCompraVenta": null
     *         }
     * }
     * @param usuario el usuario a registrar
     * @return "Guardado..."
     */
    @PostMapping(value = "/guardar")
    public String guardarUsuario(@RequestBody Usuario usuario) {
        repoUsuario.save(usuario);

        return "Guardado...";
    }

    /**
     * Postman PUT http://localhost:8080/actualizar/1
     * Ejemplo de Json para actualizar
     * usuario y email deben coincidir
     * El query param "id" debe de coincidir con el id obtenido en GET /usuarios
     * {
     *         "usuario": "1Alex",
     *         "nombre": "Alexx",
     *         "apellido": "Pacheco",
     *         "email": "1@email.com",
     *         "contrasena": "contrasena1234",
     *         "wallet": {
     *             "montoDolares": 0.00,
     *             "cantidadBTC": 0.00,
     *             "cantidadETH": 0.00,
     *             "fechaHoraCompraVenta": null,
     *             "historialCompraVenta": null
     *         }
     * }
     * @param id id del usuario a actualizar
     * @param usuario usuario que se actualizara
     * @return " Usuario "id" actualizado..." en caso de existir, caso contrario "Usuario no encontrado".
     */
    @PutMapping(value = "/actualizar/{id}")
    public String actualizarUsuario(@PathVariable long id, @RequestBody Usuario usuario) {
        Usuario actualizadoUsuario = repoUsuario.findById(id).orElse(null);

        if (actualizadoUsuario != null) {
            actualizadoUsuario.setUsuario(usuario.getUsuario());
            actualizadoUsuario.setNombre(usuario.getNombre());
            actualizadoUsuario.setApellido(usuario.getApellido());
            actualizadoUsuario.setContrasena(usuario.getContrasena());

            // Actualizar la wallet asociada
            Wallet wallet = actualizadoUsuario.getWallet();
            if (wallet != null) {
                wallet.setMontoDolares(usuario.getWallet().getMontoDolares());
                wallet.setCantidadBTC(usuario.getWallet().getCantidadBTC());
                wallet.setCantidadETH(usuario.getWallet().getCantidadETH());
                // Actualizar otros campos de la wallet si es necesario
                walletRepo.save(wallet);
            }

            // Guardar la actualización del usuario
            repoUsuario.save(actualizadoUsuario);

            return "Usuario " + id + " Actualizado...";
        } else {
            return "Usuario no encontrado.";
        }
    }

    /**
     *Postman DEL  http://localhost:8080/eliminar/1
     * el id debe de existir y coincidir on el "id" obtenido en el metodo GET /usuarios
     * @param id id del usuario a eliminar
     * @return "Usuario "id" eliminado..."
     */
    @DeleteMapping(value = "/eliminar/{id}")
    public String eliminarUsuario(@PathVariable long id) {
        Usuario eliminadoUsuario = repoUsuario.findById(id).get();
        repoUsuario.delete(eliminadoUsuario);
        return "Usuario " + id + " eliminado... ";

    }
}
