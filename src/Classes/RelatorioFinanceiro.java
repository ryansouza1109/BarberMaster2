/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Classes;

import javax.swing.JOptionPane;


public class RelatorioFinanceiro implements BMempresa {
    
    private double lucroDiario = 0.0;
    private double lucroMes = 0.0;
    private double gastos;
  
    
   
    @Override
    public void addLucro(double lucro) {
          try {
            if (lucro < 0) {
                throw new IllegalArgumentException("O valor do lucro não pode ser negativo.");
            }
            lucroDiario += lucro;
            lucroMes += lucro; 
            JOptionPane.showMessageDialog(null, "Lucro de R$ " + lucro + " adicionado!");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao adicionar lucro: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    @Override
    public void fecharDia() {
        lucroMes += lucroDiario; 
        JOptionPane.showMessageDialog(null, "O total do dia foi: R$" + lucroDiario);
        lucroDiario = 0; 
    }
    @Override
    public void verLucroMes()
    {
       JOptionPane.showMessageDialog(null, "O lucro do mês é R$ " + lucroMes);
    }
    
    
    @Override
    public void virarMes()
    {
        lucroMes = 0;
        gastos = 0;
        
        JOptionPane.showMessageDialog(null ,"Mes resetado.");
    }
    
    
    @Override
    public void addGasto (double gasto , String descricao)
    {
        try {
            if (gasto < 0) {
                throw new IllegalArgumentException("O valor do gasto não pode ser negativo.");
            }
            gastos += gasto;
            JOptionPane.showMessageDialog(null, descricao + " foi adicionada a gastos. Valor: R$ " + gasto);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Erro ao adicionar gasto: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    
    @Override
    public void mostrarMes()
    {
       double resultadoFinal = lucroMes - gastos;
        JOptionPane.showMessageDialog(null, "Resumo do mês:\nLucro total: R$" + lucroMes + 
                                            "\nGastos totais: R$" + gastos + 
                                            "\nSaldo final: R$" + resultadoFinal);
    }
    
}
