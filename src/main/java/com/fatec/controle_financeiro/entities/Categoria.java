package com.fatec.controle_financeiro.entities;

public class Categoria {

    private int id;
    private String Descricao;

    public Categoria (){

    }

    public Categoria(int id, String descricao) {
        this.id = id;
        Descricao = descricao;
    }
    public int getId() {
        return id;
    }
    public String getDescricao() {
        return Descricao;
        
    }
    public void setId(int id) {
        this.id = id;
    }
    public void setDescricao(String descricao) {
        Descricao = descricao;
    }
    
    
    
}
