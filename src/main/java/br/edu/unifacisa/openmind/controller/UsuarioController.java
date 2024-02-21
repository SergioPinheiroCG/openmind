package br.edu.unifacisa.openmind.controller;

import br.edu.unifacisa.openmind.model.Usuario;
import br.edu.unifacisa.openmind.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class UsuarioController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @GetMapping("/novo_usuario")
    public String adicionarUsuarioForm() {
        return "adicionar_usuario";
    }

    @PostMapping("/adicionar_usuario")
    public String adicionarUsuario(@RequestParam String nome, @RequestParam String email, @RequestParam String password, Model model) {

        if (usuarioRepository.existsByEmail(email)) { // Verificar se ja existe o email no banco
            // se ja existir da uma mesagem de erro
            model.addAttribute("error", "Email ja esta sendo utilizado, adicione outro.");
            return "adicionar_usuario";// Redirecione para a tela de adicionar usuário
        }

        // Caso contrario, continue para o cadastro do usuario

        // Criando e salvando o usuario no banco de dados
        Usuario usuario = new Usuario();
        usuario.setNome(nome);
        usuario.setEmail(email);
        usuario.setPassword(password);
        usuarioRepository.save(usuario);
        return "redirect:/login";// Redirecione para a pagina de login apos adicionar o usuario
    }

    @GetMapping("/listar_usuario")
    public String listarUsuarios(Model model) {
        List<Usuario> usuarios = usuarioRepository.findAll();
        model.addAttribute("usuarios", usuarios);
        return "listar_usuario";
    }
}