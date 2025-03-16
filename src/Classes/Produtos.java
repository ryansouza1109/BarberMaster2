/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Classes;

import java.util.List;

/**
 *
 * @author ryanp
 */
public class Produtos {
    
    private String nome;
    private double preco;
    List <Produtos> produtos;

    
    
    public Produtos(String nome, double preco) {
        
        
        this.nome = nome;
        this.preco = preco;
        
        
        
    }
    
    

    

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }
     
     
   
    
    
}
