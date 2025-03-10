/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistema_ticket;
import java.util.Observable;

/**
 *
 * @author user
 */
public class Ticket extends Observable{
    private String nome;
    private TicketEstado estado;
    private Pessoa solicitante;


    public Ticket(String nome, Pessoa solicitante) {
        this.estado = TicketEstadoAberto.getInstance();
        this.solicitante = solicitante;
        this.addObserver(solicitante);
        this.nome = nome;
    }
    
    public void setEstado(TicketEstado estado) {
        this.estado = estado;
        setChanged();
        notifyObservers();
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

    public String toString() {
        return "Ticket{"+ "nome=" + '\'' + this.nome+  '\'' + ", estado=" + '\''+ this.getNomeEstado()+ '\''+'}';
    }
}
