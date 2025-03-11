package sistema_ticket;

public class OperacaoResolver implements Operacao{
    private OperacaoResolver() {};
    private static OperacaoResolver instance = new OperacaoResolver();
    public static OperacaoResolver getInstance() {

        return instance;
    }

    public boolean executar(Ticket ticket) {
        return ticket.resolver();
    }
}
