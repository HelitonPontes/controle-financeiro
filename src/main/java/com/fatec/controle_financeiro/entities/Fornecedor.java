package com.fatec.controle_financeiro.entities;

import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "fornecedores")
public class Fornecedor {
   @Id

    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private int id;

    @Column(nullable = false, length = 60)
    private String nome;
 
    public Fornecedor() {
    }
 
    public Fornecedor(int id, String nome) {
        this.id = id;
        setNome(nome);
    }
 
    public int getId() {
        return id;
    }
 
    public void setId(int id) {
        this.id = id;
    }
 
    public String getNome() {
        return nome;
    }
 
    public void setNome(String nome) {
        if (nome == null || nome.trim().isEmpty()) {
            throw new IllegalArgumentException("O nome não pode ser nulo ou vazio");
        }
        this.nome = nome;
    }
 
    @Override
    public String toString() {
        return "Cliente01{id=" + id + ", nome='" + nome + "'}";
    }
 
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Fornecedor fornecedor = (Fornecedor) o; // Corrigido para Cliente01
        return id == fornecedor.id && Objects.equals(nome, fornecedor.nome);
    }
 
    @Override
    public int hashCode() {
        return Objects.hash(id, nome);
    }
}
 
