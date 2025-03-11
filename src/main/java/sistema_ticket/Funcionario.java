package sistema_ticket;

import java.util.ArrayList;

public abstract class Funcionario {

    protected ArrayList listaServicos = new ArrayList();
    private Funcionario funcionarioSuperior;

    public Funcionario getFuncionarioSuperior() {
        return funcionarioSuperior;
    }

    public void setFuncionarioSuperior(Funcionario funcionarioSuperior) {
        this.funcionarioSuperior = funcionarioSuperior;
    }

    public abstract String getDescricaoCargo();

    public String tramitarTicket(Ticket ticket) {
        if (listaServicos.contains(ticket.getServico())) {
            Execucao execucao = new Execucao(ticket);
            return getDescricaoCargo()+": " + String.valueOf(execucao.executar(OperacaoTramitar.getInstance()));
        }
        else {
            if (funcionarioSuperior != null) {
                return funcionarioSuperior.tramitarTicket(ticket);
            }
            else
            {
                return "Sem tramitação";
            }
        }
    }
    public String cancelarTicket(Ticket ticket) {
        if (listaServicos.contains(ticket.getServico())) {
            Execucao execucao = new Execucao(ticket);
            return getDescricaoCargo()+": " + String.valueOf(execucao.executar(OperacaoCancelar.getInstance()));
        }
        else {
            if (funcionarioSuperior != null) {
                return funcionarioSuperior.cancelarTicket(ticket);
            }
            else
            {
                return "Sem cancelamento";
            }
        }
    }
    public String resolverTicket(Ticket ticket) {
        if (listaServicos.contains(ticket.getServico())) {
            Execucao execucao = new Execucao(ticket);
            return getDescricaoCargo()+": " + String.valueOf(execucao.executar(OperacaoResolver.getInstance()));
        }
        else {
            if (funcionarioSuperior != null) {
                return funcionarioSuperior.resolverTicket(ticket);
            }
            else
            {
                return "Sem resolução";
            }
        }
    }
    public String fecharTicket(Ticket ticket) {
        if (listaServicos.contains(ticket.getServico())) {
            Execucao execucao = new Execucao(ticket);
            return getDescricaoCargo()+": " + String.valueOf(execucao.executar(OperacaoFechar.getInstance()));
        }
        else {
            if (funcionarioSuperior != null) {
                return funcionarioSuperior.fecharTicket(ticket);
            }
            else
            {
                return "Sem fechamento";
            }
        }
    }
}
