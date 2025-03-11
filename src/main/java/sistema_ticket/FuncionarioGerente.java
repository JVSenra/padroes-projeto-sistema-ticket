package sistema_ticket;

public class FuncionarioGerente extends Funcionario{
    public FuncionarioGerente(Funcionario superior) {
        setFuncionarioSuperior(superior);
    }

    public String getDescricaoCargo() {
        return "Gerente";
    }
}
