/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Classes;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author ryanp
 */
public class Cliente {
    
    private String nome;
    private String telefone;
    private String email;
    private String senha;
    private String confirmarSenha;
    private List<Agendamentos> agendamentos;
    
     public String getNome() {
        return nome;
    }





    public String getTelefone() {
        return telefone;
    }

    public void redefinirTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public Cliente(String nome, String telefone, String email, String senha) {
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
        this.senha = senha;
         this.agendamentos = new ArrayList<>();
        
    }

    


    public String getSenha() {
        return senha;
    }

    public void RedefinirSenha(String senha ,String novaSenha) {
        if(senha.equals(this.senha))
        {
            this.senha = novaSenha;
            JOptionPane.showMessageDialog(null ,"Senha Redefinida");
        } else {
            JOptionPane.showMessageDialog(null ,"Senha Invalida");
        }
    }

    public String getConfirmarSenha() {
        return confirmarSenha;
    }

    public void setConfirmarSenha(String confirmarSenha) {
        if(this.senha == confirmarSenha)
        {
            JOptionPane.showMessageDialog(null ,"Senha correta");
        } else {
                 JOptionPane.showMessageDialog(null ,"Senha incorreta");
                }
    }
    
         
public void agendarServico(String data, String hora, String descricao, String formaPagamento) {
    // Inicializa a lista de agendamentos, caso ela seja nula
    if (agendamentos == null) {
        agendamentos = new ArrayList<>();
    }

    Agendamentos agendamento = new Agendamentos(data, hora, descricao, this, formaPagamento);
    agendamentos.add(agendamento);

    // Informar ao usuário que o agendamento foi salvo
    JOptionPane.showMessageDialog(null, "Agendamento realizado com sucesso!");
}

     
     public void cancelarAgendamento(String hora, String data)
     {
         Agendamentos agendamentoParaRemover = null;
         
           for (Agendamentos agendamento : agendamentos) {
            if (agendamento.getData().equals(data) ||agendamento.getHora().equals(hora) ) {
                agendamentoParaRemover = agendamento;
                break;
            }
        }
           if (agendamentoParaRemover != null) {
            agendamentos.remove(agendamentoParaRemover);
            JOptionPane.showMessageDialog(null , "Agendamento cancelado com sucesso.");
        } else {
             JOptionPane.showMessageDialog(null , "Agendamento não encontrado para a data e hora fornecidas.");
        }
           
             
    }
     
     
     
  
}
