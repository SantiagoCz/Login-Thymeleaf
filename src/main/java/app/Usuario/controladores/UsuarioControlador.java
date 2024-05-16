package app.Usuario.controladores;

import app.Usuario.clases.UsuarioDto;
import app.Usuario.entidades.*;
import app.Usuario.servicios.PersonaServicio;
import app.Usuario.servicios.UsuarioServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;


@RestController
@RequestMapping("/usuario")
public class UsuarioControlador {

    @Autowired
    private UsuarioServicio usuarioServicio;
    @Autowired
    private PersonaServicio personaServicio;

    @GetMapping(value = {"/nuevo"})
    public ModelAndView nuevoUsuario() {

        ModelAndView mav = new ModelAndView();
        mav.setViewName("fragments/base");
        mav.addObject("title", "Registrar Usuario");
        mav.addObject("view", "createForms/usuario-form");
        mav.addObject("usuario", new UsuarioDto());
        mav.addObject("includeScript", true);
        return mav;
    }

    @PostMapping("/guardar")
    public RedirectView guardarUsuario(@ModelAttribute UsuarioDto usuario, RedirectAttributes redirectAttributes){

        if (usuario.getPersona().getNombre().isEmpty() || usuario.getPersona().getApellido().isEmpty() || usuario.getPersona().getDni().isEmpty() || usuario.getPersona().getTelefono().isEmpty()) {
            redirectAttributes.addFlashAttribute("error", "No fue posible registrar el usuario");
            redirectAttributes.addFlashAttribute("alertScript", true);
            return new RedirectView("/usuario/nuevo", true);
        }

        //String contrasenia = usuario.getPersona().getDni();
        BCryptPasswordEncoder coder = new BCryptPasswordEncoder();
        String contraseniaCrypt = coder.encode(usuario.getUsuario().getContrasenia());

        usuario.getUsuario().setContrasenia(contraseniaCrypt);
        usuario.getUsuario().setRol(Rol.ADMIN);
        usuario.getUsuario().setPersona(usuario.getPersona());

        personaServicio.crearPersona(usuario.getPersona());
        usuarioServicio.crearUsuario(usuario.getUsuario());

        redirectAttributes.addFlashAttribute("success", "Usuario registrado con exito");
        redirectAttributes.addFlashAttribute("alertScript", true);
        return new RedirectView("/", true);
    }

}