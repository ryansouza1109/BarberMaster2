/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import Classes.Produtos;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement; 
import javax.swing.JOptionPane;
import java.util.ArrayList;
import java.util.List;


public class ProdutosDAO {
    
         private conectaDAO c;
         private Connection conn;
         
         public ProdutosDAO() {
        this.conn = new conectaDAO().getConexao();
        if (conn == null) {
            JOptionPane.showMessageDialog(null, "Erro ao conectar ao banco de dados.");
        }
    }
    
     public List<Produtos> listarProdutos() {
        List<Produtos> listaProdutos = new ArrayList<>();
        String sql = "SELECT * FROM Produtos";

        try (PreparedStatement stmt = this.conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                int id = rs.getInt("id");
                String nome = rs.getString("nome");
                double preco = rs.getDouble("preco");

                Produtos produto = new Produtos(id, nome, preco);
                listaProdutos.add(produto);
                
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao listar produtos: " + e.getMessage());
        }

       
        return listaProdutos;
    }
     
     public int cadastrar(Produtos p) {  // Altere o tipo de retorno para int
    String sql = "INSERT INTO Produtos (nome, preco) VALUES (?, ?)";
    int idGerado = -1; // Variável para armazenar o ID gerado

    try (PreparedStatement stmt = this.conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {  
        stmt.setString(1, p.getNome());
        stmt.setDouble(2, p.getPreco());

        
        stmt.executeUpdate();

      
        ResultSet rs = stmt.getGeneratedKeys();
        if (rs.next()) {
            idGerado = rs.getInt(1);
        }
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Erro ao inserir produto: " + e.getMessage());
    }

    return idGerado; 
}


}

