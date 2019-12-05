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
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;
import java.util.*;
import java.io.*;
import java.net.*;
import java.net.URL;

public class TabDemoEXP implements ActionListener{
    protected String temp;
    protected String condition; 
    ////////////////////////WEATHER FETCHER/////////////////////////////////
    public void fetchWeather(String zip){
      
      String API_KEY = "10f1da3b41ce747a4adbf1960794ffe2";
      String LOCATION = zip + ",us";
      String urlString = "http://api.openweathermap.org/data/2.5/weather?q="+LOCATION + "&appid=" +API_KEY+"&units=imperial";
      
      try{
      StringBuilder result = new StringBuilder();
      URL url = new URL(urlString);
      URLConnection conn = url.openConnection();
      BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
      String line;
      
      while((line = rd.readLine()) != null){
         result.append(line);
      }
      rd.close();
      String data = result.toString();
      
      int index = data.indexOf("temp");
      String temp = "" + data.substring(index+6,index+10);
      this.temp = temp;
      
      int index1 = data.indexOf("main");
      String yeet = data.substring(index1+7,index1+18);
      int index2 = yeet.indexOf(",");
      this.condition = yeet.substring(0,index2-1); 
    }
    
    catch(IOException e){
      System.out.println(e.getMessage());
    }
    }
    ////////////////////////////////////////////////////////////////////////
    
    //WEATHER VARIABLE
    private String zipcode;
    
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
    private ArrayList<Glasses> glassesArray = new ArrayList();
    private ArrayList<Glove> glovesArray = new ArrayList();
    private ArrayList<Hat> hatArray = new ArrayList();
    private ArrayList<Jacket> jacketArray = new ArrayList();
    private ArrayList<Scarf> scarfArray = new ArrayList();
    private ArrayList<Shirt> shirtArray = new ArrayList();
    private ArrayList<Pants> pantsArray = new ArrayList();
    private ArrayList<Sock> sockArray = new ArrayList();
    private ArrayList<Shoe> shoeArray = new ArrayList();
    
    //Create a Warddrobe object 
    Warddrobe warddrobe = new Warddrobe(hatArray, scarfArray, glassesArray, shirtArray, jacketArray, glovesArray, pantsArray, sockArray, shoeArray);
        
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
    
    //JButton to remove clothes from the table
    private JButton removeGlassesButton;
    private JButton removeGlovesButton;
    private JButton removeHatsButton;
    private JButton removeJacketsButton;
    private JButton removeScarfsButton;
    private JButton removeShirtsButton;
    private JButton removePantsButton;
    private JButton removeSocksButton;
    private JButton removeShoesButton;
    //JLabels for each remove button
    private JLabel removeGlassesLabel;
    private JLabel removeGlovesLabel;
    private JLabel removeHatsLabel;
    private JLabel removeJacketsLabel;
    private JLabel removeScarfsLabel;
    private JLabel removeShirtsLabel;
    private JLabel removePantsLabel;
    private JLabel removeSocksLabel;
    private JLabel removeShoesLabel;
    //JTextField's for each remove button where users will enter their ID 
    private JTextField removeGlassesField;
    private JTextField removeGlovesField;
    private JTextField removeHatsField;
    private JTextField removeJacketsField;
    private JTextField removeScarfsField;
    private JTextField removeShirtsField;
    private JTextField removePantsField;
    private JTextField removeSocksField;
    private JTextField removeShoesField;
    
    //*******GLASSES VARIABLES*********
    //*********************************
    //Box for types - I NEED TO ADD DIFFERENT TYPES FOR EACH DIFFERENT CLOTHING TYPE
    String[] typesGlassesArray = {"Sunglasses","Prescription Glasses"};
    JComboBox typesGlassesBox = new JComboBox(typesGlassesArray);
    //Box for yes and no
    String[] yesnoArray = {"true", "false"};
    JComboBox yesnoBox = new JComboBox(yesnoArray);
    //Box for True and False
    String[] trufalsArray = {"true", "false"};
    JComboBox trufalsBox = new JComboBox(trufalsArray);
    //Box for season types
    String[] seasonsArray = {"Winter", "Spring", "Summer", "Fall"};
    JComboBox seasonsBox = new JComboBox(seasonsArray);
    //Box for Colors
    String[] colorsArray = {"Beige", "Gray", "Pink", "Purple", "Red", "Brown", "Orange", "Yellow", "Olive", "Green", "Blue", "Black", "White", "Lime", "Cyan", "Violet", "Turquoise"};
    JComboBox colorsBox = new JComboBox(colorsArray);
    //Box for occasions
    String[] occasionsArray = {"Formal", "Nice", "Casual"};
    JComboBox occasionsBox = new JComboBox(occasionsArray);
    
    
    //TextField names for all the various attributes that will be needed for Clothing types
    private JFormattedTextField idField = new JFormattedTextField("");      
    
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
    String[] yesnoArray1 = {"true", "false"};
    JComboBox yesnoBox1 = new JComboBox(yesnoArray1);
    //Box for True and False
    String[] trufalsArray1 = {"true", "false"};
    JComboBox trufalsBox1 = new JComboBox(trufalsArray1);
    //Box for season types
    String[] seasonsArray1 = {"Winter", "Spring", "Summer", "Fall"};
    JComboBox seasonsBox1 = new JComboBox(seasonsArray1);
    //Box for Colors
    String[] colorsArray1 = {"Beige", "Gray", "Pink", "Purple", "Red", "Brown", "Orange", "Yellow", "Olive", "Green", "Blue", "Black", "White", "Lime", "Cyan", "Violet", "Turquoise"};
    JComboBox colorsBox1 = new JComboBox(colorsArray1);
    //Box for occasions
    String[] occasionsArray1 = {"Formal", "Nice", "Casual"};
    JComboBox occasionsBox1 = new JComboBox(occasionsArray1);
    
    //TextField names for all the various attributes that will be needed for Clothing types
    JFormattedTextField idField1 = new JFormattedTextField("");     
    
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
    String[] typesGlovesArray = {"Velvet", "Leather", "Silk"};
    JComboBox typesGlovesBox = new JComboBox(typesGlovesArray);
    
    //*******HATS VARIABLES*********
    //*********************************
    //Box for types - I NEED TO ADD DIFFERENT TYPES FOR EACH DIFFERENT CLOTHING TYPE
    String[] typesHatsArray = {"Top Hat", "Fedora", "Sombrero", "Sports Cap", "Sun Hat"};
    JComboBox typesHatsBox = new JComboBox(typesHatsArray);
    //Box for yes and no
    String[] yesnoArray2 = {"true", "false"};
    JComboBox yesnoBox2 = new JComboBox(yesnoArray2);
    //Box for True and False
    String[] trufalsArray2 = {"true", "false"};
    JComboBox trufalsBox2 = new JComboBox(trufalsArray2);
    //Box for season types
    String[] seasonsArray2 = {"Winter", "Spring", "Summer", "Fall"};
    JComboBox seasonsBox2 = new JComboBox(seasonsArray2);
    //Box for Colors
    String[] colorsArray2 = {"Beige", "Gray", "Pink", "Purple", "Red", "Brown", "Orange", "Yellow", "Olive", "Green", "Blue", "Black", "White", "Lime", "Cyan", "Violet", "Turquoise"};
    JComboBox colorsBox2 = new JComboBox(colorsArray2);
    //Box for occasions
    String[] occasionsArray2 = {"Formal", "Nice", "Casual"};
    JComboBox occasionsBox2 = new JComboBox(occasionsArray2);
    
    //TextField names for all the various attributes that will be needed for Clothing types
    private JFormattedTextField idField2 = new JFormattedTextField("");      
    
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
    String[] typesJacketsArray = {"Vest", "Leather", "Sweatshirt", "Hoodie", "Sweater", "Trenchcoat"};
    JComboBox typesJacketsBox = new JComboBox(typesJacketsArray);
    //Box for yes and no
    String[] yesnoArray3 = {"true", "false"};
    JComboBox yesnoBox3 = new JComboBox(yesnoArray3);
    //Box for True and False
    String[] trufalsArray3 = {"true", "false"};
    JComboBox trufalsBox3 = new JComboBox(trufalsArray3);
    //Box for season types
    String[] seasonsArray3 = {"Winter", "Spring", "Summer", "Fall"};
    JComboBox seasonsBox3 = new JComboBox(seasonsArray3);
    //Box for Colors
    String[] colorsArray3 = {"Beige", "Gray", "Pink", "Purple", "Red", "Brown", "Orange", "Yellow", "Olive", "Green", "Blue", "Black", "White", "Lime", "Cyan", "Violet", "Turquoise"};
    JComboBox colorsBox3 = new JComboBox(colorsArray3);
    //Box for occasions
    String[] occasionsArray3 = {"Formal", "Nice", "Casual"};
    JComboBox occasionsBox3 = new JComboBox(occasionsArray3);
    
    //TextField names for all the various attributes that will be needed for Clothing types
    private JFormattedTextField idField3 = new JFormattedTextField("");      
   
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
    String[] typesScarfsArray = {"Fur", "Wool", "Silk", "Plaid"};
    JComboBox typesScarfsBox = new JComboBox(typesScarfsArray);
    //Box for yes and no
    String[] yesnoArray4 = {"true", "false"};
    JComboBox yesnoBox4 = new JComboBox(yesnoArray4);
    //Box for True and False
    String[] trufalsArray4 = {"true", "false"};
    JComboBox trufalsBox4 = new JComboBox(trufalsArray4);
    //Box for season types
    String[] seasonsArray4 = {"Winter", "Spring", "Summer", "Fall"};
    JComboBox seasonsBox4 = new JComboBox(seasonsArray4);
    //Box for Colors
    String[] colorsArray4 = {"Beige", "Gray", "Pink", "Purple", "Red", "Brown", "Orange", "Yellow", "Olive", "Green", "Blue", "Black", "White", "Lime", "Cyan", "Violet", "Turquoise"};
    JComboBox colorsBox4 = new JComboBox(colorsArray4);
    //Box for occasions
    String[] occasionsArray4 = {"Formal", "Nice", "Casual"};
    JComboBox occasionsBox4 = new JComboBox(occasionsArray4);
    
    
    //TextField names for all the various attributes tjacket will be needed for Clothing types
    private JFormattedTextField idField4 = new JFormattedTextField("");      
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
    String[] typesShirtsArray = {"Long Sleeved Cotton", "Short Sleeved Cotton", "Long Sleeved Athletic", "Short Sleeved Athletic", "Long Sleeved Wool", "Short Sleeved Wool", "Muscle Shirt"};
    JComboBox typesShirtsBox = new JComboBox(typesShirtsArray);
    //Box for yes and no
    String[] yesnoArray5 = {"true", "false"};
    JComboBox yesnoBox5 = new JComboBox(yesnoArray5);
    //Box for True and False
    String[] trufalsArray5 = {"true", "false"};
    JComboBox trufalsBox5 = new JComboBox(trufalsArray5);
    //Box for season types
    String[] seasonsArray5 = {"Winter", "Spring", "Summer", "Fall"};
    JComboBox seasonsBox5 = new JComboBox(seasonsArray5);
    //Box for Colors
    String[] colorsArray5 = {"Beige", "Gray", "Pink", "Purple", "Red", "Brown", "Orange", "Yellow", "Olive", "Green", "Blue", "Black", "White", "Lime", "Cyan", "Violet", "Turquoise"};
    JComboBox colorsBox5 = new JComboBox(colorsArray5);
    //Box for occasions
    String[] occasionsArray5 = {"Formal", "Nice", "Casual"};
    JComboBox occasionsBox5 = new JComboBox(occasionsArray5);
    
