package Isabela01vSilva.github.cursospringbootexpert.produtosapi.repository;

import Isabela01vSilva.github.cursospringbootexpert.produtosapi.model.Produto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoRepository extends JpaRepository <Produto, String>{
}
