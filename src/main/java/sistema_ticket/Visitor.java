package sistema_ticket;

public interface Visitor {
    String exibirTicketOnline(TicketOnline ticket);
    String exibirTicketPresencial(TicketPresencial ticket);
}
