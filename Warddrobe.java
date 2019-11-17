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
   }
}
   