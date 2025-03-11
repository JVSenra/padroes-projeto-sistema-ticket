package sistema_ticket;

public class TicketOnline extends Ticket{
    private String codigoVerificacao;

    public void setInfoTicket(Servico servico, String nome, Pessoa solicitante, String codigoVerificacao){
        super.setInfoTicket(servico, nome, solicitante);
        this.codigoVerificacao = codigoVerificacao;
    }

    public String getCodigoVerificacao() {
        return codigoVerificacao;
    }

    @Override
    public int calcularPrazo() {
        return 5 + this.servico.obterPrazo();
    }


    @Override
    public String aceitar(Visitor visitor) {
        return visitor.exibirTicketOnline(this);
    }

    public String toString() {
        return "Ticket{"+ "nome=" + '\'' + this.getNome()+  '\'' + ", solicitante=" + '\''+ this.getSolicitante().getNome()+ '\''+", estado=" + '\''+ this.getNomeEstado()+ '\''+", codigoVerificacao=" + '\''+ this.getCodigoVerificacao()+ '\''+'}';
    }
}
