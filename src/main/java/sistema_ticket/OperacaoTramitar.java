package sistema_ticket;

public class OperacaoTramitar implements Operacao{

    private OperacaoTramitar() {};
    private static OperacaoTramitar instance = new OperacaoTramitar();
    public static OperacaoTramitar getInstance() {

        return instance;
    }

    public boolean executar(Ticket ticket) {
        return ticket.tramitar();
    }
}
