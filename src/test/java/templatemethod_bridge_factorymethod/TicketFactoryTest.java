package templatemethod_bridge_factorymethod;
import org.junit.jupiter.api.Test;
import sistema_ticket.*;
import static org.junit.jupiter.api.Assertions.*;
public class TicketFactoryTest {

    @Test
    void deveRetornarExcecaoParaTicketInexistente() {
        try {
            Ticket ticket = TicketFactory.obterTicket("Ouvidoria");
            fail();
        } catch (IllegalArgumentException e) {
            assertEquals("Ticket inexistente", e.getMessage());
        }
    }

}
