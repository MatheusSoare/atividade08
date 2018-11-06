/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.atividade08.controller;

import com.example.atividade08.business.FuncionarioBusiness;
import com.example.atividade08.entity.Funcionario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author mathe
 */

@RestController
public class FuncionarioRestController {
    
    private FuncionarioBusiness funcionarioBusiness;
    
    @Autowired
    public FuncionarioRestController(FuncionarioBusiness funcionarioBusiness) {
        this.funcionarioBusiness = funcionarioBusiness;
    }
    
    @PostMapping(value = "/database/create", produces = MediaType.APPLICATION_JSON_VALUE)
    public String create() {
        funcionarioBusiness.create();
        return funcionarioBusiness.read().toString();

    }

    @GetMapping(value = "/funcionario", produces = MediaType.APPLICATION_JSON_VALUE)
    public String read() {
        return funcionarioBusiness.read().toString();
    }

    @PutMapping(value = "/funcionario/update/")
    public String update(@RequestBody Funcionario funcionario){
        return funcionarioBusiness.update(funcionario).toString();
    }

    @DeleteMapping(value = "/funcionario/delete/{funcionarioId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public String delete(@PathVariable String funcionarioId){
        long id = Long.parseLong(funcionarioId);
        return funcionarioBusiness.delete(id).toString();
    }
}
