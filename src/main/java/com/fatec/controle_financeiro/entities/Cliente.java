package com.fatec.controle_financeiro.entities;

public class Cliente {

  private int id;
  private String nome;
  private String email;
  private String telefone;
  private String cidade;

  public Cliente (){

  }
  public Cliente(int id, String nome, String email, String telefone, String cidade) {
    this.id = id;
    this.nome = nome;
    this.email = email;
    this.telefone = telefone;
    this.cidade = cidade;
  }
  public int getId() {
    return id;
  }
  public String getNome() {
    return nome;
  }
  public String getEmail() {
    return email;
  }
  public String getTelefone() {
    return telefone;
  }
  public String getCidade() {
    return cidade;
  }
  public void setId(int id) {
    this.id = id;
  }
  public void setNome(String nome) {
    this.nome = nome;
  }
  public void setEmail(String email) {
    this.email = email;
  }
  public void setTelefone(String telefone) {
    this.telefone = telefone;
  }
  public void setCidade(String cidade) {
    this.cidade = cidade;
  }

  



  

  

  
}
