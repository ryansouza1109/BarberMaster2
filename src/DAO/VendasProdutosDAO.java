/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author ryanp
 */
public class VendasProdutosDAO {
    
     private conectaDAO c;
     private Connection conn;
    
     public VendasProdutosDAO() {
        
        this.c = new conectaDAO();
        this.conn = this.c.getConexao();
        
    }
     
     public void cadastrarVenda(int produtoId, int quantidade) {
        String sql = "INSERT INTO VendasProdutos (produto_id, quantidade) VALUES (?, ?)";
        try (PreparedStatement stmt = this.conn.prepareStatement(sql)) {
            stmt.setInt(1, produtoId);
            stmt.setInt(2, quantidade);
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Venda cadastrada com sucesso!");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao inserir venda: " + e.getMessage());
              e.printStackTrace();
        }
    
     
    
}
     
     public boolean produtoExiste(int produtoId) {
        String sql = "SELECT COUNT(*) FROM produtos WHERE id = ?";
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, produtoId);
            try (ResultSet rs = stmt.executeQuery()) {
                return rs.next() && rs.getInt(1) > 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
     
}