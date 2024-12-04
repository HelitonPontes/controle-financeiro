package com.fatec.controle_financeiro.domain.categoria;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.fatec.controle_financeiro.entities.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Long>  {

  List<Categoria> findAllByDescricao(String descricao);
 
  // Busca por nome usando LIKE %nameparam%
  List<Categoria> findAllByDescricaoContaining(String descricao);

  //// Busca por nome usando LIKE com query manual
  @Query("SELECT c FROM Categoria c WHERE c.descricao LIKE %:descricao%")
  List<Categoria> buscarCategoriaPorDescricao(@Param("descricao") String  descricao);
  
}
 