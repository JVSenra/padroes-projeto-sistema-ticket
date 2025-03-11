package sistema_ticket;
import java.util.Observable;
import java.util.Observer;

public class Pessoa implements Observer {
    private String nome;
    private String ultimaNotificacao;

    public Pessoa(String nome) {
        this.nome = nome;
    }

    public String getUltimaNotificacao() {
        return this.ultimaNotificacao;
    }

    public void update(Observable ticket, Object arg1) {
        this.ultimaNotificacao = this.nome + ", atualização no " + ticket.toString();
    }

    public String getNome() {
        return nome;
    }
}
