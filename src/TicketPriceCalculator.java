import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

public class TicketPriceCalculator {
    public static void main(String[] args) {
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse("tickets.xml");

            NodeList ticketNodes = document.getElementsByTagName("ticket");
            double totalCost = 0.0;
            TicketFactory ticketFactory = new TicketFactory();

            for (int i = 0; i < ticketNodes.getLength(); i++) {
                Element ticketElement = (Element) ticketNodes.item(i);
                String type = ticketElement.getAttribute("type");
                double price = Double.parseDouble(ticketElement.getAttribute("price"));
                int quantity = Integer.parseInt(ticketElement.getAttribute("quantity"));

                Ticket ticket = ticketFactory.createTicket(type, price, quantity);
                totalCost += ticket.getTotalPrice()*ticket.getQuantity();

                System.out.println("Билет типа " + ticket.getType() + " x " + ticket.getQuantity() + " шт. по цене "
                        + ticket.getPrice() + " руб. Общая стоимость: " + ticket.getTotalPrice()*ticket.getQuantity() + " руб.");
            }

            System.out.println("Общая стоимость всех билетов: " + totalCost + " руб.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}