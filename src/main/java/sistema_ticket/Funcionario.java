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
        Execucao execucao = new Execucao(ticket);
        if (listaServicos.contains(ticket.getServico()) && execucao.executar(OperacaoTramitar.getInstance())) {
            return getDescricaoCargo()+": Ticket tramitado";
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
        Execucao execucao = new Execucao(ticket);
        if (listaServicos.contains(ticket.getServico()) && execucao.executar(OperacaoCancelar.getInstance())) {
            return getDescricaoCargo()+": Ticket cancelado";
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
        Execucao execucao = new Execucao(ticket);
        if (listaServicos.contains(ticket.getServico()) && execucao.executar(OperacaoResolver.getInstance())) {
            return getDescricaoCargo()+": Ticket resolvido";
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
        Execucao execucao = new Execucao(ticket);
        if (listaServicos.contains(ticket.getServico()) && execucao.executar(OperacaoFechar.getInstance())) {
            return getDescricaoCargo()+": Ticket fechado";
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
