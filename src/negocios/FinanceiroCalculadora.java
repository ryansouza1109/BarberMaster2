/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package negocios;

/**
 *
 * @author ryanp
 */
public class FinanceiroCalculadora {
    
    public double calcularSaldoFinal(double lucroMes, double gastos) {
        return lucroMes - gastos;
    }

    public double somarLucro(double lucroAtual, double novoLucro) {
        return lucroAtual + novoLucro;
    }

    public double somarGastos(double gastosAtuais, double novoGasto) {
        return gastosAtuais + novoGasto;
    }

    public double resetarValor() {
        return 0.0;
    }
    
}
