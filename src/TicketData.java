import java.util.ArrayList;
import java.util.List;

class TicketData {
    private static TicketData instance;
    private List<Ticket> tickets = new ArrayList<>();

    private TicketData() {}

    public static TicketData getInstance() {
        if (instance == null) {
            instance = new TicketData();
        }
        return instance;
    }

    public List<Ticket> getTickets() {
        return tickets;
    }

    public void addTicket(Ticket ticket) {
        tickets.add(ticket);
    }
}