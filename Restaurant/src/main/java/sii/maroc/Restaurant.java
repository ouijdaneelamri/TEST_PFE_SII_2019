package sii.maroc;

import sii.maroc.Exception.UnavailableDishException;

public class Restaurant {

	private String mozarella;

	public String getMozarella() {
		return mozarella;
	}

	public void setMozarella(String mozarella) {
		this.mozarella = mozarella;
	}

	public String getTomates() {
		return tomates;
	}

	public void setTomates(String tomates) {
		this.tomates = tomates;
	}

	public String getOil() {
		return oil;
	}

	public void setOil(String oil) {
		this.oil = oil;
	}

	public String getPepper() {
		return pepper;
	}

	public void setPepper(String pepper) {
		this.pepper = pepper;
	}

	public String getFlour() {
		return flour;
	}

	public void setFlour(String flour) {
		this.flour = flour;
	}

	public String getSalt() {
		return salt;
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}

	private String tomates;
	private String oil;
	private String pepper;
	private String flour;
	private String salt;

	public Restaurant(String string, String string2, String string3, String string4) {
		mozarella = string;
		tomates = string2;
		oil = string3;
		pepper = string4;

	}

	public Restaurant(String string, String string2, String string3, String string4, String string5, String string6) {
		mozarella = string;
		tomates = string2;
		oil = string3;
		pepper = string4;

	}

	public Ticket order(String string) throws UnavailableDishException {
		Ticket ticket = new Ticket(string);
		if(string.contains(",")){
			String [] s = string.split(",");
			int qtySalade = Integer.parseInt(s[0].split(" ")[0]);
			int qtyPizza = Integer.parseInt(s[1].split(" ")[0]);
			orderPizza(qtyPizza);
			orderSalade(qtySalade);
		}
		else if(string.contains("Pizza")){
			int qtyPizza = Integer.parseInt(string.split(" ")[0]);
			orderPizza(qtyPizza);
		}
		else if(string.contains("Salad")){
			int qtySalad = Integer.parseInt(string.split(" ")[0]);
			orderSalade(qtySalad);
		}
		return ticket;
	}
	public void orderPizza(float qty) throws UnavailableDishException {

		this.mozarella = diminuerQuantite(qty,this.mozarella);
		this.tomates = diminuerQuantite(4*qty,this.tomates);
		this.flour = diminuerQuantite((float) (0.3*qty),this.flour);

	}
	public void orderSalade(int qty) throws UnavailableDishException {

		this.mozarella = diminuerQuantite(qty,this.mozarella);
		this.tomates = diminuerQuantite(2*qty,this.tomates);

	}

	public Meal retrieve(Ticket ticket) {
		int qtyPizza =0, qtySalade = 0;
		if(ticket.getOrder().contains(",")){
			String [] s = ticket.getOrder().split(",");
			 qtySalade = Integer.parseInt(s[0].split(" ")[0]);
			 qtyPizza = Integer.parseInt(s[1].split(" ")[0]);
		}
		else if (ticket.getOrder().contains("Pizza")){
			qtyPizza = Integer.parseInt(ticket.getOrder().split(" ")[0]);
		}
		else if (ticket.getOrder().contains("Salad")){
			qtySalade = Integer.parseInt(ticket.getOrder().split(" ")[0]);
		}
		Meal meal = new Meal(qtyPizza, qtySalade);
		return meal;
	}

	public String diminuerQuantite(float quantite, String ordre) throws UnavailableDishException {
		String[] ordres = ordre.split(" ");
		float qty = Float.parseFloat(ordres[0]);
		if (qty > 0) {
			qty=-quantite;
			return qty + ordre.substring(ordre.indexOf(" "));
		}
		else throw new UnavailableDishException();
	}
}


