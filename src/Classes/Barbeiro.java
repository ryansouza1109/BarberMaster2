
package Classes;




public class Barbeiro extends Funcionario{
    
    private String especialidade;
 

    public Barbeiro(String nome, String CPF, String senha, String telefone, String especialidade , String cargo) {
        super(nome,  CPF, senha , telefone,cargo);
        this.especialidade = especialidade;
       
        }
       
    public String getEspecialidade() {
        return especialidade;
        }
 
    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
        }
    
}
