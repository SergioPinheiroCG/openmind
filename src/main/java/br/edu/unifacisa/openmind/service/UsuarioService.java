package br.edu.unifacisa.openmind.service;


        import br.edu.unifacisa.openmind.model.Usuario;
        import br.edu.unifacisa.openmind.repository.UsuarioRepository;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    public boolean validarCredenciais(String email, String password) {
        Usuario usuario = usuarioRepository.findByEmail(email);// Busca o usuario pelo email
        return usuario != null && usuario.getPassword().equals(password);// Verifica se o usuario existe e a senha esta correta
    }

}