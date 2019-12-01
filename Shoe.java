public class Shoe extends Clothing{
   
   //attributes or variables specific to shoes (Still Working on)
   
   //constructor
   public Shoe(String stackable, String permanent, String season, String color, String occasion, String type, String ID){
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
