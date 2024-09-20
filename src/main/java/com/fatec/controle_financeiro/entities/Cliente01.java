package com.fatec.controle_financeiro.entities;

import java.util.Objects;

public class Cliente01 {

    private int id;
    private String nome;
 
    public Cliente01() {
    }
 
    public Cliente01(int id, String nome) {
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
        Cliente01 cliente = (Cliente01) o; // Corrigido para Cliente01
        return id == cliente.id && Objects.equals(nome, cliente.nome);
    }
 
    @Override
    public int hashCode() {
        return Objects.hash(id, nome);
    }
}
