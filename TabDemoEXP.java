import java.awt.*;
import javax.swing.*;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;

public class TabDemoEXP implements ActionListener{
    // panel names for each clothing type - these names correspond to the tab names
    final static String GLASSESPANEL = "Glasses";
    final static String GLOVESPANEL = "Gloves";
    final static String HATSPANEL = "Hats";
    final static String JACKETSPANEL = "Jacket";
    final static String SCARFSPANEL = "Scarves";
    final static String SHIRTSPANEL = "Shirts";
    final static String PANTSPANEL = "Pants";
    final static String SHOESPANEL = "Shoes";
    final static String SOCKSPANEL = "Socks";
    
    //panel name for the outfit generator
    final static String OUTFITPANEL = "Outfit Generator";
    
    //width of the frame
    final static int extraWindowWidth = 1500;
    
    //ArrayLists for each type of Clothing - THERE USED TO BE STATIC KEYWORD AFTER PRIVATE
    private ArrayList<Glasses> glassesArray = new ArrayList();;
    private ArrayList<Glove> glovesArray = new ArrayList();
    private ArrayList<Hat> hatArray = new ArrayList();
    private ArrayList<Jacket> jacketArray = new ArrayList();
    private ArrayList<Scarf> scarfArray = new ArrayList();
    private ArrayList<Shirt> shirtArray = new ArrayList();
    private ArrayList<Pants> pantsArray = new ArrayList();
    private ArrayList<Sock> sockArray = new ArrayList();
    private ArrayList<Shoe> shoeArray = new ArrayList();
    
    //number of clothes that can be added
    private final static int NUM_CLOTHES = 10;
    
    //JButton to add clothing to the table - for each type of clothing that will trigger a specific action based on the type
    private JButton addGlassesButton;
    private JButton addGlovesButton;
    private JButton addHatsButton;
    private JButton addJacketsButton;
    private JButton addScarfsButton;
    private JButton addShirtsButton;
    private JButton addPantsButton;
    private JButton addSocksButton;
    private JButton addShoesButton;
    
    //*******GLASSES VARIABLES*********
    //*********************************
    //Box for types - I NEED TO ADD DIFFERENT TYPES FOR EACH DIFFERENT CLOTHING TYPE
    String[] typesGlassesArray = {"N/A"};
    JComboBox typesGlassesBox = new JComboBox(typesGlassesArray);
    //Box for yes and no
    String[] yesnoArray = {"yes", "no"};
    JComboBox yesnoBox = new JComboBox(yesnoArray);
    //Box for True and False
    String[] trufalsArray = {"true", "false"};
    JComboBox trufalsBox = new JComboBox(trufalsArray);
    //Box for season types
    String[] seasonsArray = {"Winter", "Spring", "Summer", "Fall"};
    JComboBox seasonsBox = new JComboBox(seasonsArray);
    //Box for Colors
    String[] colorsArray = {"Beige", "Gray", "Pink", "Purple", "Red", "Brown", "Orange", "Yellow", "Olive", "Green"};
    JComboBox colorsBox = new JComboBox(colorsArray);
    //Box for occasions
    String[] occasionsArray = {"Formal", "Nice", "Casual"};
    JComboBox occasionsBox = new JComboBox(occasionsArray);
    
    
    //TextField names for all the various attributes that will be needed for Clothing types
    private JFormattedTextField idField = new JFormattedTextField(20);      
    
    //JLabels for all the attribute names
    private JLabel stackableLabel = new JLabel("Stackable:");                     
    private JLabel permanentLabel = new JLabel("Permanent:");                   
    private JLabel seasonLabel = new JLabel("Season:");                 
    private JLabel colorLabel = new JLabel("Color:");                  
    private JLabel occasionLabel = new JLabel("Occasion:"); 
    
    private JLabel typeLabel = new JLabel("Type:");
    private JLabel idLabel = new JLabel("ID:");
    
    //JTabel that will display all the clothes 
    private JTable clothingListTable;
    
    //*******GLOVES VARIABLES*********
    //*********************************
    //Box for yes and no
    String[] yesnoArray1 = {"yes", "no"};
    JComboBox yesnoBox1 = new JComboBox(yesnoArray1);
    //Box for True and False
    String[] trufalsArray1 = {"true", "false"};
    JComboBox trufalsBox1 = new JComboBox(trufalsArray1);
    //Box for season types
    String[] seasonsArray1 = {"Winter", "Spring", "Summer", "Fall"};
    JComboBox seasonsBox1 = new JComboBox(seasonsArray1);
    //Box for Colors
    String[] colorsArray1 = {"Beige", "Gray", "Pink", "Purple", "Red", "Brown", "Orange", "Yellow", "Olive", "Green"};
    JComboBox colorsBox1 = new JComboBox(colorsArray1);
    //Box for occasions
    String[] occasionsArray1 = {"Formal", "Nice", "Casual"};
    JComboBox occasionsBox1 = new JComboBox(occasionsArray1);
    
    //TextField names for all the various attributes that will be needed for Clothing types
    JFormattedTextField idField1 = new JFormattedTextField(20);     
    
    //JLabels for all the attribute names
    private JLabel stackableLabel1 = new JLabel("Stackable:");                     
    private JLabel permanentLabel1 = new JLabel("Permanent:");                   
    private JLabel seasonLabel1 = new JLabel("Season:");                 
    private JLabel colorLabel1 = new JLabel("Color:");                  
    private JLabel occasionLabel1 = new JLabel("Occasion:"); 
    
    private JLabel typeLabel1 = new JLabel("Type:");
    private JLabel idLabel1 = new JLabel("ID:");
    
    //JTabel that will display all the clothes 
    private JTable clothingListTable1;
    //Box for types - I NEED TO ADD DIFFERENT TYPES FOR EACH DIFFERENT CLOTHING TYPE
    String[] typesGlovesArray = {"N/A"};
    JComboBox typesGlovesBox = new JComboBox(typesGlovesArray);
    
    //*******HATS VARIABLES*********
    //*********************************
    //Box for types - I NEED TO ADD DIFFERENT TYPES FOR EACH DIFFERENT CLOTHING TYPE
    String[] typesHatsArray = {"N/A"};
    JComboBox typesHatsBox = new JComboBox(typesHatsArray);
    //Box for yes and no
    String[] yesnoArray2 = {"yes", "no"};
    JComboBox yesnoBox2 = new JComboBox(yesnoArray2);
    //Box for True and False
    String[] trufalsArray2 = {"true", "false"};
    JComboBox trufalsBox2 = new JComboBox(trufalsArray2);
    //Box for season types
    String[] seasonsArray2 = {"Winter", "Spring", "Summer", "Fall"};
    JComboBox seasonsBox2 = new JComboBox(seasonsArray2);
    //Box for Colors
    String[] colorsArray2 = {"Beige", "Gray", "Pink", "Purple", "Red", "Brown", "Orange", "Yellow", "Olive", "Green"};
    JComboBox colorsBox2 = new JComboBox(colorsArray2);
    //Box for occasions
    String[] occasionsArray2 = {"Formal", "Nice", "Casual"};
    JComboBox occasionsBox2 = new JComboBox(occasionsArray2);
    
    
    //TextField names for all the various attributes that will be needed for Clothing types
    private JFormattedTextField idField2 = new JFormattedTextField(10);      
    
    //JLabels for all the attribute names
    private JLabel stackableLabel2 = new JLabel("Stackable:");                     
    private JLabel permanentLabel2 = new JLabel("Permanent:");                   
    private JLabel seasonLabel2 = new JLabel("Season:");                 
    private JLabel colorLabel2 = new JLabel("Color:");                  
    private JLabel occasionLabel2 = new JLabel("Occasion:"); 
    
    private JLabel typeLabel2 = new JLabel("Type:");
    private JLabel idLabel2 = new JLabel("ID:");
    
    //JTabel that will display all the clothes 
    private JTable clothingListTable2;
    
    //*****JACKETS VARIABLES********
    //*****************************
    //Box for types - I NEED TO ADD DIFFERENT TYPES FOR EACH DIFFERENT CLOTHING TYPE
    String[] typesJacketsArray = {"N/A"};
    JComboBox typesJacketsBox = new JComboBox(typesJacketsArray);
    //Box for yes and no
    String[] yesnoArray3 = {"yes", "no"};
    JComboBox yesnoBox3 = new JComboBox(yesnoArray3);
    //Box for True and False
    String[] trufalsArray3 = {"true", "false"};
    JComboBox trufalsBox3 = new JComboBox(trufalsArray3);
    //Box for season types
    String[] seasonsArray3 = {"Winter", "Spring", "Summer", "Fall"};
    JComboBox seasonsBox3 = new JComboBox(seasonsArray3);
    //Box for Colors
    String[] colorsArray3 = {"Beige", "Gray", "Pink", "Purple", "Red", "Brown", "Orange", "Yellow", "Olive", "Green"};
    JComboBox colorsBox3 = new JComboBox(colorsArray3);
    //Box for occasions
    String[] occasionsArray3 = {"Formal", "Nice", "Casual"};
    JComboBox occasionsBox3 = new JComboBox(occasionsArray3);
    
    //TextField names for all the various attributes that will be needed for Clothing types
    private JFormattedTextField idField3 = new JFormattedTextField(10);      
   
    //JLabels for all the attribute names
    private JLabel stackableLabel3 = new JLabel("Stackable:");                     
    private JLabel permanentLabel3 = new JLabel("Permanent:");                   
    private JLabel seasonLabel3 = new JLabel("Season:");                 
    private JLabel colorLabel3 = new JLabel("Color:");                  
    private JLabel occasionLabel3 = new JLabel("Occasion:"); 
    
    private JLabel typeLabel3 = new JLabel("Type:");
    private JLabel idLabel3 = new JLabel("ID:");
    
    //JTabel that will display all the clothes 
    private JTable clothingListTable3;
 
    //*******SCARFS VARIABLES*********
    //*********************************
    //Box for types - I NEED TO ADD DIFFERENT TYPES FOR EACH DIFFERENT CLOTHING TYPE
    String[] typesScarfsArray = {"N/A"};
    JComboBox typesScarfsBox = new JComboBox(typesScarfsArray);
    //Box for yes and no
    String[] yesnoArray4 = {"yes", "no"};
    JComboBox yesnoBox4 = new JComboBox(yesnoArray4);
    //Box for True and False
    String[] trufalsArray4 = {"true", "false"};
    JComboBox trufalsBox4 = new JComboBox(trufalsArray4);
    //Box for season types
    String[] seasonsArray4 = {"Winter", "Spring", "Summer", "Fall"};
    JComboBox seasonsBox4 = new JComboBox(seasonsArray4);
    //Box for Colors
    String[] colorsArray4 = {"Beige", "Gray", "Pink", "Purple", "Red", "Brown", "Orange", "Yellow", "Olive", "Green"};
    JComboBox colorsBox4 = new JComboBox(colorsArray4);
    //Box for occasions
    String[] occasionsArray4 = {"Formal", "Nice", "Casual"};
    JComboBox occasionsBox4 = new JComboBox(occasionsArray4);
    
    
    //TextField names for all the various attributes tjacket will be needed for Clothing types
    private JFormattedTextField idField4 = new JFormattedTextField(10);      
    //JLabels for all the attribute names
    private JLabel stackableLabel4 = new JLabel("Stackable:");                     
    private JLabel permanentLabel4 = new JLabel("Permanent:");                   
    private JLabel seasonLabel4 = new JLabel("Season:");                 
    private JLabel colorLabel4 = new JLabel("Color:");                  
    private JLabel occasionLabel4 = new JLabel("Occasion:"); 
    
    private JLabel typeLabel4 = new JLabel("Type:");
    private JLabel idLabel4 = new JLabel("ID:");
    
    //JTabel tjacket will display all the clothes 
    private JTable clothingListTable4;
    
    //*******SHIRTS VARIABLES*********
    //*********************************
    //Box for types - I NEED TO ADD DIFFERENT TYPES FOR EACH DIFFERENT CLOTHING TYPE
    String[] typesShirtsArray = {"N/A"};
    JComboBox typesShirtsBox = new JComboBox(typesShirtsArray);
    //Box for yes and no
    String[] yesnoArray5 = {"yes", "no"};
    JComboBox yesnoBox5 = new JComboBox(yesnoArray5);
    //Box for True and False
    String[] trufalsArray5 = {"true", "false"};
    JComboBox trufalsBox5 = new JComboBox(trufalsArray5);
    //Box for season types
    String[] seasonsArray5 = {"Winter", "Spring", "Summer", "Fall"};
    JComboBox seasonsBox5 = new JComboBox(seasonsArray5);
    //Box for Colors
    String[] colorsArray5 = {"Beige", "Gray", "Pink", "Purple", "Red", "Brown", "Orange", "Yellow", "Olive", "Green"};
    JComboBox colorsBox5 = new JComboBox(colorsArray5);
    //Box for occasions
    String[] occasionsArray5 = {"Formal", "Nice", "Casual"};
    JComboBox occasionsBox5 = new JComboBox(occasionsArray5);
    
    //TextField names for all the various attributes tjacket will be needed for Clothing types
    private JFormattedTextField idField5 = new JFormattedTextField(10);      
    //JLabels for all the attribute names
    private JLabel stackableLabel5 = new JLabel("Stackable:");                     
    private JLabel permanentLabel5 = new JLabel("Permanent:");                   
    private JLabel seasonLabel5 = new JLabel("Season:");                 
    private JLabel colorLabel5 = new JLabel("Color:");                  
    private JLabel occasionLabel5 = new JLabel("Occasion:"); 
    
