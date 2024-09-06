package com.fatec.controle_financeiro.controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fatec.controle_financeiro.controllers.Exercicio1Controller.User;

@RestController
@RequestMapping("/api/usuario")
public class usuarioController {
    
    //http://localhost:<port>/api/usuario/register
    //POST
    //Parametro: @RequestBody => enviar no corpo da requisicao (body)
    // @PostMapping  => CRIAÇÃO / CONSULTAS CM PARAMENTROS NO CORPO DA REQUISIÇÃO
    // @GetMapping => 
    //@PutMapping =>
    //@PatchMapping => Anexar 
    //@DeleteMapping =>  Delete _ Deletar



    @PostMapping("/register")
    
    public String registerUser(@RequestBody User user) {
        return "Bem-vindo, " + user.getName() + "! Você tem " + user.getAge() + " anos.";
    }
    
}