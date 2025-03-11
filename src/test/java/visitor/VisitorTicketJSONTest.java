package visitor;

import org.junit.jupiter.api.Test;
import sistema_ticket.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class VisitorTicketJSONTest {
    @Test
    void deveTicketOnline() {
        Pessoa solicitante = new Pessoa("João");
        Ticket ticket = TicketFactory.obterTicket("Online");
        ticket.setInfoTicket(ServicoSuporte.getInstance(), "Ticket A", solicitante);
        VisitorTicketJSON visitor = new VisitorTicketJSON();
        assertEquals("{\"nome\":\"Ticket A\",\"solicitante\":\"João\",\"estado\":\"Aberto\"}", visitor.exibir(ticket));
    }

    @Test
    void deveTicketPresencial() {
        Pessoa solicitante = new Pessoa("Paulo");
        Ticket ticket = TicketFactory.obterTicket("Presencial");
        ticket.setInfoTicket(ServicoConsultoria.getInstance(), "Ticket B", solicitante);
        VisitorTicketJSON visitor = new VisitorTicketJSON();
        assertEquals("{\"nome\":\"Ticket B\",\"solicitante\":\"Paulo\",\"estado\":\"Aberto\"}", visitor.exibir(ticket));
    }
}
