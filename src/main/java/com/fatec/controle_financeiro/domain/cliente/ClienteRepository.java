package com.fatec.controle_financeiro.domain.cliente;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.fatec.controle_financeiro.entities.Cliente;


    public interface ClienteRepository  extends JpaRepository<Cliente, Integer> {
          // Busca por nome usando =
    List<Cliente> findAllByNome(String nome);
 
    // Busca por nome usando LIKE %nameparam%
    List<Cliente> findAllByNomeContaining(String nome);
 
    //// Busca por nome usando LIKE com query manual
    @Query("SELECT c FROM Cliente c WHERE c.nome LIKE %:nome%")
    List<Cliente> buscarClientesPorNome(@Param("nome") String  nome);
}

    

