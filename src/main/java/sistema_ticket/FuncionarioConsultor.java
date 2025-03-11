package sistema_ticket;

public class FuncionarioConsultor extends Funcionario{
    public FuncionarioConsultor(Funcionario superior) {
        listaServicos.add(ServicoConsultoria.getInstance());
        setFuncionarioSuperior(superior);
    }

    public String getDescricaoCargo() {
        return "Consultor";
    }
}
