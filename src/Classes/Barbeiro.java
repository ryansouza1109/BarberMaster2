/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Classes;

import javax.swing.JOptionPane;

/**
 *
 * @author ryanp
 */
public class Barbeiro extends Funcionario{
    
     private String especialidade;
    
    
   
   

    public Barbeiro(String nome, String CPF, String senha, String telefone, String especialidade , String cargo) {
        super(nome,  CPF, senha , telefone,cargo);
        this.especialidade = especialidade;
        
      JOptionPane.showMessageDialog(null , "Cadastro registrado!");
        
    }
    
}
