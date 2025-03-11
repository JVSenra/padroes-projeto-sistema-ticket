package sistema_ticket;

public class OperacaoFechar implements Operacao{
    private OperacaoFechar() {};
    private static OperacaoFechar instance = new OperacaoFechar();
    public static OperacaoFechar getInstance() {

        return instance;
    }

    public boolean executar(Ticket ticket) {
        return ticket.fechar();
    }
}
