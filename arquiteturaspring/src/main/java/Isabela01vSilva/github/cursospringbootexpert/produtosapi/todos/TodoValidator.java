package Isabela01vSilva.github.cursospringbootexpert.produtosapi.todos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TodoValidator {

    @Autowired
    private TodoRepository todoRepository;

    public void validar(TodoEntity todo) {
        if(existeTodoComDescricao(todo.getDescricao())){
            throw new IllegalArgumentException("Já existe um TODO para essa descricao");
        }
    }

    private boolean existeTodoComDescricao(String descricao) {
        return todoRepository.existsByDescricao(descricao);
    }
}
