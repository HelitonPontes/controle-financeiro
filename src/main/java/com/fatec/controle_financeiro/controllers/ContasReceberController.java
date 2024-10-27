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

import com.fatec.controle_financeiro.domain.contasreceber.ContasReceberRepository;
import com.fatec.controle_financeiro.entities.ContasReceber;


@RestController
@RequestMapping("/api/contasreceber")
public class ContasReceberController {

    @Autowired
    private ContasReceberRepository contasreceberRepository;
    
    private List<ContasReceber> contasrecebers= new ArrayList<>();
   
    
    //CREATE     
    @PostMapping()
    public ResponseEntity<ContasReceber> createContasReceber(@RequestBody 
    ContasReceber contasreceber) {

        

        ContasReceber contasreceberCreated = contasreceberRepository.save(contasreceber);
        return new ResponseEntity<>(contasreceberCreated, HttpStatus.CREATED);
    }


    //READ

    @GetMapping()
    public ResponseEntity<List<ContasReceber>> getAllContasReceber() {
        
        //return new ResponseEntity<>(clientes, HttpStatus.OK);

        List<ContasReceber> contasrecebers = contasreceberRepository.findAll();
 
        return new ResponseEntity<>(contasrecebers, HttpStatus.OK);
    }
    
    @GetMapping("{id}")
    public ResponseEntity<ContasReceber> getById(@PathVariable Long id) {
        // Percorre a lista de usuários para encontrar o usuário com o ID correspondente
        for (ContasReceber contasreceber : contasrecebers) {
            if (contasreceber.getId() == id) {
            
                return new ResponseEntity<>(contasreceber, HttpStatus.OK);
            }
        }
        
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    
    //UPDATE
    @PutMapping("{id}")
    public ResponseEntity<ContasReceber> updateContasPagar(@PathVariable Long id, @RequestBody ContasReceber entity) {
         // Percorre a lista de usuários para encontrar o usuário com o ID correspondente
         for (ContasReceber contasreceber : contasrecebers) {
            if (contasreceber.getId() == id) {
                // Se o usuário for encontrado, atualiza suas informações
                contasreceber.setEmissao(entity.getEmissao());
                

                // Retorna o usuário atualizado com status 200 OK
                return new ResponseEntity<>(contasreceber, HttpStatus.OK);
            }
        }
        // Se o usuário não for encontrado, retorna status 404 Not Found
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    //DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCliente(@PathVariable Long id) {
        // Percorre a lista de usuários para encontrar o usuário com o ID correspondente
        for (ContasReceber contasreceber : contasrecebers) {
            if (contasreceber.getId() == id) {
                // Se o usuário for encontrado, remove-o da lista
                contasrecebers.remove(contasreceber);
                // Retorna status 204 No Content
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
        }
        // Se o usuário não for encontrado, retorna status 404 Not Found
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
    
    
   