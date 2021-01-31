package edu.pitt.is17.zhz90.menumanager;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Class MenuManager
 * @author Zhehan Zhu 
 * Created: 12/3/2016
 */

public class MenuManager {
	
	private ArrayList<Entree> entrees;
	private ArrayList<Side> sides;
	private ArrayList<Salad> salads;
	private ArrayList<Dessert> desserts;
	
	/**
	 * Constructor:
	 * Read a file and fill a single ArrayList of MenuItem in the file.
	 * @param dishesFile name 
	 */
	public MenuManager(String dishesFile) {
		ArrayList<MenuItem> menuItems = FileManager.readItems(dishesFile);
		fill(menuItems);
	}
	
	
	/**
	 * Method of fill:
	 * Fill a single ArrayList of MenuItem and separate the single ArrayList 
	 * containing MenuItem objects into the four ArrayList of different types. 
	 * @param menuItems which contains all the entrees, sides, salads and desserts
	 */
	public void fill(ArrayList<MenuItem> menuItems) {
		entrees = new ArrayList<Entree>();
		sides = new ArrayList<Side>();
		salads = new ArrayList<Salad>();
		desserts = new ArrayList<Dessert>();
		
		for (MenuItem item: menuItems){	
			if (item instanceof Entree)  entrees.add((Entree)item);
			if (item instanceof Side)  sides.add((Side)item);
			if (item instanceof Salad) salads.add((Salad)item);
			if (item instanceof Dessert) desserts.add((Dessert)item);			 	
		}
	}
		
	
	/**
	 * Method of randomMenu:
	 * Randomly pick one Entree, one Side, one Salad and one Dessert.
	 * @param name of the menu 
	 * @return a Menu object composed of the random dishes
	 */
	public Menu randomMenu(String name) {		
		int a = (int) (Math.random()*entrees.size());
		int b = (int) (Math.random()*sides.size());
		int c = (int) (Math.random()*salads.size());
		int d = (int) (Math.random()*desserts.size());	
		Menu menu = new Menu(name, entrees.get(a), sides.get(b), salads.get(c), desserts.get(d));
		return menu;
	}

	
	/**
	 * Method of minCaloriesMenu:
	 * Pick the entree with the lowest calorie value among entrees. Same for side, salad and dessert. 
	 * @param name of the menu 
	 * @return a Menu object of lowest calories
	 */
	public Menu minCaloriesMenu(String name) {
		Entree minEntree = null;
		Side minSide = null;
		Salad minSalad = null;
		Dessert minDessert = null;
			
		ArrayList<Integer> entreeCal = new ArrayList<Integer>();
		for (Entree eachEntree : entrees)  entreeCal.add(eachEntree.getCalories());			
		for (Entree eachEntree : entrees) {		
			if (eachEntree.getCalories() == Collections.min(entreeCal)) {
				minEntree = eachEntree;
			}							
		}
		
		ArrayList<Integer> SideCal = new ArrayList<Integer>();
		for (Side eachSide : sides)  SideCal.add(eachSide.getCalories());			
		for (Side eachSide : sides) {		
			if (eachSide.getCalories() == Collections.min(SideCal)) {
				minSide = eachSide;
			}							
		}
			
		ArrayList<Integer> saladCal = new ArrayList<Integer>();
		for (Salad eachSalad : salads)  saladCal.add(eachSalad.getCalories());			
		for (Salad eachSalad : salads) {		
			if (eachSalad.getCalories() == Collections.min(saladCal)) {
				minSalad = eachSalad;
			}							
		}
		
		ArrayList<Integer> dessertCal = new ArrayList<Integer>();
		for (Dessert eachDessert : desserts)  dessertCal.add(eachDessert.getCalories());			
		for (Dessert eachDessert : desserts) {		
			if (eachDessert.getCalories() == Collections.min(dessertCal)) {
				minDessert = eachDessert;
			}							
		}
		
		Menu minCaloriesMenu = new Menu(name, minEntree, minSide, minSalad, minDessert);
		return minCaloriesMenu;
	}

	
	/**
	 * Method of maxCaloriesMenu:
	 * Pick the entree with the highest calorie value among entrees. Same for side, salad and dessert. 
	 * @param name of the menu 
	 * @return a Menu object of highest calories
	 */
	public Menu maxCaloriesMenu(String name) {
		
		int maxE = entrees.get(0).getCalories();
		int maxPosE = 0;
		for (int i=0; i < entrees.size(); i++){
			if (entrees.get(i).getCalories() > maxE) {
				maxE = entrees.get(i).getCalories();
				maxPosE = i;
			}
		}
		Entree maxEntree = entrees.get(maxPosE);
		
		int maxS = sides.get(0).getCalories();
		int maxPosS = 0;
		for (int i=0; i < sides.size(); i++){
			if (sides.get(i).getCalories() > maxS) {
				maxS = sides.get(i).getCalories();
				maxPosS = i;
			}
		}
		Side maxSide = sides.get(maxPosS);
		
		int maxSa = salads.get(0).getCalories();
		int maxPosSa = 0;
		for (int i=0; i < salads.size(); i++){
			if (salads.get(i).getCalories() > maxSa) {
				maxSa = salads.get(i).getCalories();
				maxPosSa = i;
			}
		}
		Salad maxSalad = salads.get(maxPosSa);
		
		int maxD = desserts.get(0).getCalories();
		int maxPosD = 0;
		for (int i=0; i < desserts.size(); i++){
			if (desserts.get(i).getCalories() > maxD) {
				maxD = desserts.get(i).getCalories();
				maxPosD = i;
			}
		}
		Dessert maxDessert = desserts.get(maxPosD);
		
		Menu maxCaloriesMenu = new Menu(name, maxEntree, maxSide, maxSalad, maxDessert);
		return maxCaloriesMenu;
	}

	
	// Getters and setters
	public ArrayList<Entree> getEntrees() {
		return entrees;
	}

	public void setEntrees(ArrayList<Entree> entrees) {
		this.entrees = entrees;
	}

	public ArrayList<Salad> getSalads() {
		return salads;
	}

	public void setSalads(ArrayList<Salad> salads) {
		this.salads = salads;
	}

	public ArrayList<Side> getSides() {
		return sides;
	}

	public void setSides(ArrayList<Side> sides) {
		this.sides = sides;
	}

	public ArrayList<Dessert> getDesserts() {
		return desserts;
	}

	public void setDesserts(ArrayList<Dessert> desserts) {
		this.desserts = desserts;
	}
	
}
