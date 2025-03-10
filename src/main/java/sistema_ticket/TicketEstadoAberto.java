/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistema_ticket;

/**
 *
 * @author user
 */
public class TicketEstadoAberto extends TicketEstado{
    private TicketEstadoAberto() {};
    private static TicketEstadoAberto instance = new TicketEstadoAberto();
    public static TicketEstadoAberto getInstance() {
        return instance;
    }
    
    public String getEstado() {
        return "Aberto";
    }
     
   public boolean tramitar(Ticket ticke) {
         ticke.setEstado(TicketEstadoEmAndamento.getInstance());
         return true;
   }
   
    public boolean cancelar(Ticket ticke) {
         ticke.setEstado(TicketEstadoCancelado.getInstance());
         return true;
   }
   
}
