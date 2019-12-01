import java.util.*;

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
            if(this.wardrobe.get(j).getOccasion().equals(occasion) && this.wardrobe.get(j).getSeason().equals(season)){
               this.sWardrobe.add(this.wardrobe.get(j));
            }
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
