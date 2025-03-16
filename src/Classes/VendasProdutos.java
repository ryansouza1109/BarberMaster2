/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Classes;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author ryanp
 */
public class VendasProdutos {
    
     private static List<Produtos> vendas = new ArrayList<>();

    public void adicionarVenda(Produtos produto) {
        vendas.add(produto);
        JOptionPane.showMessageDialog(null,"Produto vendido: " + produto.getNome() + " por " + produto.getPreco());
    }

    public void adicionarProdutos(Produtos produto) {
        vendas.add(produto);
        JOptionPane.showMessageDialog(null, "Produto adicionado: " + produto.getNome() + " por " + produto.getPreco());
    }

    public List<Produtos> listarProdutos() {
        return vendas;
    }
    
}
