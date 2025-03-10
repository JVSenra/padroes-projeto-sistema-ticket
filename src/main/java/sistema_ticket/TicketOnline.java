package sistema_ticket;

public class TicketOnline extends Ticket{

    @Override
    public int calcularPrazo() {
        return 5 + this.servico.obterPrazo();
    }
}
