package sistema_ticket;

public class VisitorTicketJSON implements Visitor{
    public String exibir(Ticket ticket) {
        return ticket.aceitar(this);
    }

    @Override
    public String exibirTicketOnline(TicketOnline ticket) {

        return "{" +
                "\"nome\":\"" + ticket.getNome()+ "\"," +
                "\"solicitante\":\"" + ticket.getSolicitante().getNome() + "\","  +
                "\"estado\":\"" + ticket.getNomeEstado() + "\"," +
                "\"codigoVerificacao\":\"" + ticket.getCodigoVerificacao() + "\"" +
        "}";
    }

    @Override
    public String exibirTicketPresencial(TicketPresencial ticket) {
        return "{" +
                "\"nome\":\"" + ticket.getNome()+ "\"," +
                "\"solicitante\":\"" + ticket.getSolicitante().getNome() + "\","  +
                "\"estado\":\"" + ticket.getNomeEstado() + "\"," +
                "\"numeroGuiche\":" + ticket.getNumeroGuiche() +
                "}";
    }
}
