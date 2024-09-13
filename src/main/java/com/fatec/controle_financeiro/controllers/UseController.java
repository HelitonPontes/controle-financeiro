package com.fatec.controle_financeiro.controllers;

import java.util.ArrayList;

import org.hibernate.mapping.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fatec.controle_financeiro.entities.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;



@RestController
@RequestMapping("/api/use")


public class UseController {

    private List<User> usuarios = new ArrayList<>();
    private int proximoId = 1;


    //Create

    @SuppressWarnings("rawtypes")
    @PostMapping ("path")
    public ResponseEntity<User> createUse (@RequestBody User usuario)

    usuario.setId(proximoId++);
    usuarios.add(usuario);

    return  new ResponseEntity (usuario, HttpStatus.CREATED);

    
    
}

//read
 @GetMapping()
 