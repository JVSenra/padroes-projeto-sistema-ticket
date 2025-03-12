package singleton;
import org.junit.jupiter.api.Test;
import sistema_ticket.ServicoConsultoria;

import static org.junit.jupiter.api.Assertions.assertEquals;
public class ServicoConsultoriaTest {
    @Test
    void deveRetornarPrazoServicoConsultoria() {
        assertEquals(20,  ServicoConsultoria.getInstance().obterPrazo());
    }
}
