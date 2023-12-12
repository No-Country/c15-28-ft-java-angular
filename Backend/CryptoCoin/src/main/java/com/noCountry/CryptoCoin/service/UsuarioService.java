package com.noCountry.CryptoCoin.service;

import com.noCountry.CryptoCoin.controller.DTO.MonedaDTO;
import com.noCountry.CryptoCoin.controller.DTO.UsuarioDTO;
import com.noCountry.CryptoCoin.domain.Moneda;
import com.noCountry.CryptoCoin.domain.Usuario;
import com.noCountry.CryptoCoin.repository.MonedaRepositoryJPA;
import com.noCountry.CryptoCoin.repository.UsuarioRepositoryJPA;
import jakarta.xml.bind.DatatypeConverter;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UsuarioService {

    private final UsuarioRepositoryJPA usuarioRepositoryJPA;
    private final MonedaRepositoryJPA monedaRepositoryJPA;

    public Usuario guardarUsuario(UsuarioDTO dto) throws NoSuchAlgorithmException {
        if (dto.getNombre() == null || dto.getNombre().isEmpty()) {
            throw new IllegalArgumentException("El nombre no puede estar vacio");
        } else {
            Usuario usuario = new Usuario();
            usuario.setNombre(dto.getNombre());
            usuario.setEmail(dto.getEmail());
            String passHashed = encriptarContrasenia(dto.getPassword());
            usuario.setPassword(passHashed);
            usuario.setSaldo(100000.0);

            return usuarioRepositoryJPA.save(usuario);
        }
    }

    public List<Usuario> getAll() {
        return usuarioRepositoryJPA.findAll();
    }

    public Usuario buscarUsuario(String mail) {
        return usuarioRepositoryJPA.findByEmail(mail);
    }

    public static String encriptarContrasenia(String contrasenia) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("MD5");
        md.update(contrasenia.getBytes());
        byte[] digest = md.digest();
        String passHashed = DatatypeConverter
                .printHexBinary(digest).toUpperCase();
        return passHashed;
    }

    public Optional<Usuario> buscarPorId(Long id) {
        return usuarioRepositoryJPA.findById(id);
    }

    public Usuario agregarCompra(MonedaDTO monedaDTO, Long id) {
        var usuario = usuarioRepositoryJPA.findById(id).get();
        Moneda moneda = new Moneda();
        moneda.setCantidad(monedaDTO.getCantidad());
        moneda.setTipoDeMoneda(monedaDTO.getTipoDeMoneda());
        moneda.setPrecio(monedaDTO.getPrecio());

        LocalDateTime myDateObj = LocalDateTime.now();
        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        String formattedDate = myDateObj.format(myFormatObj);
        moneda.setFecha(formattedDate);

        monedaRepositoryJPA.save(moneda);

        usuario.getMonedas().add(moneda);

        return usuarioRepositoryJPA.save(usuario);
    }

    public List<Moneda> listaDeMonedasDeUnUsuario(Long id) {
        var usuario = usuarioRepositoryJPA.findById(id).get();
        return usuario.getMonedas();
    }
}
