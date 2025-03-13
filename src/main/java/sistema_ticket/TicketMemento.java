package sistema_ticket;

public class TicketMemento {
    private TicketEstado estado;

    public TicketMemento(TicketEstado estado) {
        this.estado = estado;
    }

    public TicketEstado getEstado() {
        return this.estado;
    }
}