    private JLabel typeLabel5 = new JLabel("Type:");
    private JLabel idLabel5 = new JLabel("ID:");
    
    //JTabel tjacket will display all the clothes 
    private JTable clothingListTable5;
    
    //*******PANTS VARIABLES*********
    //*********************************
    //Box for types - I NEED TO ADD DIFFERENT TYPES FOR EACH DIFFERENT CLOTHING TYPE
    String[] typesPantsArray = {"N/A"};
    JComboBox typesPantsBox = new JComboBox(typesPantsArray);
    //Box for yes and no
    String[] yesnoArray6 = {"yes", "no"};
    JComboBox yesnoBox6 = new JComboBox(yesnoArray6);
    //Box for True and False
    String[] trufalsArray6 = {"true", "false"};
    JComboBox trufalsBox6 = new JComboBox(trufalsArray6);
    //Box for season types
    String[] seasonsArray6 = {"Winter", "Spring", "Summer", "Fall"};
    JComboBox seasonsBox6 = new JComboBox(seasonsArray6);
    //Box for Colors
    String[] colorsArray6 = {"Beige", "Gray", "Pink", "Purple", "Red", "Brown", "Orange", "Yellow", "Olive", "Green"};
    JComboBox colorsBox6 = new JComboBox(colorsArray6);
    //Box for occasions
    String[] occasionsArray6 = {"Formal", "Nice", "Casual"};
    JComboBox occasionsBox6 = new JComboBox(occasionsArray6);
    
    
    //TextField names for all the various attributes tjacket will be needed for Clothing types
    private JFormattedTextField idField6 = new JFormattedTextField(10);      
    //JLabels for all the attribute names
    private JLabel stackableLabel6 = new JLabel("Stackable:");                     
    private JLabel permanentLabel6 = new JLabel("Permanent:");                   
    private JLabel seasonLabel6 = new JLabel("Season:");                 
    private JLabel colorLabel6 = new JLabel("Color:");                  
    private JLabel occasionLabel6 = new JLabel("Occasion:"); 
    
    private JLabel typeLabel6 = new JLabel("Type:");
    private JLabel idLabel6 = new JLabel("ID:");
    
    //JTabel tjacket will display all the clothes 
    private JTable clothingListTable6;
    
    //*******SHOES VARIABLES*********
    //*********************************
    //Box for types - I NEED TO ADD DIFFERENT TYPES FOR EACH DIFFERENT CLOTHING TYPE
    String[] typesShoesArray = {"N/A"};
    JComboBox typesShoesBox = new JComboBox(typesShoesArray);
    //Box for yes and no
    String[] yesnoArray7 = {"yes", "no"};
    JComboBox yesnoBox7 = new JComboBox(yesnoArray7);
    //Box for True and False
    String[] trufalsArray7 = {"true", "false"};
    JComboBox trufalsBox7 = new JComboBox(trufalsArray7);
    //Box for season types
    String[] seasonsArray7 = {"Winter", "Spring", "Summer", "Fall"};
    JComboBox seasonsBox7 = new JComboBox(seasonsArray7);
    //Box for Colors
    String[] colorsArray7 = {"Beige", "Gray", "Pink", "Purple", "Red", "Brown", "Orange", "Yellow", "Olive", "Green"};
    JComboBox colorsBox7 = new JComboBox(colorsArray7);
    //Box for occasions
    String[] occasionsArray7 = {"Formal", "Nice", "Casual"};
    JComboBox occasionsBox7 = new JComboBox(occasionsArray7);
    
    
    //TextField names for all the various attributes tjacket will be needed for Clothing types
    private JFormattedTextField idField7 = new JFormattedTextField(10);      
    //JLabels for all the attribute names
    private JLabel stackableLabel7 = new JLabel("Stackable:");                     
    private JLabel permanentLabel7 = new JLabel("Permanent:");                   
    private JLabel seasonLabel7 = new JLabel("Season:");                 
    private JLabel colorLabel7 = new JLabel("Color:");                  
    private JLabel occasionLabel7 = new JLabel("Occasion:"); 
    
    private JLabel typeLabel7 = new JLabel("Type:");
    private JLabel idLabel7 = new JLabel("ID:");
    
    //JTabel tjacket will display all the clothes 
    private JTable clothingListTable7;
    
    //*******SOCKS VARIABLES*********
    //*********************************
    //Box for types - I NEED TO ADD DIFFERENT TYPES FOR EACH DIFFERENT CLOTHING TYPE
    String[] typesSocksArray = {"N/A"};
    JComboBox typesSocksBox = new JComboBox(typesSocksArray);
    //Box for yes and no
    String[] yesnoArray8 = {"yes", "no"};
    JComboBox yesnoBox8 = new JComboBox(yesnoArray8);
    //Box for True and False
    String[] trufalsArray8 = {"true", "false"};
    JComboBox trufalsBox8 = new JComboBox(trufalsArray8);
    //Box for season types
    String[] seasonsArray8 = {"Winter", "Spring", "Summer", "Fall"};
    JComboBox seasonsBox8 = new JComboBox(seasonsArray8);
    //Box for Colors
    String[] colorsArray8 = {"Beige", "Gray", "Pink", "Purple", "Red", "Brown", "Orange", "Yellow", "Olive", "Green"};
    JComboBox colorsBox8 = new JComboBox(colorsArray8);
    //Box for occasions
    String[] occasionsArray8 = {"Formal", "Nice", "Casual"};
    JComboBox occasionsBox8 = new JComboBox(occasionsArray8);
    
    
    //TextField names for all the various attributes tjacket will be needed for Clothing types
    private JFormattedTextField idField8 = new JFormattedTextField(10);      
    //JLabels for all the attribute names
    private JLabel stackableLabel8 = new JLabel("Stackable:");                     
    private JLabel permanentLabel8 = new JLabel("Permanent:");                   
    private JLabel seasonLabel8 = new JLabel("Season:");                 
    private JLabel colorLabel8 = new JLabel("Color:");                  
    private JLabel occasionLabel8 = new JLabel("Occasion:"); 
    
    private JLabel typeLabel8 = new JLabel("Type:");
    private JLabel idLabel8 = new JLabel("ID:");
    
    //JTabel tjacket will display all the clothes 
    private JTable clothingListTable8;
    
