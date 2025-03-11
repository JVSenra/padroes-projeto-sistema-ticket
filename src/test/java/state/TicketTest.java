package state;
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
    }

    @Test
    public void naoDeveResolverTicketAberto() {
        ticket.setEstado(TicketEstadoAberto.getInstance());
        assertFalse(ticket.resolver());
    }

    @Test
    public void naoDeveFecharTicketAberto() {
        ticket.setEstado(TicketEstadoAberto.getInstance());
        assertFalse(ticket.fechar());
    }

    @Test
    public void deveCancelarTicketAberto() {
        ticket.setEstado(TicketEstadoAberto.getInstance());
        assertTrue(ticket.cancelar());
        assertEquals(TicketEstadoCancelado.getInstance(), ticket.getEstado());

    }

    @Test
    public void deveTramitarTicketAberto() {
        ticket.setEstado(TicketEstadoAberto.getInstance());
        assertTrue(ticket.tramitar());
        assertEquals(TicketEstadoEmAndamento.getInstance(), ticket.getEstado());
    }

    //Ticket Em Andamento
    @Test
    public void naoDeveAbrirTicketEmAndamento() {
        ticket.setEstado(TicketEstadoEmAndamento.getInstance());
        assertFalse(ticket.abrir());
    }

    @Test
    public void naoDeveTramitarTicketEmAndamento() {
        ticket.setEstado(TicketEstadoEmAndamento.getInstance());
        assertFalse(ticket.tramitar());
    }

    @Test
    public void naoDeveFecharTicketEmAndamento() {
        ticket.setEstado(TicketEstadoEmAndamento.getInstance());
        assertFalse(ticket.fechar());
    }

    @Test
    public void deveCancelarTicketEmAndamento() {
        ticket.setEstado(TicketEstadoEmAndamento.getInstance());
        assertTrue(ticket.cancelar());
        assertEquals(TicketEstadoCancelado.getInstance(), ticket.getEstado());
    }

    @Test
    public void deveResolverTicketEmAndamento() {
        ticket.setEstado(TicketEstadoEmAndamento.getInstance());
        assertTrue(ticket.resolver());
        assertEquals(TicketEstadoResolvido.getInstance(), ticket.getEstado());
    }

    //Ticket Resolvido
    @Test
    public void naoDeveAbrirTicketResolvido() {
        ticket.setEstado(TicketEstadoResolvido.getInstance());
        assertFalse(ticket.abrir());
    }

    @Test
    public void naoDeveResolverTicketResolvido() {
        ticket.setEstado(TicketEstadoResolvido.getInstance());
        assertFalse(ticket.resolver());
    }

    @Test
    public void naoDeveCancelarTicketResolvido() {
        ticket.setEstado(TicketEstadoResolvido.getInstance());
        assertFalse(ticket.cancelar());
    }

    @Test
    public void deveTramitarTicketResolvido() {
        ticket.setEstado(TicketEstadoResolvido.getInstance());
        assertTrue(ticket.tramitar());
        assertEquals(TicketEstadoEmAndamento.getInstance(), ticket.getEstado());
    }

    @Test
    public void deveFecharTicketResolvido() {
        ticket.setEstado(TicketEstadoResolvido.getInstance());
        assertTrue(ticket.fechar());
        assertEquals(TicketEstadoFechado.getInstance(), ticket.getEstado());
    }

    //Ticket Cancelado
    @Test
    public void naoDeveAbrirTicketCancelado() {
        ticket.setEstado(TicketEstadoCancelado.getInstance());
        assertFalse(ticket.abrir());
    }

    @Test
    public void naoDeveResolverTicketCancelado() {
        ticket.setEstado(TicketEstadoCancelado.getInstance());
        assertFalse(ticket.resolver());
    }

    @Test
    public void naoDeveCancelarTicketCancelado() {
        ticket.setEstado(TicketEstadoCancelado.getInstance());
        assertFalse(ticket.cancelar());
    }

    @Test
    public void naoDeveTramitarTicketCancelado() {
        ticket.setEstado(TicketEstadoCancelado.getInstance());
        assertFalse(ticket.tramitar());
    }

    @Test
    public void naoDeveFecharTicketCancelado() {
        ticket.setEstado(TicketEstadoCancelado.getInstance());
        assertFalse(ticket.fechar());
    }

    //Ticket Fechado
    @Test
    public void naoDeveAbrirTicketFechado() {
        ticket.setEstado(TicketEstadoFechado.getInstance());
        assertFalse(ticket.abrir());
    }

    @Test
    public void naoDeveResolverTicketFechado() {
        ticket.setEstado(TicketEstadoFechado.getInstance());
        assertFalse(ticket.resolver());
    }

    @Test
    public void naoDeveCancelarTicketFechado() {
        ticket.setEstado(TicketEstadoFechado.getInstance());
        assertFalse(ticket.cancelar());
    }

    @Test
    public void naoDeveTramitarTicketFechado() {
        ticket.setEstado(TicketEstadoFechado.getInstance());
        assertFalse(ticket.tramitar());
    }

    @Test
    public void naoDeveFecharTicketFechado() {
        ticket.setEstado(TicketEstadoFechado.getInstance());
        assertFalse(ticket.fechar());
    }

}