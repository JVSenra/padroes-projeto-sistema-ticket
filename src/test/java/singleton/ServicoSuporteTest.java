package singleton;
import org.junit.jupiter.api.Test;
import sistema_ticket.ServicoSuporte;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ServicoSuporteTest {
    @Test
    void deveRetornarPrazoServicoSuporte() {
        assertEquals(5,  ServicoSuporte.getInstance().obterPrazo());
    }
}
