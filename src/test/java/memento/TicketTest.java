package memento;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import sistema_ticket.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TicketTest {
    @Test
    void deveArmazenarEstados() {
        Pessoa solicitante = new Pessoa("João");
        Ticket ticket = TicketFactory.obterTicket("Online");
        ticket.setInfoTicket(ServicoSuporte.getInstance(), "Ticket A", solicitante);

        TicketMemento ticketMemento  = ticket.salvarEstado();
        assertEquals(TicketEstadoAberto.getInstance(), ticketMemento.getEstado());

        ticket.tramitar();
        TicketMemento ticketMemento2  = ticket.salvarEstado();
        assertEquals(TicketEstadoEmAndamento.getInstance(), ticketMemento2.getEstado());

        assertEquals(2, ticket.getHistorico().size());
    }

    @Test
    void deveExibirHistoricoEstados() {
        Pessoa solicitante = new Pessoa("João");
        Ticket ticket = TicketFactory.obterTicket("Online");
        ticket.setInfoTicket(ServicoSuporte.getInstance(), "Ticket A", solicitante);
        ticket.tramitar();
        assertEquals("Histórico de Estados do Ticket: Ticket A\n1. Aberto\n2. Em andamento\n", ticket.exibirHistorico());
    }

    @Test
    void deveRestaurarEstado() {
        Pessoa solicitante = new Pessoa("João");
        Ticket ticket = TicketFactory.obterTicket("Online");
        ticket.setInfoTicket(ServicoSuporte.getInstance(), "Ticket A", solicitante);
        ticket.tramitar();
        TicketMemento ticketMemento  = ticket.salvarEstado();
        ticket.resolver();
        ticket.restaurarEstado(ticketMemento);
        assertEquals(TicketEstadoEmAndamento.getInstance(), ticket.getEstado());
    }
}
