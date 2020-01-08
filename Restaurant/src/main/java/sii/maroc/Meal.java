package sii.maroc;

public class Meal {
	private int nbPizza;
	private int nbSalade;

	
	public Meal (int pizzas,int nbSalade) {
		nbPizza = pizzas;
		nbSalade = nbSalade;

	}

	public int servedDishes() {
		return nbPizza + nbSalade;
	}

	public int cookingDuration() {
		int duration = 0;
		if(nbSalade == 1 ) duration+=6;
		else{
			duration+=(nbSalade-1)*3;
		}
		if(nbPizza > 0) duration+= 10;
		return duration;
	}

	public int getNbPizza() {
		return nbPizza;
	}

	public void setNbPizza(int nbPizza) {
		this.nbPizza = nbPizza;
	}

	public int getNbSalade() {
		return nbSalade;
	}

	public void setNbSalade(int nbSalade) {
		this.nbSalade = nbSalade;
	}
}
