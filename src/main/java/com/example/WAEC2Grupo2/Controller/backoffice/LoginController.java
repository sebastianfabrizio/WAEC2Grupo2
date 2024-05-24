package com.example.WAEC2Grupo2.Controller.backoffice;

import com.example.WAEC2Grupo2.Model.bd.Usuario;
import com.example.WAEC2Grupo2.Model.dto.response.RespuestaResponse;
import com.example.WAEC2Grupo2.Services.IUsuarioService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.AllArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@Controller
@RequestMapping("/auth")
public class LoginController {

    private BCryptPasswordEncoder encoder;
    private IUsuarioService usuarioService;

    @GetMapping("/login")
    public String login(){
        return "backoffice/auth/login";
    }

    @GetMapping("/login-success")
    public String loginSuccess(){
        return "redirect:/auth/dashboard";
    }

    @GetMapping("/dashboard")
    public String dashboard(HttpServletRequest request){
        HttpSession session = request.getSession();
        UserDetails userDetails = (UserDetails)
                SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        session.setAttribute("nomusuario", "Bienvenido : " + userDetails.getUsername());
        return "backoffice/auth/home";
    }

    @GetMapping("/registrar")
    public String registraruser(Model model){
        model.addAttribute("u", new Usuario());
        return "backoffice/auth/registro";
    }

    @PostMapping("/registrar")
    public String registraruser(@ModelAttribute Usuario security, Model model){
        try{
            security.setPassword(encoder.encode(security.getPassword()));
            security.setActivo(true);
            usuarioService.guardarUsuario(security, security.getNomusuario());
            model.addAttribute("success", "Usuario Registrado Exitosamente");
            model.addAttribute("u", new Usuario());
        }catch(Exception ex) {
            System.out.println("Error : " + ex.getCause().getMessage());
        }
       return "backoffice/auth/registro";
    }

    @GetMapping("/cambiar-password")
    public String cambiarPassword(Model model) {
        model.addAttribute("user", new Usuario());
        return "backoffice/auth/cambiarpassword";
    }

    @PostMapping("/cambiar-password")
    public String cambiarPassword(@ModelAttribute("user") Usuario usuario, Model model) {
        try{
            UserDetails userDetails = (UserDetails)
                    SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            String password = encoder.encode(usuario.getPassword());
            String nomusuario = userDetails.getUsername();
            usuarioService.actualizarUsuario(password, nomusuario);
            model.addAttribute("success", "Se Cambio El Password");
            model.addAttribute("user", new Usuario());
        }catch (Exception e) {
            System.out.println("Error en : " + e.getCause().getMessage());
        }
        return "backoffice/auth/cambiarpassword";
    }
}
