public class Shirt extends Clothing{
   
   //attributes or variables specific to Shirts (Still Working on)
   
   //constructor
   public Shirt(String stackable, String permanent, String season, String color, String occasion, String type, String ID){
      super(stackable, permanent, season, color, occasion, type, ID);
   }
   
   public String getStackable(){
      return this.stackable;
   }
   
   public String getPermanent(){
      return this.permanent;
   }
   
   public String getOccasion(){
      return this.occasion;
   }
}
