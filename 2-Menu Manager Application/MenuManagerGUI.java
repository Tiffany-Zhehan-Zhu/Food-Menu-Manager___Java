package edu.pitt.is17.zhz90.menumanager;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.*;

/**
 * Class MenuManagerGUI
 * @author Zhehan Zhu 
 * Created: 12/3/2016
 */

public class MenuManagerGUI {
	
	private JFrame frmMain;

	// These components are to be added to the main frame
    private JLabel lblEntree;
    private JLabel lblSide;    
    private JLabel lblSalad;    
    private JLabel lblDessert;  
    private JLabel lblBuildMenu;
    private JLabel lblOrGenMenu;
    private JLabel lblCrtMenus;
    
    private JComboBox<Entree> cboEntree;
    private JComboBox<Side> cboSide;
    private JComboBox<Salad> cboSalad;    
    private JComboBox<Dessert> cboDessert;
    
    private JButton btnCrtMenu;
    private JButton btnRanMenu;
    private JButton btnMinMenu;  
    private JButton btnMaxMenu;
    private JButton btnDetails;
    private JButton btnDelete;
    private JButton btnSave;
    
    private JList<Object> listMenu;
    private DefaultListModel<Object> listModel;
       
    // These components are to be added to the second frame
	private JFrame frmSecond;
	
    private JLabel lblEntree2;
    private JLabel lblSide2;    
    private JLabel lblSalad2;    
    private JLabel lblDessert2;  
    private JLabel lbltotalCal;
    private JLabel lbltotalPri;
    
    private JTextArea txtEn;
    private JTextArea txtSi;
    private JTextArea txtSa;
    private JTextArea txtDe;
    private JTextArea txtCal;
    private JTextArea txtPri;    
	
    private MenuManager menuManager;
    

    /**
     * Constructor:
     * 1) Create the MenuManager object which loads the data from the file. 
     * 2) Build the main window gives users four options to generate Menu objects, 
     * and then see the details of a menu, delete all the menus and save the whole data of the menus into a file.
     * 3) Build a secondary window for displaying the details of a Menu. 
     */
    public MenuManagerGUI() {	
    	
    	menuManager = new MenuManager("data/dishes.txt");
    	
    	// Define the main window
    	frmMain = new JFrame("Menu Manager"); // Main window's title
		frmMain.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		frmMain.setResizable(false); 
		frmMain.setBounds(10,10,720,500); 
		frmMain.getContentPane().setLayout(null); 
		
		// Define the secondary window
		frmSecond = new JFrame(); // Secondary window's title will be set later
		frmSecond.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE); 
		frmSecond.setResizable(false); 
		frmSecond.setBounds(10,10,720,500); 
		frmSecond.getContentPane().setLayout(null);
				
		 // Define the labels in the main window
		lblEntree = new JLabel("Entree");
		lblEntree.setBounds(30,30,100,30);
		
		lblSide = new JLabel("Side");
		lblSide.setBounds(30,70,100,30);
		
		lblSalad = new JLabel("Salad");
		lblSalad.setBounds(30,110,100,30);
		
		lblDessert = new JLabel("Dessert");
		lblDessert.setBounds(30,150,100,30);
		
		lblBuildMenu = new JLabel("Build your own Menu");
		lblBuildMenu.setBounds(30,5,300,20);
		
		lblOrGenMenu = new JLabel("Or generate a Menu");
		lblOrGenMenu.setBounds(30,260,300,20);	
		
		lblCrtMenus = new JLabel("Created Menus:");
		lblCrtMenus.setBounds(360,10,300,20); 
		
		// Define the combo boxes in the main window and load the ArratList of menuManager object into the combo boxes
		cboEntree = new JComboBox(menuManager.getEntrees().toArray());
		cboEntree.setBounds(100,35,200,25);
		cboEntree.setSelectedIndex(-1); // by default, none is selected
		
		cboSide = new JComboBox(menuManager.getSides().toArray());
		cboSide.setBounds(100,75,200,25);
		cboSide.setSelectedIndex(-1);
		
		cboSalad = new JComboBox(menuManager.getSalads().toArray());
		cboSalad.setBounds(100,115,200,25);
		cboSalad.setSelectedIndex(-1);
		
