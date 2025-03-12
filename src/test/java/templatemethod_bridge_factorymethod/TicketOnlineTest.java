package templatemethod_bridge_factorymethod;
import org.junit.jupiter.api.Test;
import sistema_ticket.*;
import static org.junit.jupiter.api.Assertions.*;
public class TicketOnlineTest {
    //Prazo em dias
    @Test
    void deveRetornarPrazoTicketOnlineServicoSuporte() {
        Pessoa solicitante = new Pessoa("João");
        Ticket ticket = TicketFactory.obterTicket("Online");
        ticket.setInfoTicket(ServicoSuporte.getInstance(), "Ticket A", solicitante);
        assertEquals(10, ticket.calcularPrazo());
    }

    //Prazo em dias
    @Test
    void deveRetornarPrazoTicketOnlineServicoConsultoria() {
        Pessoa solicitante = new Pessoa("João");
        Ticket ticket = TicketFactory.obterTicket("Online");
        ticket.setInfoTicket(ServicoConsultoria.getInstance(), "Ticket A", solicitante);
        assertEquals(25, ticket.calcularPrazo());
    }
}
