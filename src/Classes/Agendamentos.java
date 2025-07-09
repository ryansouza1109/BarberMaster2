
package Classes;


public class Agendamentos {
    
    private String data; 
    private String hora; 
    private String descricao; 
    private Cliente cliente; 
    private String formaPagamento; 


    public Agendamentos(String data, String hora, String descricao, Cliente cliente, String formaPagamento) { 
            this.data = data; 
            this.hora = hora; 
            this.descricao = descricao; 
            this.cliente = cliente; 
            this.formaPagamento = formaPagamento; 

           } 

    public String getData() { 
        return data; 
    } 

  
    public void setData(String data) { 
        this.data = data; 
    } 

    public String getHora() { 
        return hora; 
    } 

  
    public void setHora(String hora) { 
        this.hora = hora; 
    } 


    public String getDescricao() { 
        return descricao; 
    } 

 
    public void setDescricao(String descricao) { 
        this.descricao = descricao; 
    } 

  
    public Cliente getCliente() { 
        return cliente; 
    } 

  
    public void setCliente(Cliente cliente) { 
        this.cliente = cliente; 
    } 

  
    public String getFormaPagamento() { 
        return formaPagamento; 
    } 


    public void setFormaPagamento(String formaPagamento) { 
        this.formaPagamento = formaPagamento; 
    } 
    
}

