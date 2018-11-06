/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.atividade08.business;

import com.example.atividade08.dao.FuncionarioDAO;
import com.example.atividade08.entity.Funcionario;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author mathe
 */

@Component
public class FuncionarioBusiness {
    
    private FuncionarioDAO funcionarioDAO;
    
    @Autowired
    public FuncionarioBusiness(FuncionarioDAO funcionarioDAO){
        this.funcionarioDAO = funcionarioDAO;
    }
    
    public void create(){
        if (funcionarioDAO.read().isEmpty()) {
            funcionarioDAO.criarFuncionarios();
        }
    }

    public List<Funcionario> read(){
        return funcionarioDAO.read();
    }

    public Funcionario update(Funcionario funcionario){
        return funcionarioDAO.update(funcionario);
    }

    public Funcionario delete(Long id){
        return funcionarioDAO.delete(id);
    }
}
