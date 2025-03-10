/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistema_ticket;

/**
 *
 * @author user
 */
public abstract class TicketEstado {
    public abstract String getEstado();

    public boolean abrir(Ticket ticket) {
        return false;
    }

    public boolean tramitar(Ticket ticket) {
        return false;
    }

    public boolean cancelar(Ticket ticket) {
        return false;
    }

    public boolean resolver(Ticket ticket) {
        return false;
    }

    public boolean fechar(Ticket ticket) {
        return false;
    }
}
