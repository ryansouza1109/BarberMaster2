/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Classes.Agendamentos;
import Classes.Cliente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;
/**
 *
 * @author ryanp
 */
public class AgendamentoDAO {
    
        private final Connection conn;

        public AgendamentoDAO() {
        conectaDAO c = new conectaDAO();
        this.conn = c.getConexao();
    }
     
     public void cadastrar(Agendamentos agendamento) {
         
         
         Cliente cliente = agendamento.getCliente();
         if (cliente == null || cliente.getClienteId() <= 0) {
         JOptionPane.showMessageDialog(null, "Erro: Cliente inválido.");
         return;
    }
          
         String dataString = agendamento.getData();
         String horaString = agendamento.getHora();
         String descricao = agendamento.getDescricao();
         int clienteId = cliente.getClienteId();  
         String formaPagamento = agendamento.getFormaPagamento();

             SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

          try {

        java.util.Date utilDate = sdf.parse(dataString);
        java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());

        
        String sql = "INSERT INTO Agendamentos (data, hora, descricao, cliente_id, forma_pagamento) VALUES (?, ?, ?, ?, ?)";
        
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
           
            stmt.setDate(1, sqlDate);  
            stmt.setString(2, horaString);  
            stmt.setString(3, descricao);  
            stmt.setInt(4, clienteId); 
            stmt.setString(5, formaPagamento); 
            
           
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Agendamento cadastrado com sucesso!");

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao inserir agendamento: " + e.getMessage());
        }

    } catch (ParseException e) {
        JOptionPane.showMessageDialog(null, "Erro ao converter a data: " + e.getMessage());
    }
}


public boolean cancelarAgendamento(String data, String hora) {
    

         String sql = "DELETE FROM Agendamentos WHERE data = ? AND hora = ?";
         SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    
         try {
                java.util.Date utilDate = sdf.parse(data);
                java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
                
                try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                stmt.setDate(1, sqlDate);
                stmt.setString(2, hora);
            
               int linhasAfetadas = stmt.executeUpdate();
                
                  if (linhasAfetadas > 0) {
                  JOptionPane.showMessageDialog(null, "Agendamento cancelado com sucesso!");
                  return true;
              } else {
                  JOptionPane.showMessageDialog(null, "Agendamento não encontrado no banco de dados.");
                   return false;
                   }
             } catch (SQLException e) {
                 JOptionPane.showMessageDialog(null, "Erro ao cancelar agendamento: " + e.getMessage());
                 return false;
                }
         } catch (ParseException e) {
            JOptionPane.showMessageDialog(null, "Erro ao converter a data: " + e.getMessage());
           return false;
             }

}
}
