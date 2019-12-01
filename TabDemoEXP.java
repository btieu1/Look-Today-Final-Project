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
    
    //**THIS MIGHT all NEED TO BE put under each unique panel **THIS ISWHERE IT STARTS
    //*EXP*--- Using JComboBoxes
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
    
    //Box for types - I NEED TO ADD DIFFERENT TYPES FOR EACH DIFFERENT CLOTHING TYPE
    String[] typesGlassesArray = {"N/A"};
    JComboBox typesGlassesBox = new JComboBox(typesGlassesArray);
    String[] typesGlovesArray = {"N/A"};
    JComboBox typesGlovesBox = new JComboBox(typesGlovesArray);
    String[] typesHatsArray = {"N/A"};
    JComboBox typesHatsBox = new JComboBox(typesHatsArray);
    String[] typesJacketsArray = {"N/A"};
    JComboBox typesJacketsBox = new JComboBox(typesJacketsArray);
    String[] typesScarfsArray = {"N/A"};
    JComboBox typesScarfsBox = new JComboBox(typesScarfsArray);
    String[] typesShirtsArray = {"N/A"};
    JComboBox typesShirtsBox = new JComboBox(typesShirtsArray);
    String[] typesPantsArray = {"N/A"};
    JComboBox typesPantsBox = new JComboBox(typesPantsArray);
    String[] typesSocksArray = {"N/A"};
    JComboBox typesSocksBox = new JComboBox(typesSocksArray);
    String[] typesShoesArray = {"N/A"};
    JComboBox typesShoesBox = new JComboBox(typesShoesArray);
    
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
    //** THIS IS WHERE THINGS STOP FOR ALL THE VARIABLES THAT MAY NEED BE COPIED INTO EACH AND EVERY VARIABLE
 
    public void addComponentToPane(Container pane) {
        JTabbedPane tabbedPane = new JTabbedPane(); // creating the tab pane
        
        //making all the text fields for the input table editable by the user  
        idField.setEditable(true);
        
        // ***GLASSES Panel***
        JPanel glassesPanel = new JPanel();
        
        //Create table to add clothes 
        JLabel tableLabel = new JLabel("Glasses");
        
        addGlassesButton = new JButton("Add");
        addGlassesButton.addActionListener(this);
        
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
        JPanel glovesPanel = new JPanel();
        
        
        // ***HAT Panel***
        JPanel hatsPanel = new JPanel();
        
        // ***JACKET Panel***
        JPanel jacketsPanel = new JPanel();
        
        // SCARVES Panel
        JPanel scarfsPanel = new JPanel();
        
        // SHIRTS Panel
        JPanel shirtsPanel = new JPanel();
        
        // PANTS Panel
        JPanel pantsPanel = new JPanel();
        
        // SHOES Panel
        JPanel shoesPanel = new JPanel();
        
        // SOCKS Panel
        JPanel socksPanel = new JPanel();
        
        // OUTFIT Panel
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
      //getting all the values in the input table so that a new clothing object can be made from the specified attributes      
      String stackable = (String)trufalsBox.getSelectedItem();
      String permanent = (String)yesnoBox.getSelectedItem();
      String season = (String)seasonsBox.getSelectedItem();
      String color = (String)colorsBox.getSelectedItem();
      String occasion = (String)occasionsBox.getSelectedItem();
      String id = idField.getText();
      
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
      
         
}         

}