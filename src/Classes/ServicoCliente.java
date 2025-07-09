
package Classes;

import Classes.Cliente;
import Classes.Agendamentos;
import javax.swing.JOptionPane;

public class ServicoCliente {
     public void redefinirSenha(Cliente cliente, String senha, String novaSenha) {
        if (cliente.getSenha().equals(senha)) {
            cliente.setSenha(novaSenha);
            JOptionPane.showMessageDialog(null, "Senha redefinida com sucesso!");
        } else {
            JOptionPane.showMessageDialog(null, "Senha inválida.");
        }
    }

    public void confirmarSenha(Cliente cliente) {
        if (cliente.getSenha().equals(cliente.getConfirmarSenha())) {
            JOptionPane.showMessageDialog(null, "Senha correta");
        } else {
            JOptionPane.showMessageDialog(null, "Senha incorreta");
        }
    }

    public void agendarServico(Cliente cliente, String data, String hora, String descricao, String formaPagamento) {
        Agendamentos agendamento = new Agendamentos(data, hora, descricao, cliente, formaPagamento);
        cliente.getAgendamentos().add(agendamento);
        JOptionPane.showMessageDialog(null, "Agendamento realizado com sucesso!");
    }

    public void cancelarAgendamento(Cliente cliente, String data, String hora) {
        Agendamentos agendamentoParaRemover = null;

        for (Agendamentos agendamento : cliente.getAgendamentos()) {
            if (agendamento.getData().equals(data) && agendamento.getHora().equals(hora)) {
                agendamentoParaRemover = agendamento;
                break;
            }
        }

        if (agendamentoParaRemover != null) {
            cliente.getAgendamentos().remove(agendamentoParaRemover);
            JOptionPane.showMessageDialog(null, "Agendamento cancelado com sucesso.");
        } else {
            JOptionPane.showMessageDialog(null, "Agendamento não encontrado.");
        }
    }
}
