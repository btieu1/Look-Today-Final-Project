import java.util.*;

public class TEST{
   public static void main(String[] args){
      
      Hat hat2 = new Hat(true, true, "winter", "black", "fancy", "cotton", "beanie", "hat2");
      Hat hat1 = new Hat(true, true, "winter", "black", "casual", "cotton", "beanie", "hat1");
      
      Scarf scarf1 = new Scarf(true, true, "winter", "black", "fancy", "cotton", "beanie", "scarf1");
      Scarf scarf2 = new Scarf(true, true, "winter", "black", "casual", "cotton", "beanie", "scarf2");
      
      Glasses glasses1 = new Glasses(true, true, "winter", "black", "fancy", "cotton", "beanie", "glasses1");
      Glasses glasses2 = new Glasses(true, true, "winter", "black", "casual", "cotton", "beanie", "glasses2");
      
      Shirt shirt1 = new Shirt(true, true, "winter", "black", "fancy", "cotton", "beanie", "hat2");
      Shirt shirt2 = new Shirt(true, true, "winter", "black", "casual", "cotton", "beanie", "hat1");
      
      Jacket jacket1 = new Jacket(true, true, "winter", "black", "fancy", "cotton", "beanie", "jacket1");
      Jacket jacket2 = new Jacket(true, true, "winter", "black", "casual", "cotton", "beanie", "jacket2");
      
      Glove glove1 = new Glove(true, true, "winter", "black", "fancy", "cotton", "beanie", "glove1");
      Glove glove2 = new Glove(true, true, "winter", "black", "casual", "cotton", "beanie", "glove2");
      
      Pants pant1 = new Pants(true, true, "winter", "black", "fancy", "cotton", "beanie", "pant1");
      Pants pant2 = new Pants(true, true, "winter", "black", "casual", "cotton", "beanie", "pant2");
      
      Sock sock1 = new Sock(true, true, "winter", "black", "fancy", "cotton", "beanie", "sock1");
      Sock sock2 = new Sock(true, true, "winter", "black", "casual", "cotton", "beanie", "sock2");
      
      Shoe shoe1 = new Shoe(true, true, "winter", "black", "fancy", "cotton", "beanie", "shoe1");
      Shoe shoe2 = new Shoe(true, true, "winter", "black", "casual", "cotton", "beanie", "shoe2");
      
      ArrayList<Hat> hats = new ArrayList<Hat>();
      hats.add(hat1);
      hats.add(hat2);
      
      ArrayList<Scarf> scarves = new ArrayList<Scarf>();
      scarves.add(scarf1);
      scarves.add(scarf2);
      
      ArrayList<Glasses> glasses = new ArrayList<Glasses>();
      glasses.add(glasses1);
      glasses.add(glasses2);
      
      ArrayList<Shirt> shirts = new ArrayList<Shirt>();
      shirts.add(shirt1);
      shirts.add(shirt2);
      
      ArrayList<Jacket> jackets = new ArrayList<Jacket>();
      jackets.add(jacket1);
      jackets.add(jacket2);
      
      ArrayList<Glove> gloves = new ArrayList<Glove>();
      gloves.add(glove1);
      gloves.add(glove2);
      
      ArrayList<Pants> pants = new ArrayList<Pants>();
      pants.add(pant1);
      pants.add(pant2);
      
      ArrayList<Sock> socks = new ArrayList<Sock>();
      socks.add(sock1);
      socks.add(sock2);
      
      ArrayList<Shoe> shoes = new ArrayList<Shoe>();
      shoes.add(shoe1);
      shoes.add(shoe2);
      
      Warddrobe ward = new Warddrobe(hats, scarves, glasses, shirts, jackets, gloves, pants, socks, shoes);
      
      ward.Condense("fancy", "winter");
      
      System.out.println(ward);
   }
}
