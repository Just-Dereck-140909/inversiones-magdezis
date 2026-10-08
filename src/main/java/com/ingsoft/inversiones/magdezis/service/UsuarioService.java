
package main.java.com.ingsoft.inversiones.magdezis.service;

import main.java.com.ingsoft.inversiones.magdezis.dto.LoginRequest;
import main.java.com.ingsoft.inversiones.magdezis.dto.RegistroRequest;
import main.java.com.ingsoft.inversiones.magdezis.model.Usuario;
import main.java.com.ingsoft.inversiones.magdezis.repository.UsuarioRepository;

import main.mindrot.jbcrypt.BCrypt;

public class UsuarioService {

    private UsuarioRepository usuarioRepository;

    public UsuarioService() {
        usuarioRepository = new UsuarioRepository();
    }

    public boolean registrarUsuario(
            RegistroRequest request) {

        String hash = BCrypt.hashpw(
                request.getContrasena(),
                BCrypt.gensalt()
        );

        Usuario usuario = new Usuario();

        usuario.setNombre(request.getNombre());
        usuario.setApellido(request.getApellido());
        usuario.setCorreo(request.getCorreo());
        usuario.setContrasenaHash(hash);
        usuario.setIdRol(1);

        return usuarioRepository.registrarUsuario(usuario);
    }

    public Usuario iniciarSesion(
            LoginRequest request) {

        Usuario usuario =
                usuarioRepository.buscarPorCorreo(
                        request.getCorreo()
                );

        if (usuario == null) {
            return null;
        }

        boolean contrasenaCorrecta =
                BCrypt.checkpw(
                        request.getContrasena(),
                        usuario.getContrasenaHash()
                );

        if (contrasenaCorrecta) {
            return usuario;
        }

        return null;
    }
}
