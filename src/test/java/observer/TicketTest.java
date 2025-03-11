package observer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import sistema_ticket.*;

import static org.junit.jupiter.api.Assertions.*;
/**
 *
 * @author user
 */
public class TicketTest {
    Ticket ticket;
    Pessoa solicitante;
    @BeforeEach
    public void setUp() {
        solicitante = new Pessoa("João");
        ticket = TicketFactory.obterTicket("Online");
        ticket.setInfoTicket(ServicoSuporte.getInstance(), "Ticket A", solicitante);
    }

    //Ticket Aberto
    @Test
    public void naoDeveAbrirTicketAberto() {
        ticket.setEstado(TicketEstadoAberto.getInstance());
        assertFalse(ticket.abrir());
        assertEquals("João, atualização no Ticket{nome='Ticket A', solicitante='João', estado='Aberto'}", solicitante.getUltimaNotificacao());
    }

    @Test
    public void naoDeveResolverTicketAberto() {
        ticket.setEstado(TicketEstadoAberto.getInstance());
        assertFalse(ticket.resolver());
        assertEquals("João, atualização no Ticket{nome='Ticket A', solicitante='João', estado='Aberto'}", solicitante.getUltimaNotificacao());
    }

    @Test
    public void naoDeveFecharTicketAberto() {
        ticket.setEstado(TicketEstadoAberto.getInstance());
        assertFalse(ticket.fechar());
        assertEquals("João, atualização no Ticket{nome='Ticket A', solicitante='João', estado='Aberto'}", solicitante.getUltimaNotificacao());
    }

    @Test
    public void deveCancelarTicketAberto() {
        ticket.setEstado(TicketEstadoAberto.getInstance());
        assertTrue(ticket.cancelar());
        assertEquals(TicketEstadoCancelado.getInstance(), ticket.getEstado());
        assertEquals("João, atualização no Ticket{nome='Ticket A', solicitante='João', estado='Cancelado'}", solicitante.getUltimaNotificacao());

    }

    @Test
    public void deveTramitarTicketAberto() {
        ticket.setEstado(TicketEstadoAberto.getInstance());
        assertTrue(ticket.tramitar());
        assertEquals(TicketEstadoEmAndamento.getInstance(), ticket.getEstado());
        assertEquals("João, atualização no Ticket{nome='Ticket A', solicitante='João', estado='Em andamento'}", solicitante.getUltimaNotificacao());
    }

    //Ticket Em Andamento
    @Test
    public void naoDeveAbrirTicketEmAndamento() {
        ticket.setEstado(TicketEstadoEmAndamento.getInstance());
        assertFalse(ticket.abrir());
        assertEquals("João, atualização no Ticket{nome='Ticket A', solicitante='João', estado='Em andamento'}", solicitante.getUltimaNotificacao());
    }

    @Test
    public void naoDeveTramitarTicketEmAndamento() {
        ticket.setEstado(TicketEstadoEmAndamento.getInstance());
        assertFalse(ticket.tramitar());
        assertEquals("João, atualização no Ticket{nome='Ticket A', solicitante='João', estado='Em andamento'}", solicitante.getUltimaNotificacao());
    }

    @Test
    public void naoDeveFecharTicketEmAndamento() {
        ticket.setEstado(TicketEstadoEmAndamento.getInstance());
        assertFalse(ticket.fechar());
        assertEquals("João, atualização no Ticket{nome='Ticket A', solicitante='João', estado='Em andamento'}", solicitante.getUltimaNotificacao());
    }

    @Test
    public void deveCancelarTicketEmAndamento() {
        ticket.setEstado(TicketEstadoEmAndamento.getInstance());
        assertTrue(ticket.cancelar());
        assertEquals(TicketEstadoCancelado.getInstance(), ticket.getEstado());
        assertEquals("João, atualização no Ticket{nome='Ticket A', solicitante='João', estado='Cancelado'}", solicitante.getUltimaNotificacao());
    }

    @Test
    public void deveResolverTicketEmAndamento() {
        ticket.setEstado(TicketEstadoEmAndamento.getInstance());
        assertTrue(ticket.resolver());
        assertEquals(TicketEstadoResolvido.getInstance(), ticket.getEstado());
        assertEquals("João, atualização no Ticket{nome='Ticket A', solicitante='João', estado='Resolvido'}", solicitante.getUltimaNotificacao());
    }

    //Ticket Resolvido
    @Test
    public void naoDeveAbrirTicketResolvido() {
        ticket.setEstado(TicketEstadoResolvido.getInstance());
        assertFalse(ticket.abrir());
        assertEquals("João, atualização no Ticket{nome='Ticket A', solicitante='João', estado='Resolvido'}", solicitante.getUltimaNotificacao());
    }

    @Test
    public void naoDeveResolverTicketResolvido() {
        ticket.setEstado(TicketEstadoResolvido.getInstance());
        assertFalse(ticket.resolver());
        assertEquals("João, atualização no Ticket{nome='Ticket A', solicitante='João', estado='Resolvido'}", solicitante.getUltimaNotificacao());
    }

    @Test
    public void naoDeveCancelarTicketResolvido() {
        ticket.setEstado(TicketEstadoResolvido.getInstance());
        assertFalse(ticket.cancelar());
        assertEquals("João, atualização no Ticket{nome='Ticket A', solicitante='João', estado='Resolvido'}", solicitante.getUltimaNotificacao());
    }

