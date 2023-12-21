class TicketFactory {
    public Ticket createTicket(String type, double price, int quantity) {
        Ticket ticket = new Ticket(type, price, quantity);
        TicketData.getInstance().addTicket(ticket);
        return ticket;
    }
}