    //THE ACTUAL PANE THAT IMPLEMENTS EVERYTHING
    public void addComponentToPane(Container pane) {
        JTabbedPane tabbedPane = new JTabbedPane(); // creating the tab pane
        
        // ***GLASSES Panel***
         
        JPanel glassesPanel = new JPanel();
        
        //Create table to add clothes 
        JLabel tableLabel = new JLabel("Glasses");
        
        addGlassesButton = new JButton("Add");
        addGlassesButton.addActionListener(this);
        
        
        idField.setEditable(true);
        //initialize table
        Object[][] tableVals = new Object[10][7];
        String[] columnHeadings = {"Stackable", "Permanent", "Season", "Color", "Occasion", "Type", "ID"};
        clothingListTable = new JTable(tableVals, columnHeadings);
        clothingListTable.setEnabled(false);
        
        //add the table and all the labels and textfields to the JPanel - this is the table that displays the different clothes
        glassesPanel.setLayout(new GridBagLayout());
        
        GridBagConstraints layoutConst = null;                  
        NumberFormat currencyFormat = null;
        
        layoutConst = new GridBagConstraints();
        layoutConst.insets = new Insets(10, 10, 1, 0);
        layoutConst.fill = GridBagConstraints.HORIZONTAL;
        layoutConst.gridx = 0;
        layoutConst.gridy = 0;
        glassesPanel.add(tableLabel, layoutConst);
        
        layoutConst = new GridBagConstraints();
        layoutConst.insets = new Insets(1, 10, 0, 0);
        layoutConst.fill = GridBagConstraints.HORIZONTAL;
        layoutConst.gridx = 0;
        layoutConst.gridy = 1;
        layoutConst.gridwidth = 8;
        glassesPanel.add(clothingListTable.getTableHeader(), layoutConst);
        
        layoutConst = new GridBagConstraints();
        layoutConst.insets = new Insets(0, 10, 10, 0);
        layoutConst.fill = GridBagConstraints.HORIZONTAL;
        layoutConst.gridx = 0;
        layoutConst.gridy = 2;
        layoutConst.gridwidth = 8; // this is where I can change the width of the table
        glassesPanel.add(clothingListTable, layoutConst);
        
        //adding the input table to the JPanel - this is where people will actually input clothes onto the table above
        layoutConst = new GridBagConstraints();
        layoutConst.insets = new Insets(10, 10, 1, 0);
        layoutConst.fill = GridBagConstraints.HORIZONTAL;
        layoutConst.gridx = 0;
        layoutConst.gridy = 3;
        glassesPanel.add(stackableLabel, layoutConst);
        
        layoutConst = new GridBagConstraints();
        layoutConst.insets = new Insets(1, 10, 10, 0);
        layoutConst.fill = GridBagConstraints.HORIZONTAL;
        layoutConst.gridx = 0;
        layoutConst.gridy = 4;
        glassesPanel.add(trufalsBox, layoutConst);
        
        layoutConst = new GridBagConstraints();
        layoutConst.insets = new Insets(10, 10, 1, 0);
        layoutConst.fill = GridBagConstraints.HORIZONTAL;
        layoutConst.gridx = 1;
        layoutConst.gridy = 3;
        glassesPanel.add(permanentLabel, layoutConst);
        
        layoutConst = new GridBagConstraints();
        layoutConst.insets = new Insets(1, 10, 10, 0);
        layoutConst.fill = GridBagConstraints.HORIZONTAL;
        layoutConst.gridx = 1;
        layoutConst.gridy = 4;
        glassesPanel.add(yesnoBox, layoutConst);
        
        layoutConst = new GridBagConstraints();
        layoutConst.insets = new Insets(10, 10, 1, 0);
        layoutConst.fill = GridBagConstraints.HORIZONTAL;
        layoutConst.gridx = 2;
        layoutConst.gridy = 3;
        glassesPanel.add(seasonLabel, layoutConst);
        
        layoutConst = new GridBagConstraints();
        layoutConst.insets = new Insets(1, 10, 10, 0);
        layoutConst.fill = GridBagConstraints.HORIZONTAL;
        layoutConst.gridx = 2;
        layoutConst.gridy = 4;
        glassesPanel.add(seasonsBox, layoutConst);
        
        layoutConst = new GridBagConstraints();
        layoutConst.insets = new Insets(10, 10, 1, 0);
        layoutConst.fill = GridBagConstraints.HORIZONTAL;
        layoutConst.gridx = 3;
        layoutConst.gridy = 3;
        glassesPanel.add(colorLabel, layoutConst);
        
        layoutConst = new GridBagConstraints();
        layoutConst.insets = new Insets(1, 10, 10, 0);
        layoutConst.fill = GridBagConstraints.HORIZONTAL;
        layoutConst.gridx = 3;
        layoutConst.gridy = 4;
        glassesPanel.add(colorsBox, layoutConst);
        
        layoutConst = new GridBagConstraints();
        layoutConst.insets = new Insets(10, 10, 1, 0);
        layoutConst.fill = GridBagConstraints.HORIZONTAL;
        layoutConst.gridx = 4;
        layoutConst.gridy = 3;
        glassesPanel.add(occasionLabel, layoutConst);
        
        layoutConst = new GridBagConstraints();
        layoutConst.insets = new Insets(1, 10, 10, 0);
        layoutConst.fill = GridBagConstraints.HORIZONTAL;
        layoutConst.gridx = 4;
        layoutConst.gridy = 4;
        glassesPanel.add(occasionsBox, layoutConst);
             
        layoutConst = new GridBagConstraints();
        layoutConst.insets = new Insets(10, 10, 1, 0);
        layoutConst.fill = GridBagConstraints.HORIZONTAL;
        layoutConst.gridx = 6;
        layoutConst.gridy = 3;
        glassesPanel.add(typeLabel, layoutConst);
        
        layoutConst = new GridBagConstraints();
        layoutConst.insets = new Insets(1, 10, 10, 0);
        layoutConst.fill = GridBagConstraints.HORIZONTAL;
        layoutConst.gridx = 6;
        layoutConst.gridy = 4;
        glassesPanel.add(typesGlassesBox, layoutConst);
        
        layoutConst = new GridBagConstraints();
        layoutConst.insets = new Insets(10, 10, 1, 0);
        layoutConst.fill = GridBagConstraints.HORIZONTAL;
        layoutConst.gridx = 7;
        layoutConst.gridy = 3;
        glassesPanel.add(idLabel, layoutConst);
        
        layoutConst = new GridBagConstraints();
        layoutConst.insets = new Insets(1, 10, 10, 0);
        layoutConst.fill = GridBagConstraints.HORIZONTAL;
        layoutConst.gridx = 7;
        layoutConst.gridy = 4;
        glassesPanel.add(idField, layoutConst);
        
        layoutConst = new GridBagConstraints();
        layoutConst.insets = new Insets(0, 10, 10, 5);
        layoutConst.fill = GridBagConstraints.HORIZONTAL;
        layoutConst.gridx = 8;
        layoutConst.gridy = 4;
        glassesPanel.add(addGlassesButton, layoutConst);
        
        
        // ***GLOVES Panel*** 
        
        //VARIABLE DEFINTIONS
              
    //making all the text fields for the input table editable by the user  
        idField.setEditable(true);
    
 
        JPanel glovesPanel = new JPanel();
        
        //Create table to add clothes 
        JLabel tableLabel1 = new JLabel("Gloves");
        
        addGlovesButton = new JButton("Add");
        addGlovesButton.addActionListener(this);
        
        //initialize table
        Object[][] tableVals1 = new Object[10][7];
        String[] columnHeadings1 = {"Stackable", "Permanent", "Season", "Color", "Occasion", "Type", "ID"};
        clothingListTable1 = new JTable(tableVals1, columnHeadings1);
        clothingListTable1.setEnabled(false);
        
        //add the table and all the labels and textfields to the JPanel - this is the table that displays the different clothes
        glovesPanel.setLayout(new GridBagLayout());
        
        GridBagConstraints layoutConst1 = null;                  
        NumberFormat currencyFormat1 = null;
        
        layoutConst1 = new GridBagConstraints();
        layoutConst1.insets = new Insets(10, 10, 1, 0);
        layoutConst1.fill = GridBagConstraints.HORIZONTAL;
        layoutConst1.gridx = 0;
        layoutConst1.gridy = 0;
        glovesPanel.add(tableLabel1, layoutConst1);
        
        layoutConst1 = new GridBagConstraints();
        layoutConst1.insets = new Insets(1, 10, 0, 0);
        layoutConst1.fill = GridBagConstraints.HORIZONTAL;
        layoutConst1.gridx = 0;
        layoutConst1.gridy = 1;
        layoutConst1.gridwidth = 8;
        glovesPanel.add(clothingListTable1.getTableHeader(), layoutConst1);
        
        layoutConst1 = new GridBagConstraints();
        layoutConst1.insets = new Insets(0, 10, 10, 0);
        layoutConst1.fill = GridBagConstraints.HORIZONTAL;
        layoutConst1.gridx = 0;
        layoutConst1.gridy = 2;
        layoutConst1.gridwidth = 8; // this is where I can change the width of the table
        glovesPanel.add(clothingListTable1, layoutConst1);
        
        //adding the input table to the JPanel - this is where people will actually input clothes onto the table above
        layoutConst1 = new GridBagConstraints();
        layoutConst1.insets = new Insets(10, 10, 1, 0);
        layoutConst1.fill = GridBagConstraints.HORIZONTAL;
        layoutConst1.gridx = 0;
        layoutConst1.gridy = 3;
        glovesPanel.add(stackableLabel1, layoutConst1);
        
        layoutConst1 = new GridBagConstraints();
        layoutConst1.insets = new Insets(1, 10, 10, 0);
        layoutConst1.fill = GridBagConstraints.HORIZONTAL;
        layoutConst1.gridx = 0;
        layoutConst1.gridy = 4;
        glovesPanel.add(trufalsBox1, layoutConst1);
        
        layoutConst1 = new GridBagConstraints();
        layoutConst1.insets = new Insets(10, 10, 1, 0);
        layoutConst1.fill = GridBagConstraints.HORIZONTAL;
        layoutConst1.gridx = 1;
        layoutConst1.gridy = 3;
        glovesPanel.add(permanentLabel1, layoutConst1);
        
        layoutConst1 = new GridBagConstraints();
        layoutConst1.insets = new Insets(1, 10, 10, 0);
        layoutConst1.fill = GridBagConstraints.HORIZONTAL;
        layoutConst1.gridx = 1;
        layoutConst1.gridy = 4;
        glovesPanel.add(yesnoBox1, layoutConst1);
        
        layoutConst1 = new GridBagConstraints();
        layoutConst1.insets = new Insets(10, 10, 1, 0);
        layoutConst1.fill = GridBagConstraints.HORIZONTAL;
        layoutConst1.gridx = 2;
        layoutConst1.gridy = 3;
        glovesPanel.add(seasonLabel1, layoutConst1);
        
        layoutConst1 = new GridBagConstraints();
        layoutConst1.insets = new Insets(1, 10, 10, 0);
        layoutConst1.fill = GridBagConstraints.HORIZONTAL;
        layoutConst1.gridx = 2;
        layoutConst1.gridy = 4;
        glovesPanel.add(seasonsBox1, layoutConst1);
        
        layoutConst1 = new GridBagConstraints();
        layoutConst1.insets = new Insets(10, 10, 1, 0);
        layoutConst1.fill = GridBagConstraints.HORIZONTAL;
        layoutConst1.gridx = 3;
        layoutConst1.gridy = 3;
        glovesPanel.add(colorLabel1, layoutConst1);
        
        layoutConst1 = new GridBagConstraints();
        layoutConst1.insets = new Insets(1, 10, 10, 0);
        layoutConst1.fill = GridBagConstraints.HORIZONTAL;
        layoutConst1.gridx = 3;
        layoutConst1.gridy = 4;
        glovesPanel.add(colorsBox1, layoutConst1);
        
        layoutConst1 = new GridBagConstraints();
        layoutConst1.insets = new Insets(10, 10, 1, 0);
        layoutConst1.fill = GridBagConstraints.HORIZONTAL;
        layoutConst1.gridx = 4;
        layoutConst1.gridy = 3;
        glovesPanel.add(occasionLabel1, layoutConst1);
        
        layoutConst1 = new GridBagConstraints();
        layoutConst1.insets = new Insets(1, 10, 10, 0);
        layoutConst1.fill = GridBagConstraints.HORIZONTAL;
        layoutConst1.gridx = 4;
        layoutConst1.gridy = 4;
        glovesPanel.add(occasionsBox1, layoutConst1);
             
        layoutConst1 = new GridBagConstraints();
        layoutConst1.insets = new Insets(10, 10, 1, 0);
        layoutConst1.fill = GridBagConstraints.HORIZONTAL;
        layoutConst1.gridx = 6;
        layoutConst1.gridy = 3;
        glovesPanel.add(typeLabel1, layoutConst1);
        
        layoutConst1 = new GridBagConstraints();
        layoutConst1.insets = new Insets(1, 10, 10, 0);
        layoutConst1.fill = GridBagConstraints.HORIZONTAL;
        layoutConst1.gridx = 6;
        layoutConst1.gridy = 4;
        glovesPanel.add(typesGlovesBox, layoutConst1);
        
        layoutConst1 = new GridBagConstraints();
        layoutConst1.insets = new Insets(10, 10, 1, 0);
        layoutConst1.fill = GridBagConstraints.HORIZONTAL;
        layoutConst1.gridx = 7;
        layoutConst1.gridy = 3;
        glovesPanel.add(idLabel1, layoutConst1);
        
        layoutConst1 = new GridBagConstraints();
        layoutConst1.insets = new Insets(1, 10, 10, 0);
        layoutConst1.fill = GridBagConstraints.HORIZONTAL;
        layoutConst1.gridx = 7;
        layoutConst1.gridy = 4;
        glovesPanel.add(idField1, layoutConst1);
        
        layoutConst1 = new GridBagConstraints();
        layoutConst1.insets = new Insets(0, 10, 10, 5);
        layoutConst1.fill = GridBagConstraints.HORIZONTAL;
        layoutConst1.gridx = 8;
        layoutConst1.gridy = 4;
        glovesPanel.add(addGlovesButton, layoutConst1);
        
        // ***HAT Panel***
        
        //VARIABLE DEFINITIONS
        //Box for types - I NEED TO ADD DIFFERENT TYPES FOR EACH DIFFERENT CLOTHING TYPE
    String[] typesHatsArray = {"N/A"};
    JComboBox typesHatsBox = new JComboBox(typesHatsArray);
        //END OF VARIABLE DEFINITIONS
        
        JPanel hatsPanel = new JPanel();
        //Create table to add clothes 
        JLabel tableLabel2 = new JLabel("Hats");
        
        addHatsButton = new JButton("Add");
        addHatsButton.addActionListener(this);
        
        idField2.setEditable(true);
        //initialize table
        Object[][] tableVals2 = new Object[10][7];
        String[] columnHeadings2 = {"Stackable", "Permanent", "Season", "Color", "Occasion", "Type", "ID"};
        clothingListTable2 = new JTable(tableVals2, columnHeadings2);
        clothingListTable2.setEnabled(false);
        
        //add the table and all the labels and textfields to the JPanel - this is the table that displays the different clothes
        hatsPanel.setLayout(new GridBagLayout());
        
        GridBagConstraints layoutConst2 = null;                  
        NumberFormat currencyFormat2 = null;
        
        layoutConst2 = new GridBagConstraints();
        layoutConst2.insets = new Insets(10, 10, 1, 0);
        layoutConst2.fill = GridBagConstraints.HORIZONTAL;
        layoutConst2.gridx = 0;
        layoutConst2.gridy = 0;
        hatsPanel.add(tableLabel2, layoutConst2);
        
        layoutConst2 = new GridBagConstraints();
        layoutConst2.insets = new Insets(1, 10, 0, 0);
        layoutConst2.fill = GridBagConstraints.HORIZONTAL;
        layoutConst2.gridx = 0;
        layoutConst2.gridy = 1;
        layoutConst2.gridwidth = 8;
        hatsPanel.add(clothingListTable2.getTableHeader(), layoutConst2);
        
        layoutConst2 = new GridBagConstraints();
        layoutConst2.insets = new Insets(0, 10, 10, 0);
        layoutConst2.fill = GridBagConstraints.HORIZONTAL;
        layoutConst2.gridx = 0;
        layoutConst2.gridy = 2;
        layoutConst2.gridwidth = 8; // this is where I can change the width of the table
        hatsPanel.add(clothingListTable2, layoutConst2);
        
        //adding the input table to the JPanel - this is where people will actually input clothes onto the table above
        layoutConst2 = new GridBagConstraints();
        layoutConst2.insets = new Insets(10, 10, 1, 0);
        layoutConst2.fill = GridBagConstraints.HORIZONTAL;
        layoutConst2.gridx = 0;
        layoutConst2.gridy = 3;
        hatsPanel.add(stackableLabel2, layoutConst2);
        
        layoutConst2 = new GridBagConstraints();
        layoutConst2.insets = new Insets(1, 10, 10, 0);
        layoutConst2.fill = GridBagConstraints.HORIZONTAL;
        layoutConst2.gridx = 0;
        layoutConst2.gridy = 4;
        hatsPanel.add(trufalsBox2, layoutConst2);
        
        layoutConst2 = new GridBagConstraints();
        layoutConst2.insets = new Insets(10, 10, 1, 0);
        layoutConst2.fill = GridBagConstraints.HORIZONTAL;
        layoutConst2.gridx = 1;
        layoutConst2.gridy = 3;
        hatsPanel.add(permanentLabel2, layoutConst2);
        
        layoutConst2 = new GridBagConstraints();
        layoutConst2.insets = new Insets(1, 10, 10, 0);
        layoutConst2.fill = GridBagConstraints.HORIZONTAL;
        layoutConst2.gridx = 1;
        layoutConst2.gridy = 4;
        hatsPanel.add(yesnoBox2, layoutConst2);
        
        layoutConst2 = new GridBagConstraints();
        layoutConst2.insets = new Insets(10, 10, 1, 0);
        layoutConst2.fill = GridBagConstraints.HORIZONTAL;
        layoutConst2.gridx = 2;
        layoutConst2.gridy = 3;
        hatsPanel.add(seasonLabel2, layoutConst2);
        
        layoutConst2 = new GridBagConstraints();
        layoutConst2.insets = new Insets(1, 10, 10, 0);
        layoutConst2.fill = GridBagConstraints.HORIZONTAL;
        layoutConst2.gridx = 2;
        layoutConst2.gridy = 4;
        hatsPanel.add(seasonsBox2, layoutConst2);
        
        layoutConst2 = new GridBagConstraints();
        layoutConst2.insets = new Insets(10, 10, 1, 0);
        layoutConst2.fill = GridBagConstraints.HORIZONTAL;
        layoutConst2.gridx = 3;
        layoutConst2.gridy = 3;
        hatsPanel.add(colorLabel2, layoutConst2);
        
        layoutConst2 = new GridBagConstraints();
        layoutConst2.insets = new Insets(1, 10, 10, 0);
        layoutConst2.fill = GridBagConstraints.HORIZONTAL;
        layoutConst2.gridx = 3;
        layoutConst2.gridy = 4;
        hatsPanel.add(colorsBox2, layoutConst2);
        
        layoutConst2 = new GridBagConstraints();
        layoutConst2.insets = new Insets(10, 10, 1, 0);
        layoutConst2.fill = GridBagConstraints.HORIZONTAL;
        layoutConst2.gridx = 4;
        layoutConst2.gridy = 3;
        hatsPanel.add(occasionLabel2, layoutConst2);
        
        layoutConst2 = new GridBagConstraints();
        layoutConst2.insets = new Insets(1, 10, 10, 0);
        layoutConst2.fill = GridBagConstraints.HORIZONTAL;
        layoutConst2.gridx = 4;
        layoutConst2.gridy = 4;
        hatsPanel.add(occasionsBox2, layoutConst2);
             
        layoutConst2 = new GridBagConstraints();
        layoutConst2.insets = new Insets(10, 10, 1, 0);
        layoutConst2.fill = GridBagConstraints.HORIZONTAL;
        layoutConst2.gridx = 6;
        layoutConst2.gridy = 3;
        hatsPanel.add(typeLabel2, layoutConst2);
        
        layoutConst2 = new GridBagConstraints();
        layoutConst2.insets = new Insets(1, 10, 10, 0);
        layoutConst2.fill = GridBagConstraints.HORIZONTAL;
        layoutConst2.gridx = 6;
        layoutConst2.gridy = 4;
        hatsPanel.add(typesHatsBox, layoutConst2);
        
        layoutConst2 = new GridBagConstraints();
        layoutConst2.insets = new Insets(10, 10, 1, 0);
        layoutConst2.fill = GridBagConstraints.HORIZONTAL;
        layoutConst2.gridx = 7;
        layoutConst2.gridy = 3;
        hatsPanel.add(idLabel2, layoutConst2);
        
        layoutConst2 = new GridBagConstraints();
        layoutConst2.insets = new Insets(1, 10, 10, 0);
        layoutConst2.fill = GridBagConstraints.HORIZONTAL;
        layoutConst2.gridx = 7;
        layoutConst2.gridy = 4;
        hatsPanel.add(idField2, layoutConst2);
        
        layoutConst2 = new GridBagConstraints();
        layoutConst2.insets = new Insets(0, 10, 10, 5);
        layoutConst2.fill = GridBagConstraints.HORIZONTAL;
        layoutConst2.gridx = 8;
        layoutConst2.gridy = 4;
        hatsPanel.add(addHatsButton, layoutConst2);
        // ***JACKET Panel***
        
        //VARIABLE DEFINITIONS
        //Box for types - I NEED TO ADD DIFFERENT TYPES FOR EACH DIFFERENT CLOTHING TYPE
    String[] typesJacketsArray = {"N/A"};
    JComboBox typesJacketsBox = new JComboBox(typesJacketsArray);
        //END OF VARIABLE DEFINITIONS
        
        JPanel jacketsPanel = new JPanel();
        
        //Create table to add clothes 
        JLabel tableLabel3 = new JLabel("Jackets");
        
        addJacketsButton = new JButton("Add");
        addJacketsButton.addActionListener(this);
        
        //initialize table
        Object[][] tableVals3 = new Object[10][7];
        String[] columnHeadings3 = {"Stackable", "Permanent", "Season", "Color", "Occasion", "Type", "ID"};
        clothingListTable3 = new JTable(tableVals3, columnHeadings3);
        clothingListTable3.setEnabled(false);
        
        idField3.setEditable(true);
        //add the table and all the labels and textfields to the JPanel - this is the table tjacket displays the different clothes
        jacketsPanel.setLayout(new GridBagLayout());
        
        GridBagConstraints layoutConst3 = null;                  
        NumberFormat currencyFormat3 = null;
        
        layoutConst3 = new GridBagConstraints();
        layoutConst3.insets = new Insets(10, 10, 1, 0);
        layoutConst3.fill = GridBagConstraints.HORIZONTAL;
        layoutConst3.gridx = 0;
        layoutConst3.gridy = 0;
        jacketsPanel.add(tableLabel3, layoutConst3);
        
        layoutConst3 = new GridBagConstraints();
        layoutConst3.insets = new Insets(1, 10, 0, 0);
        layoutConst3.fill = GridBagConstraints.HORIZONTAL;
        layoutConst3.gridx = 0;
        layoutConst3.gridy = 1;
        layoutConst3.gridwidth = 8;
        jacketsPanel.add(clothingListTable3.getTableHeader(), layoutConst3);
        
        layoutConst3 = new GridBagConstraints();
        layoutConst3.insets = new Insets(0, 10, 10, 0);
        layoutConst3.fill = GridBagConstraints.HORIZONTAL;
        layoutConst3.gridx = 0;
        layoutConst3.gridy = 2;
        layoutConst3.gridwidth = 8; // this is where I can change the width of the table
        jacketsPanel.add(clothingListTable3, layoutConst3);
        
        //adding the input table to the JPanel - this is where people will actually input clothes onto the table above
        layoutConst3 = new GridBagConstraints();
        layoutConst3.insets = new Insets(10, 10, 1, 0);
        layoutConst3.fill = GridBagConstraints.HORIZONTAL;
        layoutConst3.gridx = 0;
        layoutConst3.gridy = 3;
        jacketsPanel.add(stackableLabel3, layoutConst3);
        
        layoutConst3 = new GridBagConstraints();
        layoutConst3.insets = new Insets(1, 10, 10, 0);
        layoutConst3.fill = GridBagConstraints.HORIZONTAL;
        layoutConst3.gridx = 0;
        layoutConst3.gridy = 4;
        jacketsPanel.add(trufalsBox3, layoutConst3);
        
        layoutConst3 = new GridBagConstraints();
        layoutConst3.insets = new Insets(10, 10, 1, 0);
        layoutConst3.fill = GridBagConstraints.HORIZONTAL;
        layoutConst3.gridx = 1;
        layoutConst3.gridy = 3;
        jacketsPanel.add(permanentLabel3, layoutConst3);
        
        layoutConst3 = new GridBagConstraints();
        layoutConst3.insets = new Insets(1, 10, 10, 0);
        layoutConst3.fill = GridBagConstraints.HORIZONTAL;
        layoutConst3.gridx = 1;
        layoutConst3.gridy = 4;
        jacketsPanel.add(yesnoBox3, layoutConst3);
        
        layoutConst3 = new GridBagConstraints();
        layoutConst3.insets = new Insets(10, 10, 1, 0);
        layoutConst3.fill = GridBagConstraints.HORIZONTAL;
        layoutConst3.gridx = 2;
        layoutConst3.gridy = 3;
        jacketsPanel.add(seasonLabel3, layoutConst3);
        
        layoutConst3 = new GridBagConstraints();
        layoutConst3.insets = new Insets(1, 10, 10, 0);
        layoutConst3.fill = GridBagConstraints.HORIZONTAL;
        layoutConst3.gridx = 2;
        layoutConst3.gridy = 4;
        jacketsPanel.add(seasonsBox3, layoutConst3);
        
        layoutConst3 = new GridBagConstraints();
        layoutConst3.insets = new Insets(10, 10, 1, 0);
        layoutConst3.fill = GridBagConstraints.HORIZONTAL;
        layoutConst3.gridx = 3;
        layoutConst3.gridy = 3;
        jacketsPanel.add(colorLabel3, layoutConst3);
        
        layoutConst3 = new GridBagConstraints();
        layoutConst3.insets = new Insets(1, 10, 10, 0);
        layoutConst3.fill = GridBagConstraints.HORIZONTAL;
        layoutConst3.gridx = 3;
        layoutConst3.gridy = 4;
        jacketsPanel.add(colorsBox3, layoutConst3);
        
        layoutConst3 = new GridBagConstraints();
        layoutConst3.insets = new Insets(10, 10, 1, 0);
        layoutConst3.fill = GridBagConstraints.HORIZONTAL;
        layoutConst3.gridx = 4;
        layoutConst3.gridy = 3;
        jacketsPanel.add(occasionLabel3, layoutConst3);
        
        layoutConst3 = new GridBagConstraints();
        layoutConst3.insets = new Insets(1, 10, 10, 0);
        layoutConst3.fill = GridBagConstraints.HORIZONTAL;
        layoutConst3.gridx = 4;
        layoutConst3.gridy = 4;
        jacketsPanel.add(occasionsBox3, layoutConst3);
             
        layoutConst3 = new GridBagConstraints();
        layoutConst3.insets = new Insets(10, 10, 1, 0);
        layoutConst3.fill = GridBagConstraints.HORIZONTAL;
        layoutConst3.gridx = 6;
        layoutConst3.gridy = 3;
        jacketsPanel.add(typeLabel3, layoutConst3);
        
        layoutConst3 = new GridBagConstraints();
        layoutConst3.insets = new Insets(1, 10, 10, 0);
        layoutConst3.fill = GridBagConstraints.HORIZONTAL;
        layoutConst3.gridx = 6;
        layoutConst3.gridy = 4;
        jacketsPanel.add(typesJacketsBox, layoutConst3);
        
        layoutConst3 = new GridBagConstraints();
        layoutConst3.insets = new Insets(10, 10, 1, 0);
        layoutConst3.fill = GridBagConstraints.HORIZONTAL;
        layoutConst3.gridx = 7;
        layoutConst3.gridy = 3;
        jacketsPanel.add(idLabel3, layoutConst3);
        
        layoutConst3 = new GridBagConstraints();
        layoutConst3.insets = new Insets(1, 10, 10, 0);
        layoutConst3.fill = GridBagConstraints.HORIZONTAL;
        layoutConst3.gridx = 7;
        layoutConst3.gridy = 4;
        jacketsPanel.add(idField3, layoutConst3);
        
        layoutConst3 = new GridBagConstraints();
        layoutConst3.insets = new Insets(0, 10, 10, 5);
        layoutConst3.fill = GridBagConstraints.HORIZONTAL;
        layoutConst3.gridx = 8;
        layoutConst3.gridy = 4;
        jacketsPanel.add(addJacketsButton, layoutConst3);

        
        // SCARVES Panel
        
        //VARIABLE DEFINITIONS
        //Box for types - I NEED TO ADD DIFFERENT TYPES FOR EACH DIFFERENT CLOTHING TYPE
    String[] typesScarfsArray = {"N/A"};
    JComboBox typesScarfsBox = new JComboBox(typesScarfsArray);
        //END OF VARIABLE DEFINITIONS
        
        JPanel scarfsPanel = new JPanel();       
        
        //Create table to add clothes 
        JLabel tableLabel4 = new JLabel("Scarfs");
        
        addScarfsButton = new JButton("Add");
        addScarfsButton.addActionListener(this);
        
        //initialize table
        Object[][] tableVals4 = new Object[10][7];
        String[] columnHeadings4 = {"Stackable", "Permanent", "Season", "Color", "Occasion", "Type", "ID"};
        clothingListTable4 = new JTable(tableVals4, columnHeadings4);
        clothingListTable4.setEnabled(false);
        
        idField4.setEditable(true);
        //add the table and all the labels and textfields to the JPanel - this is the table tjacket displays the different clothes
        scarfsPanel.setLayout(new GridBagLayout());
        
        GridBagConstraints layoutConst4 = null;                  
        NumberFormat currencyFormat4 = null;
        
        layoutConst4 = new GridBagConstraints();
        layoutConst4.insets = new Insets(10, 10, 1, 0);
        layoutConst4.fill = GridBagConstraints.HORIZONTAL;
        layoutConst4.gridx = 0;
        layoutConst4.gridy = 0;
        scarfsPanel.add(tableLabel4, layoutConst4);
        
        layoutConst4 = new GridBagConstraints();
        layoutConst4.insets = new Insets(1, 10, 0, 0);
        layoutConst4.fill = GridBagConstraints.HORIZONTAL;
        layoutConst4.gridx = 0;
        layoutConst4.gridy = 1;
        layoutConst4.gridwidth = 8;
        scarfsPanel.add(clothingListTable4.getTableHeader(), layoutConst4);
        
        layoutConst4 = new GridBagConstraints();
        layoutConst4.insets = new Insets(0, 10, 10, 0);
        layoutConst4.fill = GridBagConstraints.HORIZONTAL;
        layoutConst4.gridx = 0;
        layoutConst4.gridy = 2;
        layoutConst4.gridwidth = 8; // this is where I can change the width of the table
        scarfsPanel.add(clothingListTable4, layoutConst4);
        
        //adding the input table to the JPanel - this is where people will actually input clothes onto the table above
        layoutConst4 = new GridBagConstraints();
        layoutConst4.insets = new Insets(10, 10, 1, 0);
        layoutConst4.fill = GridBagConstraints.HORIZONTAL;
        layoutConst4.gridx = 0;
        layoutConst4.gridy = 3;
        scarfsPanel.add(stackableLabel4, layoutConst4);
        
        layoutConst4 = new GridBagConstraints();
        layoutConst4.insets = new Insets(1, 10, 10, 0);
        layoutConst4.fill = GridBagConstraints.HORIZONTAL;
        layoutConst4.gridx = 0;
        layoutConst4.gridy = 4;
        scarfsPanel.add(trufalsBox4, layoutConst4);
        
        layoutConst4 = new GridBagConstraints();
        layoutConst4.insets = new Insets(10, 10, 1, 0);
        layoutConst4.fill = GridBagConstraints.HORIZONTAL;
        layoutConst4.gridx = 1;
        layoutConst4.gridy = 3;
        scarfsPanel.add(permanentLabel4, layoutConst4);
        
        layoutConst4 = new GridBagConstraints();
        layoutConst4.insets = new Insets(1, 10, 10, 0);
        layoutConst4.fill = GridBagConstraints.HORIZONTAL;
        layoutConst4.gridx = 1;
        layoutConst4.gridy = 4;
        scarfsPanel.add(yesnoBox4, layoutConst4);
        
        layoutConst4 = new GridBagConstraints();
        layoutConst4.insets = new Insets(10, 10, 1, 0);
        layoutConst4.fill = GridBagConstraints.HORIZONTAL;
        layoutConst4.gridx = 2;
        layoutConst4.gridy = 3;
        scarfsPanel.add(seasonLabel4, layoutConst4);
        
        layoutConst4 = new GridBagConstraints();
        layoutConst4.insets = new Insets(1, 10, 10, 0);
        layoutConst4.fill = GridBagConstraints.HORIZONTAL;
        layoutConst4.gridx = 2;
        layoutConst4.gridy = 4;
        scarfsPanel.add(seasonsBox4, layoutConst4);
        
        layoutConst4 = new GridBagConstraints();
        layoutConst4.insets = new Insets(10, 10, 1, 0);
        layoutConst4.fill = GridBagConstraints.HORIZONTAL;
        layoutConst4.gridx = 3;
        layoutConst4.gridy = 3;
        scarfsPanel.add(colorLabel4, layoutConst4);
        
        layoutConst4 = new GridBagConstraints();
        layoutConst4.insets = new Insets(1, 10, 10, 0);
        layoutConst4.fill = GridBagConstraints.HORIZONTAL;
        layoutConst4.gridx = 3;
        layoutConst4.gridy = 4;
        scarfsPanel.add(colorsBox4, layoutConst4);
        
        layoutConst4 = new GridBagConstraints();
        layoutConst4.insets = new Insets(10, 10, 1, 0);
        layoutConst4.fill = GridBagConstraints.HORIZONTAL;
        layoutConst4.gridx = 4;
        layoutConst4.gridy = 3;
        scarfsPanel.add(occasionLabel4, layoutConst4);
        
        layoutConst4 = new GridBagConstraints();
        layoutConst4.insets = new Insets(1, 10, 10, 0);
        layoutConst4.fill = GridBagConstraints.HORIZONTAL;
        layoutConst4.gridx = 4;
        layoutConst4.gridy = 4;
        scarfsPanel.add(occasionsBox4, layoutConst4);
             
        layoutConst4 = new GridBagConstraints();
        layoutConst4.insets = new Insets(10, 10, 1, 0);
        layoutConst4.fill = GridBagConstraints.HORIZONTAL;
        layoutConst4.gridx = 5;
        layoutConst4.gridy = 3;
        scarfsPanel.add(typeLabel4, layoutConst4);
        
        layoutConst4 = new GridBagConstraints();
        layoutConst4.insets = new Insets(1, 10, 10, 0);
        layoutConst4.fill = GridBagConstraints.HORIZONTAL;
        layoutConst4.gridx = 5;
        layoutConst4.gridy = 4;
        scarfsPanel.add(typesScarfsBox, layoutConst4);
        
        layoutConst4 = new GridBagConstraints();
        layoutConst4.insets = new Insets(10, 10, 1, 0);
        layoutConst4.fill = GridBagConstraints.HORIZONTAL;
        layoutConst4.gridx = 6;
        layoutConst4.gridy = 3;
        scarfsPanel.add(idLabel4, layoutConst4);
        
        layoutConst4 = new GridBagConstraints();
        layoutConst4.insets = new Insets(1, 10, 10, 0);
        layoutConst4.fill = GridBagConstraints.HORIZONTAL;
        layoutConst4.gridx = 6;
        layoutConst4.gridy = 4;
        scarfsPanel.add(idField4, layoutConst4);
        
        layoutConst4 = new GridBagConstraints();
        layoutConst4.insets = new Insets(0, 10, 10, 5);
        layoutConst4.fill = GridBagConstraints.HORIZONTAL;
        layoutConst4.gridx = 7;
        layoutConst4.gridy = 4;
        scarfsPanel.add(addScarfsButton, layoutConst4);
        
        // SHIRTS Panel
        
        //VARIABLE DEFINITIONS
        //Box for types - I NEED TO ADD DIFFERENT TYPES FOR EACH DIFFERENT CLOTHING TYPE
    String[] typesShirtsArray = {"N/A"};
    JComboBox typesShirtsBox = new JComboBox(typesShirtsArray);
        //END OF VARIABLE DEFINITIONS
        
        JPanel shirtsPanel = new JPanel();
        
        //Create table to add clothes 
        JLabel tableLabel5 = new JLabel("Shirts");
        
        addShirtsButton = new JButton("Add");
        addShirtsButton.addActionListener(this);
        
        //initialize table
        Object[][] tableVals5 = new Object[10][7];
        String[] columnHeadings5 = {"Stackable", "Permanent", "Season", "Color", "Occasion", "Type", "ID"};
        clothingListTable5 = new JTable(tableVals5, columnHeadings5);
        clothingListTable5.setEnabled(false);
        
        idField5.setEditable(true);
        //add the table and all the labels and textfields to the JPanel - this is the table tjacket displays the different clothes
        shirtsPanel.setLayout(new GridBagLayout());
        
        GridBagConstraints layoutConst5 = null;                  
        NumberFormat currencyFormat5 = null;
        
        layoutConst5 = new GridBagConstraints();
        layoutConst5.insets = new Insets(10, 10, 1, 0);
        layoutConst5.fill = GridBagConstraints.HORIZONTAL;
        layoutConst5.gridx = 0;
        layoutConst5.gridy = 0;
        shirtsPanel.add(tableLabel5, layoutConst5);
        
        layoutConst5 = new GridBagConstraints();
        layoutConst5.insets = new Insets(1, 10, 0, 0);
        layoutConst5.fill = GridBagConstraints.HORIZONTAL;
        layoutConst5.gridx = 0;
        layoutConst5.gridy = 1;
        layoutConst5.gridwidth = 8;
        shirtsPanel.add(clothingListTable5.getTableHeader(), layoutConst5);
        
        layoutConst5 = new GridBagConstraints();
        layoutConst5.insets = new Insets(0, 10, 10, 0);
        layoutConst5.fill = GridBagConstraints.HORIZONTAL;
        layoutConst5.gridx = 0;
        layoutConst5.gridy = 2;
        layoutConst5.gridwidth = 8; // this is where I can change the width of the table
        shirtsPanel.add(clothingListTable5, layoutConst5);
        
        //adding the input table to the JPanel - this is where people will actually input clothes onto the table above
        layoutConst5 = new GridBagConstraints();
        layoutConst5.insets = new Insets(10, 10, 1, 0);
        layoutConst5.fill = GridBagConstraints.HORIZONTAL;
        layoutConst5.gridx = 0;
        layoutConst5.gridy = 3;
        shirtsPanel.add(stackableLabel5, layoutConst5);
        
        layoutConst5 = new GridBagConstraints();
        layoutConst5.insets = new Insets(1, 10, 10, 0);
        layoutConst5.fill = GridBagConstraints.HORIZONTAL;
        layoutConst5.gridx = 0;
        layoutConst5.gridy = 4;
        shirtsPanel.add(trufalsBox5, layoutConst5);
        
        layoutConst5 = new GridBagConstraints();
        layoutConst5.insets = new Insets(10, 10, 1, 0);
        layoutConst5.fill = GridBagConstraints.HORIZONTAL;
        layoutConst5.gridx = 1;
        layoutConst5.gridy = 3;
        shirtsPanel.add(permanentLabel5, layoutConst5);
        
        layoutConst5 = new GridBagConstraints();
        layoutConst5.insets = new Insets(1, 10, 10, 0);
        layoutConst5.fill = GridBagConstraints.HORIZONTAL;
        layoutConst5.gridx = 1;
        layoutConst5.gridy = 4;
        shirtsPanel.add(yesnoBox5, layoutConst5);
        
        layoutConst5 = new GridBagConstraints();
        layoutConst5.insets = new Insets(10, 10, 1, 0);
        layoutConst5.fill = GridBagConstraints.HORIZONTAL;
        layoutConst5.gridx = 2;
        layoutConst5.gridy = 3;
        shirtsPanel.add(seasonLabel5, layoutConst5);
        
        layoutConst5 = new GridBagConstraints();
        layoutConst5.insets = new Insets(1, 10, 10, 0);
        layoutConst5.fill = GridBagConstraints.HORIZONTAL;
        layoutConst5.gridx = 2;
        layoutConst5.gridy = 4;
        shirtsPanel.add(seasonsBox5, layoutConst5);
        
        layoutConst5 = new GridBagConstraints();
        layoutConst5.insets = new Insets(10, 10, 1, 0);
        layoutConst5.fill = GridBagConstraints.HORIZONTAL;
        layoutConst5.gridx = 3;
        layoutConst5.gridy = 3;
        shirtsPanel.add(colorLabel5, layoutConst5);
        
        layoutConst5 = new GridBagConstraints();
        layoutConst5.insets = new Insets(1, 10, 10, 0);
        layoutConst5.fill = GridBagConstraints.HORIZONTAL;
        layoutConst5.gridx = 3;
        layoutConst5.gridy = 4;
        shirtsPanel.add(colorsBox5, layoutConst5);
        
        layoutConst5 = new GridBagConstraints();
        layoutConst5.insets = new Insets(10, 10, 1, 0);
        layoutConst5.fill = GridBagConstraints.HORIZONTAL;
        layoutConst5.gridx = 5;
        layoutConst5.gridy = 3;
        shirtsPanel.add(occasionLabel5, layoutConst5);
        
        layoutConst5 = new GridBagConstraints();
        layoutConst5.insets = new Insets(1, 10, 10, 0);
        layoutConst5.fill = GridBagConstraints.HORIZONTAL;
        layoutConst5.gridx = 5;
        layoutConst5.gridy = 4;
        shirtsPanel.add(occasionsBox5, layoutConst5);
             
        layoutConst5 = new GridBagConstraints();
        layoutConst5.insets = new Insets(10, 10, 1, 0);
        layoutConst5.fill = GridBagConstraints.HORIZONTAL;
        layoutConst5.gridx = 6;
        layoutConst5.gridy = 3;
        shirtsPanel.add(typeLabel5, layoutConst5);
        
        layoutConst5 = new GridBagConstraints();
        layoutConst5.insets = new Insets(1, 10, 10, 0);
        layoutConst5.fill = GridBagConstraints.HORIZONTAL;
        layoutConst5.gridx = 6;
        layoutConst5.gridy = 4;
        shirtsPanel.add(typesShirtsBox, layoutConst5);
        
        layoutConst5 = new GridBagConstraints();
        layoutConst5.insets = new Insets(10, 10, 1, 0);
        layoutConst5.fill = GridBagConstraints.HORIZONTAL;
        layoutConst5.gridx = 7;
        layoutConst5.gridy = 3;
        shirtsPanel.add(idLabel5, layoutConst5);
        
        layoutConst5 = new GridBagConstraints();
        layoutConst5.insets = new Insets(1, 10, 10, 0);
        layoutConst5.fill = GridBagConstraints.HORIZONTAL;
        layoutConst5.gridx = 7;
        layoutConst5.gridy = 4;
        shirtsPanel.add(idField5, layoutConst5);
        
        layoutConst5 = new GridBagConstraints();
        layoutConst5.insets = new Insets(0, 10, 10, 5);
        layoutConst5.fill = GridBagConstraints.HORIZONTAL;
        layoutConst5.gridx = 8;
        layoutConst5.gridy = 5;
        shirtsPanel.add(addShirtsButton, layoutConst5);
        
        // PANTS Panel
        
        //VARIABLE DEFINITIONS
        //Box for types - I NEED TO ADD DIFFERENT TYPES FOR EACH DIFFERENT CLOTHING TYPE
    String[] typesPantsArray = {"N/A"};
    JComboBox typesPantsBox = new JComboBox(typesPantsArray);
        //END OF VARIABLE DEFINITIONS
        
        JPanel pantsPanel = new JPanel();
        
        //Create table to add clothes 
        JLabel tableLabel6 = new JLabel("Pants");
        
        addPantsButton = new JButton("Add");
        addPantsButton.addActionListener(this);
        
        //initialize table
        Object[][] tableVals6 = new Object[10][7];
        String[] columnHeadings6 = {"Stackable", "Permanent", "Season", "Color", "Occasion", "Type", "ID"};
        clothingListTable6 = new JTable(tableVals6, columnHeadings6);
        clothingListTable6.setEnabled(false);
        
        idField6.setEditable(true);
        //add the table and all the labels and textfields to the JPanel - this is the table tjacket displays the different clothes
        pantsPanel.setLayout(new GridBagLayout());
        
        GridBagConstraints layoutConst6 = null;                  
        NumberFormat currencyFormat6 = null;
        
        layoutConst6 = new GridBagConstraints();
        layoutConst6.insets = new Insets(10, 10, 1, 0);
        layoutConst6.fill = GridBagConstraints.HORIZONTAL;
        layoutConst6.gridx = 0;
        layoutConst6.gridy = 0;
        pantsPanel.add(tableLabel6, layoutConst6);
        
        layoutConst6 = new GridBagConstraints();
        layoutConst6.insets = new Insets(1, 10, 0, 0);
        layoutConst6.fill = GridBagConstraints.HORIZONTAL;
        layoutConst6.gridx = 0;
        layoutConst6.gridy = 1;
        layoutConst6.gridwidth = 8;
        pantsPanel.add(clothingListTable6.getTableHeader(), layoutConst6);
        
        layoutConst6 = new GridBagConstraints();
        layoutConst6.insets = new Insets(0, 10, 10, 0);
        layoutConst6.fill = GridBagConstraints.HORIZONTAL;
        layoutConst6.gridx = 0;
        layoutConst6.gridy = 2;
        layoutConst6.gridwidth = 8; // this is where I can change the width of the table
        pantsPanel.add(clothingListTable6, layoutConst6);
        
        //adding the input table to the JPanel - this is where people will actually input clothes onto the table above
        layoutConst6 = new GridBagConstraints();
        layoutConst6.insets = new Insets(10, 10, 1, 0);
        layoutConst6.fill = GridBagConstraints.HORIZONTAL;
        layoutConst6.gridx = 0;
        layoutConst6.gridy = 3;
        pantsPanel.add(stackableLabel6, layoutConst6);
        
        layoutConst6 = new GridBagConstraints();
        layoutConst6.insets = new Insets(1, 10, 10, 0);
        layoutConst6.fill = GridBagConstraints.HORIZONTAL;
        layoutConst6.gridx = 0;
        layoutConst6.gridy = 4;
        pantsPanel.add(trufalsBox6, layoutConst6);
        
        layoutConst6 = new GridBagConstraints();
        layoutConst6.insets = new Insets(10, 10, 1, 0);
        layoutConst6.fill = GridBagConstraints.HORIZONTAL;
        layoutConst6.gridx = 1;
        layoutConst6.gridy = 3;
        pantsPanel.add(permanentLabel6, layoutConst6);
        
        layoutConst6 = new GridBagConstraints();
        layoutConst6.insets = new Insets(1, 10, 10, 0);
        layoutConst6.fill = GridBagConstraints.HORIZONTAL;
        layoutConst6.gridx = 1;
        layoutConst6.gridy = 4;
        pantsPanel.add(yesnoBox6, layoutConst6);
        
        layoutConst6 = new GridBagConstraints();
        layoutConst6.insets = new Insets(10, 10, 1, 0);
        layoutConst6.fill = GridBagConstraints.HORIZONTAL;
        layoutConst6.gridx = 2;
        layoutConst6.gridy = 3;
        pantsPanel.add(seasonLabel6, layoutConst6);
        
        layoutConst6 = new GridBagConstraints();
        layoutConst6.insets = new Insets(1, 10, 10, 0);
        layoutConst6.fill = GridBagConstraints.HORIZONTAL;
        layoutConst6.gridx = 2;
        layoutConst6.gridy = 4;
        pantsPanel.add(seasonsBox6, layoutConst6);
        
        layoutConst6 = new GridBagConstraints();
        layoutConst6.insets = new Insets(10, 10, 1, 0);
        layoutConst6.fill = GridBagConstraints.HORIZONTAL;
        layoutConst6.gridx = 3;
        layoutConst6.gridy = 3;
        pantsPanel.add(colorLabel6, layoutConst6);
        
        layoutConst6 = new GridBagConstraints();
        layoutConst6.insets = new Insets(1, 10, 10, 0);
        layoutConst6.fill = GridBagConstraints.HORIZONTAL;
        layoutConst6.gridx = 3;
        layoutConst6.gridy = 4;
        pantsPanel.add(colorsBox6, layoutConst6);
        
        layoutConst6 = new GridBagConstraints();
        layoutConst6.insets = new Insets(10, 10, 1, 0);
        layoutConst6.fill = GridBagConstraints.HORIZONTAL;
        layoutConst6.gridx = 5;
        layoutConst6.gridy = 3;
        pantsPanel.add(occasionLabel6, layoutConst6);
        
        layoutConst6 = new GridBagConstraints();
        layoutConst6.insets = new Insets(1, 10, 10, 0);
        layoutConst6.fill = GridBagConstraints.HORIZONTAL;
        layoutConst6.gridx = 5;
        layoutConst6.gridy = 4;
        pantsPanel.add(occasionsBox6, layoutConst6);
             
        layoutConst6 = new GridBagConstraints();
        layoutConst6.insets = new Insets(10, 10, 1, 0);
        layoutConst6.fill = GridBagConstraints.HORIZONTAL;
        layoutConst6.gridx = 6;
        layoutConst6.gridy = 3;
        pantsPanel.add(typeLabel6, layoutConst6);
        
        layoutConst6 = new GridBagConstraints();
        layoutConst6.insets = new Insets(1, 10, 10, 0);
        layoutConst6.fill = GridBagConstraints.HORIZONTAL;
        layoutConst6.gridx = 6;
        layoutConst6.gridy = 4;
        pantsPanel.add(typesPantsBox, layoutConst6);
        
        layoutConst6 = new GridBagConstraints();
        layoutConst6.insets = new Insets(10, 10, 1, 0);
        layoutConst6.fill = GridBagConstraints.HORIZONTAL;
        layoutConst6.gridx = 7;
        layoutConst6.gridy = 3;
        pantsPanel.add(idLabel6, layoutConst6);
        
        layoutConst6 = new GridBagConstraints();
        layoutConst6.insets = new Insets(1, 10, 10, 0);
        layoutConst6.fill = GridBagConstraints.HORIZONTAL;
        layoutConst6.gridx = 7;
        layoutConst6.gridy = 4;
        pantsPanel.add(idField6, layoutConst6);
        
        layoutConst6 = new GridBagConstraints();
        layoutConst6.insets = new Insets(0, 10, 10, 6);
        layoutConst6.fill = GridBagConstraints.HORIZONTAL;
        layoutConst6.gridx = 8;
        layoutConst6.gridy = 6;
        pantsPanel.add(addPantsButton, layoutConst6);

        
        // SHOES Panel
        
        //VARIABLE DEFINITIONS
        //Box for types - I NEED TO ADD DIFFERENT TYPES FOR EACH DIFFERENT CLOTHING TYPE
    String[] typesShoesArray = {"N/A"};
    JComboBox typesShoesBox = new JComboBox(typesShoesArray);
        //END OF VARIABLE DEFINITIONS
        
        JPanel shoesPanel = new JPanel();
        //Create table to add clothes 
        JLabel tableLabel7 = new JLabel("Shoes");
        
        addShoesButton = new JButton("Add");
        addShoesButton.addActionListener(this);
        
        //initialize table
        Object[][] tableVals7 = new Object[10][7];
        String[] columnHeadings7 = {"Stackable", "Permanent", "Season", "Color", "Occasion", "Type", "ID"};
        clothingListTable7 = new JTable(tableVals7, columnHeadings7);
        clothingListTable7.setEnabled(false);
        
        idField7.setEditable(true);
        //add the table and all the labels and textfields to the JPanel - this is the table tjacket displays the different clothes
        shoesPanel.setLayout(new GridBagLayout());
        
        GridBagConstraints layoutConst7 = null;                  
        NumberFormat currencyFormat7 = null;
        
        layoutConst7 = new GridBagConstraints();
        layoutConst7.insets = new Insets(10, 10, 1, 0);
        layoutConst7.fill = GridBagConstraints.HORIZONTAL;
        layoutConst7.gridx = 0;
        layoutConst7.gridy = 0;
        shoesPanel.add(tableLabel7, layoutConst7);
        
        layoutConst7 = new GridBagConstraints();
        layoutConst7.insets = new Insets(1, 10, 0, 0);
        layoutConst7.fill = GridBagConstraints.HORIZONTAL;
        layoutConst7.gridx = 0;
        layoutConst7.gridy = 1;
        layoutConst7.gridwidth = 8;
        shoesPanel.add(clothingListTable7.getTableHeader(), layoutConst7);
        
        layoutConst7 = new GridBagConstraints();
        layoutConst7.insets = new Insets(0, 10, 10, 0);
        layoutConst7.fill = GridBagConstraints.HORIZONTAL;
        layoutConst7.gridx = 0;
        layoutConst7.gridy = 2;
        layoutConst7.gridwidth = 8; // this is where I can change the width of the table
        shoesPanel.add(clothingListTable7, layoutConst7);
        
        //adding the input table to the JPanel - this is where people will actually input clothes onto the table above
        layoutConst7 = new GridBagConstraints();
        layoutConst7.insets = new Insets(10, 10, 1, 0);
        layoutConst7.fill = GridBagConstraints.HORIZONTAL;
        layoutConst7.gridx = 0;
        layoutConst7.gridy = 3;
        shoesPanel.add(stackableLabel7, layoutConst7);
        
        layoutConst7 = new GridBagConstraints();
        layoutConst7.insets = new Insets(1, 10, 10, 0);
        layoutConst7.fill = GridBagConstraints.HORIZONTAL;
        layoutConst7.gridx = 0;
        layoutConst7.gridy = 4;
        shoesPanel.add(trufalsBox7, layoutConst7);
        
        layoutConst7 = new GridBagConstraints();
        layoutConst7.insets = new Insets(10, 10, 1, 0);
        layoutConst7.fill = GridBagConstraints.HORIZONTAL;
        layoutConst7.gridx = 1;
        layoutConst7.gridy = 3;
        shoesPanel.add(permanentLabel7, layoutConst7);
        
        layoutConst7 = new GridBagConstraints();
        layoutConst7.insets = new Insets(1, 10, 10, 0);
        layoutConst7.fill = GridBagConstraints.HORIZONTAL;
        layoutConst7.gridx = 1;
        layoutConst7.gridy = 4;
        shoesPanel.add(yesnoBox7, layoutConst7);
        
        layoutConst7 = new GridBagConstraints();
        layoutConst7.insets = new Insets(10, 10, 1, 0);
        layoutConst7.fill = GridBagConstraints.HORIZONTAL;
        layoutConst7.gridx = 2;
        layoutConst7.gridy = 3;
        shoesPanel.add(seasonLabel7, layoutConst7);
        
        layoutConst7 = new GridBagConstraints();
        layoutConst7.insets = new Insets(1, 10, 10, 0);
        layoutConst7.fill = GridBagConstraints.HORIZONTAL;
        layoutConst7.gridx = 2;
        layoutConst7.gridy = 4;
        shoesPanel.add(seasonsBox7, layoutConst7);
        
        layoutConst7 = new GridBagConstraints();
        layoutConst7.insets = new Insets(10, 10, 1, 0);
        layoutConst7.fill = GridBagConstraints.HORIZONTAL;
        layoutConst7.gridx = 3;
        layoutConst7.gridy = 3;
        shoesPanel.add(colorLabel7, layoutConst7);
        
        layoutConst7 = new GridBagConstraints();
        layoutConst7.insets = new Insets(1, 10, 10, 0);
        layoutConst7.fill = GridBagConstraints.HORIZONTAL;
        layoutConst7.gridx = 3;
        layoutConst7.gridy = 4;
        shoesPanel.add(colorsBox7, layoutConst7);
        
        layoutConst7 = new GridBagConstraints();
        layoutConst7.insets = new Insets(10, 10, 1, 0);
        layoutConst7.fill = GridBagConstraints.HORIZONTAL;
        layoutConst7.gridx = 4;
        layoutConst7.gridy = 3;
        shoesPanel.add(occasionLabel7, layoutConst7);
        
        layoutConst7 = new GridBagConstraints();
        layoutConst7.insets = new Insets(1, 10, 10, 0);
        layoutConst7.fill = GridBagConstraints.HORIZONTAL;
        layoutConst7.gridx = 4;
        layoutConst7.gridy = 4;
        shoesPanel.add(occasionsBox7, layoutConst7);
             
        layoutConst7 = new GridBagConstraints();
        layoutConst7.insets = new Insets(10, 10, 1, 0);
        layoutConst7.fill = GridBagConstraints.HORIZONTAL;
        layoutConst7.gridx = 5;
        layoutConst7.gridy = 3;
        shoesPanel.add(typeLabel7, layoutConst7);
        
        layoutConst7 = new GridBagConstraints();
        layoutConst7.insets = new Insets(1, 10, 10, 0);
        layoutConst7.fill = GridBagConstraints.HORIZONTAL;
        layoutConst7.gridx = 5;
        layoutConst7.gridy = 4;
        shoesPanel.add(typesShoesBox, layoutConst7);
        
        layoutConst7 = new GridBagConstraints();
        layoutConst7.insets = new Insets(10, 10, 1, 0);
        layoutConst7.fill = GridBagConstraints.HORIZONTAL;
        layoutConst7.gridx = 6;
        layoutConst7.gridy = 3;
        shoesPanel.add(idLabel7, layoutConst7);
        
        layoutConst7 = new GridBagConstraints();
        layoutConst7.insets = new Insets(1, 10, 10, 0);
        layoutConst7.fill = GridBagConstraints.HORIZONTAL;
        layoutConst7.gridx = 6;
        layoutConst7.gridy = 4;
        shoesPanel.add(idField7, layoutConst7);
        
        layoutConst7 = new GridBagConstraints();
        layoutConst7.insets = new Insets(0, 10, 10, 7);
        layoutConst7.fill = GridBagConstraints.HORIZONTAL;
        layoutConst7.gridx = 8;
        layoutConst7.gridy = 7;
        shoesPanel.add(addShoesButton, layoutConst7);
        // SOCKS Panel
        
        //VARIABLE DEFINITIONS
        //Box for types - I NEED TO ADD DIFFERENT TYPES FOR EACH DIFFERENT CLOTHING TYPE
    String[] typesSocksArray = {"N/A"};
    JComboBox typesSocksBox = new JComboBox(typesSocksArray);
        //END OF VARIABLE DEFINITIONS
        
        JPanel socksPanel = new JPanel();
        
        //Create table to add clothes 
        JLabel tableLabel8 = new JLabel("Socks");
        
        addSocksButton = new JButton("Add");
        addSocksButton.addActionListener(this);
        
        //initialize table
        Object[][] tableVals8 = new Object[10][8];
        String[] columnHeadings8 = {"Stackable", "Permanent", "Season", "Color", "Occasion", "Type", "ID"};
        clothingListTable8 = new JTable(tableVals8, columnHeadings8);
        clothingListTable8.setEnabled(false);
        
        idField8.setEditable(true);
        //add the table and all the labels and textfields to the JPanel - this is the table tjacket displays the different clothes
        socksPanel.setLayout(new GridBagLayout());
        
        GridBagConstraints layoutConst8 = null;                  
        NumberFormat currencyFormat8 = null;
        
        layoutConst8 = new GridBagConstraints();
        layoutConst8.insets = new Insets(10, 10, 1, 0);
        layoutConst8.fill = GridBagConstraints.HORIZONTAL;
        layoutConst8.gridx = 0;
        layoutConst8.gridy = 0;
        socksPanel.add(tableLabel8, layoutConst8);
        
        layoutConst8 = new GridBagConstraints();
        layoutConst8.insets = new Insets(1, 10, 0, 0);
        layoutConst8.fill = GridBagConstraints.HORIZONTAL;
        layoutConst8.gridx = 0;
        layoutConst8.gridy = 1;
        layoutConst8.gridwidth = 8;
        socksPanel.add(clothingListTable8.getTableHeader(), layoutConst8);
        
        layoutConst8 = new GridBagConstraints();
        layoutConst8.insets = new Insets(0, 10, 10, 0);
        layoutConst8.fill = GridBagConstraints.HORIZONTAL;
        layoutConst8.gridx = 0;
        layoutConst8.gridy = 2;
        layoutConst8.gridwidth = 8; // this is where I can change the width of the table
        socksPanel.add(clothingListTable8, layoutConst8);
        
        //adding the input table to the JPanel - this is where people will actually input clothes onto the table above
        layoutConst8 = new GridBagConstraints();
        layoutConst8.insets = new Insets(10, 10, 1, 0);
        layoutConst8.fill = GridBagConstraints.HORIZONTAL;
        layoutConst8.gridx = 0;
        layoutConst8.gridy = 3;
        socksPanel.add(stackableLabel8, layoutConst8);
        
        layoutConst8 = new GridBagConstraints();
        layoutConst8.insets = new Insets(1, 10, 10, 0);
        layoutConst8.fill = GridBagConstraints.HORIZONTAL;
        layoutConst8.gridx = 0;
        layoutConst8.gridy = 4;
        socksPanel.add(trufalsBox8, layoutConst8);
        
        layoutConst8 = new GridBagConstraints();
        layoutConst8.insets = new Insets(10, 10, 1, 0);
        layoutConst8.fill = GridBagConstraints.HORIZONTAL;
        layoutConst8.gridx = 1;
        layoutConst8.gridy = 3;
        socksPanel.add(permanentLabel8, layoutConst8);
        
        layoutConst8 = new GridBagConstraints();
        layoutConst8.insets = new Insets(1, 10, 10, 0);
        layoutConst8.fill = GridBagConstraints.HORIZONTAL;
        layoutConst8.gridx = 1;
        layoutConst8.gridy = 4;
        socksPanel.add(yesnoBox8, layoutConst8);
        
        layoutConst8 = new GridBagConstraints();
        layoutConst8.insets = new Insets(10, 10, 1, 0);
        layoutConst8.fill = GridBagConstraints.HORIZONTAL;
        layoutConst8.gridx = 2;
        layoutConst8.gridy = 3;
        socksPanel.add(seasonLabel8, layoutConst8);
        
        layoutConst8 = new GridBagConstraints();
        layoutConst8.insets = new Insets(1, 10, 10, 0);
        layoutConst8.fill = GridBagConstraints.HORIZONTAL;
        layoutConst8.gridx = 2;
        layoutConst8.gridy = 4;
        socksPanel.add(seasonsBox8, layoutConst8);
        
        layoutConst8 = new GridBagConstraints();
        layoutConst8.insets = new Insets(10, 10, 1, 0);
        layoutConst8.fill = GridBagConstraints.HORIZONTAL;
        layoutConst8.gridx = 3;
        layoutConst8.gridy = 3;
        socksPanel.add(colorLabel8, layoutConst8);
        
        layoutConst8 = new GridBagConstraints();
        layoutConst8.insets = new Insets(1, 10, 10, 0);
        layoutConst8.fill = GridBagConstraints.HORIZONTAL;
        layoutConst8.gridx = 3;
        layoutConst8.gridy = 4;
        socksPanel.add(colorsBox8, layoutConst8);
        
        layoutConst8 = new GridBagConstraints();
        layoutConst8.insets = new Insets(10, 10, 1, 0);
        layoutConst8.fill = GridBagConstraints.HORIZONTAL;
        layoutConst8.gridx = 4;
        layoutConst8.gridy = 3;
        socksPanel.add(occasionLabel8, layoutConst8);
        
        layoutConst8 = new GridBagConstraints();
        layoutConst8.insets = new Insets(1, 10, 10, 0);
        layoutConst8.fill = GridBagConstraints.HORIZONTAL;
        layoutConst8.gridx = 4;
        layoutConst8.gridy = 4;
        socksPanel.add(occasionsBox8, layoutConst8);
             
        layoutConst8 = new GridBagConstraints();
        layoutConst8.insets = new Insets(10, 10, 1, 0);
        layoutConst8.fill = GridBagConstraints.HORIZONTAL;
        layoutConst8.gridx = 5;
        layoutConst8.gridy = 3;
        socksPanel.add(typeLabel8, layoutConst8);
        
        layoutConst8 = new GridBagConstraints();
        layoutConst8.insets = new Insets(1, 10, 10, 0);
        layoutConst8.fill = GridBagConstraints.HORIZONTAL;
        layoutConst8.gridx = 5;
        layoutConst8.gridy = 4;
        socksPanel.add(typesSocksBox, layoutConst8);
        
        layoutConst8 = new GridBagConstraints();
        layoutConst8.insets = new Insets(10, 10, 1, 0);
        layoutConst8.fill = GridBagConstraints.HORIZONTAL;
        layoutConst8.gridx = 6;
        layoutConst8.gridy = 3;
        socksPanel.add(idLabel8, layoutConst8);
        
        layoutConst8 = new GridBagConstraints();
        layoutConst8.insets = new Insets(1, 10, 10, 0);
        layoutConst8.fill = GridBagConstraints.HORIZONTAL;
        layoutConst8.gridx = 6;
        layoutConst8.gridy = 4;
        socksPanel.add(idField8, layoutConst8);
        
        layoutConst8 = new GridBagConstraints();
        layoutConst8.insets = new Insets(0, 10, 10, 8);
        layoutConst8.fill = GridBagConstraints.HORIZONTAL;
        layoutConst8.gridx = 8;
        layoutConst8.gridy = 8;
        socksPanel.add(addSocksButton, layoutConst8);
        
        // OUTFIT Panel
        
        //VARIABLE DEFINITIONS
        
        //END OF VARIABLE DEFINITIONS
        
        JPanel outfitPanel = new JPanel();
        
        // adding of various panels to the tab 
        tabbedPane.addTab(GLASSESPANEL, glassesPanel);
        tabbedPane.addTab(GLOVESPANEL, glovesPanel);
        tabbedPane.addTab(HATSPANEL, hatsPanel);
        tabbedPane.addTab(JACKETSPANEL, jacketsPanel);
        tabbedPane.addTab(SCARFSPANEL, scarfsPanel);
        tabbedPane.addTab(SHIRTSPANEL, shirtsPanel);
        tabbedPane.addTab(PANTSPANEL, pantsPanel);
        tabbedPane.addTab(SHOESPANEL, shoesPanel);
        tabbedPane.addTab(SOCKSPANEL, socksPanel);
        tabbedPane.addTab(OUTFITPANEL, outfitPanel);
 
        pane.add(tabbedPane, BorderLayout.CENTER);
    }
 
