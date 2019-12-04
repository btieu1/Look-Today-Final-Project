public class Outfit{

   //variables that make up the outfit
   protected Hat hat;
   protected Scarf scarf;
   protected Glasses glasses;
   protected Shirt shirt;
   protected Jacket jacket;
   protected Glove glove; 
   protected Pants pants;
   protected Sock socks;
   protected Shoe shoes;
   
   //takes in a varible amount of arguments
   public Outfit(Clothing ... a){
      for(int i = 0; i<a.length; i++){
         if(a[i] instanceof Hat){
            this.hat = (Hat)a[i];
         }
         
         if(a[i] instanceof Scarf){
            this.scarf = (Scarf)a[i];
         }

         if(a[i] instanceof Glasses){
            this.glasses = (Glasses)a[i];
         }
         
         if(a[i] instanceof Shirt){
            this.shirt = (Shirt)a[i];
         }
         
         if(a[i] instanceof Jacket){
            this.jacket = (Jacket)a[i];
         }
         
         if(a[i] instanceof Glove){
            this.glove = (Glove)a[i];
         }
         
         if(a[i] instanceof Pants){
            this.pants = (Pants)a[i];
         }
         
         if(a[i] instanceof Sock){
            this.socks = (Sock)a[i];
         }
         
         if(a[i] instanceof Shoe){
            this.shoes = (Shoe)a[i];
         }
      }
   }
   
   public String toString(){
      System.out.println("outfit:");
      System.out.print(this.hat+", ");
      System.out.print(this.scarf+", ");
      System.out.print(this.glasses+", ");
      System.out.print(this.shirt+", ");
      System.out.print(this.jacket+", ");
      System.out.print(this.glove+", ");
      System.out.print(this.pants+", ");
      System.out.print(this.socks+", ");
      System.out.print(this.shoes+", ");
      return "";
   }
}
