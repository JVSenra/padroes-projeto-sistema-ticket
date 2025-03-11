package sistema_ticket;

public class VisitorTicketCSV implements Visitor{
    public String exibir(Ticket ticket) {
        return ticket.aceitar(this);
    }

    @Override
    public String exibirTicketOnline(TicketOnline ticket) {
        return "nome,solicitante,estado\n"
                + ticket.getNome()
                + "," + ticket.getSolicitante().getNome()
                + "," + ticket.getNomeEstado();
    }

    @Override
    public String exibirTicketPresencial(TicketPresencial ticket) {
        return "nome,solicitante,estado\n"
                + ticket.getNome()
                + "," + ticket.getSolicitante().getNome()
                + "," + ticket.getNomeEstado();
    }
}
