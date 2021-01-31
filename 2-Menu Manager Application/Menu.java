package edu.pitt.is17.zhz90.menumanager;

/**
 * Class Menu
 * @author Zhehan Zhu 
 * Created: 10/13/2016
 */

public class Menu {

	private String name;
	private Entree entree;
	private Salad salad;
	private Side side;
	private Dessert dessert;

	// Constructor 1
	public Menu(String name) {
		this.name = name;
		entree = null;
		side = null;
		salad = null;
		dessert = null;
	}

	// Constructor 2
	public Menu(String name, Entree entree, Side side) {
		this.name = name;
		this.entree = entree;
		this.side = side;
		salad = null;
		dessert = null;
	}

	// Constructor 3
	public Menu(String name, Entree entree, Side side, Salad salad, Dessert dessert) {
		this.name = name;
		this.entree = entree;
		this.side = side;
		this.salad = salad;
		this.dessert = dessert;
	}

	// Sums the calories of all the parts of the menu
	public int totalCalories() {

		int totalCalories = 0;

		if (entree == null)
			totalCalories += 0; // If the object is null, the calories is 0.
		else
			totalCalories += entree.getCalories(); // If the object is not null,
													// add the calories to the
													// total calories.

		if (side == null)
			totalCalories += 0;
		else
			totalCalories += side.getCalories();

		if (salad == null)
			totalCalories += 0;
		else
			totalCalories += salad.getCalories();

		if (dessert == null)
			totalCalories += 0;
		else
			totalCalories += dessert.getCalories();

		return totalCalories;

	} // end of the totalCalories method

	// Sums the price of all the parts of the menu
	public double totalPrice() {

		double totalPrice = 0;

		if (entree == null)
			totalPrice += 0; // If the object is null, the price is 0.
		else
			totalPrice += entree.getPrice(); // If the object is not null, add
												// the price to the total price.

		if (side == null)
			totalPrice += 0;
		else
			totalPrice += side.getPrice();

		if (salad == null)
			totalPrice += 0;
		else
			totalPrice += salad.getPrice();

		if (dessert == null)
			totalPrice += 0;
		else
			totalPrice += dessert.getPrice();

		return totalPrice;

	} // end of the totalPrice method

	// Concatenates the descriptions of the parts of the menu in order
	public String description() {

		String description = "";

		if (entree == null) {
			description += "Entree: N/A\n"; // If a menu lack of this part, the
											// description of this part indicate
											// as N/A.
		} else {
			description += "Entree: " + entree.getName() + ". " + entree.getDescription() + ". Calories: "
					+ entree.getCalories() + ". Price: " + entree.getPrice() + ". \n";
		}

		if (side == null) {
			description += "Side: N/A\n";
		} else {
			description += "Side: " + side.getName() + ". " + side.getDescription() + ". Calories: "
					+ side.getCalories() + ". Price: " + side.getPrice() + ". \n";
		}

		if (salad == null) {
			description += "Salad: N/A\n";
		} else {
			description += "Salad: " + salad.getName() + ". " + salad.getDescription() + ". Calories: "
					+ salad.getCalories() + ". Price: " + salad.getPrice() + ". \n";
		}

		if (dessert == null) {
			description += "Dessert: N/A";
		} else {
			description += "Dessert: " + dessert.getName() + ". " + dessert.getDescription() + ". Calories: "
					+ dessert.getCalories() + ". Price: " + dessert.getPrice() + ". ";
		}

		return description;

	} // end of the description method

	@Override
	public String toString() {
		return getName();
	}

	// Getters
	public String getName() {
		return name;
	}

	public Entree getEntree() {
		return entree;
	}

	public Salad getSalad() {
		return salad;
	}

	public Side getSide() {
		return side;
	}

	public Dessert getDessert() {
		return dessert;
	}

	// Setters
	public void setName(String name) {
		this.name = name;
	}

	public void setEntree(Entree entree) {
		this.entree = entree;
	}

	public void setSalad(Salad salad) {
		this.salad = salad;
	}

	public void setSide(Side side) {
		this.side = side;
	}

	public void setDessert(Dessert dessert) {
		this.dessert = dessert;
	}

}
