package sistema_ticket;

public class ServicoSuporte implements Servico{
    private ServicoSuporte() {};
    private static ServicoSuporte instance = new ServicoSuporte();
    public static ServicoSuporte getInstance() {

        return instance;
    }

    @Override
    public int obterPrazo() {
        return 5;
    }
}
