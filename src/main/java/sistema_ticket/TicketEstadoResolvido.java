/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sistema_ticket;

/**
 *
 * @author user
 */
public class TicketEstadoResolvido extends TicketEstado{
    private TicketEstadoResolvido() {};
    private static TicketEstadoResolvido instance = new TicketEstadoResolvido();
    public static TicketEstadoResolvido getInstance() {
        return instance;
    }
    
    public String getEstado() {
        return "Resolvido";
    }
     
   public boolean fechar(Ticket ticke) {
         ticke.setEstado(TicketEstadoFechado.getInstance());
         return true;
   }
   
    public boolean tramitar(Ticket ticke) {
         ticke.setEstado(TicketEstadoEmAndamento.getInstance());
         return true;
   }
}
