import java.util.*;
import java.lang.Math; 

public class Warddrobe{

   //a bunch of arraylists that store all the clothing types in their respective categories
   private ArrayList<Hat> hats;
   private ArrayList<Scarf> scarves;
   private ArrayList<Glasses> glasses;
   private ArrayList<Shirt> shirts;
   private ArrayList<Jacket> jackets;
   private ArrayList<Glove> gloves;
   private ArrayList<Pants> pants;
   private ArrayList<Sock> socks;
   private ArrayList<Shoe> shoes;
   private List<Clothing> wardrobe; 
   private List<Clothing> sWardrobe; 
   
   private ArrayList<Hat> sHats;
   private ArrayList<Scarf> sScarves;
   private ArrayList<Glasses> sGlasses;
   private ArrayList<Shirt> sShirts;
   private ArrayList<Jacket> sJackets;
   private ArrayList<Glove> sGloves;
   private ArrayList<Pants> sPants;
   private ArrayList<Sock> sSocks;
   private ArrayList<Shoe> sShoes;
   
   private Outfit[] outfits;
   //constructor takes in arraylists
   public Warddrobe(ArrayList<Hat> hats, ArrayList<Scarf> scarves,ArrayList<Glasses> glasses, ArrayList<Shirt> shirts, ArrayList<Jacket> jackets, ArrayList<Glove> gloves, ArrayList<Pants> pants, ArrayList<Sock> socks, ArrayList<Shoe> shoes){
      this.hats = hats;
      this.scarves = scarves;
      this.glasses = glasses;
      this.shirts = shirts;
      this.jackets = jackets;
      this.gloves = gloves;
      this.pants = pants;
      this.socks = socks;
      this.shoes = shoes;
      
      this.wardrobe = new ArrayList<Clothing>();
      
      //adds all the clothing items into the wardrobe array
      for(int i = 0; i<hats.size(); i++){
         this.wardrobe.add(hats.get(i));
      }
      for(int i = 0; i<scarves.size(); i++){
         this.wardrobe.add(scarves.get(i));
      }
      for(int i = 0; i<glasses.size(); i++){
         this.wardrobe.add(glasses.get(i));
      }
      for(int i = 0; i<shirts.size(); i++){
         this.wardrobe.add(shirts.get(i));
      }
      for(int i = 0; i<jackets.size(); i++){
         this.wardrobe.add(jackets.get(i));
      }
      for(int i = 0; i<gloves.size(); i++){
         this.wardrobe.add(gloves.get(i));
      }
      for(int i = 0; i<pants.size(); i++){
         this.wardrobe.add(pants.get(i));
      }
      for(int i = 0; i<socks.size(); i++){
         this.wardrobe.add(socks.get(i));
      }
      for(int i = 0; i<shoes.size(); i++){
         this.wardrobe.add(shoes.get(i));
      }
      
   }
   public ArrayList<Hat> getHatArray(){
      return this.hats;
   }
   public ArrayList<Scarf> getScarfArray(){
      return this.scarves;
   }
   public ArrayList<Glasses> getGlassesArray(){
      return this.glasses;
   }
   public ArrayList<Shirt> getShirtArray(){
      return this.shirts;
   }
   public ArrayList<Jacket> getJacketArray(){
      return this.jackets;
   }
   public ArrayList<Glove> getGlovesArray(){
      return this.gloves;
   }
   public ArrayList<Pants> getPantsArray(){
      return this.pants;
   }
   public ArrayList<Sock> getSocksArray(){
      return this.socks;
   }
   public ArrayList<Shoe> getShoesArray(){
      return this.shoes;
   }
   public String[] getColorPalette(String primeColor){
      String[] colors = new String[5];
      if(primeColor.equals("beige")){
         colors = new String[]{"blue", "brown", "green", "black", "red", "white"};
      }
      
      if(primeColor.equals("black")){
         colors = new String[]{"blue", "brown", "green", "black", "red", "white", "yellow", "olive", "beige", "lime", "cyan"};
      }
      
      if(primeColor.equals("gray")){
         colors = new String[]{"purple", "red", "violet", "pink", "blue"};
      }
      
      if(primeColor.equals("pink")){
         colors = new String[]{"brown", "white", "mint green", "olive", "gray", "turquoise", "light-blue"};
      }
      
      if(primeColor.equals("purple")){
         colors = new String[]{"gray", "yellow-brown", "lime", "mint-green", "brown"};
      }
      
      if(primeColor.equals("red")){
         colors = new String[]{"yellow", "white", "fulvous", "green", "blue", "black"};
      }
      
      if(primeColor.equals("brown")){
         colors = new String[]{"cyan", "cream", "pink", "fawn", "green", "beige"};
      }
      
      if(primeColor.equals("orange")){
         colors = new String[]{"cyan", "blue", "lilac", "violet", "white", "black"};
      }
      
      if(primeColor.equals("yellow")){
         colors = new String[]{"blue", "lilac", "light-cyan", "purple", "gray", "black"};
      }
      
      if(primeColor.equals("olive")){
         colors = new String[]{"orange", "light-brown", "brown"};
      }
      
      if(primeColor.equals("green")){
         colors = new String[]{"golden-brown", "orange", "salad green", "yellow", "brown", "gray", "cream", "black", "creamy-white"};
      }
      
      return colors;
   }
   
