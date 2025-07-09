/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
    package DAO;

    import java.sql.Connection;
    import java.sql.PreparedStatement;
    import javax.swing.JOptionPane;
    import java.sql.ResultSet;
    import java.sql.SQLException;

    /**
     *
     * @author ryanp
     */
    public class FinanceiroDAO {
         private conectaDAO c;
         private Connection conn;

         public FinanceiroDAO() {

            this.c = new conectaDAO();
            this.conn = this.c.getConexao();
              verificarEIniciarRegistro(); 

         }
         
           public Connection getConnection() {
        return this.conn;
         }
         
         
           private void verificarEIniciarRegistro() {
             try {
            String sql = "SELECT COUNT(*) FROM RelatorioFinanceiro WHERE id = 1";
            try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                ResultSet rs = stmt.executeQuery();
                rs.next();
                int count = rs.getInt(1);
                rs.close();

                if (count == 0) {
                    sql = "INSERT INTO RelatorioFinanceiro (id, lucro_diario, lucro_mes, gastos) VALUES (1, 0, 0, 0)";
                    try (PreparedStatement insertStmt = conn.prepareStatement(sql)) {
                        insertStmt.executeUpdate();
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

           public void addLucro(double lucro) {
          if (lucro < 0) {
            JOptionPane.showMessageDialog(null, "O lucro não pode ser negativo.", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try {
            String sql = "UPDATE RelatorioFinanceiro SET lucro_diario = lucro_diario + ?, lucro_mes = lucro_mes + ? WHERE id = 1";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setDouble(1, lucro);
            stmt.setDouble(2, lucro);
            stmt.executeUpdate();
            stmt.close();

            JOptionPane.showMessageDialog(null, "Lucro de R$ " + lucro + " adicionado com sucesso!");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao adicionar lucro: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    
    public  boolean  fecharDia() {
         String sql = "UPDATE RelatorioFinanceiro SET lucro_mes = lucro_mes + lucro_diario, lucro_diario = 0 WHERE id = 1";

        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

   
    public void verLucroMes() {
        try {
            String sql = "SELECT lucro_mes FROM RelatorioFinanceiro WHERE id = 1";
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                double lucroMes = rs.getDouble("lucro_mes");
                JOptionPane.showMessageDialog(null, "Lucro do mês: R$ " + lucroMes);
            } else {
                JOptionPane.showMessageDialog(null, "Nenhum dado encontrado.");
            }

            rs.close();
            stmt.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao consultar lucro do mês: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

   
    public void virarMes() {
        try {
            String sql = "UPDATE RelatorioFinanceiro SET lucro_mes = 0, gastos = 0 WHERE id = 1";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.executeUpdate();
            stmt.close();

            JOptionPane.showMessageDialog(null, "Novo mês iniciado.");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao resetar mês: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

   
    public void addGasto(double gasto, String descricao) {
         if (gasto < 0) {
            JOptionPane.showMessageDialog(null, "O valor do gasto não pode ser negativo.", "Erro", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try {
            String sql = "UPDATE RelatorioFinanceiro SET gastos = gastos + ? WHERE id = 1";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setDouble(1, gasto);
            stmt.executeUpdate();
            stmt.close();

            JOptionPane.showMessageDialog(null, descricao + " foi adicionado aos gastos. Valor: R$ " + gasto);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao adicionar gasto: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

 
    public void mostrarMes() {
        try {
            String sql = "SELECT lucro_mes, gastos FROM RelatorioFinanceiro WHERE id = 1";
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                double lucroMes = rs.getDouble("lucro_mes");
                double gastos = rs.getDouble("gastos");
                double saldoFinal = lucroMes - gastos;

                JOptionPane.showMessageDialog(null, "Resumo do mês:\nLucro total: R$ " + lucroMes +
                        "\nGastos totais: R$ " + gastos +
                        "\nSaldo final: R$ " + saldoFinal);
            } else {
                JOptionPane.showMessageDialog(null, "Nenhum dado encontrado para o relatório financeiro.");
            }

            rs.close();
            stmt.close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro ao obter relatório: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }
    }
