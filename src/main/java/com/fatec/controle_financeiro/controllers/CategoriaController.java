package com.fatec.controle_financeiro.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

//import org.hibernate.mapping.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fatec.controle_financeiro.domain.categoria.CategoriaRepository;
import com.fatec.controle_financeiro.entities.Categoria;

@RestController
@RequestMapping("/api/categoria")
public class CategoriaController{

    @Autowired
    private CategoriaRepository categoriaRepository;
    private List<Categoria> categorias = new ArrayList<>();

    private String erro = "erro";

    //CREATE     
    @PostMapping()
    public ResponseEntity<Categoria> createCategoria(@RequestBody 
    Categoria categoria) {

         // Verificando se já existe uma categoria com a mesma descrição
         Optional<Categoria> categoriaExistente = categoriaRepository.findByDescricao(categoria.getDescricao());
         if (categoriaExistente.isPresent()) {
             return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
         }



         // Caso o campo 'ativo' não seja enviado, o valor padrão será true
         if (categoria.getAtivo() == null) {
            categoria.setAtivo(true); // Definindo ativo como true por padrão
        }

        Categoria categoriaCreated = categoriaRepository.save(categoria);
        return new ResponseEntity<>(categoriaCreated, HttpStatus.CREATED);
    }

     //READ
     @GetMapping()
     public ResponseEntity<List<Categoria>> getAllCategoria() {
         
         //return new ResponseEntity<>(clientes, HttpStatus.OK);
 
         List<Categoria> categorias = categoriaRepository.findAll();
  
         return new ResponseEntity<>(categorias, HttpStatus.OK);
     }

     //READ
     //READ
    @GetMapping("{id}")
    public ResponseEntity<Categoria> getById(@PathVariable Long id) {
        // Percorre a lista de usuários para encontrar o usuário com o ID correspondente
        for (Categoria categoria : categorias) {
            if (categoria.getId() == id) {
            
                return new ResponseEntity<>(categoria, HttpStatus.OK);
            }
        }
        
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    //UPDATE
    @PutMapping("{id}")
    public ResponseEntity<Categoria> updateCategoria(@PathVariable Long id, @RequestBody Categoria entity) {
         // Percorre a lista de usuários para encontrar o usuário com o ID correspondente
         for (Categoria categoria : categorias) {
            if (categoria.getId() == id) {
                // Se o usuário for encontrado, atualiza suas informações
                categoria.setDescricao(entity.getDescricao());
                

                // Retorna o usuário atualizado com status 200 OK
                return new ResponseEntity<>(categoria, HttpStatus.OK);
            }
        }
        // Se o usuário não for encontrado, retorna status 404 Not Found
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    //DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCategoria(@PathVariable Long id) {
        // Percorre a lista de usuários para encontrar o usuário com o ID correspondente
        for (Categoria categoria : categorias) {
            if (categoria.getId() == id) {
                // Se o usuário for encontrado, remove-o da lista
                categorias.remove(categoria);
                // Retorna status 204 No Content
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
        }
        // Se o usuário não for encontrado, retorna status 404 Not Found
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

}