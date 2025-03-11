package sistema_ticket;

public class TicketPresencial extends Ticket{
    private int numeroGuiche;
    public void setInfoTicket(Servico servico, String nome, Pessoa solicitante, int numeroGuiche){
        super.setInfoTicket(servico, nome, solicitante);
        this.numeroGuiche = numeroGuiche;
    }

    public int getNumeroGuiche() {
        return numeroGuiche;
    }

    @Override
    public int calcularPrazo() {
        return 15 + this.servico.obterPrazo();
    }

    @Override
    public String aceitar(Visitor visitor) {
        return visitor.exibirTicketPresencial(this);
    }

    public String toString() {
        return "Ticket{"+ "nome=" + '\'' + this.getNome()+  '\'' + ", solicitante=" + '\''+ this.getSolicitante().getNome()+ '\''+", estado=" + '\''+ this.getNomeEstado()+ '\''+", numeroGuiche=" + '\''+ this.getNumeroGuiche()+ '\''+'}';
    }
}
