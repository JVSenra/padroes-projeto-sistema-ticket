package sistema_ticket;

public class ServicoConsultoria implements Servico{
    private ServicoConsultoria() {};
    private static ServicoConsultoria instance = new ServicoConsultoria();
    public static ServicoConsultoria getInstance() {

        return instance;
    }

    @Override
    public int obterPrazo() {
        return 20;
    }
}
