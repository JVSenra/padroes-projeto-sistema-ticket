/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistema_ticket;

/**
 *
 * @author user
 */
public class TicketEstadoCancelado extends TicketEstado{
    private TicketEstadoCancelado() {};
    private static TicketEstadoCancelado instance = new TicketEstadoCancelado();
    public static TicketEstadoCancelado getInstance() {
        return instance;
    }
    
    public String getEstado() {
        return "Cancelado";
    }
}
