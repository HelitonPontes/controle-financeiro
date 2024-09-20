package com.fatec.controle_financeiro.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.fatec.controle_financeiro.entities.Cliente;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/clientes01")
public class ClienteController01 {

    private List<Cliente> clientes = new ArrayList<>();
    private int nextId = 1;

    @PostMapping
    public ResponseEntity<Cliente> createCliente(@RequestBody Cliente cliente) {
        if (cliente.getNome() == null || cliente.getNome().trim().isEmpty()) {
            return ResponseEntity.badRequest().build(); // Validação simples
        }
        cliente.setId(nextId++);
        clientes.add(cliente);
        return ResponseEntity.status(HttpStatus.CREATED).body(cliente); // Status 201 Created
    }

    @GetMapping
    public ResponseEntity<List<Cliente>> getAllClientes() {
        return ResponseEntity.ok(clientes);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cliente> getClienteById(@PathVariable int id) {
        Optional<Cliente> cliente = clientes.stream()
                .filter(c -> c.getId() == id)
                .findFirst();
        return cliente.map(ResponseEntity::ok)
                      .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Cliente> updateCliente(@PathVariable int id, @RequestBody Cliente clienteAtualizado) {
        if (clienteAtualizado.getNome() == null || clienteAtualizado.getNome().trim().isEmpty()) {
            return ResponseEntity.badRequest().build(); // Validação
        }
        
        for (Cliente cliente : clientes) {
            if (cliente.getId() == id) {
                cliente.setNome(clienteAtualizado.getNome());
                return ResponseEntity.ok(cliente);
            }
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCliente(@PathVariable int id) {
        boolean removed = clientes.removeIf(cliente -> cliente.getId() == id);
        if (removed) {
            return ResponseEntity.ok("Cliente com id " + id + " foi removido.");
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
