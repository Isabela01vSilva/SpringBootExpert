package Isabela01vSilva.github.cursospringbootexpert.produtosapi.repository;

import Isabela01vSilva.github.cursospringbootexpert.produtosapi.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProdutoRepository extends JpaRepository <Produto, String>{

    List<Produto> findByNome(String nome);
}
