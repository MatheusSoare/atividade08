/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.atividade08.dao;

import com.example.atividade08.entity.Funcionario;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;

/**
 *
 * @author mathe
 */

@Component
public class FuncionarioDAO {
    
    private List<Funcionario> funcionarios = new ArrayList<>();
    
    public FuncionarioDAO(){}
    
    public FuncionarioDAO(List<Funcionario> funcionarios){
        
        this.funcionarios = funcionarios;
        
    }
    
    public void criarFuncionarios(){
        
        this.funcionarios.add(new Funcionario( new Long(1),"Matheus Alves Soares",21,5000.00f));
        this.funcionarios.add(new Funcionario( new Long(2),"Carlos Roberto Sanches",24,1000.00f));
        this.funcionarios.add(new Funcionario( new Long(3),"Nelson Boralli Neto",21,1010.00f));
        this.funcionarios.add(new Funcionario( new Long(4),"Rodrigo Miyashiro Muci",23,500.00f));
        this.funcionarios.add(new Funcionario( new Long(5),"Maycon Alves Soares",19,4000.00f));
        this.funcionarios.add(new Funcionario( new Long(6),"Cauana Maria",18,6000.00f));
        this.funcionarios.add(new Funcionario( new Long(7),"Wagner Antonio Soares",47,2000.00f));
        this.funcionarios.add(new Funcionario( new Long(8),"Eliane Aparecida Alves",47,10000.00f));
        this.funcionarios.add(new Funcionario( new Long(9),"Ruan Barbosa",35,2500.00f));
        this.funcionarios.add(new Funcionario( new Long(10),"Joao Figueiredo",70,5000.00f));
        
    } 
    
    public List<Funcionario> read(){
        
        return this.funcionarios;
        
    }
    
    public Funcionario update(Funcionario funcionario){
        
        int x = 0;
        
        for(Funcionario f : this.read()){
            if(f.getId().equals(funcionario.getId())){
                return this.read().set(x, funcionario);
            }
            x++;
        }
        
        return null;
        
    }
    
    public Funcionario delete(Long id){
        
        Funcionario funcionario = this.read().stream().filter(e -> e.getId() == id.intValue()).findAny().get();
        this.read().remove(funcionario);
        return funcionario;
        
    }
}
