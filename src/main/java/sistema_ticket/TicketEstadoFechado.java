/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistema_ticket;

/**
 *
 * @author user
 */
public class TicketEstadoFechado extends TicketEstado{
    private TicketEstadoFechado() {};
    private static TicketEstadoFechado instance = new TicketEstadoFechado();
    public static TicketEstadoFechado getInstance() {
        return instance;
    }
    
    public String getEstado() {
        return "Fechado";
    }
}
