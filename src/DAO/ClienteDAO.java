/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Classes.Cliente;
import java.beans.Statement;
import java.sql.Connection; 
import java.sql.DriverManager; 
import java.sql.PreparedStatement;
import java.sql.ResultSet; 
import java.sql.SQLException; 
import javax.swing.JOptionPane;
        
public class ClienteDAO {
    
        private conectaDAO c;
        private Connection conn;
        ResultSet rs = null;
        PreparedStatement stmt = null;

        public ClienteDAO() {
        
        this.c = new conectaDAO();
        this.conn = this.c.getConexao();
        
          }
   
        public boolean cadastrar(Cliente cliente) {
          String sql = "INSERT INTO Cliente (nome, telefone, email, senha) VALUES (?, ?, ?, ?)";
    
          try (PreparedStatement stmt = conn.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS)) {
      
          stmt.setString(1, cliente.getNome());
          stmt.setString(2, cliente.getTelefone());
          stmt.setString(3, cliente.getEmail());
          stmt.setString(4, cliente.getSenha());

        
          int rowsAffected = stmt.executeUpdate();

       
          if (rowsAffected > 0) {
            ResultSet generatedKeys = stmt.getGeneratedKeys();
            if (generatedKeys.next()) {
                int generatedId = generatedKeys.getInt(1);
                cliente.setClienteId(generatedId);
            }
             JOptionPane.showMessageDialog(null, " Cliente cadastrado com sucesso!");
            return true; 
        }
           } catch (SQLException e) {
      
           JOptionPane.showMessageDialog(null, "Erro ao inserir cliente: " + e.getMessage());
           e.printStackTrace(); 
      }
      
       return false; 
}   
    
    
         public boolean redefinirSenha(String email, String senhaAntiga, String novaSenha) {
          String sql = "UPDATE Cliente SET senha = ? WHERE email = ? AND senha = ?";
        
            try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, novaSenha); 
            stmt.setString(2, email); 
            stmt.setString(3, senhaAntiga); 

            int linhasAfetadas = stmt.executeUpdate();
            
            if (linhasAfetadas > 0) {
                JOptionPane.showMessageDialog(null, "Senha redefinida com sucesso!");
                return true;
            } else {
                JOptionPane.showMessageDialog(null, "Email ou senha incorretos.");
                return false;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao redefinir senha: " + e.getMessage());
            return false;
        }
    }

}
