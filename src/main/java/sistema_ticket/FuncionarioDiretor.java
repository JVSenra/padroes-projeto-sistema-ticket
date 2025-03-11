package sistema_ticket;

public class FuncionarioDiretor extends Funcionario{
    public FuncionarioDiretor(Funcionario superior) {
        setFuncionarioSuperior(superior);
    }

    public String getDescricaoCargo() {
        return "Diretor";
    }
}
