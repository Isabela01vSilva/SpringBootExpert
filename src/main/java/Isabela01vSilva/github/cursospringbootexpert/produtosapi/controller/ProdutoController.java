package Isabela01vSilva.github.cursospringbootexpert.produtosapi.controller;

import Isabela01vSilva.github.cursospringbootexpert.produtosapi.model.Produto;
import Isabela01vSilva.github.cursospringbootexpert.produtosapi.repository.ProdutoRepository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("produtos")
public class ProdutoController {

    private ProdutoRepository produtoRepository;

    public ProdutoController(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    @PostMapping
    @Transactional
    public Produto salvar(@RequestBody Produto produto){
        System.out.println("Produto recebido" + produto);

        var id = UUID.randomUUID().toString();
        produto.setId(id);

        produtoRepository.save(produto);
        return produto;
    }

    @GetMapping("/{id}")
    @Transactional
    public Produto obterPorId(@PathVariable("id") String id){
        return produtoRepository.findById(id).orElse(null);
    }
}