    /**
     * Create the GUI and show it.  For thread safety,
     * this method should be invoked from the
     * event dispatch thread.
     */
    private static void createAndShowGUI() {
        //Create and set up the window.
        JFrame frame = new JFrame("WardDrobe");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 
        //Create and set up the content pane.
        TabDemoEXP demo = new TabDemoEXP();
        demo.addComponentToPane(frame.getContentPane());
 
        //Display the window.
        frame.pack();
        frame.setVisible(true);
    }
 
    public static void main(String[] args) {
        /* Use an appropriate Look and Feel */
        try {
            //UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
            UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
        } catch (UnsupportedLookAndFeelException ex) {
            ex.printStackTrace();
        } catch (IllegalAccessException ex) {
            ex.printStackTrace();
        } catch (InstantiationException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        }
        /* Turn off metal's use of bold fonts */
        UIManager.put("swing.boldMetal", Boolean.FALSE);
         
        //Schedule a job for the event dispatch thread:
        //creating and showing this application's GUI.
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }
    
    @Override
    public void actionPerformed(ActionEvent event){
      
      
      //get source of event (there are a couple different buttons that might have triggered it)
      JButton sourceEvent = (JButton) event.getSource();
      
      //these will be used to update the table 
      final int num0 = 0;   
      final int num1 = 1; 
      final int num2 = 2;  
      final int num3 = 3;
      final int num4 = 4;
      final int num5 = 5;
      final int num6 = 6;       // Col num for amount paid
      int i;
      
      if(sourceEvent == addGlassesButton){
      //getting all the values in the input table so that a new clothing object can be made from the specified attributes      
      String stackable = (String)trufalsBox.getSelectedItem();
      String permanent = (String)yesnoBox.getSelectedItem();
      String season = (String)seasonsBox.getSelectedItem();
      String color = (String)colorsBox.getSelectedItem();
      String occasion = (String)occasionsBox.getSelectedItem();
      String id = idField.getText();
         //get the specific type for Glasses
         String type = (String)typesGlassesBox.getSelectedItem();
         //add the clothing type         
         Glasses addGlasses = new Glasses(stackable, permanent, season, color, occasion, type, id); 
         glassesArray.add(addGlasses);
       
         for (i = 0; i < NUM_CLOTHES && i < glassesArray.size(); ++i) {
            if (glassesArray.get(i) == null) { // Clear table entries 
               clothingListTable.setValueAt(null, i, num0);
               clothingListTable.setValueAt(null, i, num1);
               clothingListTable.setValueAt(null, i, num2);
               clothingListTable.setValueAt(null, i, num3);
               clothingListTable.setValueAt(null, i, num4);
               clothingListTable.setValueAt(null, i, num5);
               clothingListTable.setValueAt(null, i, num6);
            }
            else {                             // Update table with content in the clothingListArray ArrayList
               clothingListTable.setValueAt(glassesArray.get(i).getStackable(), i, num0);
               clothingListTable.setValueAt(glassesArray.get(i).getPermanent(), i, num1);
               clothingListTable.setValueAt(glassesArray.get(i).getSeason(), i, num2);
               clothingListTable.setValueAt(glassesArray.get(i).getColor(), i, num3);
               clothingListTable.setValueAt(glassesArray.get(i).getOccasion(), i, num4);
               clothingListTable.setValueAt(glassesArray.get(i).getType(), i, num5);
               clothingListTable.setValueAt(glassesArray.get(i).getID(), i, num6);
            }
         }  
      }
      else if(sourceEvent == addGlovesButton){
         //getting all the values in the input table so that a new clothing object can be made from the specified attributes      
         String stackable1 = (String)trufalsBox1.getSelectedItem();
         String permanent1 = (String)yesnoBox1.getSelectedItem();
         String season1 = (String)seasonsBox1.getSelectedItem();
         String color1 = (String)colorsBox.getSelectedItem();
         String occasion1 = (String)occasionsBox.getSelectedItem();
         String id1 = idField.getText();
         //get the specific type for Glasses
         String type1 = (String)typesGlassesBox.getSelectedItem();
         //add the clothing type         
         Glove addGloves = new Glove(stackable1, permanent1, season1, color1, occasion1, type1, id1); 
         glovesArray.add(addGloves);
       
         for (i = 0; i < NUM_CLOTHES && i < glovesArray.size(); ++i) {
            if (glovesArray.get(i) == null) { // Clear table entries 
               clothingListTable1.setValueAt(null, i, num0);
               clothingListTable1.setValueAt(null, i, num1);
               clothingListTable1.setValueAt(null, i, num2);
               clothingListTable1.setValueAt(null, i, num3);
               clothingListTable1.setValueAt(null, i, num4);
               clothingListTable1.setValueAt(null, i, num5);
               clothingListTable1.setValueAt(null, i, num6);
            }
            else {                             // Update table with content in the clothingListArray ArrayList
               clothingListTable1.setValueAt(glovesArray.get(i).getStackable(), i, num0);
               clothingListTable1.setValueAt(glovesArray.get(i).getPermanent(), i, num1);
               clothingListTable1.setValueAt(glovesArray.get(i).getSeason(), i, num2);
               clothingListTable1.setValueAt(glovesArray.get(i).getColor(), i, num3);
               clothingListTable1.setValueAt(glovesArray.get(i).getOccasion(), i, num4);
               clothingListTable1.setValueAt(glovesArray.get(i).getType(), i, num5);
               clothingListTable1.setValueAt(glovesArray.get(i).getID(), i, num6);
            }
         }  
      }
      else if(sourceEvent == addHatsButton){
         //getting all the values in the input table so that a new clothing object can be made from the specified attributes      
         String stackable2 = (String)trufalsBox2.getSelectedItem();
         String permanent2 = (String)yesnoBox2.getSelectedItem();
         String season2 = (String)seasonsBox2.getSelectedItem();
         String color2 = (String)colorsBox2.getSelectedItem();
         String occasion2 = (String)occasionsBox2.getSelectedItem();
         String id2 = idField1.getText();
         //get the specific type for Hats
         String type2 = (String)typesHatsBox.getSelectedItem();
         //add the clothing type         
         Hat addHats = new Hat(stackable2, permanent2, season2, color2, occasion2, type2, id2); 
         hatArray.add(addHats);
       
         for (i = 0; i < NUM_CLOTHES && i < hatArray.size(); ++i) {
            if (hatArray.get(i) == null) { // Clear table entries 
               clothingListTable2.setValueAt(null, i, num0);
               clothingListTable2.setValueAt(null, i, num1);
               clothingListTable2.setValueAt(null, i, num2);
               clothingListTable2.setValueAt(null, i, num3);
               clothingListTable2.setValueAt(null, i, num4);
               clothingListTable2.setValueAt(null, i, num5);
               clothingListTable2.setValueAt(null, i, num6);
            }
            else {                             // Update table with content in the clothingListArray ArrayList
               clothingListTable2.setValueAt(hatArray.get(i).getStackable(), i, num0);
               clothingListTable2.setValueAt(hatArray.get(i).getPermanent(), i, num1);
               clothingListTable2.setValueAt(hatArray.get(i).getSeason(), i, num2);
               clothingListTable2.setValueAt(hatArray.get(i).getColor(), i, num3);
               clothingListTable2.setValueAt(hatArray.get(i).getOccasion(), i, num4);
               clothingListTable2.setValueAt(hatArray.get(i).getType(), i, num5);
               clothingListTable2.setValueAt(hatArray.get(i).getID(), i, num6);
            }
         }  
      }
      else if(sourceEvent == addJacketsButton){
         //getting all the values in the input table so tjacket a new clothing object can be made from the specified attributes      
         String stackable3 = (String)trufalsBox3.getSelectedItem();
         String permanent3 = (String)yesnoBox3.getSelectedItem();
         String season3 = (String)seasonsBox3.getSelectedItem();
         String color3 = (String)colorsBox3.getSelectedItem();
         String occasion3 = (String)occasionsBox3.getSelectedItem();
         String id3 = idField1.getText();
         //get the specific type for Jackets
         String type3 = (String)typesJacketsBox.getSelectedItem();
         //add the clothing type         
         Jacket addJackets = new Jacket(stackable3, permanent3, season3, color3, occasion3, type3, id3); 
         jacketArray.add(addJackets);
       
         for (i = 0; i < NUM_CLOTHES && i < jacketArray.size(); ++i) {
            if (jacketArray.get(i) == null) { // Clear table entries 
               clothingListTable3.setValueAt(null, i, num0);
               clothingListTable3.setValueAt(null, i, num1);
               clothingListTable3.setValueAt(null, i, num3);
               clothingListTable3.setValueAt(null, i, num3);
               clothingListTable3.setValueAt(null, i, num4);
               clothingListTable3.setValueAt(null, i, num5);
               clothingListTable3.setValueAt(null, i, num6);
            }
            else {                             // Update table with content in the clothingListArray ArrayList
               clothingListTable3.setValueAt(jacketArray.get(i).getStackable(), i, num0);
               clothingListTable3.setValueAt(jacketArray.get(i).getPermanent(), i, num1);
               clothingListTable3.setValueAt(jacketArray.get(i).getSeason(), i, num2);
               clothingListTable3.setValueAt(jacketArray.get(i).getColor(), i, num3);
               clothingListTable3.setValueAt(jacketArray.get(i).getOccasion(), i, num4);
               clothingListTable3.setValueAt(jacketArray.get(i).getType(), i, num5);
               clothingListTable3.setValueAt(jacketArray.get(i).getID(), i, num6);
            }
         }  
      }
      else if(sourceEvent == addScarfsButton){
         //getting all the values in the input table so tjacket a new clothing object can be made from the specified attributes      
         String stackable4 = (String)trufalsBox4.getSelectedItem();
         String permanent4 = (String)yesnoBox4.getSelectedItem();
         String season4 = (String)seasonsBox4.getSelectedItem();
         String color4 = (String)colorsBox4.getSelectedItem();
         String occasion4 = (String)occasionsBox4.getSelectedItem();
         String id4 = idField1.getText();
         //get the specific type for Scarfs
         String type4 = (String)typesScarfsBox.getSelectedItem();
         //add the clothing type         
         Scarf addScarfs = new Scarf(stackable4, permanent4, season4, color4, occasion4, type4, id4); 
         scarfArray.add(addScarfs);
       
         for (i = 0; i < NUM_CLOTHES && i < scarfArray.size(); ++i) {
            if (scarfArray.get(i) == null) { // Clear table entries 
               clothingListTable4.setValueAt(null, i, num0);
               clothingListTable4.setValueAt(null, i, num1);
               clothingListTable4.setValueAt(null, i, num4);
               clothingListTable4.setValueAt(null, i, num4);
               clothingListTable4.setValueAt(null, i, num4);
               clothingListTable4.setValueAt(null, i, num5);
               clothingListTable4.setValueAt(null, i, num6);
            }
            else {                             // Update table with content in the clothingListArray ArrayList
               clothingListTable4.setValueAt(scarfArray.get(i).getStackable(), i, num0);
               clothingListTable4.setValueAt(scarfArray.get(i).getPermanent(), i, num1);
               clothingListTable4.setValueAt(scarfArray.get(i).getSeason(), i, num2);
               clothingListTable4.setValueAt(scarfArray.get(i).getColor(), i, num3);
               clothingListTable4.setValueAt(scarfArray.get(i).getOccasion(), i, num4);
               clothingListTable4.setValueAt(scarfArray.get(i).getType(), i, num5);
               clothingListTable4.setValueAt(scarfArray.get(i).getID(), i, num6);
            }
         }  
      }
      else if(sourceEvent == addShirtsButton){
         //getting all the values in the input table so tjacket a new clothing object can be made from the specified attributes      
         String stackable5 = (String)trufalsBox5.getSelectedItem();
         String permanent5 = (String)yesnoBox5.getSelectedItem();
         String season5 = (String)seasonsBox5.getSelectedItem();
         String color5 = (String)colorsBox5.getSelectedItem();
         String occasion5 = (String)occasionsBox5.getSelectedItem();
         String id5 = idField5.getText();
         //get the specific type for Shirts
         String type5 = (String)typesShirtsBox.getSelectedItem();
         //add the clothing type         
         Shirt addShirts = new Shirt(stackable5, permanent5, season5, color5, occasion5, type5, id5); 
         shirtArray.add(addShirts);
       
         for (i = 0; i < NUM_CLOTHES && i < shirtArray.size(); ++i) {
            if (shirtArray.get(i) == null) { // Clear table entries 
               clothingListTable5.setValueAt(null, i, num0);
               clothingListTable5.setValueAt(null, i, num1);
               clothingListTable5.setValueAt(null, i, num2);
               clothingListTable5.setValueAt(null, i, num3);
               clothingListTable5.setValueAt(null, i, num4);
               clothingListTable5.setValueAt(null, i, num5);
               clothingListTable5.setValueAt(null, i, num6);
            }
            else {                             // Update table with content in the clothingListArray ArrayList
               clothingListTable5.setValueAt(shirtArray.get(i).getStackable(), i, num0);
               clothingListTable5.setValueAt(shirtArray.get(i).getPermanent(), i, num1);
               clothingListTable5.setValueAt(shirtArray.get(i).getSeason(), i, num2);
               clothingListTable5.setValueAt(shirtArray.get(i).getColor(), i, num3);
               clothingListTable5.setValueAt(shirtArray.get(i).getOccasion(), i, num4);
               clothingListTable5.setValueAt(shirtArray.get(i).getType(), i, num5);
               clothingListTable5.setValueAt(shirtArray.get(i).getID(), i, num6);
            }
         }  
      }
      else if(sourceEvent == addPantsButton){
         //getting all the values in the input table so tjacket a new clothing object can be made from the specified attributes      
         String stackable6 = (String)trufalsBox6.getSelectedItem();
         String permanent6 = (String)yesnoBox6.getSelectedItem();
         String season6 = (String)seasonsBox6.getSelectedItem();
         String color6 = (String)colorsBox6.getSelectedItem();
         String occasion6 = (String)occasionsBox6.getSelectedItem();
         String id6 = idField6.getText();
         //get the specific type for Pants
         String type6 = (String)typesPantsBox.getSelectedItem();
         //add the clothing type         
         Pants addPants = new Pants(stackable6, permanent6, season6, color6, occasion6, type6, id6); 
         pantsArray.add(addPants);
       
         for (i = 0; i < NUM_CLOTHES && i < pantsArray.size(); ++i) {
            if (pantsArray.get(i) == null) { // Clear table entries 
               clothingListTable6.setValueAt(null, i, num0);
               clothingListTable6.setValueAt(null, i, num1);
               clothingListTable6.setValueAt(null, i, num2);
               clothingListTable6.setValueAt(null, i, num3);
               clothingListTable6.setValueAt(null, i, num4);
               clothingListTable6.setValueAt(null, i, num5);
               clothingListTable6.setValueAt(null, i, num6);
            }
            else {                             // Update table with content in the clothingListArray ArrayList
               clothingListTable6.setValueAt(pantsArray.get(i).getStackable(), i, num0);
               clothingListTable6.setValueAt(pantsArray.get(i).getPermanent(), i, num1);
               clothingListTable6.setValueAt(pantsArray.get(i).getSeason(), i, num2);
               clothingListTable6.setValueAt(pantsArray.get(i).getColor(), i, num3);
               clothingListTable6.setValueAt(pantsArray.get(i).getOccasion(), i, num4);
               clothingListTable6.setValueAt(pantsArray.get(i).getType(), i, num5);
               clothingListTable6.setValueAt(pantsArray.get(i).getID(), i, num6);
            }
         }  
      }
      else if(sourceEvent == addShoesButton){
         //getting all the values in the input table so tjacket a new clothing object can be made from the specified attributes      
         String stackable7 = (String)trufalsBox7.getSelectedItem();
         String permanent7 = (String)yesnoBox7.getSelectedItem();
         String season7 = (String)seasonsBox7.getSelectedItem();
         String color7 = (String)colorsBox7.getSelectedItem();
         String occasion7 = (String)occasionsBox7.getSelectedItem();
         String id7 = idField7.getText();
         //get the specific type for Shoes
         String type7 = (String)typesShoesBox.getSelectedItem();
         //add the clothing type         
         Shoe addShoes = new Shoe(stackable7, permanent7, season7, color7, occasion7, type7, id7); 
         shoeArray.add(addShoes);
       
         for (i = 0; i < NUM_CLOTHES && i < shoeArray.size(); ++i) {
            if (shoeArray.get(i) == null) { // Clear table entries 
               clothingListTable7.setValueAt(null, i, num0);
               clothingListTable7.setValueAt(null, i, num1);
               clothingListTable7.setValueAt(null, i, num2);
               clothingListTable7.setValueAt(null, i, num3);
               clothingListTable7.setValueAt(null, i, num4);
               clothingListTable7.setValueAt(null, i, num5);
               clothingListTable7.setValueAt(null, i, num6);
            }
            else {                             // Update table with content in the clothingListArray ArrayList
               clothingListTable7.setValueAt(shoeArray.get(i).getStackable(), i, num0);
               clothingListTable7.setValueAt(shoeArray.get(i).getPermanent(), i, num1);
               clothingListTable7.setValueAt(shoeArray.get(i).getSeason(), i, num2);
               clothingListTable7.setValueAt(shoeArray.get(i).getColor(), i, num3);
               clothingListTable7.setValueAt(shoeArray.get(i).getOccasion(), i, num4);
               clothingListTable7.setValueAt(shoeArray.get(i).getType(), i, num5);
               clothingListTable7.setValueAt(shoeArray.get(i).getID(), i, num6);
            }
         }  
      }
      
      else if(sourceEvent == addSocksButton){
         //getting all the values in the input table so tjacket a new clothing object can be made from the specified attributes      
         String stackable8 = (String)trufalsBox8.getSelectedItem();
         String permanent8 = (String)yesnoBox8.getSelectedItem();
         String season8 = (String)seasonsBox8.getSelectedItem();
         String color8 = (String)colorsBox8.getSelectedItem();
         String occasion8 = (String)occasionsBox8.getSelectedItem();
         String id8 = idField8.getText();
         //get the specific type for Socks
         String type8 = (String)typesSocksBox.getSelectedItem();
         //add the clothing type         
         Sock addSocks = new Sock(stackable8, permanent8, season8, color8, occasion8, type8, id8); 
         sockArray.add(addSocks);
       
         for (i = 0; i < NUM_CLOTHES && i < sockArray.size(); ++i) {
            if (sockArray.get(i) == null) { // Clear table entries 
               clothingListTable8.setValueAt(null, i, num0);
               clothingListTable8.setValueAt(null, i, num1);
               clothingListTable8.setValueAt(null, i, num2);
               clothingListTable8.setValueAt(null, i, num3);
               clothingListTable8.setValueAt(null, i, num4);
               clothingListTable8.setValueAt(null, i, num5);
               clothingListTable8.setValueAt(null, i, num6);
            }
            else {                             // Update table with content in the clothingListArray ArrayList
               clothingListTable8.setValueAt(sockArray.get(i).getStackable(), i, num0);
               clothingListTable8.setValueAt(sockArray.get(i).getPermanent(), i, num1);
               clothingListTable8.setValueAt(sockArray.get(i).getSeason(), i, num2);
               clothingListTable8.setValueAt(sockArray.get(i).getColor(), i, num3);
               clothingListTable8.setValueAt(sockArray.get(i).getOccasion(), i, num4);
               clothingListTable8.setValueAt(sockArray.get(i).getType(), i, num5);
               clothingListTable8.setValueAt(sockArray.get(i).getID(), i, num6);
            }
         }  
      }
      
         
}         

}