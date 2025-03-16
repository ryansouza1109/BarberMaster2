/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Classes;

/**
 *
 * @author ryanp
 */
public class Funcionario {
    
    private String nome;
    private double salario;
    private String CPF;  
    private String senha;
    private String confirmarSenha;
    private String telefone;
    private String cargo;
    
     public Funcionario(String nome, String CPF, String senha, String telefone, String cargo) {
  
        this.nome = nome;
        this.CPF = CPF;
        this.senha = senha;
        this.telefone = telefone;
        this.cargo = cargo;

    }

    public String getNome() {
        return nome;
    }

 

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }


    public String getCPF() {
        return CPF;
    }
    
}
