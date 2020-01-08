package sii.maroc;

public class Ticket {
	private String order;
	
	public Ticket(String string) {
		order = string;
	}

	public Ticket and(String string) {
		Ticket t = new Ticket(this.order + "," + string);
		return t;
	}

	public String getOrder() {
		return order;
	}

	public void setOrder(String order) {
		this.order = order;
	}
}