    @Test
    public void deveTramitarTicketResolvido() {
        ticket.setEstado(TicketEstadoResolvido.getInstance());
        assertTrue(ticket.tramitar());
        assertEquals(TicketEstadoEmAndamento.getInstance(), ticket.getEstado());
        assertEquals("João, atualização no Ticket{nome='Ticket A', solicitante='João', estado='Em andamento'}", solicitante.getUltimaNotificacao());
    }

    @Test
    public void deveFecharTicketResolvido() {
        ticket.setEstado(TicketEstadoResolvido.getInstance());
        assertTrue(ticket.fechar());
        assertEquals(TicketEstadoFechado.getInstance(), ticket.getEstado());
        assertEquals("João, atualização no Ticket{nome='Ticket A', solicitante='João', estado='Fechado'}", solicitante.getUltimaNotificacao());
    }

    //Ticket Cancelado
    @Test
    public void naoDeveAbrirTicketCancelado() {
        ticket.setEstado(TicketEstadoCancelado.getInstance());
        assertFalse(ticket.abrir());
        assertEquals("João, atualização no Ticket{nome='Ticket A', solicitante='João', estado='Cancelado'}", solicitante.getUltimaNotificacao());
    }

    @Test
    public void naoDeveResolverTicketCancelado() {
        ticket.setEstado(TicketEstadoCancelado.getInstance());
        assertFalse(ticket.resolver());
        assertEquals("João, atualização no Ticket{nome='Ticket A', solicitante='João', estado='Cancelado'}", solicitante.getUltimaNotificacao());
    }

    @Test
    public void naoDeveCancelarTicketCancelado() {
        ticket.setEstado(TicketEstadoCancelado.getInstance());
        assertFalse(ticket.cancelar());
        assertEquals("João, atualização no Ticket{nome='Ticket A', solicitante='João', estado='Cancelado'}", solicitante.getUltimaNotificacao());
    }

    @Test
    public void naoDeveTramitarTicketCancelado() {
        ticket.setEstado(TicketEstadoCancelado.getInstance());
        assertFalse(ticket.tramitar());
        assertEquals("João, atualização no Ticket{nome='Ticket A', solicitante='João', estado='Cancelado'}", solicitante.getUltimaNotificacao());
    }

    @Test
    public void naoDeveFecharTicketCancelado() {
        ticket.setEstado(TicketEstadoCancelado.getInstance());
        assertFalse(ticket.fechar());
        assertEquals("João, atualização no Ticket{nome='Ticket A', solicitante='João', estado='Cancelado'}", solicitante.getUltimaNotificacao());
    }

    //Ticket Fechado
    @Test
    public void naoDeveAbrirTicketFechado() {
        ticket.setEstado(TicketEstadoFechado.getInstance());
        assertFalse(ticket.abrir());
        assertEquals("João, atualização no Ticket{nome='Ticket A', solicitante='João', estado='Fechado'}", solicitante.getUltimaNotificacao());
    }

    @Test
    public void naoDeveResolverTicketFechado() {
        ticket.setEstado(TicketEstadoFechado.getInstance());
        assertFalse(ticket.resolver());
        assertEquals("João, atualização no Ticket{nome='Ticket A', solicitante='João', estado='Fechado'}", solicitante.getUltimaNotificacao());
    }

    @Test
    public void naoDeveCancelarTicketFechado() {
        ticket.setEstado(TicketEstadoFechado.getInstance());
        assertFalse(ticket.cancelar());
        assertEquals("João, atualização no Ticket{nome='Ticket A', solicitante='João', estado='Fechado'}", solicitante.getUltimaNotificacao());
    }

    @Test
    public void naoDeveTramitarTicketFechado() {
        ticket.setEstado(TicketEstadoFechado.getInstance());
        assertFalse(ticket.tramitar());
        assertEquals("João, atualização no Ticket{nome='Ticket A', solicitante='João', estado='Fechado'}", solicitante.getUltimaNotificacao());
    }

    @Test
    public void naoDeveFecharTicketFechado() {
        ticket.setEstado(TicketEstadoFechado.getInstance());
        assertFalse(ticket.fechar());
        assertEquals("João, atualização no Ticket{nome='Ticket A', solicitante='João', estado='Fechado'}", solicitante.getUltimaNotificacao());
    }

    //Observer
    @Test
    void naoDeveNotificarSolicitante() {
        Pessoa solicitante1 = new Pessoa("Arnaldo");
        Pessoa solicitante2 = new Pessoa("Carlos");
        Ticket ticketB = TicketFactory.obterTicket("Online");
        ticketB.setInfoTicket(ServicoSuporte.getInstance(), "Ticket B", solicitante1);
        assertTrue(ticketB.tramitar());
        assertEquals(TicketEstadoEmAndamento.getInstance(), ticketB.getEstado());
        assertEquals(null, solicitante2.getUltimaNotificacao());
    }

    @Test
    void deveNotificarSolicitanteTicketB() {
        Pessoa solicitante1 = new Pessoa("Arnaldo");
        Pessoa solicitante2 = new Pessoa("Carlos");
        Ticket ticketB = TicketFactory.obterTicket("Online");
        ticketB.setInfoTicket(ServicoSuporte.getInstance(), "Ticket B", solicitante1);
        Ticket ticketC = TicketFactory.obterTicket("Online");
        ticketC.setInfoTicket(ServicoSuporte.getInstance(), "Ticket C", solicitante2);
        assertTrue(ticketB.tramitar());
        assertEquals(TicketEstadoEmAndamento.getInstance(), ticketB.getEstado());
        assertEquals("Arnaldo, atualização no Ticket{nome='Ticket B', solicitante='Arnaldo', estado='Em andamento'}", solicitante1.getUltimaNotificacao());
        assertEquals(null, solicitante2.getUltimaNotificacao());
    }
}