		cboDessert = new JComboBox(menuManager.getDesserts().toArray());
		cboDessert.setBounds(100,155,200,25);
		cboDessert.setSelectedIndex(-1); 
		
		// Define the buttons in the main window
		btnCrtMenu = new JButton("Create Menu with these dishes"); 
		btnCrtMenu.setBounds(30,200,270,30);
		
		btnRanMenu = new JButton("Generate a Random Menu"); 
		btnRanMenu.setBounds(30,290,270,30);
		
		btnMinMenu = new JButton("Generate a Minimum Calories Menu"); 
		btnMinMenu.setBounds(30,335,270,30);
		
		btnMaxMenu = new JButton("Generate a Maximum Calories Menu"); 
		btnMaxMenu.setBounds(30,380,270,30);
		
	    btnDetails = new JButton("Details");     
	    btnDetails.setBounds(360,420,100,30);
	    
	    btnDelete = new JButton("Delete all"); 
	    btnDelete.setBounds(470,420,100,30);
	    
	    btnSave = new JButton("Save to file"); 
	    btnSave.setBounds(580,420,100,30); 
	    
	    // Define the JList in the main window        
	    listModel = new DefaultListModel<Object>();
        listMenu = new JList<Object>(listModel);
        listMenu.setBounds(360,35,320,370);
        listMenu.setBorder(BorderFactory.createLineBorder(Color.black));      
        
