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

import com.fatec.controle_financeiro.domain.contaspagar.ContasPagarRepository;
import com.fatec.controle_financeiro.entities.ContasPagar;

@RestController
@RequestMapping("/api/contaspagar")
public class ContasPagarController {

    @Autowired
    private ContasPagarRepository contaspagarRepository;
    
    private List<ContasPagar> contaspagars= new ArrayList<>();
   
    
    //CREATE     
    @PostMapping()
    public ResponseEntity<ContasPagar> createContasPagar(@RequestBody 
    ContasPagar contaspagar) {

        ContasPagar contaspagarCreated = contaspagarRepository.save(contaspagar);
        return new ResponseEntity<>(contaspagarCreated, HttpStatus.CREATED);
    }

    //READ
    @GetMapping()
    public ResponseEntity<List<ContasPagar>> getAllContasPagar() {
        
        //return new ResponseEntity<>(clientes, HttpStatus.OK);

        List<ContasPagar> contaspagars = contaspagarRepository.findAll();
 
        return new ResponseEntity<>(contaspagars, HttpStatus.OK);
    }
    
    //READ
    @GetMapping("{id}")
    public ResponseEntity<ContasPagar> getById(@PathVariable Long id) {
        // Percorre a lista de usuários para encontrar o usuário com o ID correspondente
        for (ContasPagar contaspagar : contaspagars) {
            if (contaspagar.getId() == id) {
            
                return new ResponseEntity<>(contaspagar, HttpStatus.OK);
            }
        }
        
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    
    //UPDATE
    @PutMapping("{id}")
    public ResponseEntity<ContasPagar> updateContasPagar(@PathVariable Long id, @RequestBody ContasPagar entity) {
         // Percorre a lista de usuários para encontrar o usuário com o ID correspondente
         for (ContasPagar contaspagar : contaspagars) {
            if (contaspagar.getId() == id) {
                // Se o usuário for encontrado, atualiza suas informações
                contaspagar.setEmissao(entity.getEmissao());
                

                // Retorna o usuário atualizado com status 200 OK
                return new ResponseEntity<>(contaspagar, HttpStatus.OK);
            }
        }
        // Se o usuário não for encontrado, retorna status 404 Not Found
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    //DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCliente(@PathVariable Long id) {
        // Percorre a lista de usuários para encontrar o usuário com o ID correspondente
        for (ContasPagar contaspagar : contaspagars) {
            if (contaspagar.getId() == id) {
                // Se o usuário for encontrado, remove-o da lista
                contaspagars.remove(contaspagar);
                // Retorna status 204 No Content
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
        }
        // Se o usuário não for encontrado, retorna status 404 Not Found
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
      
               