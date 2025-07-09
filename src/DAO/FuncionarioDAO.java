/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;


import Classes.Funcionario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.swing.JOptionPane;
import java.sql.SQLException;

/**
 *
 * @author ryanp
 */
public class FuncionarioDAO {
    
    
         private conectaDAO c;
         private Connection conn;

          public FuncionarioDAO() {
        
                this.c = new conectaDAO();
                this.conn = this.c.getConexao();
        
           }
    
         public boolean cadastrar(Funcionario funcionario) {
               String sql = "INSERT INTO Funcionario (nome, cpf, telefone, cargo, senha) VALUES (?, ?, ?, ?, ?)";

                try (PreparedStatement stmt = conn.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS)) {
                  stmt.setString(1, funcionario.getNome());
                  stmt.setString(2, funcionario.getCPF());
                  stmt.setString(3, funcionario.getTelefone());
                  stmt.setString(4, funcionario.getCargo());
                  stmt.setString(5, funcionario.getSenha());
        
                 int rowsAffected = stmt.executeUpdate();

                 if (rowsAffected > 0) {
            
                 return true;
                 } else {
            
                return false;
           }
      } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Erro ao cadastrar funcionário: " + e.getMessage());
        return false;
    }
}

    
}
