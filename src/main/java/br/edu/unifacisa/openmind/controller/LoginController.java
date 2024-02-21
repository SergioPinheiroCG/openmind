package br.edu.unifacisa.openmind.controller;

import br.edu.unifacisa.openmind.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.ui.Model;

@Controller
public class LoginController {

    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("/login")
    public String loginForm(@RequestParam(required = false) String error, Model model) {
        model.addAttribute("error", error);
        return "login";
    }

    @PostMapping("/login")
    public String processLogin(@RequestParam String email, @RequestParam String password, Model model) {
        if (usuarioService.validarCredenciais(email, password)) {

            return "redirect:/nova_postagem";// Credenciais válidas, redirecione para a postagem
        } else {

            return "redirect:/novo_usuario";// Se estiver em branco ou nao existir vai para a tela de cadastro

        }
    }
}