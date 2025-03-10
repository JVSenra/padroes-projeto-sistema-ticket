package sistema_ticket;

public class TicketPresencial extends Ticket{

    @Override
    public int calcularPrazo() {
        return 15 + this.servico.obterPrazo();
    }
}
