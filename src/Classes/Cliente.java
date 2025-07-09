
package Classes;


import java.util.ArrayList;
import java.util.List;



public class Cliente {
    
    private String nome;
    private String telefone;
    private String email;
    private String senha;
    private String confirmarSenha;
    private List<Agendamentos> agendamentos;
    private int clienteId;

    public Cliente(String nome, String telefone, String email, String senha ) {
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
        this.senha = senha;
        this.agendamentos = new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getConfirmarSenha() {
        return confirmarSenha;
    }

    public void setConfirmarSenha(String confirmarSenha) {
        this.confirmarSenha = confirmarSenha;
    }

    public List<Agendamentos> getAgendamentos() {
        return agendamentos;
    }



    public int getClienteId() {
        return clienteId;
    }

    public void setClienteId(int clienteId) {
        this.clienteId = clienteId;
    }
     
  
}
                                                                                                