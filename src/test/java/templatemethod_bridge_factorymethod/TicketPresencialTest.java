package templatemethod_bridge_factorymethod;
import org.junit.jupiter.api.Test;
import sistema_ticket.*;
import static org.junit.jupiter.api.Assertions.*;

public class TicketPresencialTest {
    //Prazo em dias
    @Test
    void deveRetornarPrazoTicketPresencialServicoSuporte() {
        Pessoa solicitante = new Pessoa("João");
        Ticket ticket = TicketFactory.obterTicket("Presencial");
        ticket.setInfoTicket(ServicoSuporte.getInstance(), "Ticket A", solicitante);
        assertEquals(20, ticket.calcularPrazo());
    }

    //Prazo em dias
    @Test
    void deveRetornarPrazoTicketPresencialServicoConsultoria() {
        Pessoa solicitante = new Pessoa("João");
        Ticket ticket = TicketFactory.obterTicket("Presencial");
        ticket.setInfoTicket(ServicoConsultoria.getInstance(), "Ticket A", solicitante);
        assertEquals(35, ticket.calcularPrazo());
    }
}
