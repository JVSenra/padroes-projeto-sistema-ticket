package sistema_ticket;

public class OperacaoCancelar implements Operacao{
    private OperacaoCancelar() {};
    private static OperacaoCancelar instance = new OperacaoCancelar();
    public static OperacaoCancelar getInstance() {

        return instance;
    }

    public boolean executar(Ticket ticket) {
        return ticket.cancelar();
    }
}
