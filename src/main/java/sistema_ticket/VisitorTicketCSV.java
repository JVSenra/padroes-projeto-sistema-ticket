package sistema_ticket;

public class VisitorTicketCSV implements Visitor{
    public String exibir(Ticket ticket) {
        return ticket.aceitar(this);
    }

    @Override
    public String exibirTicketOnline(TicketOnline ticket) {
        return "nome,solicitante,estado,codigoVerificacao\n"
                + ticket.getNome()
                + "," + ticket.getSolicitante().getNome()
                + "," + ticket.getNomeEstado()
                + "," + ticket.getCodigoVerificacao();
    }

    @Override
    public String exibirTicketPresencial(TicketPresencial ticket) {
        return "nome,solicitante,estado,numeroGuiche\n"
                + ticket.getNome()
                + "," + ticket.getSolicitante().getNome()
                + "," + ticket.getNomeEstado()
                + "," + ticket.getNumeroGuiche();
    }
}
