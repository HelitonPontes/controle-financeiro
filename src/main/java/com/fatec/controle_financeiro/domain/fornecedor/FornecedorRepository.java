package com.fatec.controle_financeiro.domain.fornecedor;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


import com.fatec.controle_financeiro.entities.Fornecedor;

public interface FornecedorRepository extends JpaRepository<Fornecedor, Integer> {

   
    // Busca por nome usando =
    List<Fornecedor> findAllByNome(String nome);
 
    // Busca por nome usando LIKE %nameparam%
    List<Fornecedor> findAllByNomeContaining(String nome);
 
    //// Busca por nome usando LIKE com query manual
    @Query("SELECT c FROM Fornecedor c WHERE c.nome LIKE %:nome%")
    List<Fornecedor> buscarFornecedoresPorNome(@Param("nome") String  nome);
}
    

