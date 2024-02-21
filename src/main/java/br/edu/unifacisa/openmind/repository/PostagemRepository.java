package br.edu.unifacisa.openmind.repository;

import br.edu.unifacisa.openmind.model.Postagem;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface PostagemRepository extends JpaRepository<Postagem, Integer> {

    List <Postagem> findAllByOrderByDataPostagemDesc();

    List<Postagem> findByAutorIdOrderByDataPostagemDesc(Integer autorId);
}
