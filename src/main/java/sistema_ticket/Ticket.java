/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistema_ticket;
import java.util.Observable;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author user
 */
public abstract class Ticket extends Observable{
    protected String nome;
    protected TicketEstado estado;
    protected Pessoa solicitante;
    protected Servico servico;
    protected List<TicketMemento> historico = new ArrayList<TicketMemento>();

    public Ticket() {
    }

    public void setInfoTicket(Servico servico, String nome, Pessoa solicitante) {
        this.servico =servico;
        this.estado = TicketEstadoAberto.getInstance();
        this.solicitante = solicitante;
        this.addObserver(solicitante);
        this.nome = nome;
        historico.add(salvarEstado());
    }

    public void setEstado(TicketEstado estado) {
        this.estado = estado;
        setChanged();
        notifyObservers();
        historico.add(salvarEstado());
    }

    public boolean abrir() {
        return estado.abrir(this);
    }
    
    public boolean tramitar() {
        return estado.tramitar(this);
    }

    public boolean cancelar() {
        return estado.cancelar(this);
    }
    
    public boolean resolver() {
        return estado.resolver(this);
    }
    
    public boolean fechar() {   
        return estado.fechar(this);
    }

    public String getNomeEstado() {
        return estado.getEstado();
    }

    public TicketEstado getEstado() {
        return estado;
    }

    public abstract int calcularPrazo();

    public Pessoa getSolicitante() {
        return solicitante;
    }

    public String getNome() {
        return nome;
    }

    public Servico getServico() {
        return servico;
    }

    public TicketMemento salvarEstado() {
        return new TicketMemento(this.estado);
    }
    public String toString() {
        return "Ticket{"+ "nome=" + '\'' + this.getNome()+  '\'' + ", solicitante=" + '\''+ this.getSolicitante().getNome()+ '\''+", estado=" + '\''+ this.getNomeEstado()+ '\''+'}';
    }
    public void restaurarEstado(TicketMemento memento) {
        this.estado = memento.getEstado();
    }

    public List<TicketMemento> getHistorico() {
        return historico;
    }

    public String exibirHistorico() {
        String result = "Histórico de Estados do Ticket: " + this.nome + "\n";

        int i = 1;
        for (TicketMemento memento : this.historico) {
            result += i++ + ". " + memento.getEstado().getEstado() + "\n";
        }
        return result;
    }

    public abstract String aceitar(Visitor visitor);
}
