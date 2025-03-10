package sistema_ticket;

public class TicketFactory {
    public static Ticket obterTicket(String ticket) {
        Class classe = null;
        Object objeto = null;
        try {
            classe = Class.forName("sistema_ticket.Ticket" + ticket);
            objeto = classe.newInstance();
        } catch (Exception ex) {
            throw new IllegalArgumentException("Ticket inexistente");
        }
        if (!(objeto instanceof Ticket)) {
            throw new IllegalArgumentException("Ticket inválido");
        }
        return (Ticket) objeto;
    }
}