    //TextField names for all the various attributes tjacket will be needed for Clothing types
    private JFormattedTextField idField5 = new JFormattedTextField("");      
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
    String[] typesPantsArray = {"Jean Shorts", "Jean Pants", "Khaki Pants", "Khaki Shorts", "Sport Pants", "Athletic Shorts", "Lined Jeans"};
    JComboBox typesPantsBox = new JComboBox(typesPantsArray);
    //Box for yes and no
    String[] yesnoArray6 = {"true", "false"};
    JComboBox yesnoBox6 = new JComboBox(yesnoArray6);
    //Box for True and False
    String[] trufalsArray6 = {"true", "false"};
    JComboBox trufalsBox6 = new JComboBox(trufalsArray6);
    //Box for season types
    String[] seasonsArray6 = {"Winter", "Spring", "Summer", "Fall"};
    JComboBox seasonsBox6 = new JComboBox(seasonsArray6);
    //Box for Colors
    String[] colorsArray6 = {"Beige", "Gray", "Pink", "Purple", "Red", "Brown", "Orange", "Yellow", "Olive", "Green", "Blue", "Black", "White", "Lime", "Cyan", "Violet", "Turquoise"};
    JComboBox colorsBox6 = new JComboBox(colorsArray6);
    //Box for occasions
    String[] occasionsArray6 = {"Formal", "Nice", "Casual"};
    JComboBox occasionsBox6 = new JComboBox(occasionsArray6);
    
    
    //TextField names for all the various attributes tjacket will be needed for Clothing types
    private JFormattedTextField idField6 = new JFormattedTextField("");      
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
    String[] typesShoesArray = {"Sneakers", "Flip Flops", "Basketball", "Cleats", "Nike", "Adidas", "Sperry", "Suede", "Dress", "Boots"};
    JComboBox typesShoesBox = new JComboBox(typesShoesArray);
    //Box for yes and no
    String[] yesnoArray7 = {"true", "false"};
    JComboBox yesnoBox7 = new JComboBox(yesnoArray7);
    //Box for True and False
    String[] trufalsArray7 = {"true", "false"};
    JComboBox trufalsBox7 = new JComboBox(trufalsArray7);
    //Box for season types
    String[] seasonsArray7 = {"Winter", "Spring", "Summer", "Fall"};
    JComboBox seasonsBox7 = new JComboBox(seasonsArray7);
    //Box for Colors
    String[] colorsArray7 = {"Beige", "Gray", "Pink", "Purple", "Red", "Brown", "Orange", "Yellow", "Olive", "Green", "Blue", "Black", "White", "Lime", "Cyan", "Violet", "Turquoise"};
    JComboBox colorsBox7 = new JComboBox(colorsArray7);
    //Box for occasions
    String[] occasionsArray7 = {"Formal", "Nice", "Casual"};
    JComboBox occasionsBox7 = new JComboBox(occasionsArray7);
    
    
    //TextField names for all the various attributes tjacket will be needed for Clothing types
    private JFormattedTextField idField7 = new JFormattedTextField("");      
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
    String[] typesSocksArray = {"Long Wool", "Nike", "Ankle", "Silk"};
    JComboBox typesSocksBox = new JComboBox(typesSocksArray);
    //Box for yes and no
    String[] yesnoArray8 = {"true", "false"};
    JComboBox yesnoBox8 = new JComboBox(yesnoArray8);
    //Box for True and False
    String[] trufalsArray8 = {"true", "false"};
    JComboBox trufalsBox8 = new JComboBox(trufalsArray8);
    //Box for season types
    String[] seasonsArray8 = {"Winter", "Spring", "Summer", "Fall"};
    JComboBox seasonsBox8 = new JComboBox(seasonsArray8);
    //Box for Colors
    String[] colorsArray8 = {"Beige", "Gray", "Pink", "Purple", "Red", "Brown", "Orange", "Yellow", "Olive", "Green", "Blue", "Black", "White", "Lime", "Cyan", "Violet", "Turquoise"};
    JComboBox colorsBox8 = new JComboBox(colorsArray8);
    //Box for occasions
    String[] occasionsArray8 = {"Formal", "Nice", "Casual"};
    JComboBox occasionsBox8 = new JComboBox(occasionsArray8);
    
    
    //TextField names for all the various attributes tjacket will be needed for Clothing types
    private JFormattedTextField idField8 = new JFormattedTextField("");      
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
    
    //**********************************************THIS IS A METHOD AND GOES WITH ALL THE OTHER FILE READERS 
    //GLASSES FILE READER METHOD THIS IS WHERE I READ INTO A FILE ALL OF THE  HAT ARRAY TO SAVE THE DATA 
    //************************************************
    public void generateGlassesFile(){
      try{
      PrintWriter writer = new PrintWriter("glassesFile.txt", "UTF-8");
      
      ArrayList<Glasses> hg = warddrobe.getGlassesArray();
      for(int z = 0; z<hg.size();z++){
         writer.println(hg.get(z).getStackable());
         writer.println(hg.get(z).getPermanent());
         writer.println(hg.get(z).getSeason());
         writer.println(hg.get(z).getColor());
         writer.println(hg.get(z).getOccasion());
         writer.println(hg.get(z).getType());
         writer.println(hg.get(z).getID());
      }
      writer.close();
      } catch(IOException e){
        e.printStackTrace();
      }
   
   }
   //**********************************************THIS IS A METHOD AND GOES WITH ALL THE OTHER FILE READERS 
    //GLOVES FILE READER METHOD THIS IS WHERE I READ INTO A FILE ALL OF THE  HAT ARRAY TO SAVE THE DATA 
    //************************************************
    public void generateGlovesFile(){
      try{
      PrintWriter writer = new PrintWriter("glovesFile.txt", "UTF-8");
      
      ArrayList<Glove> hgl = warddrobe.getGlovesArray();
      for(int z = 0; z<hgl.size();z++){
         writer.println(hgl.get(z).getStackable());
         writer.println(hgl.get(z).getPermanent());
         writer.println(hgl.get(z).getSeason());
         writer.println(hgl.get(z).getColor());
         writer.println(hgl.get(z).getOccasion());
         writer.println(hgl.get(z).getType());
         writer.println(hgl.get(z).getID());
      }
      writer.close();
      } catch(IOException e){
        e.printStackTrace();
      }
   
   }
    //**********************************************
    //HAT FILE READER METHOD THIS IS WHERE I READ INTO A FILE ALL OF THE  HAT ARRAY TO SAVE THE DATA 
    //************************************************
    public void generateHatFile(){
      try{
      PrintWriter writer = new PrintWriter("hatFile.txt", "UTF-8");
      
      ArrayList<Hat> h = warddrobe.getHatArray();
      for(int z = 0; z<h.size();z++){
         writer.println(h.get(z).getStackable());
         writer.println(h.get(z).getPermanent());
         writer.println(h.get(z).getSeason());
         writer.println(h.get(z).getColor());
         writer.println(h.get(z).getOccasion());
         writer.println(h.get(z).getType());
         writer.println(h.get(z).getID());
      }
      writer.close();
      } catch(IOException e){
        e.printStackTrace();
      }
   
   }
    //**********************************************THIS IS A METHOD AND GOES WITH ALL THE OTHER FILE READERS 
    //Jacket FILE READER METHOD THIS IS WHERE I READ INTO A FILE ALL OF THE  HAT ARRAY TO SAVE THE DATA 
    //************************************************
    public void generateJacketsFile(){
      try{
      PrintWriter writer = new PrintWriter("jacketsFile.txt", "UTF-8");
      
      ArrayList<Jacket> hglj = warddrobe.getJacketArray();
      for(int z = 0; z<hglj.size();z++){
         writer.println(hglj.get(z).getStackable());
         writer.println(hglj.get(z).getPermanent());
         writer.println(hglj.get(z).getSeason());
         writer.println(hglj.get(z).getColor());
         writer.println(hglj.get(z).getOccasion());
         writer.println(hglj.get(z).getType());
         writer.println(hglj.get(z).getID());
      }
      writer.close();
      } catch(IOException e){
        e.printStackTrace();
      }
   
   }
   //**********************************************THIS IS A METHOD AND GOES WITH ALL THE OTHER FILE READERS 
    //SCARVES FILE READER METHOD THIS IS WHERE I READ INTO A FILE ALL OF THE  HAT ARRAY TO SAVE THE DATA 
    //************************************************
    public void generateScarfsFile(){
      try{
      PrintWriter writer = new PrintWriter("scarfsFile.txt", "UTF-8");
      
      ArrayList<Scarf> hgljs = warddrobe.getScarfArray();
      for(int z = 0; z<hgljs.size();z++){
         writer.println(hgljs.get(z).getStackable());
         writer.println(hgljs.get(z).getPermanent());
         writer.println(hgljs.get(z).getSeason());
         writer.println(hgljs.get(z).getColor());
         writer.println(hgljs.get(z).getOccasion());
         writer.println(hgljs.get(z).getType());
         writer.println(hgljs.get(z).getID());
      }
      writer.close();
      } catch(IOException e){
        e.printStackTrace();
      }
   
   }
   //**********************************************THIS IS A METHOD AND GOES WITH ALL THE OTHER FILE READERS 
    //SHIRTS FILE READER METHOD THIS IS WHERE I READ INTO A FILE ALL OF THE  HAT ARRAY TO SAVE THE DATA 
    //************************************************
    public void generateShirtsFile(){
      try{
      PrintWriter writer = new PrintWriter("shirtsFile.txt", "UTF-8");
      
      ArrayList<Shirt> hgljss = warddrobe.getShirtArray();
      for(int z = 0; z<hgljss.size();z++){
         writer.println(hgljss.get(z).getStackable());
         writer.println(hgljss.get(z).getPermanent());
         writer.println(hgljss.get(z).getSeason());
         writer.println(hgljss.get(z).getColor());
         writer.println(hgljss.get(z).getOccasion());
         writer.println(hgljss.get(z).getType());
         writer.println(hgljss.get(z).getID());
      }
      writer.close();
      } catch(IOException e){
        e.printStackTrace();
      }
   
   }
   //**********************************************THIS IS A METHOD AND GOES WITH ALL THE OTHER FILE READERS 
    //PANTS FILE READER METHOD THIS IS WHERE I READ INTO A FILE ALL OF THE  HAT ARRAY TO SAVE THE DATA 
    //************************************************
    public void generatePantsFile(){
      try{
      PrintWriter writer = new PrintWriter("pantssFile.txt", "UTF-8");
      
      ArrayList<Pants> hgljssp = warddrobe.getPantsArray();
      for(int z = 0; z<hgljssp.size();z++){
         writer.println(hgljssp.get(z).getStackable());
         writer.println(hgljssp.get(z).getPermanent());
         writer.println(hgljssp.get(z).getSeason());
         writer.println(hgljssp.get(z).getColor());
         writer.println(hgljssp.get(z).getOccasion());
         writer.println(hgljssp.get(z).getType());
         writer.println(hgljssp.get(z).getID());
      }
      writer.close();
      } catch(IOException e){
        e.printStackTrace();
      }
   
   }
   //**********************************************THIS IS A METHOD AND GOES WITH ALL THE OTHER FILE READERS 
    //SHOES FILE READER METHOD THIS IS WHERE I READ INTO A FILE ALL OF THE  HAT ARRAY TO SAVE THE DATA 
    //************************************************
    public void generateShoesFile(){
      try{
      PrintWriter writer = new PrintWriter("shoesFile.txt", "UTF-8");
      
      ArrayList<Shoe> hgljssps = warddrobe.getShoesArray();
      for(int z = 0; z<hgljssps.size();z++){
         writer.println(hgljssps.get(z).getStackable());
         writer.println(hgljssps.get(z).getPermanent());
         writer.println(hgljssps.get(z).getSeason());
         writer.println(hgljssps.get(z).getColor());
         writer.println(hgljssps.get(z).getOccasion());
         writer.println(hgljssps.get(z).getType());
         writer.println(hgljssps.get(z).getID());
      }
      writer.close();
      } catch(IOException e){
        e.printStackTrace();
      }
   
   }
   //**********************************************THIS IS A METHOD AND GOES WITH ALL THE OTHER FILE READERS 
    //SOCKS FILE READER METHOD THIS IS WHERE I READ INTO A FILE ALL OF THE  HAT ARRAY TO SAVE THE DATA 
    //************************************************
    public void generateSocksFile(){
      try{
      PrintWriter writer = new PrintWriter("socksFile.txt", "UTF-8");
      
      ArrayList<Sock> hgljsspss = warddrobe.getSocksArray();
      for(int z = 0; z<hgljsspss.size();z++){
         writer.println(hgljsspss.get(z).getStackable());
         writer.println(hgljsspss.get(z).getPermanent());
         writer.println(hgljsspss.get(z).getSeason());
         writer.println(hgljsspss.get(z).getColor());
         writer.println(hgljsspss.get(z).getOccasion());
         writer.println(hgljsspss.get(z).getType());
         writer.println(hgljsspss.get(z).getID());
      }
      writer.close();
      } catch(IOException e){
        e.printStackTrace();
      }
   
   }