        // Generate menu objects and add menus to the list at the right side
        btnCrtMenu.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){			
				String input = JOptionPane.showInputDialog("Please input a name for the menu: ");				    		    
			    Entree selectedEn = (Entree) cboEntree.getSelectedItem();
			    Side selectedSi = (Side) cboSide.getSelectedItem();
			    Salad selectedSa = (Salad) cboSalad.getSelectedItem();
			    Dessert selectedDe = (Dessert) cboDessert.getSelectedItem();
			    if (input != null){
			    	Menu m = new Menu(input, selectedEn, selectedSi, selectedSa, selectedDe);
					listModel.addElement(m);  
			    }			    		    
			}
		});
        
        btnRanMenu.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				String input = JOptionPane.showInputDialog("Please input a name for the menu: ");
				if (input != null){				
					Menu mRan = menuManager.randomMenu(input);					
					listModel.addElement(mRan);
				}
			}
		});
        
        btnMinMenu.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				String input = JOptionPane.showInputDialog("Please input a name for the menu: ");
				if (input != null){
					Menu mMin = menuManager.minCaloriesMenu(input);			
					listModel.addElement(mMin);
				}
			}
		});
        
        btnMaxMenu.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				String input = JOptionPane.showInputDialog("Please input a name for the menu: ");
				if (input != null){
					Menu mMax = menuManager.maxCaloriesMenu(input);
					listModel.addElement(mMax);
				}				
			}
		});
               
		// Button "Details": Display the secondary window    
		btnDetails.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				if (!listMenu.isSelectionEmpty()) {            			   				  
                	Menu a = (Menu) listMenu.getSelectedValue();	
    				if(a != null){
    					Entree en = a.getEntree();
    					txtEn.setText(" "+en.getName()+"\n "+en.getDescription()+". Calories: "+en.getCalories()+". Price: $ "+en.getPrice());
    					Side si = a.getSide();
    					txtSi.setText(" "+si.getName()+"\n "+si.getDescription()+". Calories: "+si.getCalories()+". Price: $ "+si.getPrice()); 
    					Salad sa = a.getSalad();
    					txtSa.setText(" "+sa.getName()+"\n "+sa.getDescription()+". Calories: "+sa.getCalories()+". Price: $ "+sa.getPrice()); 
    					Dessert de = a.getDessert();
    					txtDe.setText(" "+de.getName()+"\n "+de.getDescription()+". Calories: "+de.getCalories()+". Price: $ "+de.getPrice()); 		                   	
    					txtCal.setText(" "+String.valueOf(a.totalCalories()));			            	
    					txtPri.setText(" "+String.valueOf(a.totalPrice()));    
    									
    					frmSecond.setTitle("Menu: " + a.toString()); // set the secondary window's title
    					frmSecond.setVisible(true);	// set the secondary window visible
    				}   					
				}
			}
		});
		
		// Button "Delete all": removes all Menu elements from the list
		btnDelete.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				listModel.removeAllElements();
			}
		});
				
		// Button "Save to File"
		btnSave.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				ArrayList<Menu> menus = new ArrayList<Menu>();	
				
				if (listModel.getSize() != 0){
					for (int i = 0; i < listModel.getSize(); i++)					
						menus.add((Menu)listModel.getElementAt(i));										
				}

				FileManager.writeMenu("data/menus.txt", menus);				
			}
		});
        		
        // Add the components to the main window
        frmMain.add(lblEntree);
        frmMain.add(lblSide);
        frmMain.add(lblSalad);
        frmMain.add(lblDessert);
        frmMain.add(lblBuildMenu);
        frmMain.add(lblOrGenMenu);
        frmMain.add(lblCrtMenus);
        frmMain.add(cboEntree);
        frmMain.add(cboSide);
        frmMain.add(cboSalad);
        frmMain.add(cboDessert);
        frmMain.add(btnCrtMenu);
        frmMain.add(btnRanMenu);
        frmMain.add(btnMinMenu);
        frmMain.add(btnMaxMenu);
        frmMain.add(btnDetails);
        frmMain.add(btnDelete);
        frmMain.add(btnSave);
        frmMain.add(listMenu);
       
	
        // Define the labels in the second frame  	
        lblEntree2 = new JLabel("Entree");   	
        lblEntree2.setBounds(30,15,100,30);    		
     	
        lblSide2 = new JLabel("Side");    	
        lblSide2.setBounds(30,90,100,30);    		
     	
        lblSalad2 = new JLabel("Salad");    	
        lblSalad2.setBounds(30,165,100,30);    		
     		
        lblDessert2 = new JLabel("Dessert");     		
        lblDessert2.setBounds(30,240,100,30);    		
     		
        lbltotalCal = new JLabel("Total calories:");    		
        lbltotalCal.setBounds(30,325,80,25);     		
     		
        lbltotalPri = new JLabel("Total price: $");     		
        lbltotalPri.setBounds(30,375,80,25);
        
        // Define the text fields in the second window
        txtEn = new JTextArea();
        txtEn.setBounds(130,20,560,55);
        txtEn.setBorder(BorderFactory.createLineBorder(Color.black));
        txtEn.setEditable(false);
        txtEn.setLineWrap(true);         
        txtEn.setWrapStyleWord(true); 
        
        txtSi = new JTextArea();
        txtSi.setBounds(130,95,560,55);
        txtSi.setBorder(BorderFactory.createLineBorder(Color.black));
        txtSi.setEditable(false);
        txtSi.setLineWrap(true);         
        txtSi.setWrapStyleWord(true);        
        
        txtSa = new JTextArea();
        txtSa.setBounds(130,170,560,55);
        txtSa.setBorder(BorderFactory.createLineBorder(Color.black));
        txtSa.setEditable(false);
        txtSa.setLineWrap(true);         
        txtSa.setWrapStyleWord(true); 
        
        txtDe = new JTextArea();
        txtDe.setBounds(130,245,560,55);
        txtDe.setBorder(BorderFactory.createLineBorder(Color.black));
        txtDe.setEditable(false);
        txtDe.setLineWrap(true);         
        txtDe.setWrapStyleWord(true); 
        
        txtCal = new JTextArea();
        txtCal.setBounds(130,320,100,30);
        txtCal.setBorder(BorderFactory.createLineBorder(Color.black));
        txtCal.setEditable(false);
        
        txtPri = new JTextArea();
        txtPri.setBounds(130,370,100,30);
        txtPri.setBorder(BorderFactory.createLineBorder(Color.black));
        txtPri.setEditable(false);
                    
        // Add the components to the second window
        frmSecond.add(lblEntree2);
        frmSecond.add(lblSide2);
        frmSecond.add(lblSalad2);
        frmSecond.add(lblDessert2);
        frmSecond.add(lbltotalCal);
        frmSecond.add(lbltotalPri);       
        frmSecond.add(txtEn);
        frmSecond.add(txtSi);
        frmSecond.add(txtSa);
        frmSecond.add(txtDe);
        frmSecond.add(txtCal);
        frmSecond.add(txtPri);   
        
        // set the main window visible
		frmMain.setVisible(true); 
		
    } // end of constructor
    
    
	public static void main(String[] args) {
		MenuManagerGUI mGUI = new MenuManagerGUI();
		
	}

}
