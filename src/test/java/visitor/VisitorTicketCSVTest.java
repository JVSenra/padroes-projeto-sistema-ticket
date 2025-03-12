package visitor;
import org.junit.jupiter.api.Test;
import sistema_ticket.*;
import static org.junit.jupiter.api.Assertions.*;

public class VisitorTicketCSVTest {

    @Test
    void deveTicketOnline() {
        Pessoa solicitante = new Pessoa("João");
        Ticket ticket = TicketFactory.obterTicket("Online");
        ticket.setInfoTicket(ServicoSuporte.getInstance(), "Ticket A", solicitante);
        VisitorTicketCSV visitor = new VisitorTicketCSV();
        assertEquals("nome,solicitante,estado\nTicket A,João,Aberto", visitor.exibir(ticket));
    }

    @Test
    void deveTicketPresencial() {
        Pessoa solicitante = new Pessoa("Paulo");
        Ticket ticket = TicketFactory.obterTicket("Presencial");
        ticket.setInfoTicket(ServicoConsultoria.getInstance(), "Ticket B", solicitante);
        VisitorTicketCSV visitor = new VisitorTicketCSV();
        assertEquals("nome,solicitante,estado\nTicket B,Paulo,Aberto", visitor.exibir(ticket));
    }
}
