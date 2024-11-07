package com.fatec.controle_financeiro.controllers;

import java.util.ArrayList;
import java.util.List;

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


import com.fatec.controle_financeiro.domain.fornecedor.FornecedorRepository;
import com.fatec.controle_financeiro.entities.Fornecedor;



@RestController
@RequestMapping("/api/fornecedor")
public class FornecedorController {

    @Autowired
    private FornecedorRepository fornecedorRepository;
    
    private List<Fornecedor> fornecedores = new ArrayList<>();
   
    
    //CREATE    
    @PostMapping()
    public ResponseEntity<Fornecedor> createFornecedor(@RequestBody Fornecedor fornecedor) {

        Fornecedor fornecedorCreated = fornecedorRepository.save(fornecedor);
        return new ResponseEntity<>(fornecedorCreated, HttpStatus.CREATED);

        
    }


    //READ

    @GetMapping()
    public ResponseEntity<List<Fornecedor>> getAllFornecedor() {
        
       
        List<Fornecedor> fornecedores = fornecedorRepository.findAll();
 
        return new ResponseEntity<>(fornecedores, HttpStatus.OK);
    }
    
    @GetMapping("{id}")
    public ResponseEntity<Fornecedor> getById(@PathVariable int id) {
        // Percorre a lista de usuários para encontrar o usuário com o ID correspondente
        for (Fornecedor fornecedor : fornecedores) {
            if (fornecedor.getId() == id) {
                // Se o usuário for encontrado, retorna-o com status 200 OK
                return new ResponseEntity<>(fornecedor, HttpStatus.OK);
            }
        }
        // Se o usuário não for encontrado, retorna status 404 Not Found
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    
    //UPDATE
    @PutMapping("{id}")
    public ResponseEntity<Fornecedor> updateFornecedor(@PathVariable int id, @RequestBody Fornecedor entity) {
         // Percorre a lista de usuários para encontrar o usuário com o ID correspondente
         for (Fornecedor fornecedor : fornecedores) {
            if (fornecedor.getId() == id) {
                // Se o usuário for encontrado, atualiza suas informações
                fornecedor.setNome(entity.getNome());
                

                // Retorna o usuário atualizado com status 200 OK
                return new ResponseEntity<>(fornecedor, HttpStatus.OK);
            }
        }
        // Se o usuário não for encontrado, retorna status 404 Not Found
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    //DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFornecedor(@PathVariable int id) {
        // Percorre a lista de usuários para encontrar o usuário com o ID correspondente
        for (Fornecedor fornecedor : fornecedores) {
            if (fornecedor.getId() == id) {
                // Se o usuário for encontrado, remove-o da lista
               fornecedores.remove(fornecedor);
                // Retorna status 204 No Content
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
        }
        // Se o usuário não for encontrado, retorna status 404 Not Found
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
  


    

