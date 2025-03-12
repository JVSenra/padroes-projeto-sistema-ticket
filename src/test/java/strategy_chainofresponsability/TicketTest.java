package strategy_chainofresponsability;
import org.junit.jupiter.api.Test;
import sistema_ticket.*;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.assertEquals;
public class TicketTest {
    private FuncionarioSuporte funcionarioSuporte;
    private FuncionarioConsultor funcionarioConsultor;
    private FuncionarioGerente funcionarioGerente;
    private FuncionarioDiretor funcionarioDiretor;

    @BeforeEach
    void setUp() {
        funcionarioDiretor = new FuncionarioDiretor(null);
        funcionarioGerente = new FuncionarioGerente(funcionarioDiretor);
        funcionarioConsultor = new FuncionarioConsultor(funcionarioGerente);
        funcionarioSuporte = new FuncionarioSuporte(funcionarioConsultor);
    }

    //Tramitação
    @Test
    void deveTramitarTicketServicoSuporte() {
        Pessoa solicitante = new Pessoa("João");
        Ticket ticket = TicketFactory.obterTicket("Online");
        ticket.setInfoTicket(ServicoSuporte.getInstance(), "Ticket A", solicitante);
        assertEquals("Suporte: Ticket tramitado", funcionarioSuporte.tramitarTicket(ticket));
    }

    @Test
    void deveTramitarTicketServicoConsultoria() {
        Pessoa solicitante = new Pessoa("João");
        Ticket ticket = TicketFactory.obterTicket("Online");
        ticket.setInfoTicket(ServicoConsultoria.getInstance(), "Ticket A", solicitante);
        assertEquals("Consultor: Ticket tramitado", funcionarioSuporte.tramitarTicket(ticket));
    }

    @Test
    void naoDeveTramitarTicket() {
        Pessoa solicitante = new Pessoa("João");
        Ticket ticket = TicketFactory.obterTicket("Online");
        ticket.setInfoTicket(ServicoConsultoria.getInstance(), "Ticket A", solicitante);
        funcionarioSuporte.tramitarTicket(ticket);
        assertEquals("Sem tramitação", funcionarioSuporte.tramitarTicket(ticket));
    }

    //Resolução
    @Test
    void deveResolverTicketServicoSuporte() {
        Pessoa solicitante = new Pessoa("João");
        Ticket ticket = TicketFactory.obterTicket("Online");
        ticket.setInfoTicket(ServicoSuporte.getInstance(), "Ticket A", solicitante);
        funcionarioSuporte.tramitarTicket(ticket);
        assertEquals("Suporte: Ticket resolvido", funcionarioSuporte.resolverTicket(ticket));
    }

    @Test
    void deveResolverTicketServicoConsultoria() {
        Pessoa solicitante = new Pessoa("João");
        Ticket ticket = TicketFactory.obterTicket("Online");
        ticket.setInfoTicket(ServicoConsultoria.getInstance(), "Ticket A", solicitante);
        funcionarioSuporte.tramitarTicket(ticket);
        assertEquals("Consultor: Ticket resolvido", funcionarioSuporte.resolverTicket(ticket));
    }

    @Test
    void naoDeveResolverTicket() {
        Pessoa solicitante = new Pessoa("João");
        Ticket ticket = TicketFactory.obterTicket("Online");
        ticket.setInfoTicket(ServicoConsultoria.getInstance(), "Ticket A", solicitante);
        assertEquals("Sem resolução", funcionarioSuporte.resolverTicket(ticket));
    }

    //Fechamento
    @Test
    void deveFecharTicketServicoSuporte() {
        Pessoa solicitante = new Pessoa("João");
        Ticket ticket = TicketFactory.obterTicket("Online");
        ticket.setInfoTicket(ServicoSuporte.getInstance(), "Ticket A", solicitante);
        funcionarioSuporte.tramitarTicket(ticket);
        funcionarioSuporte.resolverTicket(ticket);
        assertEquals("Suporte: Ticket fechado", funcionarioSuporte.fecharTicket(ticket));
    }

    @Test
    void deveFecharTicketServicoConsultoria() {
        Pessoa solicitante = new Pessoa("João");
        Ticket ticket = TicketFactory.obterTicket("Online");
        ticket.setInfoTicket(ServicoConsultoria.getInstance(), "Ticket A", solicitante);
        funcionarioSuporte.tramitarTicket(ticket);
        funcionarioSuporte.resolverTicket(ticket);
        assertEquals("Consultor: Ticket fechado", funcionarioSuporte.fecharTicket(ticket));
    }

    @Test
    void naoDeveFecharTicket() {
        Pessoa solicitante = new Pessoa("João");
        Ticket ticket = TicketFactory.obterTicket("Online");
        ticket.setInfoTicket(ServicoConsultoria.getInstance(), "Ticket A", solicitante);
        assertEquals("Sem fechamento", funcionarioSuporte.fecharTicket(ticket));
    }

    //Cancelamento
    @Test
    void deveCancelarTicketServicoSuporte() {
        Pessoa solicitante = new Pessoa("João");
        Ticket ticket = TicketFactory.obterTicket("Online");
        ticket.setInfoTicket(ServicoSuporte.getInstance(), "Ticket A", solicitante);
        assertEquals("Suporte: Ticket cancelado", funcionarioSuporte.cancelarTicket(ticket));
    }

    @Test
    void deveCancelarTicketServicoConsultoria() {
        Pessoa solicitante = new Pessoa("João");
        Ticket ticket = TicketFactory.obterTicket("Online");
        ticket.setInfoTicket(ServicoConsultoria.getInstance(), "Ticket A", solicitante);
        assertEquals("Consultor: Ticket cancelado", funcionarioSuporte.cancelarTicket(ticket));
    }

    @Test
    void naoDeveCancelarTicket() {
        Pessoa solicitante = new Pessoa("João");
        Ticket ticket = TicketFactory.obterTicket("Online");
        ticket.setInfoTicket(ServicoConsultoria.getInstance(), "Ticket A", solicitante);
        funcionarioSuporte.tramitarTicket(ticket);
        funcionarioSuporte.resolverTicket(ticket);
        assertEquals("Sem cancelamento", funcionarioSuporte.cancelarTicket(ticket));
    }

}