   public void Condense(String occasion, String season, String primeColor){
      this.sHats = new ArrayList<Hat>();
      this.sScarves = new ArrayList<Scarf>();
      this.sGlasses = new ArrayList<Glasses>();
      this.sShirts = new ArrayList<Shirt>();
      this.sJackets = new ArrayList<Jacket>();
      this.sGloves = new ArrayList<Glove>();
      this.sPants = new ArrayList<Pants>();
      this.sSocks = new ArrayList<Sock>();
      this.sShoes = new ArrayList<Shoe>();
      
      this.sWardrobe = new ArrayList<Clothing>();

      
         for(int j = 0; j < this.wardrobe.size(); j++){
            if(this.wardrobe.get(j).getOccasion().equals(occasion) && this.wardrobe.get(j).getSeason().equals(season) && Arrays.stream(getColorPalette(primeColor)).anyMatch(this.wardrobe.get(j).getColor()::equals)){
               this.sWardrobe.add(this.wardrobe.get(j));
            }
      }
   }
   
   public Outfit[] matches(String occasion, String season, String primeColor){
      Condense(occasion, season, primeColor);
      Outfit[] outfits = new Outfit[25];
      
      int number = 0; //counts the index of each outfit
      
      while(number<25){ //25 outfits
         Clothing[] list = new Clothing[9];//0 = shirt, 1 = jacket, 2 = pants, 3 = sock, 4 = shoe, 5 = scarf, 6 = glove, 7 = glasses, 8 = hat
         int curr = (int)(Math.random() * 11);
         
         //default, no jacket
            if(curr == 2 && !season.equals("winter")){
               for(int i = 0; i<30; i++){
                  int ran = (int)(Math.random()*sWardrobe.size());
                  if(this.sWardrobe.get(ran) instanceof Shirt){
                     list[0] = this.sWardrobe.get(ran);
                     break;
                  }
               }
               
               for(int i = 0; i<30; i++){
                  int ran = (int)(Math.random()*sWardrobe.size());
                  if(this.sWardrobe.get(ran) instanceof Pants){
                     list[2] = this.sWardrobe.get(ran);
                     break;
                  }
               }
               
               for(int i = 0; i<30; i++){
                  int ran = (int)(Math.random()*sWardrobe.size());
                  if(this.sWardrobe.get(ran) instanceof Sock){
                     list[3] = this.sWardrobe.get(ran);
                     break;
                  }
               }
               
               for(int i = 0; i<30; i++){
                  int ran = (int)(Math.random()*sWardrobe.size());
                  if(this.sWardrobe.get(ran) instanceof Shoe){
                     list[4] = this.sWardrobe.get(ran);
                     break;
                  }
               }
               Outfit outfit = new Outfit(list[0], list[2], list[3], list[4]);
               outfits[number] = outfit; 
               }
               
         //5,6,7
         if(curr == 10 && season.equals("winter")){
               for(int i = 0; i<30; i++){
                  int ran = (int)(Math.random()*sWardrobe.size());
                  if(this.sWardrobe.get(ran) instanceof Shirt){
                     list[0] = this.sWardrobe.get(ran);
                     break;
                  }
               }
               
               for(int i = 0; i<30; i++){
                  int ran = (int)(Math.random()*sWardrobe.size());
                  if(this.sWardrobe.get(ran) instanceof Scarf){
                     list[5] = this.sWardrobe.get(ran);
                     break;
                  }
               }
               
               for(int i = 0; i<30; i++){
                  int ran = (int)(Math.random()*sWardrobe.size());
                  if(this.sWardrobe.get(ran) instanceof Glove){
                     list[6] = this.sWardrobe.get(ran);
                     break;
                  }
               }
               
               for(int i = 0; i<30; i++){
                  int ran = (int)(Math.random()*sWardrobe.size());
                  if(this.sWardrobe.get(ran) instanceof Glasses){
                     list[7] = this.sWardrobe.get(ran);
                     break;
                  }
               }
               
               for(int i = 0; i<30; i++){
                  int ran = (int)(Math.random()*sWardrobe.size());
                  if(this.sWardrobe.get(ran) instanceof Jacket){
                     list[1] = this.sWardrobe.get(ran);
                     break;
                  }
               }
               
               for(int i = 0; i<30; i++){
                  int ran = (int)(Math.random()*sWardrobe.size());
                  if(this.sWardrobe.get(ran) instanceof Pants){
                     list[2] = this.sWardrobe.get(ran);
                     break;
                  }
               }
               
               for(int i = 0; i<30; i++){
                  int ran = (int)(Math.random()*sWardrobe.size());
                  if(this.sWardrobe.get(ran) instanceof Sock){
                     list[3] = this.sWardrobe.get(ran);
                     break;
                  }
               }
               
               for(int i = 0; i<30; i++){
                  int ran = (int)(Math.random()*sWardrobe.size());
                  if(this.sWardrobe.get(ran) instanceof Shoe){
                     list[4] = this.sWardrobe.get(ran);
                     break;
                  }
               }
               Outfit outfit = new Outfit(list[0], list[1], list[2], list[3], list[4], list[5], list[6]);
               outfits[number] = outfit; 
               }

         
         //5,6,7,8
         if(curr == 9 && season.equals("winter")){
               for(int i = 0; i<30; i++){
                  int ran = (int)(Math.random()*sWardrobe.size());
                  if(this.sWardrobe.get(ran) instanceof Shirt){
                     list[0] = this.sWardrobe.get(ran);
                     break;
                  }
               }
               
               for(int i = 0; i<30; i++){
                  int ran = (int)(Math.random()*sWardrobe.size());
                  if(this.sWardrobe.get(ran) instanceof Scarf){
                     list[5] = this.sWardrobe.get(ran);
                     break;
                  }
               }
               
               for(int i = 0; i<30; i++){
                  int ran = (int)(Math.random()*sWardrobe.size());
                  if(this.sWardrobe.get(ran) instanceof Glove){
                     list[6] = this.sWardrobe.get(ran);
                     break;
                  }
               }
               
               for(int i = 0; i<30; i++){
                  int ran = (int)(Math.random()*sWardrobe.size());
                  if(this.sWardrobe.get(ran) instanceof Glasses){
                     list[7] = this.sWardrobe.get(ran);
                     break;
                  }
               }
               
               for(int i = 0; i<30; i++){
                  int ran = (int)(Math.random()*sWardrobe.size());
                  if(this.sWardrobe.get(ran) instanceof Hat){
                     list[8] = this.sWardrobe.get(ran);
                     break;
                  }
               }
               
               for(int i = 0; i<30; i++){
                  int ran = (int)(Math.random()*sWardrobe.size());
                  if(this.sWardrobe.get(ran) instanceof Jacket){
                     list[1] = this.sWardrobe.get(ran);
                     break;
                  }
               }
               
               for(int i = 0; i<30; i++){
                  int ran = (int)(Math.random()*sWardrobe.size());
                  if(this.sWardrobe.get(ran) instanceof Pants){
                     list[2] = this.sWardrobe.get(ran);
                     break;
                  }
               }
               
               for(int i = 0; i<30; i++){
                  int ran = (int)(Math.random()*sWardrobe.size());
                  if(this.sWardrobe.get(ran) instanceof Sock){
                     list[3] = this.sWardrobe.get(ran);
                     break;
                  }
               }
               
               for(int i = 0; i<30; i++){
                  int ran = (int)(Math.random()*sWardrobe.size());
                  if(this.sWardrobe.get(ran) instanceof Shoe){
                     list[4] = this.sWardrobe.get(ran);
                     break;
                  }
               }
               Outfit outfit = new Outfit(list[0], list[1], list[2], list[3], list[4], list[5], list[6]);
               outfits[number] = outfit; 
               }

         
         //6,7
         if(curr == 8 && season.equals("winter")){
               for(int i = 0; i<30; i++){
                  int ran = (int)(Math.random()*sWardrobe.size());
                  if(this.sWardrobe.get(ran) instanceof Shirt){
                     list[0] = this.sWardrobe.get(ran);
                     break;
                  }
               }
               
               for(int i = 0; i<30; i++){
                  int ran = (int)(Math.random()*sWardrobe.size());
                  if(this.sWardrobe.get(ran) instanceof Glove){
                     list[6] = this.sWardrobe.get(ran);
                     break;
                  }
               }
               
               for(int i = 0; i<30; i++){
                  int ran = (int)(Math.random()*sWardrobe.size());
                  if(this.sWardrobe.get(ran) instanceof Glasses){
                     list[7] = this.sWardrobe.get(ran);
                     break;
                  }
               }
               
               for(int i = 0; i<30; i++){
                  int ran = (int)(Math.random()*sWardrobe.size());
                  if(this.sWardrobe.get(ran) instanceof Jacket){
                     list[1] = this.sWardrobe.get(ran);
                     break;
                  }
               }
               
               for(int i = 0; i<30; i++){
                  int ran = (int)(Math.random()*sWardrobe.size());
                  if(this.sWardrobe.get(ran) instanceof Pants){
                     list[2] = this.sWardrobe.get(ran);
                     break;
                  }
               }
               
               for(int i = 0; i<30; i++){
                  int ran = (int)(Math.random()*sWardrobe.size());
                  if(this.sWardrobe.get(ran) instanceof Sock){
                     list[3] = this.sWardrobe.get(ran);
                     break;
                  }
               }
               
               for(int i = 0; i<30; i++){
                  int ran = (int)(Math.random()*sWardrobe.size());
                  if(this.sWardrobe.get(ran) instanceof Shoe){
                     list[4] = this.sWardrobe.get(ran);
                     break;
                  }
               }
               Outfit outfit = new Outfit(list[0], list[1], list[2], list[3], list[4], list[5], list[6]);
               outfits[number] = outfit; 
               }

         
         //6,7,8
         if(curr == 7 && season.equals("winter")){
               for(int i = 0; i<30; i++){
                  int ran = (int)(Math.random()*sWardrobe.size());
                  if(this.sWardrobe.get(ran) instanceof Shirt){
                     list[0] = this.sWardrobe.get(ran);
                     break;
                  }
               }
               
               for(int i = 0; i<30; i++){
                  int ran = (int)(Math.random()*sWardrobe.size());
                  if(this.sWardrobe.get(ran) instanceof Glove){
                     list[6] = this.sWardrobe.get(ran);
                     break;
                  }
               }
               
               for(int i = 0; i<30; i++){
                  int ran = (int)(Math.random()*sWardrobe.size());
                  if(this.sWardrobe.get(ran) instanceof Glasses){
                     list[7] = this.sWardrobe.get(ran);
                     break;
                  }
               }
               
               for(int i = 0; i<30; i++){
                  int ran = (int)(Math.random()*sWardrobe.size());
                  if(this.sWardrobe.get(ran) instanceof Hat){
                     list[8] = this.sWardrobe.get(ran);
                     break;
                  }
               }
               
               for(int i = 0; i<30; i++){
                  int ran = (int)(Math.random()*sWardrobe.size());
                  if(this.sWardrobe.get(ran) instanceof Jacket){
                     list[1] = this.sWardrobe.get(ran);
                     break;
                  }
               }
               
               for(int i = 0; i<30; i++){
                  int ran = (int)(Math.random()*sWardrobe.size());
                  if(this.sWardrobe.get(ran) instanceof Pants){
                     list[2] = this.sWardrobe.get(ran);
                     break;
                  }
               }
               
               for(int i = 0; i<30; i++){
                  int ran = (int)(Math.random()*sWardrobe.size());
                  if(this.sWardrobe.get(ran) instanceof Sock){
                     list[3] = this.sWardrobe.get(ran);
                     break;
                  }
               }
               
               for(int i = 0; i<30; i++){
                  int ran = (int)(Math.random()*sWardrobe.size());
                  if(this.sWardrobe.get(ran) instanceof Shoe){
                     list[4] = this.sWardrobe.get(ran);
                     break;
                  }
               }
               Outfit outfit = new Outfit(list[0], list[1], list[2], list[3], list[4], list[5], list[6]);
               outfits[number] = outfit; 
               }

         
         //7,8
         if(curr == 6){
               for(int i = 0; i<30; i++){
                  int ran = (int)(Math.random()*sWardrobe.size());
                  if(this.sWardrobe.get(ran) instanceof Shirt){
                     list[0] = this.sWardrobe.get(ran);
                     break;
                  }
               }
               
               for(int i = 0; i<30; i++){
                  int ran = (int)(Math.random()*sWardrobe.size());
                  if(this.sWardrobe.get(ran) instanceof Glasses){
                     list[7] = this.sWardrobe.get(ran);
                     break;
                  }
               }
               
               for(int i = 0; i<30; i++){
                  int ran = (int)(Math.random()*sWardrobe.size());
                  if(this.sWardrobe.get(ran) instanceof Hat){
                     list[8] = this.sWardrobe.get(ran);
                     break;
                  }
               }
               
               for(int i = 0; i<30; i++){
                  int ran = (int)(Math.random()*sWardrobe.size());
                  if(this.sWardrobe.get(ran) instanceof Jacket){
                     list[1] = this.sWardrobe.get(ran);
                     break;
                  }
               }
               
               for(int i = 0; i<30; i++){
                  int ran = (int)(Math.random()*sWardrobe.size());
                  if(this.sWardrobe.get(ran) instanceof Pants){
                     list[2] = this.sWardrobe.get(ran);
                     break;
                  }
               }
               
               for(int i = 0; i<30; i++){
                  int ran = (int)(Math.random()*sWardrobe.size());
                  if(this.sWardrobe.get(ran) instanceof Sock){
                     list[3] = this.sWardrobe.get(ran);
                     break;
                  }
               }
               
               for(int i = 0; i<30; i++){
                  int ran = (int)(Math.random()*sWardrobe.size());
                  if(this.sWardrobe.get(ran) instanceof Shoe){
                     list[4] = this.sWardrobe.get(ran);
                     break;
                  }
               }
               Outfit outfit = new Outfit(list[0], list[1], list[2], list[3], list[4], list[5], list[6]);
               outfits[number] = outfit; 
               }

         
         //5,6
         if(curr == 5 && season.equals("winter")){
               for(int i = 0; i<30; i++){
                  int ran = (int)(Math.random()*sWardrobe.size());
                  if(this.sWardrobe.get(ran) instanceof Shirt){
                     list[0] = this.sWardrobe.get(ran);
                     break;
                  }
               }
               
               for(int i = 0; i<30; i++){
                  int ran = (int)(Math.random()*sWardrobe.size());
                  if(this.sWardrobe.get(ran) instanceof Scarf){
                     list[5] = this.sWardrobe.get(ran);
                     break;
                  }
               }
               
               for(int i = 0; i<30; i++){
                  int ran = (int)(Math.random()*sWardrobe.size());
                  if(this.sWardrobe.get(ran) instanceof Glove){
                     list[6] = this.sWardrobe.get(ran);
                     break;
                  }
               }
               
               for(int i = 0; i<30; i++){
                  int ran = (int)(Math.random()*sWardrobe.size());
                  if(this.sWardrobe.get(ran) instanceof Jacket){
                     list[1] = this.sWardrobe.get(ran);
                     break;
                  }
               }
               
               for(int i = 0; i<30; i++){
                  int ran = (int)(Math.random()*sWardrobe.size());
                  if(this.sWardrobe.get(ran) instanceof Pants){
                     list[2] = this.sWardrobe.get(ran);
                     break;
                  }
               }
               
               for(int i = 0; i<30; i++){
                  int ran = (int)(Math.random()*sWardrobe.size());
                  if(this.sWardrobe.get(ran) instanceof Sock){
                     list[3] = this.sWardrobe.get(ran);
                     break;
                  }
               }
               
               for(int i = 0; i<30; i++){
                  int ran = (int)(Math.random()*sWardrobe.size());
                  if(this.sWardrobe.get(ran) instanceof Shoe){
                     list[4] = this.sWardrobe.get(ran);
                     break;
                  }
               }
               Outfit outfit = new Outfit(list[0], list[1], list[2], list[3], list[4], list[5], list[6]);
               outfits[number] = outfit; 
               }
         
         //8
         if(curr == 4){
               for(int i = 0; i<30; i++){
                  int ran = (int)(Math.random()*sWardrobe.size());
                  if(this.sWardrobe.get(ran) instanceof Shirt){
                     list[0] = this.sWardrobe.get(ran);
                     break;
                  }
               }
               
               for(int i = 0; i<30; i++){
                  int ran = (int)(Math.random()*sWardrobe.size());
                  if(this.sWardrobe.get(ran) instanceof Hat){
                     list[8] = this.sWardrobe.get(ran);
                     break;
                  }
               }
               
               for(int i = 0; i<30; i++){
                  int ran = (int)(Math.random()*sWardrobe.size());
                  if(this.sWardrobe.get(ran) instanceof Jacket){
                     list[1] = this.sWardrobe.get(ran);
                     break;
                  }
               }
               
               for(int i = 0; i<30; i++){
                  int ran = (int)(Math.random()*sWardrobe.size());
                  if(this.sWardrobe.get(ran) instanceof Pants){
                     list[2] = this.sWardrobe.get(ran);
                     break;
                  }
               }
               
               for(int i = 0; i<30; i++){
                  int ran = (int)(Math.random()*sWardrobe.size());
                  if(this.sWardrobe.get(ran) instanceof Sock){
                     list[3] = this.sWardrobe.get(ran);
                     break;
                  }
               }
               
               for(int i = 0; i<30; i++){
                  int ran = (int)(Math.random()*sWardrobe.size());
                  if(this.sWardrobe.get(ran) instanceof Shoe){
                     list[4] = this.sWardrobe.get(ran);
                     break;
                  }
               }
               Outfit outfit = new Outfit(list[0], list[1], list[2], list[3], list[4], list[8]);
               outfits[number] = outfit; 
               }
         
         //7
         if(curr == 3){
               for(int i = 0; i<30; i++){
                  int ran = (int)(Math.random()*sWardrobe.size());
                  if(this.sWardrobe.get(ran) instanceof Shirt){
                     list[0] = this.sWardrobe.get(ran);
                     break;
                  }
               }
               
               for(int i = 0; i<30; i++){
                  int ran = (int)(Math.random()*sWardrobe.size());
                  if(this.sWardrobe.get(ran) instanceof Glasses){
                     list[7] = this.sWardrobe.get(ran);
                     break;
                  }
               }
               
               for(int i = 0; i<30; i++){
                  int ran = (int)(Math.random()*sWardrobe.size());
                  if(this.sWardrobe.get(ran) instanceof Jacket){
                     list[1] = this.sWardrobe.get(ran);
                     break;
                  }
               }
               
               for(int i = 0; i<30; i++){
                  int ran = (int)(Math.random()*sWardrobe.size());
                  if(this.sWardrobe.get(ran) instanceof Pants){
                     list[2] = this.sWardrobe.get(ran);
                     break;
                  }
               }
               
               for(int i = 0; i<30; i++){
                  int ran = (int)(Math.random()*sWardrobe.size());
                  if(this.sWardrobe.get(ran) instanceof Sock){
                     list[3] = this.sWardrobe.get(ran);
                     break;
                  }
               }
               
               for(int i = 0; i<30; i++){
                  int ran = (int)(Math.random()*sWardrobe.size());
                  if(this.sWardrobe.get(ran) instanceof Shoe){
                     list[4] = this.sWardrobe.get(ran);
                     break;
                  }
               }
               Outfit outfit = new Outfit(list[0], list[1], list[2], list[3], list[4], list[7]);
               outfits[number] = outfit; 
               }
            
            //default
            if(curr == 2){
               for(int i = 0; i<30; i++){
                  int ran = (int)(Math.random()*sWardrobe.size());
                  if(this.sWardrobe.get(ran) instanceof Shirt){
                     list[0] = this.sWardrobe.get(ran);
                     break;
                  }
               }
               
               for(int i = 0; i<30; i++){
                  int ran = (int)(Math.random()*sWardrobe.size());
                  if(this.sWardrobe.get(ran) instanceof Jacket){
                     list[1] = this.sWardrobe.get(ran);
                     break;
                  }
               }
               
               for(int i = 0; i<30; i++){
                  int ran = (int)(Math.random()*sWardrobe.size());
                  if(this.sWardrobe.get(ran) instanceof Pants){
                     list[2] = this.sWardrobe.get(ran);
                     break;
                  }
               }
               
               for(int i = 0; i<30; i++){
                  int ran = (int)(Math.random()*sWardrobe.size());
                  if(this.sWardrobe.get(ran) instanceof Sock){
                     list[3] = this.sWardrobe.get(ran);
                     break;
                  }
               }
               
               for(int i = 0; i<30; i++){
                  int ran = (int)(Math.random()*sWardrobe.size());
                  if(this.sWardrobe.get(ran) instanceof Shoe){
                     list[4] = this.sWardrobe.get(ran);
                     break;
                  }
               }
               Outfit outfit = new Outfit(list[0], list[1], list[2], list[3], list[4]);
               outfits[number] = outfit; 
               }
               
               //5
               if(curr == 1 && season.equals("winter")){
               for(int i = 0; i<30; i++){
                  int ran = (int)(Math.random()*sWardrobe.size());
                  if(this.sWardrobe.get(ran) instanceof Shirt){
                     list[0] = this.sWardrobe.get(ran);
                     break;
                  }
               }
               
               for(int i = 0; i<30; i++){
                  int ran = (int)(Math.random()*sWardrobe.size());
                  if(this.sWardrobe.get(ran) instanceof Jacket){
                     list[1] = this.sWardrobe.get(ran);
                     break;
                  }
               }
               
               for(int i = 0; i<30; i++){
                  int ran = (int)(Math.random()*sWardrobe.size());
                  if(this.sWardrobe.get(ran) instanceof Pants){
                     list[2] = this.sWardrobe.get(ran);
                     break;
                  }
               }
               
               for(int i = 0; i<30; i++){
                  int ran = (int)(Math.random()*sWardrobe.size());
                  if(this.sWardrobe.get(ran) instanceof Sock){
                     list[3] = this.sWardrobe.get(ran);
                     break;
                  }
               }
               
               for(int i = 0; i<30; i++){
                  int ran = (int)(Math.random()*sWardrobe.size());
                  if(this.sWardrobe.get(ran) instanceof Shoe){
                     list[4] = this.sWardrobe.get(ran);
                     break;
                  }
               }
               Outfit outfit = new Outfit(list[0], list[1], list[2], list[3], list[4], list[5]);
               outfits[number] = outfit; 
               }
               
               //6
               if(curr == 0 && season.equals("winter")){
               for(int i = 0; i<30; i++){
                  int ran = (int)(Math.random()*sWardrobe.size());
                  if(this.sWardrobe.get(ran) instanceof Shirt){
                     list[0] = this.sWardrobe.get(ran);
                     break;
                  }
                  }
               
               for(int i = 0; i<30; i++){
                  int ran = (int)(Math.random()*sWardrobe.size());
                  if(this.sWardrobe.get(ran) instanceof Jacket){
                     list[1] = this.sWardrobe.get(ran);
                     break;
                  }
               }
               
               for(int i = 0; i<30; i++){
                  int ran = (int)(Math.random()*sWardrobe.size());
                  if(this.sWardrobe.get(ran) instanceof Pants){
                     list[2] = this.sWardrobe.get(ran);
                     break;
                  }
               }
               
               for(int i = 0; i<this.sWardrobe.size(); i++){
                  int ran = (int)(Math.random()*sWardrobe.size());
                  if(this.sWardrobe.get(ran) instanceof Sock){
                     list[3] = this.sWardrobe.get(ran);
                     break;
                  }
               }
               
               for(int i = 0; i<30; i++){
                  int ran = (int)(Math.random()*sWardrobe.size());
                  if(this.sWardrobe.get(ran) instanceof Shoe){
                     list[4] = this.sWardrobe.get(ran);
                     break;
                  }
               }
               Outfit outfit = new Outfit(list[0], list[1], list[2], list[3], list[4], list[6]);
               outfits[number] = outfit; 
               }
               number++;
            }
         this.outfits = outfits;
      return outfits;
   }
   
   public void printOutfits(){
      for(int i = 0; i<this.outfits.length; i++){
         System.out.println(this.outfits[i]);
         }
   }
   
   public String toString(){
       System.out.println("Condensed clothes:");
      for(int i = 0; i<this.sWardrobe.size(); i++){
         System.out.print(this.sWardrobe.get(i)+", ");
         }
         
         System.out.println("");
       System.out.println("Your closet:"); 
       for(int i = 0; i<this.wardrobe.size(); i++){ 
         System.out.print(this.wardrobe.get(i)+", ");
         }
         
      return "";
   }
}
