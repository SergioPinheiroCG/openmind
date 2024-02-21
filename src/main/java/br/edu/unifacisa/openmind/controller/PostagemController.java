package br.edu.unifacisa.openmind.controller;

import br.edu.unifacisa.openmind.model.Postagem;
import br.edu.unifacisa.openmind.repository.PostagemRepository;
import br.edu.unifacisa.openmind.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;


import java.util.Date;
import java.util.List;

@Controller
public class PostagemController {

    @Autowired
    private PostagemRepository repository;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @GetMapping("/nova_postagem")
    public String novaPostagemForm(Model model) {
        model.addAttribute("postagem", new Postagem());
        model.addAttribute("usuarios", usuarioRepository.findAll());
        return "form_postagem";
    }

    @PostMapping("/nova_postagem")
    public String novaPostagem(@ModelAttribute("postagem") Postagem postagem) {
        postagem.setDataPostagem(new Date()); // Define a data atual
        repository.save(postagem); //salva no banco de dados
        return "redirect:/listar_postagem";
    }

    @GetMapping("/listar_postagem")
    public String listarPostagens(Model model) {
        List<Postagem> postagens = repository.findAllByOrderByDataPostagemDesc();
        model.addAttribute("postagens", postagens);
        return "listar_postagem";
    }

    @GetMapping("/listar_por_autor/{autorId}")
    public String listarPostagensPorAutor(@PathVariable Integer autorId, Model model) {
        List<Postagem> postagens = repository.findByAutorIdOrderByDataPostagemDesc(autorId);
        model.addAttribute("postagens", postagens);
        return "listar_por_autor";
    }

}
