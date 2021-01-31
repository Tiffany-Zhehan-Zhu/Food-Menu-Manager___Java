package edu.pitt.is17.zhz90.menumanager;

import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.BufferedWriter;
import java.io.FileWriter;

/**
 * Class FileManager
 * @author Zhehan Zhu
 * Created:10/28/2016
 */

public class FileManager {
		
	/**
	 * Method of readItems
	 * @param fileName of the file includes name, description and calories of each item
	 * @return an ArrayList contains multiple menu items
	 */
	public static ArrayList<MenuItem> readItems(String fileName) {
		ArrayList<MenuItem> menuItemList = new ArrayList<MenuItem>();
		
		try {
			FileReader fr = new FileReader(fileName);
		    BufferedReader br = new BufferedReader(fr);
		    String line = "";
		    
		    while((line = br.readLine()) != null){
		    		String[] parts = line.split("@@");
		    		MenuItem menuItem = null;
		    		if(parts[1].equalsIgnoreCase("entree")) 
		    			menuItem = new Entree(parts[0], parts[2], Integer.parseInt(parts[3]), Double.parseDouble(parts[4]));
		    		if(parts[1].equalsIgnoreCase("side")) 
		    			menuItem = new Side(parts[0], parts[2], Integer.parseInt(parts[3]), Double.parseDouble(parts[4]));
		    		if(parts[1].equalsIgnoreCase("salad")) 
		    			menuItem = new Salad(parts[0], parts[2], Integer.parseInt(parts[3]), Double.parseDouble(parts[4]));
		    		if(parts[1].equalsIgnoreCase("dessert")) 
		    			menuItem = new Dessert(parts[0], parts[2], Integer.parseInt(parts[3]), Double.parseDouble(parts[4]));
		    		menuItemList.add(menuItem);
		    }
		    br.close();
		    fr.close();
		} catch (IOException e) {
		    System.out.println(e.getMessage());
		}
		
		return menuItemList;
		
	}
	
	
	/**
	 * Method of writeMenu
	 * @param fileName of the file created
	 * @param menus in an ArrayList
	 */
	public static void writeMenu(String fileName, ArrayList<Menu> menus) {
		
		try {
            FileWriter fw = new FileWriter(fileName);
            BufferedWriter bw = new BufferedWriter(fw);
            for (Menu eachMenu: menus) {            
            	String fileLine = eachMenu.toString()+"\n"+eachMenu.description()+"\nCalories: "+eachMenu.totalCalories()+". \nPrice: $ "+eachMenu.totalPrice()+"\n";
            	bw.write(fileLine);
            	bw.newLine();
            }
            bw.close();
            fw.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
		
	}
	
}
