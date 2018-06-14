package ostbahn.Entity;
import javax.persistence.*;

@Entity
public class Einzelticket extends Ticket {

	private TicketOption ticketOption;

	public TicketOption getTicketOption() {
		return ticketOption;
	}

	public Einzelticket() {
	}

	public void setTicketOption(TicketOption ticketOption) {
		this.ticketOption = ticketOption;
	}

	public Einzelticket(TicketOption ticketOption) {
		this.ticketOption = ticketOption;
	}
}
