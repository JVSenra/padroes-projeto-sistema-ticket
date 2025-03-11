package sistema_ticket;

public class FuncionarioSuporte extends Funcionario{
    public FuncionarioSuporte(Funcionario superior) {
        listaServicos.add(ServicoSuporte.getInstance());
        setFuncionarioSuperior(superior);
    }

    public String getDescricaoCargo() {
        return "Suporte";
    }
}
