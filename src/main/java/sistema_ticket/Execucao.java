package sistema_ticket;

public class Execucao {
    private Ticket ticket;

    public Execucao(Ticket ticket) {
        this.ticket = ticket;
    }

    public boolean executar(Operacao operacao) {
        return operacao.executar(this.ticket);
    }
}
