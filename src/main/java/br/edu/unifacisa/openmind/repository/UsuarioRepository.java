package br.edu.unifacisa.openmind.repository;

import br.edu.unifacisa.openmind.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

    boolean existsByEmail(String email);
    Usuario findByEmail(String email);

}