package app.Usuario.servicios;

import app.Usuario.entidades.Usuario;
import app.Usuario.repositorios.UsuarioRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class UsuarioServicio implements UserDetailsService {

        @Autowired
        private UsuarioRepositorio usuarioRepositorio;

        public Usuario crearUsuario(Usuario usuario) {
            return usuarioRepositorio.save(usuario);
        }

        public Usuario modificarUsuario(Usuario usuario) {
            return usuarioRepositorio.save(usuario);
        }

        public List<Usuario> traerUsuarios() {
            return usuarioRepositorio.findAll();
        }

        public Usuario traerUsuarioPorDni(String dni) {
            return usuarioRepositorio.findUsuarioByPersona_Dni(dni);
        }


    @Override
    public UserDetails loadUserByUsername(String dni) throws UsernameNotFoundException {
        Usuario usuario = usuarioRepositorio.findUsuarioByPersona_Dni(dni);

        if (usuario == null) {
            throw new UsernameNotFoundException("Usuario no encontrado: " + usuario);
        }

        List<GrantedAuthority> authorities = buildAuthorities(usuario);
        return buildUser(usuario, authorities);
    }

    public UserDetails buildUser(Usuario usuario, List<GrantedAuthority> authorities) {
        return new User(
                usuario.getPersona().getDni(),
                usuario.getContrasenia(),
                authorities
        );
    }

    public List<GrantedAuthority> buildAuthorities(Usuario usuario) {
        GrantedAuthority authority = new SimpleGrantedAuthority("ROLE_" + usuario.getRol());
        return Collections.singletonList(authority);
    }

}
