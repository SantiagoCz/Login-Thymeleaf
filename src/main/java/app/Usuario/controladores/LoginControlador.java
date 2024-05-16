package app.Usuario.controladores;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

@RestController
public class LoginControlador {

    @GetMapping("/login")
    public ModelAndView mostrarLoginForm(Model model,
                                         @RequestParam(name = "error", required = false) String error,
                                         @RequestParam(name = "logout", required = false) String logout) {

        ModelAndView maw = new ModelAndView();
        maw.setViewName("fragments/base");
        maw.addObject("title", "Iniciar sesión");
        maw.addObject("view", "auth/login");
        model.addAttribute("error", error);
        model.addAttribute("logout", logout);
        maw.addObject("includeLoginFormScript", true);
        return maw;
    }

/*
    @PostMapping("/loginerror")
    public ResponseEntity<String> loginError() {
        String errorMessage = "Credenciales inválidas";
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{\"error\": \"" + errorMessage + "\"}");
    }
*/

/*
    @GetMapping({"/loginSuccess"})
    public RedirectView loginCheck() {
        return new RedirectView("/establecimiento/nuevo");
    }

    @GetMapping("/loginSuccess")
    public ResponseEntity<String> loginCheck() {
        String mensaje = "¡Inicio de sesión exitoso!";
        return ResponseEntity.status(HttpStatus.OK).body(mensaje);
    }
*/
}
