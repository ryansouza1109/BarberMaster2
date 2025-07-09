
package Classes;

/**
 *
 * @author ryanp
 */
public class Funcionario {
    
    private String nome;
    private double salario;
    private String CPF;  
    private String senha;
    private String confirmarSenha;
    private String telefone;
    private String cargo;

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }



    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }
    
     public Funcionario(String nome, String CPF, String senha, String telefone, String cargo) {
  
        this.nome = nome;
        this.CPF = CPF;
        this.senha = senha;
        this.telefone = telefone;
        this.cargo = cargo;

    }

    public String getNome() {
        return nome;
    }

 

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }


    public String getCPF() {
        return CPF;
    }
    
    public boolean validarSenha(String tentativa) {
        return senha.equals(tentativa);
    }
    
}
