package com.fatec.controle_financeiro.entities;

public class Produto {

    private int id;
    private String nome;
    private double valorVenda;
    private double valorCompra;
    private int qtdEstoque;
    //private Categoria categoria;

    public Produto (){
        
    }

    public Produto(int id, String nome, double valorVenda, double valorCompra, int qtdEstoque) {
        this.id = id;
        this.nome = nome;
        this.valorVenda = valorVenda;
        this.valorCompra = valorCompra;
        this.qtdEstoque = qtdEstoque;
        //this.categoria = categoria;
    }

    public int getId() {
        return id;
    }
    public String getNome() {
        return nome;
    }
    public double getValorVenda() {
        return valorVenda;
    }
    public double getValorCompra() {
        return valorCompra;
    }
    public int getQtdEstoque() {
        return qtdEstoque;
    }
   

    public void setId(int id) {
        this.id = id;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public void setValorVenda(double valorVenda) {
        this.valorVenda = valorVenda;
    }
    public void setValorCompra(double valorCompra) {
        this.valorCompra = valorCompra;
    }
    public void setQtdEstoque(int qtdEstoque) {
        this.qtdEstoque = qtdEstoque;
    }
   
    
}
