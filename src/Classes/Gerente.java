/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Classes;




public class Gerente extends Funcionario {
    
      private String cargo;
      
      public Gerente(String nome, String CPF, String senha, String telefone) {
       
        super(nome, CPF, senha, telefone, "Gerente");
    }
    
}