    //THE ACTUAL PANE THAT IMPLEMENTS EVERYTHING
    public void addComponentToPane(Container pane) {
        JTabbedPane tabbedPane = new JTabbedPane(); // creating the tab pane
        
        //**************WEATHER PANEL!!!!!!
        //**********************************
        //output of temperature and condition
         JTextArea outputArea = new JTextArea(10, 15);
         outputArea.setEditable(false);
         
         JLabel outputLabel = new JLabel("Weather");
         
         JScrollPane scrollPane = new JScrollPane(outputArea);
        JLabel weatherLabel = new JLabel("Weather");
        
        JLabel changeZipLabel = new JLabel("Enter Zipcode: ");
        
        JTextField changeZipField = new JTextField("    ");
        changeZipField.setEditable(true);
        
        JButton changeZipButton = new JButton("Find Weather");
        changeZipButton.addActionListener(new ActionListener() {
           public void actionPerformed(ActionEvent e) {
               
              zipcode = changeZipField.getText();
              fetchWeather(zipcode);
              System.out.println(temp+" "+condition);
              outputArea.append("Temperature: "+ temp +"\n"+"Condition: "+condition+"\n");
             
            }
         });
         
         //fetchWeather(zipcode);
        
        JPanel weatherPanel = new JPanel();
        
        weatherPanel.setLayout(new GridBagLayout());
        
        GridBagConstraints layoutConstW = null;                  
        NumberFormat currencyFormatW = null;       
        
        
        layoutConstW = new GridBagConstraints();
        layoutConstW.insets = new Insets(10, 10, 5, 1);
        layoutConstW.fill = GridBagConstraints.LINE_END;
        layoutConstW.gridx = 0;
        layoutConstW.gridy = 0;
        weatherPanel.add(changeZipLabel, layoutConstW);
        
        layoutConstW = new GridBagConstraints();
        layoutConstW.insets = new Insets(10, 1, 5, 10);
        layoutConstW.fill = GridBagConstraints.HORIZONTAL;
        layoutConstW.gridx = 1;
        layoutConstW.gridy = 0;
        weatherPanel.add(changeZipField, layoutConstW);
        
        layoutConstW = new GridBagConstraints();
        layoutConstW.insets = new Insets(0, 5, 0, 10);
        layoutConstW.fill = GridBagConstraints.BOTH;
        layoutConstW.gridx = 2;
        layoutConstW.gridy = 0;
        weatherPanel.add(changeZipButton, layoutConstW);
        
         
         
         
         layoutConstW = new GridBagConstraints();
         layoutConstW.insets = new Insets(10, 10, 1, 10);
         layoutConstW.fill = GridBagConstraints.HORIZONTAL;
         layoutConstW.gridx = 0;
         layoutConstW.gridy = 3;
         weatherPanel.add(outputLabel, layoutConstW);
         
         layoutConstW = new GridBagConstraints();
         layoutConstW.insets = new Insets(1, 10, 10, 10);
         layoutConstW.fill = GridBagConstraints.HORIZONTAL;
         layoutConstW.gridx = 0;
         layoutConstW.gridy = 4;
         weatherPanel.add(scrollPane, layoutConstW);
        

        
        // ***GLASSES Panel***
         
        JPanel glassesPanel = new JPanel();
        
        //Create table to add clothes 
        JLabel tableLabel = new JLabel("Glasses");
        
        //the add button
        addGlassesButton = new JButton("Add");
        addGlassesButton.addActionListener(this);
        
        //the remove button and corresponding remove field as well as remove label
        removeGlassesButton = new JButton("Remove");
        removeGlassesButton. addActionListener(this);
        
        removeGlassesLabel = new JLabel("Enter ID to remove:");
        
        removeGlassesField = new JTextField("");
        removeGlassesField.setEditable(true);
        
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
        //new remove button implementation*****************
        layoutConst = new GridBagConstraints();
        layoutConst.insets = new Insets(0, 10, 10, 5);
        layoutConst.fill = GridBagConstraints.HORIZONTAL;
        layoutConst.gridx = 2;
        layoutConst.gridy = 5;
        glassesPanel.add(removeGlassesButton, layoutConst);
        
        layoutConst = new GridBagConstraints();
        layoutConst.insets = new Insets(0, 10, 10, 5);
        layoutConst.fill = GridBagConstraints.HORIZONTAL;
        layoutConst.gridx = 0;
        layoutConst.gridy = 5;
        glassesPanel.add(removeGlassesLabel, layoutConst);
        
        layoutConst = new GridBagConstraints();
        layoutConst.insets = new Insets(0, 10, 10, 5);
        layoutConst.fill = GridBagConstraints.HORIZONTAL;
        layoutConst.gridx = 1;
        layoutConst.gridy = 5;
        glassesPanel.add(removeGlassesField, layoutConst);
        
        //***************************************PUT AT END OF EACH PANEL
        //INSTANTIATING THE GLASSES ARRAY USING THE FILE ALREADY CREATED
         try {
            File file = new File("glassesFile.txt");
            Scanner scan = new Scanner(file);
            
            String stackabl = " ";
            String permanen = " ";
            String seaso = " ";
            String colo = " ";
            String occasio = " ";
            String typ = " ";
            String ide = " ";
            int cntr = 0;
            while(scan.hasNext() && cntr<10){
               stackabl = scan.nextLine();
               permanen = scan.nextLine();
               seaso = scan.nextLine();
               colo = scan.nextLine();
               occasio = scan.nextLine();
               typ = scan.nextLine();
               ide = scan.nextLine();
               glassesArray.add(new Glasses(stackabl, permanen, seaso, colo, occasio, typ, ide));
               
               clothingListTable.setValueAt(glassesArray.get(cntr).getStackable(), cntr, 0);
               clothingListTable.setValueAt(glassesArray.get(cntr).getPermanent(), cntr, 1);
               clothingListTable.setValueAt(glassesArray.get(cntr).getSeason(), cntr, 2);
               clothingListTable.setValueAt(glassesArray.get(cntr).getColor(), cntr, 3);
               clothingListTable.setValueAt(glassesArray.get(cntr).getOccasion(), cntr, 4);
               clothingListTable.setValueAt(glassesArray.get(cntr).getType(), cntr, 5);
               clothingListTable.setValueAt(glassesArray.get(cntr).getID(), cntr, 6);
               
               cntr = cntr + 1;
            }
         } catch (IOException d) {
      d.printStackTrace();
      }
        // ***GLOVES Panel*** 
        
        //VARIABLE DEFINTIONS
              
    //making all the text fields for the input table editable by the user  
        idField.setEditable(true);
    
 
        JPanel glovesPanel = new JPanel();
        
        //Create table to add clothes 
        JLabel tableLabel1 = new JLabel("Gloves");
        
        addGlovesButton = new JButton("Add");
        addGlovesButton.addActionListener(this);
        
        //the remove button and corresponding remove field as well as remove label
        removeGlovesButton = new JButton("Remove");
        removeGlovesButton. addActionListener(this);
        
        removeGlovesLabel = new JLabel("Enter ID to remove:");
        
        removeGlovesField = new JTextField("");
        removeGlovesField.setEditable(true);
        
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
        
        //new remove button implementation*****************
        layoutConst = new GridBagConstraints();
        layoutConst.insets = new Insets(0, 10, 10, 5);
        layoutConst.fill = GridBagConstraints.HORIZONTAL;
        layoutConst.gridx = 2;
        layoutConst.gridy = 5;
        glovesPanel.add(removeGlovesButton, layoutConst);
        
        layoutConst = new GridBagConstraints();
        layoutConst.insets = new Insets(0, 10, 10, 5);
        layoutConst.fill = GridBagConstraints.HORIZONTAL;
        layoutConst.gridx = 0;
        layoutConst.gridy = 5;
        glovesPanel.add(removeGlovesLabel, layoutConst);
        
        layoutConst = new GridBagConstraints();
        layoutConst.insets = new Insets(0, 10, 10, 5);
        layoutConst.fill = GridBagConstraints.HORIZONTAL;
        layoutConst.gridx = 1;
        layoutConst.gridy = 5;
        glovesPanel.add(removeGlovesField, layoutConst);
        
        //***************************************PUT AT END OF EACH PANEL
        //INSTANTIATING THE HATS ARRAY USING THE FILE ALREADY CREATED
         try {
            File file = new File("glovesFile.txt");
            Scanner scan1 = new Scanner(file);
            
            String stackabl1 = " ";
            String permanen1 = " ";
            String seaso1 = " ";
            String colo1 = " ";
            String occasio1 = " ";
            String typ1 = " ";
            String ide1 = " ";
            int cntr1 = 0;
            while(scan1.hasNext() && cntr1<10){
               stackabl1 = scan1.nextLine();
               permanen1 = scan1.nextLine();
               seaso1 = scan1.nextLine();
               colo1 = scan1.nextLine();
               occasio1 = scan1.nextLine();
               typ1 = scan1.nextLine();
               ide1 = scan1.nextLine();
               glovesArray.add(new Glove(stackabl1, permanen1, seaso1, colo1, occasio1, typ1, ide1));
               
               clothingListTable1.setValueAt(glovesArray.get(cntr1).getStackable(), cntr1, 0);
               clothingListTable1.setValueAt(glovesArray.get(cntr1).getPermanent(), cntr1, 1);
               clothingListTable1.setValueAt(glovesArray.get(cntr1).getSeason(), cntr1, 2);
               clothingListTable1.setValueAt(glovesArray.get(cntr1).getColor(), cntr1, 3);
               clothingListTable1.setValueAt(glovesArray.get(cntr1).getOccasion(), cntr1, 4);
               clothingListTable1.setValueAt(glovesArray.get(cntr1).getType(), cntr1, 5);
               clothingListTable1.setValueAt(glovesArray.get(cntr1).getID(), cntr1, 6);
               
               cntr1 = cntr1 + 1;
            }
         } catch (IOException d) {
      d.printStackTrace();
      }
        // ***HAT Panel***
        
        JPanel hatsPanel = new JPanel();
        //Create table to add clothes 
        JLabel tableLabel2 = new JLabel("Hats");
        
        addHatsButton = new JButton("Add");
        addHatsButton.addActionListener(this);
        
        //the remove button and corresponding remove field as well as remove label
        removeHatsButton = new JButton("Remove");
        removeHatsButton. addActionListener(this);
        
        removeHatsLabel = new JLabel("Enter ID to remove:");
        
        removeHatsField = new JTextField("");
        removeHatsField.setEditable(true);
        
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
        //new remove button implementation*****************
        layoutConst = new GridBagConstraints();
        layoutConst.insets = new Insets(0, 10, 10, 5);
        layoutConst.fill = GridBagConstraints.HORIZONTAL;
        layoutConst.gridx = 2;
        layoutConst.gridy = 5;
        hatsPanel.add(removeHatsButton, layoutConst);
        
        layoutConst = new GridBagConstraints();
        layoutConst.insets = new Insets(0, 10, 10, 5);
        layoutConst.fill = GridBagConstraints.HORIZONTAL;
        layoutConst.gridx = 0;
        layoutConst.gridy = 5;
        hatsPanel.add(removeHatsLabel, layoutConst);
        
        layoutConst = new GridBagConstraints();
        layoutConst.insets = new Insets(0, 10, 10, 5);
        layoutConst.fill = GridBagConstraints.HORIZONTAL;
        layoutConst.gridx = 1;
        layoutConst.gridy = 5;
        hatsPanel.add(removeHatsField, layoutConst);
        
        
        //***************************************
        //INSTANTIATING THE HATS ARRAY USING THE FILE ALREADY CREATED
         try {
            File file2 = new File("hatFile.txt");
            Scanner scan2 = new Scanner(file2);
            
            String stackabl2 = " ";
            String permanen2 = " ";
            String seaso2 = " ";
            String colo2 = " ";
            String occasio2 = " ";
            String typ2 = " ";
            String ide2 = " ";
            int cntr2 = 0;
            while(scan2.hasNext() && cntr2<10){
               stackabl2 = scan2.nextLine();
               permanen2 = scan2.nextLine();
               seaso2 = scan2.nextLine();
               colo2 = scan2.nextLine();
               occasio2 = scan2.nextLine();
               typ2 = scan2.nextLine();
               ide2 = scan2.nextLine();
               hatArray.add(new Hat(stackabl2, permanen2, seaso2, colo2, occasio2, typ2, ide2));
               
               clothingListTable2.setValueAt(hatArray.get(cntr2).getStackable(), cntr2, 0);
               clothingListTable2.setValueAt(hatArray.get(cntr2).getPermanent(), cntr2, 1);
               clothingListTable2.setValueAt(hatArray.get(cntr2).getSeason(), cntr2, 2);
               clothingListTable2.setValueAt(hatArray.get(cntr2).getColor(), cntr2, 3);
               clothingListTable2.setValueAt(hatArray.get(cntr2).getOccasion(), cntr2, 4);
               clothingListTable2.setValueAt(hatArray.get(cntr2).getType(), cntr2, 5);
               clothingListTable2.setValueAt(hatArray.get(cntr2).getID(), cntr2, 6);
               
               cntr2 = cntr2 + 1;
            }
         } catch (IOException d) {
      d.printStackTrace();
      }
        
        // ***JACKET Panel***
        
        //VARIABLE DEFINITIONS
        
        JPanel jacketsPanel = new JPanel();
        
        //Create table to add clothes 
        JLabel tableLabel3 = new JLabel("Jackets");
        
        addJacketsButton = new JButton("Add");
        addJacketsButton.addActionListener(this);
        
        //the remove button and corresponding remove field as well as remove label
        removeJacketsButton = new JButton("Remove");
        removeJacketsButton. addActionListener(this);
        
        removeJacketsLabel = new JLabel("Enter ID to remove:");
        
        removeJacketsField = new JTextField("");
        removeJacketsField.setEditable(true);
        
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

        //new remove button implementation*****************
        layoutConst = new GridBagConstraints();
        layoutConst.insets = new Insets(0, 10, 10, 5);
        layoutConst.fill = GridBagConstraints.HORIZONTAL;
        layoutConst.gridx = 2;
        layoutConst.gridy = 5;
        jacketsPanel.add(removeJacketsButton, layoutConst);
        
        layoutConst = new GridBagConstraints();
        layoutConst.insets = new Insets(0, 10, 10, 5);
        layoutConst.fill = GridBagConstraints.HORIZONTAL;
        layoutConst.gridx = 0;
        layoutConst.gridy = 5;
        jacketsPanel.add(removeJacketsLabel, layoutConst);
        
        layoutConst = new GridBagConstraints();
        layoutConst.insets = new Insets(0, 10, 10, 5);
        layoutConst.fill = GridBagConstraints.HORIZONTAL;
        layoutConst.gridx = 1;
        layoutConst.gridy = 5;
        jacketsPanel.add(removeJacketsField, layoutConst);
        //***************************************PUT AT END OF EACH PANEL
        //INSTANTIATING THE HATS ARRAY USING THE FILE ALREADY CREATED
         try {
            File file = new File("jacketsFile.txt");
            Scanner scan3 = new Scanner(file);
            
            String stackabl3 = " ";
            String permanen3 = " ";
            String seaso3 = " ";
            String colo3 = " ";
            String occasio3 = " ";
            String typ3 = " ";
            String ide3 = " ";
            int cntr3 = 0;
            while(scan3.hasNext() && cntr3<10){
               stackabl3 = scan3.nextLine();
               permanen3 = scan3.nextLine();
               seaso3 = scan3.nextLine();
               colo3 = scan3.nextLine();
               occasio3 = scan3.nextLine();
               typ3 = scan3.nextLine();
               ide3 = scan3.nextLine();
               jacketArray.add(new Jacket(stackabl3, permanen3, seaso3, colo3, occasio3, typ3, ide3));
               
               clothingListTable3.setValueAt(jacketArray.get(cntr3).getStackable(), cntr3, 0);
               clothingListTable3.setValueAt(jacketArray.get(cntr3).getPermanent(), cntr3, 1);
               clothingListTable3.setValueAt(jacketArray.get(cntr3).getSeason(), cntr3, 2);
               clothingListTable3.setValueAt(jacketArray.get(cntr3).getColor(), cntr3, 3);
               clothingListTable3.setValueAt(jacketArray.get(cntr3).getOccasion(), cntr3, 4);
               clothingListTable3.setValueAt(jacketArray.get(cntr3).getType(), cntr3, 5);
               clothingListTable3.setValueAt(jacketArray.get(cntr3).getID(), cntr3, 6);
               
               cntr3 = cntr3 + 1;
            }
         } catch (IOException d) {
      d.printStackTrace();
      }

        // SCARVES Panel
        
        
        JPanel scarfsPanel = new JPanel();       
        
        //Create table to add clothes 
        JLabel tableLabel4 = new JLabel("Scarfs");
        
        addScarfsButton = new JButton("Add");
        addScarfsButton.addActionListener(this);
        
        //the remove button and corresponding remove field as well as remove label
        removeScarfsButton = new JButton("Remove");
        removeScarfsButton. addActionListener(this);
        
        removeScarfsLabel = new JLabel("Enter ID to remove:");
        
        removeScarfsField = new JTextField("");
        removeScarfsField.setEditable(true);
        
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
        
        //new remove button implementation*****************
        layoutConst = new GridBagConstraints();
        layoutConst.insets = new Insets(0, 10, 10, 5);
        layoutConst.fill = GridBagConstraints.HORIZONTAL;
        layoutConst.gridx = 2;
        layoutConst.gridy = 5;
        scarfsPanel.add(removeScarfsButton, layoutConst);
        
        layoutConst = new GridBagConstraints();
        layoutConst.insets = new Insets(0, 10, 10, 5);
        layoutConst.fill = GridBagConstraints.HORIZONTAL;
        layoutConst.gridx = 0;
        layoutConst.gridy = 5;
        scarfsPanel.add(removeScarfsLabel, layoutConst);
        
        layoutConst = new GridBagConstraints();
        layoutConst.insets = new Insets(0, 10, 10, 5);
        layoutConst.fill = GridBagConstraints.HORIZONTAL;
        layoutConst.gridx = 1;
        layoutConst.gridy = 5;
        scarfsPanel.add(removeScarfsField, layoutConst);
        
        //***************************************PUT AT END OF EACH PANEL
        //INSTANTIATING THE HATS ARRAY USING THE FILE ALREADY CREATED
         try {
            File file = new File("scarfsFile.txt");
            Scanner scan4 = new Scanner(file);
            
            String stackabl4 = " ";
            String permanen4 = " ";
            String seaso4 = " ";
            String colo4 = " ";
            String occasio4 = " ";
            String typ4 = " ";
            String ide4 = " ";
            int cntr4 = 0;
            while(scan4.hasNext() && cntr4<10){
               stackabl4 = scan4.nextLine();
               permanen4 = scan4.nextLine();
               seaso4 = scan4.nextLine();
               colo4 = scan4.nextLine();
               occasio4 = scan4.nextLine();
               typ4 = scan4.nextLine();
               ide4 = scan4.nextLine();
               scarfArray.add(new Scarf(stackabl4, permanen4, seaso4, colo4, occasio4, typ4, ide4));
               
               clothingListTable4.setValueAt(scarfArray.get(cntr4).getStackable(), cntr4, 0);
               clothingListTable4.setValueAt(scarfArray.get(cntr4).getPermanent(), cntr4, 1);
               clothingListTable4.setValueAt(scarfArray.get(cntr4).getSeason(), cntr4, 2);
               clothingListTable4.setValueAt(scarfArray.get(cntr4).getColor(), cntr4, 3);
               clothingListTable4.setValueAt(scarfArray.get(cntr4).getOccasion(), cntr4, 4);
               clothingListTable4.setValueAt(scarfArray.get(cntr4).getType(), cntr4, 5);
               clothingListTable4.setValueAt(scarfArray.get(cntr4).getID(), cntr4, 6);
               
               cntr4 = cntr4 + 1;
            }
         } catch (IOException d) {
      d.printStackTrace();
      }
        // SHIRTS Panel
        
        //VARIABLE DEFINITIONS
        
        JPanel shirtsPanel = new JPanel();
        
        //Create table to add clothes 
        JLabel tableLabel5 = new JLabel("Shirts");
        
        addShirtsButton = new JButton("Add");
        addShirtsButton.addActionListener(this);
        
        //the remove button and corresponding remove field as well as remove label
        removeShirtsButton = new JButton("Remove");
        removeShirtsButton. addActionListener(this);
        
        removeShirtsLabel = new JLabel("Enter ID to remove:");
        
        removeShirtsField = new JTextField("");
        removeShirtsField.setEditable(true);
        
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
        layoutConst5.gridx = 4;
        layoutConst5.gridy = 3;
        shirtsPanel.add(occasionLabel5, layoutConst5);
        
        layoutConst5 = new GridBagConstraints();
        layoutConst5.insets = new Insets(1, 10, 10, 0);
        layoutConst5.fill = GridBagConstraints.HORIZONTAL;
        layoutConst5.gridx = 4;
        layoutConst5.gridy = 4;
        shirtsPanel.add(occasionsBox5, layoutConst5);
             
        layoutConst5 = new GridBagConstraints();
        layoutConst5.insets = new Insets(10, 10, 1, 0);
        layoutConst5.fill = GridBagConstraints.HORIZONTAL;
        layoutConst5.gridx = 5;
        layoutConst5.gridy = 3;
        shirtsPanel.add(typeLabel5, layoutConst5);
        
        layoutConst5 = new GridBagConstraints();
        layoutConst5.insets = new Insets(1, 10, 10, 0);
        layoutConst5.fill = GridBagConstraints.HORIZONTAL;
        layoutConst5.gridx = 5;
        layoutConst5.gridy = 4;
        shirtsPanel.add(typesShirtsBox, layoutConst5);
        
        layoutConst5 = new GridBagConstraints();
        layoutConst5.insets = new Insets(10, 10, 1, 0);
        layoutConst5.fill = GridBagConstraints.HORIZONTAL;
        layoutConst5.gridx = 6;
        layoutConst5.gridy = 3;
        shirtsPanel.add(idLabel5, layoutConst5);
        
        layoutConst5 = new GridBagConstraints();
        layoutConst5.insets = new Insets(1, 10, 10, 0);
        layoutConst5.fill = GridBagConstraints.HORIZONTAL;
        layoutConst5.gridx = 6;
        layoutConst5.gridy = 4;
        shirtsPanel.add(idField5, layoutConst5);
        
        layoutConst5 = new GridBagConstraints();
        layoutConst5.insets = new Insets(0, 10, 10, 5);
        layoutConst5.fill = GridBagConstraints.HORIZONTAL;
        layoutConst5.gridx = 8;
        layoutConst5.gridy = 5;
        shirtsPanel.add(addShirtsButton, layoutConst5);
        
        //new remove button implementation*****************
        layoutConst = new GridBagConstraints();
        layoutConst.insets = new Insets(0, 10, 10, 5);
        layoutConst.fill = GridBagConstraints.HORIZONTAL;
        layoutConst.gridx = 2;
        layoutConst.gridy = 5;
        shirtsPanel.add(removeShirtsButton, layoutConst);
        
        layoutConst = new GridBagConstraints();
        layoutConst.insets = new Insets(0, 10, 10, 5);
        layoutConst.fill = GridBagConstraints.HORIZONTAL;
        layoutConst.gridx = 0;
        layoutConst.gridy = 5;
        shirtsPanel.add(removeShirtsLabel, layoutConst);
        
        layoutConst = new GridBagConstraints();
        layoutConst.insets = new Insets(0, 10, 10, 5);
        layoutConst.fill = GridBagConstraints.HORIZONTAL;
        layoutConst.gridx = 1;
        layoutConst.gridy = 5;
        shirtsPanel.add(removeShirtsField, layoutConst);
        
        //***************************************PUT AT END OF EACH PANEL
        //INSTANTIATING THE SHIRTS ARRAY USING THE FILE ALREADY CREATED
         try {
            File file = new File("shirtsFile.txt");
            Scanner scan5 = new Scanner(file);
            
            String stackabl5 = " ";
            String permanen5 = " ";
            String seaso5 = " ";
            String colo5 = " ";
            String occasio5 = " ";
            String typ5 = " ";
            String ide5 = " ";
            int cntr5 = 0;
            while(scan5.hasNext() && cntr5<10){
               stackabl5 = scan5.nextLine();
               permanen5 = scan5.nextLine();
               seaso5 = scan5.nextLine();
               colo5 = scan5.nextLine();
               occasio5 = scan5.nextLine();
               typ5 = scan5.nextLine();
               ide5 = scan5.nextLine();
               shirtArray.add(new Shirt(stackabl5, permanen5, seaso5, colo5, occasio5, typ5, ide5));
               
               clothingListTable5.setValueAt(shirtArray.get(cntr5).getStackable(), cntr5, 0);
               clothingListTable5.setValueAt(shirtArray.get(cntr5).getPermanent(), cntr5, 1);
               clothingListTable5.setValueAt(shirtArray.get(cntr5).getSeason(), cntr5, 2);
               clothingListTable5.setValueAt(shirtArray.get(cntr5).getColor(), cntr5, 3);
               clothingListTable5.setValueAt(shirtArray.get(cntr5).getOccasion(), cntr5, 4);
               clothingListTable5.setValueAt(shirtArray.get(cntr5).getType(), cntr5, 5);
               clothingListTable5.setValueAt(shirtArray.get(cntr5).getID(), cntr5, 6);
               
               cntr5 = cntr5 + 1;
            }
         } catch (IOException d) {
      d.printStackTrace();
      }
        // PANTS Panel
        
        JPanel pantsPanel = new JPanel();
        
        //Create table to add clothes 
        JLabel tableLabel6 = new JLabel("Pants");
        
        addPantsButton = new JButton("Add");
        addPantsButton.addActionListener(this);
        
        //the remove button and corresponding remove field as well as remove label
        removePantsButton = new JButton("Remove");
        removePantsButton. addActionListener(this);
        
        removePantsLabel = new JLabel("Enter ID to remove:");
        
        removePantsField = new JTextField("");
        removePantsField.setEditable(true);
        
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

        //new remove button implementation*****************
        layoutConst = new GridBagConstraints();
        layoutConst.insets = new Insets(0, 10, 10, 5);
        layoutConst.fill = GridBagConstraints.HORIZONTAL;
        layoutConst.gridx = 2;
        layoutConst.gridy = 5;
        pantsPanel.add(removePantsButton, layoutConst);
        
        layoutConst = new GridBagConstraints();
        layoutConst.insets = new Insets(0, 10, 10, 5);
        layoutConst.fill = GridBagConstraints.HORIZONTAL;
        layoutConst.gridx = 0;
        layoutConst.gridy = 5;
        pantsPanel.add(removePantsLabel, layoutConst);
        
        layoutConst = new GridBagConstraints();
        layoutConst.insets = new Insets(0, 10, 10, 5);
        layoutConst.fill = GridBagConstraints.HORIZONTAL;
        layoutConst.gridx = 1;
        layoutConst.gridy = 5;
        pantsPanel.add(removePantsField, layoutConst);
        
        //***************************************PUT AT END OF EACH PANEL
        //INSTANTIATING THE SHIRTS ARRAY USING THE FILE ALREADY CREATED
         try {
            File file = new File("pantssFile.txt");
            Scanner scan6 = new Scanner(file);
            
            String stackabl6 = " ";
            String permanen6 = " ";
            String seaso6 = " ";
            String colo6 = " ";
            String occasio6 = " ";
            String typ6 = " ";
            String ide6 = " ";
            int cntr6 = 0;
            while(scan6.hasNext() && cntr6<10){
               stackabl6 = scan6.nextLine();
               permanen6 = scan6.nextLine();
               seaso6 = scan6.nextLine();
               colo6 = scan6.nextLine();
               occasio6 = scan6.nextLine();
               typ6 = scan6.nextLine();
               ide6 = scan6.nextLine();
               pantsArray.add(new Pants(stackabl6, permanen6, seaso6, colo6, occasio6, typ6, ide6));
               
               clothingListTable6.setValueAt(pantsArray.get(cntr6).getStackable(), cntr6, 0);
               clothingListTable6.setValueAt(pantsArray.get(cntr6).getPermanent(), cntr6, 1);
               clothingListTable6.setValueAt(pantsArray.get(cntr6).getSeason(), cntr6, 2);
               clothingListTable6.setValueAt(pantsArray.get(cntr6).getColor(), cntr6, 3);
               clothingListTable6.setValueAt(pantsArray.get(cntr6).getOccasion(), cntr6, 4);
               clothingListTable6.setValueAt(pantsArray.get(cntr6).getType(), cntr6, 5);
               clothingListTable6.setValueAt(pantsArray.get(cntr6).getID(), cntr6, 6);
               
               cntr6 = cntr6 + 1;
            }
         } catch (IOException d) {
      d.printStackTrace();
      }
        
        // SHOES Panel
        
        JPanel shoesPanel = new JPanel();
        //Create table to add clothes 
        JLabel tableLabel7 = new JLabel("Shoes");
        
        addShoesButton = new JButton("Add");
        addShoesButton.addActionListener(this);
        
        //the remove button and corresponding remove field as well as remove label
        removeShoesButton = new JButton("Remove");
        removeShoesButton. addActionListener(this);
        
        removeShoesLabel = new JLabel("Enter ID to remove:");
        
        removeShoesField = new JTextField("");
        removeShoesField.setEditable(true);
        
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
        
        //new remove button implementation*****************
        layoutConst = new GridBagConstraints();
        layoutConst.insets = new Insets(0, 10, 10, 5);
        layoutConst.fill = GridBagConstraints.HORIZONTAL;
        layoutConst.gridx = 2;
        layoutConst.gridy = 5;
        shoesPanel.add(removeShoesButton, layoutConst);
        
        layoutConst = new GridBagConstraints();
        layoutConst.insets = new Insets(0, 10, 10, 5);
        layoutConst.fill = GridBagConstraints.HORIZONTAL;
        layoutConst.gridx = 0;
        layoutConst.gridy = 5;
        shoesPanel.add(removeShoesLabel, layoutConst);
        
        layoutConst = new GridBagConstraints();
        layoutConst.insets = new Insets(0, 10, 10, 5);
        layoutConst.fill = GridBagConstraints.HORIZONTAL;
        layoutConst.gridx = 1;
        layoutConst.gridy = 5;
        shoesPanel.add(removeShoesField, layoutConst);
        
        //***************************************PUT AT END OF EACH PANEL
        //INSTANTIATING THE SHIRTS ARRAY USING THE FILE ALREADY CREATED
         try {
            File file = new File("shoesFile.txt");
            Scanner scan7 = new Scanner(file);
            
            String stackabl7 = " ";
            String permanen7 = " ";
            String seaso7 = " ";
            String colo7 = " ";
            String occasio7 = " ";
            String typ7 = " ";
            String ide7 = " ";
            int cntr7 = 0;
            while(scan7.hasNext() && cntr7<10){
               stackabl7 = scan7.nextLine();
               permanen7 = scan7.nextLine();
               seaso7 = scan7.nextLine();
               colo7 = scan7.nextLine();
               occasio7 = scan7.nextLine();
               typ7 = scan7.nextLine();
               ide7 = scan7.nextLine();
               shoeArray.add(new Shoe(stackabl7, permanen7, seaso7, colo7, occasio7, typ7, ide7));
               
               clothingListTable7.setValueAt(shoeArray.get(cntr7).getStackable(), cntr7, 0);
               clothingListTable7.setValueAt(shoeArray.get(cntr7).getPermanent(), cntr7, 1);
               clothingListTable7.setValueAt(shoeArray.get(cntr7).getSeason(), cntr7, 2);
               clothingListTable7.setValueAt(shoeArray.get(cntr7).getColor(), cntr7, 3);
               clothingListTable7.setValueAt(shoeArray.get(cntr7).getOccasion(), cntr7, 4);
               clothingListTable7.setValueAt(shoeArray.get(cntr7).getType(), cntr7, 5);
               clothingListTable7.setValueAt(shoeArray.get(cntr7).getID(), cntr7, 6);
               
               cntr7 = cntr7 + 1;
            }
         } catch (IOException d) {
      d.printStackTrace();
      }
        
        // SOCKS Panel
        
        JPanel socksPanel = new JPanel();
        
        //Create table to add clothes 
        JLabel tableLabel8 = new JLabel("Socks");
        
        addSocksButton = new JButton("Add");
        addSocksButton.addActionListener(this);
        
        //the remove button and corresponding remove field as well as remove label
        removeSocksButton = new JButton("Remove");
        removeSocksButton. addActionListener(this);
        
        removeSocksLabel = new JLabel("Enter ID to remove:");
        
        removeSocksField = new JTextField("");
        removeSocksField.setEditable(true);
        
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
        
        //new remove button implementation*****************
        layoutConst = new GridBagConstraints();
        layoutConst.insets = new Insets(0, 10, 10, 5);
        layoutConst.fill = GridBagConstraints.HORIZONTAL;
        layoutConst.gridx = 2;
        layoutConst.gridy = 5;
        socksPanel.add(removeSocksButton, layoutConst);
        
        layoutConst = new GridBagConstraints();
        layoutConst.insets = new Insets(0, 10, 10, 5);
        layoutConst.fill = GridBagConstraints.HORIZONTAL;
        layoutConst.gridx = 0;
        layoutConst.gridy = 5;
        socksPanel.add(removeSocksLabel, layoutConst);
        
        layoutConst = new GridBagConstraints();
        layoutConst.insets = new Insets(0, 10, 10, 5);
        layoutConst.fill = GridBagConstraints.HORIZONTAL;
        layoutConst.gridx = 1;
        layoutConst.gridy = 5;
        socksPanel.add(removeSocksField, layoutConst);
        
        //***************************************PUT AT END OF EACH PANEL
        //INSTANTIATING THE SHIRTS ARRAY USING THE FILE ALREADY CREATED
         try {
            File file = new File("socksFile.txt");
            Scanner scan8 = new Scanner(file);
            
            String stackabl8 = " ";
            String permanen8 = " ";
            String seaso8 = " ";
            String colo8 = " ";
            String occasio8 = " ";
            String typ8 = " ";
            String ide8 = " ";
            int cntr8 = 0;
            while(scan8.hasNext() && cntr8<10){
               stackabl8 = scan8.nextLine();
               permanen8 = scan8.nextLine();
               seaso8 = scan8.nextLine();
               colo8 = scan8.nextLine();
               occasio8 = scan8.nextLine();
               typ8 = scan8.nextLine();
               ide8 = scan8.nextLine();
               sockArray.add(new Sock(stackabl8, permanen8, seaso8, colo8, occasio8, typ8, ide8));
               
               clothingListTable8.setValueAt(sockArray.get(cntr8).getStackable(), cntr8, 0);
               clothingListTable8.setValueAt(sockArray.get(cntr8).getPermanent(), cntr8, 1);
               clothingListTable8.setValueAt(sockArray.get(cntr8).getSeason(), cntr8, 2);
               clothingListTable8.setValueAt(sockArray.get(cntr8).getColor(), cntr8, 3);
               clothingListTable8.setValueAt(sockArray.get(cntr8).getOccasion(), cntr8, 4);
               clothingListTable8.setValueAt(sockArray.get(cntr8).getType(), cntr8, 5);
               clothingListTable8.setValueAt(sockArray.get(cntr8).getID(), cntr8, 6);
               
               cntr8 = cntr8 + 1;
            }
         } catch (IOException d) {
      d.printStackTrace();
      }
        
        // OUTFIT Panel
        
        //VARIABLE DEFINITIONS
        
        //END OF VARIABLE DEFINITIONS
        
        JPanel outfitPanel = new JPanel();
        
        outfitPanel.setLayout(new GridBagLayout());
        
        GridBagConstraints layoutConstO = null;                  
        NumberFormat currencyFormatO = null;
        
        JTextArea outfitArea = new JTextArea(10, 15);
        outfitArea.setEditable(false);
        JScrollPane outfitPane = new JScrollPane(outfitArea);
        
        JLabel occLabel = new JLabel("Occasion: ");
        JLabel seasLabel = new JLabel("Season: ");
        JLabel colLabel = new JLabel("Color: ");
        JLabel zipLabel = new JLabel("Zipcode: ");
        JLabel outfitLabel = new JLabel("Outfits: ");
        
        JTextField occField = new JTextField("");
        occField.setEditable(true);
        JTextField seasField = new JTextField("");
        seasField.setEditable(true);
        JTextField colField = new JTextField("");
        colField.setEditable(true);
        JTextField zipField = new JTextField("");
        zipField.setEditable(true);
        
        JButton outfitButton = new JButton("Create Outfit");
         

         layoutConstO = new GridBagConstraints();
         layoutConstO.insets = new Insets(10, 10, 5, 1);
         layoutConstO.anchor = GridBagConstraints.LINE_END;
         layoutConstO.gridx = 0;
         layoutConstO.gridy = 0;
         outfitPanel.add(occLabel, layoutConstO);
         
         layoutConstO = new GridBagConstraints();
         layoutConstO.insets = new Insets(10, 1, 5, 10);
         layoutConstO.fill = GridBagConstraints.HORIZONTAL;
         layoutConstO.gridx = 1;
         layoutConstO.gridy = 0;
         outfitPanel.add(occField, layoutConstO);
        
         layoutConstO = new GridBagConstraints();
         layoutConstO.insets = new Insets(5, 10, 5, 1);
         layoutConstO.anchor = GridBagConstraints.LINE_END;
         layoutConstO.gridx = 0;
         layoutConstO.gridy = 1;
         outfitPanel.add(seasLabel, layoutConstO);
         
         layoutConstO = new GridBagConstraints();
         layoutConstO.insets = new Insets(5, 1, 5, 10);
         layoutConstO.fill = GridBagConstraints.HORIZONTAL;
         layoutConstO.gridx = 1;
         layoutConstO.gridy = 1;
         outfitPanel.add(seasField, layoutConstO);
         
         layoutConstO = new GridBagConstraints();
         layoutConstO.insets = new Insets(5, 10, 10, 1);
         layoutConstO.anchor = GridBagConstraints.LINE_END;
         layoutConstO.gridx = 0;
         layoutConstO.gridy = 2;
         outfitPanel.add(colLabel, layoutConstO);
         
         layoutConstO = new GridBagConstraints();
         layoutConstO.insets = new Insets(5, 1, 10, 10);
         layoutConstO.fill = GridBagConstraints.HORIZONTAL;
         layoutConstO.gridx = 1;
         layoutConstO.gridy = 2;
         outfitPanel.add(colField, layoutConstO);
         
         layoutConstO = new GridBagConstraints();
         layoutConstO.insets = new Insets(5, 10, 10, 1);
         layoutConstO.anchor = GridBagConstraints.LINE_END;
         layoutConstO.gridx = 0;
         layoutConstO.gridy = 3;
         outfitPanel.add(zipLabel, layoutConstO);
         
         layoutConstO = new GridBagConstraints();
         layoutConstO.insets = new Insets(5, 1, 10, 10);
         layoutConstO.fill = GridBagConstraints.HORIZONTAL;
         layoutConstO.gridx = 1;
         layoutConstO.gridy = 3;
         outfitPanel.add(zipField, layoutConstO);
         
         layoutConstO = new GridBagConstraints();
         layoutConstO.insets = new Insets(0, 5, 0, 10);
         layoutConstO.fill = GridBagConstraints.BOTH;
         layoutConstO.gridx = 2;
         layoutConstO.gridy = 1;
         outfitPanel.add(outfitButton, layoutConstO);
         
         layoutConstO = new GridBagConstraints();
         layoutConstO.insets = new Insets(10, 10, 1, 10);
         layoutConstO.fill = GridBagConstraints.HORIZONTAL;
         layoutConstO.gridx = 0;
         layoutConstO.gridy = 4;
         outfitPanel.add(outfitLabel, layoutConstO);
         
         layoutConstO = new GridBagConstraints();
         layoutConstO.insets = new Insets(1, 10, 10, 10);
         layoutConstO.fill = GridBagConstraints.HORIZONTAL;
         layoutConstO.gridx = 0;
         layoutConstO.gridy = 5;
         outfitPanel.add(outfitPane, layoutConstO);
         
         outfitButton.addActionListener(new ActionListener() {
           public void actionPerformed(ActionEvent e) {
           
               //System.out.println(warddrobe.getHatArray().toString());
               
               String oc = occField.getText();
               String se = seasField.getText();
               String co = colField.getText();
               String zip = zipField.getText();
               
               //System.out.println(oc+" " +se+" "+co+" "+zip);
               
               //resetting wardrobed
               warddrobe.setHats(hatArray);
               warddrobe.setScarfs(scarfArray);
               warddrobe.setGlasses(glassesArray);
               warddrobe.setShirts(shirtArray);
               warddrobe.setJackets(jacketArray);
               warddrobe.setGloves(glovesArray);
               warddrobe.setPants(pantsArray);
               warddrobe.setSocks(sockArray);
               warddrobe.setShoes(shoeArray);
               
               Warddrobe ward = new Warddrobe(hatArray, scarfArray, glassesArray, shirtArray, jacketArray, glovesArray, pantsArray, sockArray, shoeArray);
               
               outfitArea.append(ward.matches(oc, se, co, zip).toString());
               //ward.matches(oc, se, co, zip);
               ward.printOutfits();
               //outfitArea.append(ward.matches(oc, se, co, zip));
               if(ward.printOutfits()==null){
                  JOptionPane.showMessageDialog(null,"No Outfits - Buy More Clothes", "", JOptionPane.YES_NO_CANCEL_OPTION);
               }
               //for(int f = 0;f<
               //calling matches
               /*Outfit[] outfitsToday = warddrobe.matches(oc, se, co, zip);
               boolean triggered = false;
               System.out.println(outfitsToday.length);
               for(int i = 0;i<outfitsToday.length;i++){
                  if(!(outfitsToday[i]==null)){
                     outfitArea.append("Outfit "+i+": "+ outfitsToday[i].toString()+"\n");
                     triggered = true;
                  }
               }
               if(!triggered){
                        JOptionPane.showMessageDialog(null,"No Outfits - Buy More Clothes", "", JOptionPane.YES_NO_CANCEL_OPTION);
                        TabDemoEXP demo = new TabDemoEXP();
                     }*/
                    
                  
                  
               }
         });
         
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
        tabbedPane.addTab("Weather", weatherPanel);
        
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
      
      
      //THESE ARE ALL CHECKING FOR ADD BUTTONS
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
         
         //TESTING
         
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
               //TESTING
               System.out.println(glassesArray.get(i).getID());
            }
         } 
         //THIS IS TO CALL THE FILE GENERATOR FOR BOTH THE REMOVE AND ADD BUTTONS 
      this.generateGlassesFile(); 
      this.updateWarddrobe();
      }
      else if(sourceEvent == addGlovesButton){
         //getting all the values in the input table so that a new clothing object can be made from the specified attributes      
         String stackable1 = (String)trufalsBox1.getSelectedItem();
         String permanent1 = (String)yesnoBox1.getSelectedItem();
         String season1 = (String)seasonsBox1.getSelectedItem();
         String color1 = (String)colorsBox1.getSelectedItem();
         String occasion1 = (String)occasionsBox1.getSelectedItem();
         String id1 = idField1.getText();
         //get the specific type for Glasses
         String type1 = (String)typesGlovesBox.getSelectedItem();
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
         //THIS IS TO CALL THE FILE GENERATOR FOR BOTH THE REMOVE AND ADD BUTTONS 
      this.generateGlovesFile(); 
      this.updateWarddrobe();
      }
      else if(sourceEvent == addHatsButton){
         //getting all the values in the input table so that a new clothing object can be made from the specified attributes      
         String stackable2 = (String)trufalsBox2.getSelectedItem();
         String permanent2 = (String)yesnoBox2.getSelectedItem();
         String season2 = (String)seasonsBox2.getSelectedItem();
         String color2 = (String)colorsBox2.getSelectedItem();
         String occasion2 = (String)occasionsBox2.getSelectedItem();
         String id2 = idField2.getText();
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
         this.generateHatFile(); 
         this.updateWarddrobe();
      }
      else if(sourceEvent == addJacketsButton){
         //getting all the values in the input table so tjacket a new clothing object can be made from the specified attributes      
         String stackable3 = (String)trufalsBox3.getSelectedItem();
         String permanent3 = (String)yesnoBox3.getSelectedItem();
         String season3 = (String)seasonsBox3.getSelectedItem();
         String color3 = (String)colorsBox3.getSelectedItem();
         String occasion3 = (String)occasionsBox3.getSelectedItem();
         String id3 = idField3.getText();
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
         //THIS IS TO CALL THE FILE GENERATOR FOR BOTH THE REMOVE AND ADD BUTTONS 
      this.generateJacketsFile(); 
      this.updateWarddrobe();
      }
      else if(sourceEvent == addScarfsButton){
         //getting all the values in the input table so tjacket a new clothing object can be made from the specified attributes      
         String stackable4 = (String)trufalsBox4.getSelectedItem();
         String permanent4 = (String)yesnoBox4.getSelectedItem();
         String season4 = (String)seasonsBox4.getSelectedItem();
         String color4 = (String)colorsBox4.getSelectedItem();
         String occasion4 = (String)occasionsBox4.getSelectedItem();
         String id4 = idField4.getText();
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
         //THIS IS TO CALL THE FILE GENERATOR FOR BOTH THE REMOVE AND ADD BUTTONS 
      this.generateScarfsFile();  
      this.updateWarddrobe();
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
         //THIS IS TO CALL THE FILE GENERATOR FOR BOTH THE REMOVE AND ADD BUTTONS 
      this.generateShirtsFile();
      this.updateWarddrobe();
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
         //THIS IS TO CALL THE FILE GENERATOR FOR BOTH THE REMOVE AND ADD BUTTONS 
      this.generatePantsFile();
      this.updateWarddrobe();
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
         //THIS IS TO CALL THE FILE GENERATOR FOR BOTH THE REMOVE AND ADD BUTTONS 
      this.generateShoesFile();
      this.updateWarddrobe();
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
         this.updateWarddrobe();
         //THIS IS TO CALL THE FILE GENERATOR FOR BOTH THE REMOVE AND ADD BUTTONS 
      this.generateSocksFile();
      this.updateWarddrobe();
      }
      else if(sourceEvent == removeGlassesButton){
         String id = removeGlassesField.getText();
         for(i = 0; i<glassesArray.size();i++){
            if(glassesArray.get(i).getID().equals(id)){
               glassesArray.remove(i);     
               i = i-1;          
            }
         }
         ArrayList<Glasses> nglassesArray = glassesArray;
         for (i = 0; i < NUM_CLOTHES; i++) {
            clothingListTable.setValueAt(null, i, num0);
            clothingListTable.setValueAt(null, i, num1);
            clothingListTable.setValueAt(null, i, num2);
            clothingListTable.setValueAt(null, i, num3);
            clothingListTable.setValueAt(null, i, num4);
            clothingListTable.setValueAt(null, i, num5);
            clothingListTable.setValueAt(null, i, num6);
         }
         i = 0;
         while(i<nglassesArray.size() && nglassesArray.get(i)!=null) {                             // Update table with content in the clothingListArray ArrayList
               clothingListTable.setValueAt(nglassesArray.get(i).getStackable(), i, num0);
               clothingListTable.setValueAt(nglassesArray.get(i).getPermanent(), i, num1);
               clothingListTable.setValueAt(nglassesArray.get(i).getSeason(), i, num2);
               clothingListTable.setValueAt(nglassesArray.get(i).getColor(), i, num3);
               clothingListTable.setValueAt(nglassesArray.get(i).getOccasion(), i, num4);
               clothingListTable.setValueAt(nglassesArray.get(i).getType(), i, num5);
               clothingListTable.setValueAt(nglassesArray.get(i).getID(), i, num6);
               i = i+1;
               // Update table with content in the clothingListArray ArrayList
         }
         //THIS IS TO CALL THE FILE GENERATOR FOR BOTH THE REMOVE AND ADD BUTTONS 
      this.generateGlassesFile();
      this.updateWarddrobe();
      }
      else if(sourceEvent == removeGlovesButton){
         String id1 = removeGlovesField.getText();
         for(i = 0; i<glovesArray.size();i++){
            if(glovesArray.get(i).getID().equals(id1)){
               glovesArray.remove(i);     
               i = i-1;          
            }
         }
         ArrayList<Glove> nglovesArray = glovesArray;
         for (i = 0; i < NUM_CLOTHES; i++) {
            clothingListTable1.setValueAt(null, i, num0);
            clothingListTable1.setValueAt(null, i, num1);
            clothingListTable1.setValueAt(null, i, num2);
            clothingListTable1.setValueAt(null, i, num3);
            clothingListTable1.setValueAt(null, i, num4);
            clothingListTable1.setValueAt(null, i, num5);
            clothingListTable1.setValueAt(null, i, num6);
         }
         i = 0;
         while(i<nglovesArray.size() && nglovesArray.get(i)!=null) {                             // Update table with content in the clothingListArray ArrayList
               clothingListTable1.setValueAt(nglovesArray.get(i).getStackable(), i, num0);
               clothingListTable1.setValueAt(nglovesArray.get(i).getPermanent(), i, num1);
               clothingListTable1.setValueAt(nglovesArray.get(i).getSeason(), i, num2);
               clothingListTable1.setValueAt(nglovesArray.get(i).getColor(), i, num3);
               clothingListTable1.setValueAt(nglovesArray.get(i).getOccasion(), i, num4);
               clothingListTable1.setValueAt(nglovesArray.get(i).getType(), i, num5);
               clothingListTable1.setValueAt(nglovesArray.get(i).getID(), i, num6);
               i = i+1;
               // Update table with content in the clothingListArray ArrayList
         }
         //THIS IS TO CALL THE FILE GENERATOR FOR BOTH THE REMOVE AND ADD BUTTONS 
      this.generateGlovesFile();
      this.updateWarddrobe();
      }
      else if(sourceEvent == removeHatsButton){
         String id = removeHatsField.getText();
         for(i = 0; i<hatArray.size();i++){
            if(hatArray.get(i).getID().equals(id)){
               hatArray.remove(i);     
               i = i-1;          
            }
         }
         ArrayList<Hat> nhatsArray = hatArray;
         for (i = 0; i < NUM_CLOTHES; i++) {
            clothingListTable2.setValueAt(null, i, num0);
            clothingListTable2.setValueAt(null, i, num1);
            clothingListTable2.setValueAt(null, i, num2);
            clothingListTable2.setValueAt(null, i, num3);
            clothingListTable2.setValueAt(null, i, num4);
            clothingListTable2.setValueAt(null, i, num5);
            clothingListTable2.setValueAt(null, i, num6);
         }
         i = 0;
         while(i<nhatsArray.size() && nhatsArray.get(i)!=null) {                             // Update table with content in the clothingListArray ArrayList
               clothingListTable2.setValueAt(nhatsArray.get(i).getStackable(), i, num0);
               clothingListTable2.setValueAt(nhatsArray.get(i).getPermanent(), i, num1);
               clothingListTable.setValueAt(nhatsArray.get(i).getSeason(), i, num2);
               clothingListTable2.setValueAt(nhatsArray.get(i).getColor(), i, num3);
               clothingListTable2.setValueAt(nhatsArray.get(i).getOccasion(), i, num4);
               clothingListTable2.setValueAt(nhatsArray.get(i).getType(), i, num5);
               clothingListTable2.setValueAt(nhatsArray.get(i).getID(), i, num6);
               i = i+1;
               // Update table with content in the clothingListArray ArrayList
         }
         this.generateHatFile();
      this.updateWarddrobe();
      }
      else if(sourceEvent == removeJacketsButton){
         String id = removeJacketsField.getText();
         for(i = 0; i<jacketArray.size();i++){
            if(jacketArray.get(i).getID().equals(id)){
               jacketArray.remove(i);     
               i = i-1;          
            }
         }
         ArrayList<Jacket> njacketsArray = jacketArray;
         for (i = 0; i < NUM_CLOTHES; i++) {
            clothingListTable3.setValueAt(null, i, num0);
            clothingListTable3.setValueAt(null, i, num1);
            clothingListTable3.setValueAt(null, i, num2);
            clothingListTable3.setValueAt(null, i, num3);
            clothingListTable3.setValueAt(null, i, num4);
            clothingListTable3.setValueAt(null, i, num5);
            clothingListTable3.setValueAt(null, i, num6);
         }
         i = 0;
         while(i<njacketsArray.size() && njacketsArray.get(i)!=null) {                             // Update table with content in the clothingListArray ArrayList
               clothingListTable3.setValueAt(njacketsArray.get(i).getStackable(), i, num0);
               clothingListTable3.setValueAt(njacketsArray.get(i).getPermanent(), i, num1);
               clothingListTable3.setValueAt(njacketsArray.get(i).getSeason(), i, num2);
               clothingListTable3.setValueAt(njacketsArray.get(i).getColor(), i, num3);
               clothingListTable3.setValueAt(njacketsArray.get(i).getOccasion(), i, num4);
               clothingListTable3.setValueAt(njacketsArray.get(i).getType(), i, num5);
               clothingListTable3.setValueAt(njacketsArray.get(i).getID(), i, num6);
               i = i+1;
               // Update table with content in the clothingListArray ArrayList
         }
         //THIS IS TO CALL THE FILE GENERATOR FOR BOTH THE REMOVE AND ADD BUTTONS 
      this.generateJacketsFile();
      this.updateWarddrobe();
      }
      else if(sourceEvent == removeScarfsButton){
         String id = removeScarfsField.getText();
         for(i = 0; i<scarfArray.size();i++){
            if(scarfArray.get(i).getID().equals(id)){
               scarfArray.remove(i);     
               i = i-1;          
            }
         }
         ArrayList<Scarf> nscarfsArray = scarfArray;
         for (i = 0; i < NUM_CLOTHES; i++) {
            clothingListTable4.setValueAt(null, i, num0);
            clothingListTable4.setValueAt(null, i, num1);
            clothingListTable4.setValueAt(null, i, num2);
            clothingListTable4.setValueAt(null, i, num3);
            clothingListTable4.setValueAt(null, i, num4);
            clothingListTable4.setValueAt(null, i, num5);
            clothingListTable4.setValueAt(null, i, num6);
         }
         i = 0;
         while(i<nscarfsArray.size() && nscarfsArray.get(i)!=null) {                             // Update table with content in the clothingListArray ArrayList
               clothingListTable4.setValueAt(nscarfsArray.get(i).getStackable(), i, num0);
               clothingListTable4.setValueAt(nscarfsArray.get(i).getPermanent(), i, num1);
               clothingListTable4.setValueAt(nscarfsArray.get(i).getSeason(), i, num2);
               clothingListTable4.setValueAt(nscarfsArray.get(i).getColor(), i, num3);
               clothingListTable4.setValueAt(nscarfsArray.get(i).getOccasion(), i, num4);
               clothingListTable4.setValueAt(nscarfsArray.get(i).getType(), i, num5);
               clothingListTable4.setValueAt(nscarfsArray.get(i).getID(), i, num6);
               i = i+1;
               // Update table with content in the clothingListArray ArrayList
         }
         //THIS IS TO CALL THE FILE GENERATOR FOR BOTH THE REMOVE AND ADD BUTTONS 
      this.generateScarfsFile();
      this.updateWarddrobe();
      }
      else if(sourceEvent == removeShirtsButton){
         String id = removeShirtsField.getText();
         for(i = 0; i<shirtArray.size();i++){
            if(shirtArray.get(i).getID().equals(id)){
               shirtArray.remove(i);     
               i = i-1;          
            }
         }
         ArrayList<Shirt> nshirtsArray = shirtArray;
         for (i = 0; i < NUM_CLOTHES; i++) {
            clothingListTable5.setValueAt(null, i, num0);
            clothingListTable5.setValueAt(null, i, num1);
            clothingListTable5.setValueAt(null, i, num2);
            clothingListTable5.setValueAt(null, i, num3);
            clothingListTable5.setValueAt(null, i, num4);
            clothingListTable5.setValueAt(null, i, num5);
            clothingListTable5.setValueAt(null, i, num6);
         }
         i = 0;
         while(i<nshirtsArray.size() && nshirtsArray.get(i)!=null) {                             // Update table with content in the clothingListArray ArrayList
               clothingListTable5.setValueAt(nshirtsArray.get(i).getStackable(), i, num0);
               clothingListTable5.setValueAt(nshirtsArray.get(i).getPermanent(), i, num1);
               clothingListTable5.setValueAt(nshirtsArray.get(i).getSeason(), i, num2);
               clothingListTable5.setValueAt(nshirtsArray.get(i).getColor(), i, num3);
               clothingListTable5.setValueAt(nshirtsArray.get(i).getOccasion(), i, num4);
               clothingListTable5.setValueAt(nshirtsArray.get(i).getType(), i, num5);
               clothingListTable5.setValueAt(nshirtsArray.get(i).getID(), i, num6);
               i = i+1;
               // Update table with content in the clothingListArray ArrayList
         }
         //THIS IS TO CALL THE FILE GENERATOR FOR BOTH THE REMOVE AND ADD BUTTONS 
      this.generateShirtsFile();
      this.updateWarddrobe();
      }
      else if(sourceEvent == removePantsButton){
         String id = removePantsField.getText();
         for(i = 0; i<pantsArray.size();i++){
            if(pantsArray.get(i).getID().equals(id)){
               pantsArray.remove(i);     
               i = i-1;          
            }
         }
         ArrayList<Pants> npantsArray = pantsArray;
         for (i = 0; i < NUM_CLOTHES; i++) {
            clothingListTable6.setValueAt(null, i, num0);
            clothingListTable6.setValueAt(null, i, num1);
            clothingListTable6.setValueAt(null, i, num2);
            clothingListTable6.setValueAt(null, i, num3);
            clothingListTable6.setValueAt(null, i, num4);
            clothingListTable6.setValueAt(null, i, num5);
            clothingListTable6.setValueAt(null, i, num6);
         }
         i = 0;
         while(i<npantsArray.size() && npantsArray.get(i)!=null) {                             // Update table with content in the clothingListArray ArrayList
               clothingListTable6.setValueAt(npantsArray.get(i).getStackable(), i, num0);
               clothingListTable6.setValueAt(npantsArray.get(i).getPermanent(), i, num1);
               clothingListTable6.setValueAt(npantsArray.get(i).getSeason(), i, num2);
               clothingListTable6.setValueAt(npantsArray.get(i).getColor(), i, num3);
               clothingListTable6.setValueAt(npantsArray.get(i).getOccasion(), i, num4);
               clothingListTable6.setValueAt(npantsArray.get(i).getType(), i, num5);
               clothingListTable6.setValueAt(npantsArray.get(i).getID(), i, num6);
               i = i+1;
               // Update table with content in the clothingListArray ArrayList
         }
         //THIS IS TO CALL THE FILE GENERATOR FOR BOTH THE REMOVE AND ADD BUTTONS 
      this.generatePantsFile();
      this.updateWarddrobe();
      }
      else if(sourceEvent == removeShoesButton){
         String id = removeShoesField.getText();
         for(i = 0; i<shoeArray.size();i++){
            if(shoeArray.get(i).getID().equals(id)){
               shoeArray.remove(i);     
               i = i-1;          
            }
         }
         ArrayList<Shoe> nshoesArray = shoeArray;
         for (i = 0; i < NUM_CLOTHES; i++) {
            clothingListTable7.setValueAt(null, i, num0);
            clothingListTable7.setValueAt(null, i, num1);
            clothingListTable7.setValueAt(null, i, num2);
            clothingListTable7.setValueAt(null, i, num3);
            clothingListTable7.setValueAt(null, i, num4);
            clothingListTable7.setValueAt(null, i, num5);
            clothingListTable7.setValueAt(null, i, num6);
         }
         i = 0;
         while(i<nshoesArray.size() && nshoesArray.get(i)!=null) {                             // Update table with content in the clothingListArray ArrayList
               clothingListTable7.setValueAt(nshoesArray.get(i).getStackable(), i, num0);
               clothingListTable7.setValueAt(nshoesArray.get(i).getPermanent(), i, num1);
               clothingListTable7.setValueAt(nshoesArray.get(i).getSeason(), i, num2);
               clothingListTable7.setValueAt(nshoesArray.get(i).getColor(), i, num3);
               clothingListTable7.setValueAt(nshoesArray.get(i).getOccasion(), i, num4);
               clothingListTable7.setValueAt(nshoesArray.get(i).getType(), i, num5);
               clothingListTable7.setValueAt(nshoesArray.get(i).getID(), i, num6);
               i = i+1;
               // Update table with content in the clothingListArray ArrayList
         }
         //THIS IS TO CALL THE FILE GENERATOR FOR BOTH THE REMOVE AND ADD BUTTONS 
      this.generateShoesFile();
      this.updateWarddrobe();
      }
      else if(sourceEvent == removeSocksButton){
         String id = removeSocksField.getText();
         for(i = 0; i<sockArray.size();i++){
            if(sockArray.get(i).getID().equals(id)){
               sockArray.remove(i);     
               i = i-1;          
            }
         }
         ArrayList<Sock> nsocksArray = sockArray;
         for (i = 0; i < NUM_CLOTHES; i++) {
            clothingListTable8.setValueAt(null, i, num0);
            clothingListTable8.setValueAt(null, i, num1);
            clothingListTable8.setValueAt(null, i, num2);
            clothingListTable8.setValueAt(null, i, num3);
            clothingListTable8.setValueAt(null, i, num4);
            clothingListTable8.setValueAt(null, i, num5);
            clothingListTable8.setValueAt(null, i, num6);
         }
         i = 0;
         while(i<nsocksArray.size() && nsocksArray.get(i)!=null) {                             // Update table with content in the clothingListArray ArrayList
               clothingListTable8.setValueAt(nsocksArray.get(i).getStackable(), i, num0);
               clothingListTable8.setValueAt(nsocksArray.get(i).getPermanent(), i, num1);
               clothingListTable8.setValueAt(nsocksArray.get(i).getSeason(), i, num2);
               clothingListTable8.setValueAt(nsocksArray.get(i).getColor(), i, num3);
               clothingListTable8.setValueAt(nsocksArray.get(i).getOccasion(), i, num4);
               clothingListTable8.setValueAt(nsocksArray.get(i).getType(), i, num5);
               clothingListTable8.setValueAt(nsocksArray.get(i).getID(), i, num6);
               i = i+1;
               // Update table with content in the clothingListArray ArrayList
         }
         //THIS IS TO CALL THE FILE GENERATOR FOR BOTH THE REMOVE AND ADD BUTTONS 
      this.generateSocksFile();
      this.updateWarddrobe();
      }
      
      
         
}
    public void updateWarddrobe(){
         warddrobe.setHats(hatArray);
         warddrobe.setScarfs(scarfArray);
         warddrobe.setGlasses(glassesArray);
         warddrobe.setShirts(shirtArray);
         warddrobe.setJackets(jacketArray);
         warddrobe.setGloves(glovesArray);
         warddrobe.setPants(pantsArray);
         warddrobe.setSocks(sockArray);
         warddrobe.setShoes(shoeArray);
      }     

}
