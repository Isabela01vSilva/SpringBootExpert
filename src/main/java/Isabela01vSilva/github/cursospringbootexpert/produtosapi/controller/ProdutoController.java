package Isabela01vSilva.github.cursospringbootexpert.produtosapi.controller;

import Isabela01vSilva.github.cursospringbootexpert.produtosapi.model.Produto;
import Isabela01vSilva.github.cursospringbootexpert.produtosapi.repository.ProdutoRepository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("produtos")
public class ProdutoController {

    @Autowired
    private ProdutoRepository produtoRepository;

    @PostMapping
    public Produto salvar(@RequestBody Produto produto){
        System.out.println("Produto recebido" + produto);

        var id = UUID.randomUUID().toString();
        produto.setId(id);

        produtoRepository.save(produto);
        return produto;
    }

    @GetMapping("/{id}")
    public Produto obterPorId(@PathVariable("id") String id){
        return produtoRepository.findById(id).orElse(null);
    }

    @DeleteMapping("{id}")
    public void deletar(@PathVariable("id") String id) {
        produtoRepository.deleteAllById(Collections.singleton(id));
    }

    @PutMapping("{id}")
    public void atualizar(@PathVariable("id") String id, @RequestBody Produto produto) {
        produto.setId(id);
        produtoRepository.save(produto);
    }

    @GetMapping
    public List<Produto> buscar(@RequestParam("nome") String nome) {
       return produtoRepository.findByNome(nome);
    }
}
