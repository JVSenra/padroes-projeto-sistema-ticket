/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistema_ticket;

/**
 *
 * @author user
 */
public class TicketEstadoEmAndamento extends TicketEstado{
    private TicketEstadoEmAndamento() {};
    private static TicketEstadoEmAndamento instance = new TicketEstadoEmAndamento();
    public static TicketEstadoEmAndamento getInstance() {
        return instance;
    }
    
    public String getEstado() {
        return "Em andamento";
    }
     
   public boolean resolver(Ticket ticke) {
         ticke.setEstado(TicketEstadoResolvido.getInstance());
         return true;
   }
   
    public boolean cancelar(Ticket ticke) {
         ticke.setEstado(TicketEstadoCancelado.getInstance());
         return true;
   }
}
